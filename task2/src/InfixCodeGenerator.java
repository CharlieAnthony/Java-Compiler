import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfixCodeGenerator  extends AbstractParseTreeVisitor<String> implements InfixVisitor<String>  {

    private int numOfArgs;
    private List<TerminalNode> args;
    private final Map<String, Integer> localVars = new HashMap<>();
    private final Map<String, InfixParser.DecContext> globalFuncs = new HashMap<>();

    private int labelCounter = 0;

    /**
     * Visit a parse tree produced by {@link InfixParser#prog}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitProg(InfixParser.ProgContext ctx) {

        //adds all the functions to the globalFuncs hashmap
        for(int i=0; i < ctx.dec().size(); i++)
        {
            globalFuncs.put(ctx.dec(i).IDFR().getText(), ctx.dec(i));
        }

        return visit(globalFuncs.get("main"));
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#dec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitDec(InfixParser.DecContext ctx) {

        args = ctx.vardec().IDFR();
        numOfArgs = ctx.vardec().type().size();

        if (numOfArgs + localVars.size() > 22) {     // x10 - x31
            throw new RuntimeException("Too many local variables.");
        }

        StringBuilder sb = new StringBuilder();
        //adds the tag of the declaration
        sb.append(
                String.format("""
                        %s:    
                            lw      ra, 4(sp)
                            addi    sp, sp, 4
                        """,
                        ctx.IDFR().getText())
        );

        int regOffset = 10;
        //adds all the variables to the stack
        for(int i=0; i < numOfArgs; i++){
            localVars.put(ctx.vardec().IDFR(i).getText(), i + regOffset);
            sb.append(
                    String.format("""
                                lw          x%2d, 4(sp)
                                addi        sp, sp, 4
                            """,
                            i + regOffset)
            );
        }

        //regOffset = regOffset + numOfArgs;
        //not exactly sure what this is used for

        sb.append(String.format("""
                    addi        sp, sp, 4
                """));


        return visit(ctx.body());
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#vardec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitVardec(InfixParser.VardecContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#body}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitBody(InfixParser.BodyContext ctx) {

        StringBuilder sb = new StringBuilder();

        //dec node
        InfixParser.DecContext parentNode = (InfixParser.DecContext) ctx.parent;


        if (numOfArgs + parentNode.vardec().IDFR().size() > 22) {     // x10 - x31
            throw new RuntimeException("Too many local variables.");
        }

        int regOffset = 10;

        for (int i = 0; i < numOfArgs; ++i) {
            localVars.put(args.get(i).getText(), i + regOffset);
            sb.append(
                String.format("""
                    lw          x%2d, 4(sp)
                    addi        sp, sp, 4
                """,
                i + regOffset
                )
            );
        }

        regOffset = regOffset + numOfArgs;

        sb.append("""
                    addi        sp, sp, 4
                """
        );


        for(int i=0; i<ctx.type().size(); i++)
        {
            //sb.append(String.format("""
            //
            //        """));
        }
        //visits all the expressions in the body
        for (int i = 0; i < ctx.ene().exp().size(); ++i) {
            sb.append(visit(ctx.ene().exp(i)));
        }

        sb.append("""
                    ret
                """
        );

        return sb.toString();
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitBlock(InfixParser.BlockContext ctx) {

        StringBuilder sb = new StringBuilder();
        //visits all the expressions in the block
        for (int i = 0; i < ctx.ene().exp().size(); ++i) {
            sb.append(visit(ctx.ene().exp(i)));

            //if the expression adds a value to the pointer, adjust the stack pointer by 4
            if (
                    ctx.ene().exp(i) instanceof InfixParser.BinopExpContext
                            || ctx.ene().exp(i) instanceof InfixParser.IntLitExpContext
                            || ctx.ene().exp(i) instanceof InfixParser.IdentifierExpContext
                            || ctx.ene().exp(i) instanceof InfixParser.BoolLitExpContext
            ) {

                sb.append("""
                    Discard     4
                """
                );

            }

        }

        return sb.toString();
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#ene}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitEne(InfixParser.EneContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitType(InfixParser.TypeContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code AssExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitAssExp(InfixParser.AssExpContext ctx) {
        //visits the expression, then pops it into the register specified in localVars
        StringBuilder sb = new StringBuilder();
        sb.append(visit(ctx.exp()));
        sb.append(
                String.format("""
                        
                       PopReg       x%2d
                        """,
                        localVars.get(ctx.IDFR().getText()))
        );
        return sb.toString();
    }

    /**
     * Visit a parse tree produced by the {@code BinopExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitBinopExp(InfixParser.BinopExpContext ctx) {

        StringBuilder sb = new StringBuilder();

        //add the two operands to the stack
        sb.append(visit(ctx.exp(1)));
        sb.append(visit(ctx.exp(0)));

        //switch - depending on what operation is being referred to, carry out said expression
        switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()){

            case InfixParser.AND -> {
                sb.append("""
                            LogicalAnd
                        """);
            }

            case InfixParser.OR -> {
                sb.append("""
                            LogicalOr
                        """);
            }

            case InfixParser.XOR -> {
                sb.append("""
                            LogicalXor
                        """);
            }

            case InfixParser.PLUS -> {
                sb.append("""
                            Plus
                        """);
            }

            case InfixParser.MINUS -> {
                sb.append("""
                            Minus
                        """);
            }

            case InfixParser.MULTIPLY -> {
                sb.append("""
                            Multiply
                        """);
            }

            case InfixParser.DIVIDE -> {
                sb.append("""
                            Divide
                        """);
            }

            case InfixParser.EQUAL -> {
                sb.append("""
                            Equal
                        """);
            }

            case InfixParser.LESS -> {
                sb.append("""
                            CompL
                        """);
            }

            case InfixParser.LESSEQ -> {
                sb.append("""
                            CompLE
                        """);
            }

            case InfixParser.GREATER -> {
                sb.append("""
                            CompG
                        """);
            }

            case InfixParser.GREATEREQ -> {
                sb.append("""
                            CompGE
                        """);
            }

            default -> {
                throw new RuntimeException("Shouldn't be here - wrong binary operator.");
            }
        }

        return sb.toString();
    }

    /**
     * Visit a parse tree produced by the {@code FuncExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitFuncExp(InfixParser.FuncExpContext ctx) {

        StringBuilder sb = new StringBuilder();

        sb.append(visit(globalFuncs.get(ctx.IDFR().getText())));

        return sb.toString();
    }

    /**
     * Visit a parse tree produced by the {@code BlockExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitBlockExp(InfixParser.BlockExpContext ctx) {
        //visits the block
        return visit(ctx.block());
    }

    /**
     * Visit a parse tree produced by the {@code IfThenElseExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitIfThenElseExp(InfixParser.IfThenElseExpContext ctx) {
        StringBuilder sb = new StringBuilder();

        //creating labels for the top of the loop, and where the code will exit to resume the programs execution
        String thenLabel = String.format("label_%d", labelCounter++);
        String elseLabel = String.format("label_%d", labelCounter++);

        //visits the expression, and appends it to the stack
        sb.append(visit(ctx.exp()));

        //adds the jumping conditions to the stack
        sb.append(
                String.format("""
                            PushImm 1
                            LogicalXor
                            JumpTrue    %s
                            Jump        %s
                        """,
                        thenLabel,
                        elseLabel)
        );

        sb.append(
                String.format("""
                        %s:
                        """,
                        thenLabel)
        );

        sb.append(visit(ctx.block(0)));

        sb.append(
                String.format("""
                        %s:
                        """,
                        elseLabel)
        );

        sb.append(visit(ctx.block(1)));

        return sb.toString();
    }

    /**
     * Visit a parse tree produced by the {@code WhileExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitWhileExp(InfixParser.WhileExpContext ctx) {

        StringBuilder sb = new StringBuilder();

        //creating labels for the top of the loop, and where the code will exit to resume the programs execution
        String loopLabel = String.format("label_%d", labelCounter++);
        String exitLabel = String.format("label_%d", labelCounter++);

        sb.append(
                String.format("""
                %s:     
                """,
                loopLabel)
        );

        sb.append(visit(ctx.exp()));

        sb.append(
                String.format("""
                            PushImm 1
                            LogicalXor
                            JumpTrue    %s
                        """,
                        exitLabel)
        );

        sb.append(visit(ctx.block()));

        sb.append(
                String.format("""
                            Jump %s
                        """,
                        loopLabel)
        );

        sb.append(
                String.format("""
                        %s:
                        """,
                        exitLabel)
        );

        return sb.toString();
    }

    /**
     * Visit a parse tree produced by the {@code RepeatExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitRepeatExp(InfixParser.RepeatExpContext ctx) {

        StringBuilder sb = new StringBuilder();

        //creating labels for the top of the loop, and where the code will exit to resume the programs execution
        String loopLabel = String.format("label_%d", labelCounter++);
        String exitLabel = String.format("label_%d", labelCounter++);

        sb.append(
                String.format("""
                %s:     
                """,
                        loopLabel)
        );

        sb.append(visit(ctx.block()));



        sb.append(visit(ctx.exp()));

        sb.append(
                String.format("""
                            PushImm 1
                            LogicalXor
                            JumpTrue    %s
                        """,
                        exitLabel)
        );

        sb.append(
                String.format("""
                            Jump        %s
                        """,
                        loopLabel)
        );

        sb.append(
                String.format("""
                        %s:
                        """,
                        exitLabel)
        );

        return sb.toString();
    }

    /**
     * Visit a parse tree produced by the {@code PrintExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitPrintExp(InfixParser.PrintExpContext ctx) {

        StringBuilder sb = new StringBuilder();

        sb.append(visit(ctx.exp()));

        sb.append(
                String.format("""
                            ecall
                        """)
        );

        return sb.toString();
    }

    /**
     * Visit a parse tree produced by the {@code SpaceExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitSpaceExp(InfixParser.SpaceExpContext ctx) {
        StringBuilder sb = new StringBuilder();

        //not convinced this is the correct functionality of space, but I cant figure out what else it would be
        sb.append(
                String.format("""
                            %s
                        """,
                        " ")
        );

        return sb.toString();
    }

    /**
     * Visit a parse tree produced by the {@code NewLineExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitNewLineExp(InfixParser.NewLineExpContext ctx) {

        StringBuilder sb = new StringBuilder();

        //same with this one - doesnt seem right but whatever.
        sb.append("\n");

        return sb.toString();

    }

    /**
     * Visit a parse tree produced by the {@code SkipExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitSkipExp(InfixParser.SkipExpContext ctx) {
        return null;
    }

    /**
     * Visit a parse tree produced by the {@code IdentifierExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitIdentifierExp(InfixParser.IdentifierExpContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append(
                String.format("""
                            PushReg     x%2d
                        """,
                        localVars.get(ctx.IDFR().getText()))
        );
        return sb.toString();
    }

    /**
     * Visit a parse tree produced by the {@code IntLitExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitIntLitExp(InfixParser.IntLitExpContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append(
                String.format("""
                            PushImm     %d
                        """,
                        Integer.parseInt(ctx.INTLIT().getText()))
        );
        return sb.toString();
    }

    /**
     * Visit a parse tree produced by the {@code BoolLitExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitBoolLitExp(InfixParser.BoolLitExpContext ctx) {
        StringBuilder sb = new StringBuilder();
        if(ctx.BOOLLIT().getText().equals("true"))
        {
            sb.append(
                    String.format("""
                                PushImm     1
                            """)
            );
        }else{
            sb.append(
                    String.format("""
                                PushImm     0
                            """)
            );
        }
        return sb.toString();
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#args}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitArgs(InfixParser.ArgsContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    /**
     * Visit a parse tree produced by the {@code EqBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public String visitEqBinop(InfixParser.EqBinopContext ctx) {
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
    public String visitGreaterBinop(InfixParser.GreaterBinopContext ctx) {
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
    public String visitLessBinop(InfixParser.LessBinopContext ctx) {
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
    public String visitGreaterEqBinop(InfixParser.GreaterEqBinopContext ctx) {
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
    public String visitLessEqBinop(InfixParser.LessEqBinopContext ctx) {
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
    public String visitPlusBinop(InfixParser.PlusBinopContext ctx) {
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
    public String visitMinusBinop(InfixParser.MinusBinopContext ctx) {
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
    public String visitMultiplyBinop(InfixParser.MultiplyBinopContext ctx) {
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
    public String visitDivideBinop(InfixParser.DivideBinopContext ctx) {
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
    public String visitAndBinop(InfixParser.AndBinopContext ctx) {
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
    public String visitOrBinop(InfixParser.OrBinopContext ctx) {
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
    public String visitXorBinop(InfixParser.XorBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
}
