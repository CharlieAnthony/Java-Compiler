import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class InfixEvaluator extends AbstractParseTreeVisitor<Integer> implements InfixVisitor<Integer> {

    private final Map<String, Integer> localVars = new HashMap<>();

    public Integer visitProgram(InfixParser.ProgContext ctx, String[] args)
    {
        //finds dec(x) which represents main function
        int x=0;
        while(!ctx.dec(x).IDFR().getText().equalsIgnoreCase("main")){
            x++;
        }
        //System.out.println("main dec: " + x);

        for(int i=0; i< (args.length); i++)
        {
            //if the argument is true, it adds it to localVars as a 1
            if(args[i].equalsIgnoreCase("true"))
            {
                localVars.put(ctx.dec(x).vardec().IDFR(i).getText(), 1);
            }else if(args[i].equalsIgnoreCase("false"))
            {
                localVars.put(ctx.dec(x).vardec().IDFR(i).getText(), 0);
            }else
            {
                localVars.put(ctx.dec(x).vardec().IDFR(i).getText(), Integer.parseInt(args[i]));
            }
        }
        //System.out.println("main arguments: " + localVars);
        //System.out.println("return value: ");
        return visit(ctx.dec(x).body());
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#prog}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitProg(InfixParser.ProgContext ctx) {
        throw new RuntimeException("Should not be here");
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#dec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitDec(InfixParser.DecContext ctx) {

        //should not have to visit this
        throw new RuntimeException("Should not be here");
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#vardec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitVardec(InfixParser.VardecContext ctx) {
        throw new RuntimeException("Should not be here");
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#body}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitBody(InfixParser.BodyContext ctx) {
        //adds all the initialised variables to the hashmap
        for(int i=0; i<ctx.type().size(); i++)
        {
            localVars.put(ctx.IDFR(i).getText(), visit(ctx.exp(i)));
        }
        Integer returnValue = null;
        //visits all the expressions in ene
        for(int i=0; i<(ctx.ene().exp().size()); i++)
        {
            returnValue = visit(ctx.ene().exp(i));
        }

        return returnValue;
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitBlock(InfixParser.BlockContext ctx) {
        Integer returnValue = null;
        //visits all the elements in a block, and stores the return type
        for(int i=0; i<ctx.ene().exp().size(); i++)
        {
            returnValue = visit(ctx.ene().exp(i));
        }
        return returnValue;
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#ene}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitEne(InfixParser.EneContext ctx) {
        throw new RuntimeException("Should not be here");
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitType(InfixParser.TypeContext ctx) {
        throw new RuntimeException("Should not be here");
    }

    /**
     * Visit a parse tree produced by the {@code IdentifierExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitIdentifierExp(InfixParser.IdentifierExpContext ctx) {
        //looks in hashmap - returns value of the element
        return localVars.get(ctx.IDFR().getText());
    }

    /**
     * Visit a parse tree produced by the {@code IntLitExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitIntLitExp(InfixParser.IntLitExpContext ctx) {
        return Integer.parseInt(ctx.INTLIT().getText());
    }

    /**
     * Visit a parse tree produced by the {@code BoolLitExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitBoolLitExp(InfixParser.BoolLitExpContext ctx) {
        //if the text says true, return 1, otherwise return 0
        if(ctx.BOOLLIT().getText().equals("true"))
        {
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * Visit a parse tree produced by the {@code AssExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitAssExp(InfixParser.AssExpContext ctx) {
        //updates a value in the hashmap
        localVars.replace(ctx.IDFR().getText(), visit(ctx.exp()));
        return 0;
    }

    /**
     * Visit a parse tree produced by the {@code BinopExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitBinopExp(InfixParser.BinopExpContext ctx) {
        Integer oprand1 = visit(ctx.exp(0));
        Integer oprand2 = visit(ctx.exp(1));
        //System.out.println("binop: oprand1 = " + oprand1 + " oprand2 = " + oprand2 + " operator = " + ctx.binop().getText());

        switch(((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType())
        {
            case InfixParser.AND -> {
                return oprand1 & oprand2;
            }
            case InfixParser.OR -> {
                return oprand1 | oprand2;
            }
            case InfixParser.XOR -> {
                return oprand1 ^ oprand2;
            }
            case InfixParser.EQUAL -> {
                return ((oprand1.equals(oprand2)) ? 1 : 0);
            }
            case InfixParser.GREATER -> {
                return ((oprand1 < oprand2) ? 1 : 0);
            }
            case InfixParser.GREATEREQ -> {
                return ((oprand1 <= oprand2) ? 1 : 0);
            }
            case InfixParser.LESS -> {
                return ((oprand1 > oprand2) ? 1 : 0);
            }
            case InfixParser.LESSEQ -> {
                return ((oprand1 >= oprand2) ? 1 : 0);
            }
            case InfixParser.PLUS -> {
                return oprand1 + oprand2;
            }
            case InfixParser.MINUS -> {
                return oprand1 - oprand2;
            }
            case InfixParser.MULTIPLY -> {
                return oprand1 * oprand2;
            }
            case InfixParser.DIVIDE -> {
                return oprand1 / oprand2;
            }
            default -> {
                throw new RuntimeException("Shouldn't be here - wrong binary operator");
            }
        }
    }

    /**
     * Visit a parse tree produced by the {@code FuncExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitFuncExp(InfixParser.FuncExpContext ctx) {
        //creates a variable and iterates to the top of the AST
        RuleContext temp = ctx;
        while(temp.parent != null){
            temp = temp.parent;
        }
        //creates a variable, and uses it to find a declaration
        int x=0;
        for(int i=0; i < ((InfixParser.ProgContext) temp).dec().size(); i++)
        {
            if(((InfixParser.ProgContext) temp).dec(i).IDFR().getText().equals(ctx.IDFR().getText()))
            {
                x = i;
            }
        }

        final Map<String, Integer> tempVars = new HashMap<>();
        final Map<String, Integer> setupVars = new HashMap<>();
        tempVars.putAll(localVars);
        for(int i=0; i<ctx.args().exp().size(); i++)
        {
            //System.out.println("add var:   " + ((InfixParser.ProgContext) temp).dec(x).vardec().IDFR(i).getText() + " : " + visit(ctx.args().exp(i)));
            if(ctx.args().exp(i) instanceof InfixParser.IdentifierExpContext){
                //System.out.println("adding: " + ((InfixParser.ProgContext) temp).dec(x).vardec().IDFR(i).getText() + " , " + tempVars.get(((InfixParser.IdentifierExpContext) ctx.args().exp(i)).IDFR().getText()));
                setupVars.put(((InfixParser.ProgContext) temp).dec(x).vardec().IDFR(i).getText(), tempVars.get(ctx.args().exp(i).getText()));
            }else {
                setupVars.put(((InfixParser.ProgContext) temp).dec(x).vardec().IDFR(i).getText(), visit(ctx.args().exp(i)));
            }
        }

        //System.out.println("Function call:" + ctx.IDFR().getText());

        localVars.clear();
        localVars.putAll(setupVars);
        setupVars.clear();
        //System.out.println("localVars: " + localVars);
        Integer returnValue = visit(((InfixParser.ProgContext) temp).dec(x).body());
        localVars.clear();
        localVars.putAll(tempVars);
        return returnValue;
    }

    /**
     * Visit a parse tree produced by the {@code BlockExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitBlockExp(InfixParser.BlockExpContext ctx) { return visit(ctx.block()); }

    /**
     * Visit a parse tree produced by the {@code IfThenElseExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitIfThenElseExp(InfixParser.IfThenElseExpContext ctx) {
        //System.out.println("IfThenElse:");
        if( visit(ctx.exp()) > 0 )
        {
            return visit(ctx.block(0));
        }else{
            return visit(ctx.block(1));
        }
    }

    /**
     * Visit a parse tree produced by the {@code WhileExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitWhileExp(InfixParser.WhileExpContext ctx) {
        while( visit(ctx.exp()) > 0 )
        {
            visit(ctx.block());
        }
        return 0;
    }

    /**
     * Visit a parse tree produced by the {@code RepeatExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitRepeatExp(InfixParser.RepeatExpContext ctx) {
        do{
            visit(ctx.block());
        }while( visit(ctx.exp()) > 0 );
        return 0;
    }

    /**
     * Visit a parse tree produced by the {@code PrintExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitPrintExp(InfixParser.PrintExpContext ctx) {
        if(ctx.exp().getText().equalsIgnoreCase("space")){
            System.out.print(" ");
        }else if(ctx.exp().getText().equalsIgnoreCase("newline")){
            System.out.print("\n");
        }else{
            System.out.print(visit(ctx.exp()));
        }
        return 0;
    }

    /**
     * Visit a parse tree produced by the {@code SpaceExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitSpaceExp(InfixParser.SpaceExpContext ctx) {
        throw new RuntimeException("Should not be here");
    }

    /**
     * Visit a parse tree produced by the {@code NewLineExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitNewLineExp(InfixParser.NewLineExpContext ctx) {
        throw new RuntimeException("Should not be here");
    }

    /**
     * Visit a parse tree produced by the {@code SkipExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitSkipExp(InfixParser.SkipExpContext ctx) {
        throw new RuntimeException("Should not be here");
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#args}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitArgs(InfixParser.ArgsContext ctx) {
        throw new RuntimeException("Should not be here");
    }

    /**
     * Visit a parse tree produced by the {@code EqBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitEqBinop(InfixParser.EqBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code GreaterBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitGreaterBinop(InfixParser.GreaterBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code LessBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitLessBinop(InfixParser.LessBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code GreaterEqBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitGreaterEqBinop(InfixParser.GreaterEqBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code LessEqBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitLessEqBinop(InfixParser.LessEqBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code PlusBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitPlusBinop(InfixParser.PlusBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code MinusBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitMinusBinop(InfixParser.MinusBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code MultiplyBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitMultiplyBinop(InfixParser.MultiplyBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code DivideBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitDivideBinop(InfixParser.DivideBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code AndBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitAndBinop(InfixParser.AndBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code OrBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitOrBinop(InfixParser.OrBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code XorBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Integer visitXorBinop(InfixParser.XorBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

}
