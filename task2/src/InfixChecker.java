import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class InfixChecker extends AbstractParseTreeVisitor<Types> implements InfixVisitor<Types>
{

    // In DemoLang, since all variables are INT, these are just for checking whether
    // variables are defined when they are used
    private final Map<String, Types> globalVars = new HashMap<>();

    private final Map<String, Types> localVars = new HashMap<>();

    /**
     * Visit a parse tree produced by {@link InfixParser#prog}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitProg(InfixParser.ProgContext ctx) {
        //System.out.print("type checking:\nvisit prog:");
        for(int i=0; i < ctx.dec().size(); i++){
            if (globalVars.containsKey(ctx.dec(i).IDFR().getText())) {
                throw new TypeException().duplicatedFuncError();
            }
            if(ctx.dec(i).type().getText().equals("int")){
                globalVars.put(ctx.dec(i).IDFR().getText(), Types.INT);
            }else if(ctx.dec(i).type().getText().equals("bool")){
                globalVars.put(ctx.dec(i).IDFR().getText(), Types.BOOL);
            }else if(ctx.dec(i).type().getText().equals("unit")){
                globalVars.put(ctx.dec(i).IDFR().getText(), Types.UNIT);
            }
        }

        //System.out.print("globalVars: " + globalVars);

        if (!globalVars.containsKey("main")){
            throw new TypeException().noMainFuncError();
        }
        Boolean temp = true;
        int x=0;
        while(temp)
        {
            if(ctx.dec(x).IDFR().getText().equals("main")){
                break;
            }
            x++;
        }
        if(visit(ctx.dec(x).type()) != Types.INT){
            throw new TypeException().mainReturnTypeError();
        }

        visit(ctx.dec(x));
        for(int i=0; i < ctx.dec().size(); i++)
        {
            if(ctx.dec(i).IDFR().getText().equals("main")){

            }else{
                visit(ctx.dec(i));
            }
        }
        //System.out.println("return main \n---------- CHECKING COMPLETE ----------");
        return Types.INT;
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#dec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitDec(InfixParser.DecContext ctx) {
        final Map<String, Types> temp = localVars;
        localVars.clear();
        //System.out.println("\n\nvisit dec " + ctx.IDFR().getText() + " ,");
        for(int i=0; i<ctx.vardec().IDFR().size(); i++)
        {
            if(localVars.containsKey(ctx.vardec().IDFR(i).getText()))
            {
                throw new TypeException().duplicatedVarError();
            }
            if(visit(ctx.vardec().type(i)) == Types.UNIT){
                throw new TypeException().unitVarError();
            }
            localVars.put(ctx.vardec().IDFR(i).getText(), visit(ctx.vardec().type(i)));
        }
        //System.out.println("dec localVars: " + localVars);
        Types returnType = visit(ctx.body());
        if(visit(ctx.type()) != returnType){
            //System.out.println("dec type: " + visit(ctx.type()) + "\nbody type: " + visit(ctx.body()));
            throw new TypeException().functionBodyError();
        }
        localVars.clear();
        localVars.putAll(temp);
        return returnType;
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#vardec}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitVardec(InfixParser.VardecContext ctx) {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#body}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitBody(InfixParser.BodyContext ctx) {

        //System.out.print("\n\nvisit body, ");

        for(int i=0; i < ctx.type().size(); i++)
        {
            Types expType = visit(ctx.type(i));
            if(expType == Types.UNIT)
            {
                throw new TypeException().unitVarError();
            }else if(! (expType == Types.INT || expType == Types.BOOL) ){
                throw new TypeException().assignmentError();
            }
            if(localVars.containsKey(ctx.IDFR(i).getText()))
            {
                throw new TypeException().duplicatedVarError();
            }
            if(globalVars.containsKey(ctx.IDFR(i).getText()))
            {
                throw new TypeException().clashedVarError();
            }

            localVars.put(ctx.IDFR(i).getText(), visit(ctx.type(i)));
        }

        Types returnType = Types.UNIT;
        //System.out.println("BodyChildcount: " + ctx.ene().exp().size());
        for (int i=0; i < (ctx.ene().exp().size()); i++){
            InfixParser.ExpContext exp = ctx.ene().exp(i);
            //System.out.println("current exp: " + exp.getText());
            returnType = visit(exp);
            //System.out.println("i: " + i + "returntype: " + returnType);
        }
        //System.out.println("body return: " + returnType);
        return returnType;
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitBlock(InfixParser.BlockContext ctx) {

        Types returnType = Types.UNIT;
        for(int i=0; i < ctx.ene().exp().size(); i++){
            returnType = visit(ctx.ene().exp(i));
        }
        //add return type to be the type of the last line in the block

        return returnType;
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#ene}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitEne(InfixParser.EneContext ctx) {
        //System.out.print("visit ene, ");
        for(int i=0; i< (ctx.getChildCount() -1); i++)
        {
            visit(ctx.exp(i));
        }
        return visit(ctx.exp(ctx.getChildCount() - 1));
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitType(InfixParser.TypeContext ctx)
    {
        //System.out.print("type: " + ctx.getText() + ", ");
        if(ctx.getText().equalsIgnoreCase("int")){
            //System.out.print("return INT, ");
            return Types.INT;
        }else if(ctx.getText().equalsIgnoreCase("bool")){
            //System.out.print("return BOOL, ");
            return Types.BOOL;
        }else if(ctx.getText().equalsIgnoreCase("unit")){
            //System.out.print("return UNIT, ");
            return Types.UNIT;
        }else{
            throw new TypeException("Invalid Type Expression");
        }
    }

    /**
     * Visit a parse tree produced by the {@code IdentifierExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitIdentifierExp(InfixParser.IdentifierExpContext ctx)
    {
        if(!localVars.containsKey(ctx.IDFR().getText()))
        {
            //System.out.println(ctx.IDFR().getText() + " not defined");
            throw new TypeException().undefinedVarError();
        }

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
    public Types visitIntLitExp(InfixParser.IntLitExpContext ctx)
    {
        return Types.INT;
    }

    /**
     * Visit a parse tree produced by the {@code BoolLitExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitBoolLitExp(InfixParser.BoolLitExpContext ctx)
    {
        return Types.BOOL;
    }

    /**
     * Visit a parse tree produced by the {@code AssExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitAssExp(InfixParser.AssExpContext ctx)
    {
        if ( ! (globalVars.containsKey(ctx.IDFR().getText()) || localVars.containsKey(ctx.IDFR().getText()))  ) {
            //System.out.println("here: " + localVars);
            throw new TypeException().assignmentError();
        }
        if ( ! (visit(ctx.exp()) == Types.INT || visit(ctx.exp()) == Types.BOOL) ) {
            throw new TypeException().assignmentError();
        }

        return Types.UNIT;
    }

    /**
     * Visit a parse tree produced by the {@code BinopExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitBinopExp(InfixParser.BinopExpContext ctx) {
        Types op1type = visit(ctx.exp(0));
        Types op2type = visit(ctx.exp(1));

        return switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType())
                {
                    case InfixParser.LESSEQ, InfixParser.GREATEREQ, InfixParser.GREATER, InfixParser.LESS, InfixParser.EQUAL -> {
                        if (op1type != Types.INT || op2type != Types.INT){
                            throw new TypeException().comparisonError();
                        }
                        yield Types.BOOL;
                    }

                    case InfixParser.PLUS, InfixParser.MINUS, InfixParser.MULTIPLY, InfixParser.DIVIDE -> {
                        if (op1type != Types.INT || op2type != Types.INT){
                            throw new TypeException().arithmeticError();
                        }
                        yield Types.INT;
                    }

                    case InfixParser.AND, InfixParser.OR, InfixParser.XOR -> {
                        if (op1type != Types.BOOL || op2type != Types.BOOL){
                            throw new TypeException().logicalError();
                        }
                        yield Types.BOOL;
                    }


                    default -> {
                        throw new RuntimeException("Wrong binary operator");
                    }
                };
    }

    /**
     * Visit a parse tree produced by the {@code FuncExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitFuncExp(InfixParser.FuncExpContext ctx) {
        //makes sure function declaration exists
        if(!globalVars.containsKey(ctx.IDFR().getText())){
            throw new TypeException().undefinedFuncError();
        }

        //checking if the number of arguments in the call matches the number of arguments in the declaration
        RuleContext temp = ctx;
        while(temp.parent != null){
            temp = temp.parent;
        }
        InfixParser.DecContext funcDec = null;
        for(int i=0; i<( temp.getChildCount() - 1) ; i++)
        {
            if(((InfixParser.ProgContext) temp).dec(i).IDFR().getText().equals(ctx.IDFR().getText()) ){
                funcDec = ((InfixParser.ProgContext) temp).dec(i);
            }
        }
        //System.out.println("funcDec: " + funcDec.getText());
        if( ! (funcDec.vardec().type().size() == ctx.args().exp().size())){
            throw new TypeException().argumentNumberError();
        }

        //checking types of the arguments match the types in the declaration
        for(int i=0; i<funcDec.vardec().type().size(); i++)
        {
            //System.out.println("here");
            if(visit(funcDec.vardec().type(i)) != visit(ctx.args().exp(i)))
            {
                //System.out.println(visit(funcDec.vardec().type(i)) + " != " + visit(ctx.args().exp(i)));
                throw new TypeException().argumentError();
            }
        }

        return globalVars.get(ctx.IDFR().getText());
    }

    /**
     * Visit a parse tree produced by the {@code BlockExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitBlockExp(InfixParser.BlockExpContext ctx)
    {
//        for(int i=0; i < ctx.children.size(); i++){
//            visit(ctx.children.get(i));
//        }
//        return Types.UNIT;
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
    public Types visitIfThenElseExp(InfixParser.IfThenElseExpContext ctx) {
        if( visit(ctx.exp()) != Types.BOOL ){
            throw new TypeException().conditionError();
        }
        if(visit(ctx.block(0)) != visit(ctx.block(1))){
            throw new TypeException().branchMismatchError();
        }
        //System.out.println("IfThenElse: " + visit(ctx.block(1)) + " ,");
        return visit(ctx.block(1));
    }

    /**
     * Visit a parse tree produced by the {@code WhileExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitWhileExp(InfixParser.WhileExpContext ctx) {
        if( visit(ctx.exp()) != Types.BOOL ){
            throw new TypeException().conditionError();
        }
        if(visit(ctx.block()) != Types.UNIT){
            throw new TypeException().loopBodyError();
        }

        return Types.UNIT;
    }

    /**
     * Visit a parse tree produced by the {@code RepeatExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitRepeatExp(InfixParser.RepeatExpContext ctx)
    {
        if( visit(ctx.exp()) != Types.BOOL ){
            throw new TypeException().conditionError();
        }
        if(visit(ctx.block()) != Types.UNIT){
            throw new TypeException().loopBodyError();
        }

        return Types.UNIT;
    }

    /**
     * Visit a parse tree produced by the {@code PrintExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitPrintExp(InfixParser.PrintExpContext ctx) {
        //another way to do this is to get expression child and convert to text, then just check if equals to 'space' or 'newline'
        //System.out.println("visit print");
        if(visit(ctx.exp()) == Types.INT){
            return Types.UNIT;
        }else if(((TerminalNode) (ctx.exp().getChild(0))).getSymbol().getType() == InfixParser.SPACE ){
            return Types.UNIT;
        }else if(((TerminalNode) (ctx.exp().getChild(0))).getSymbol().getType() == InfixParser.NEWLINE ){
            return Types.UNIT;
        }else{
            throw new TypeException().printError();
        }
    }

    /**
     * Visit a parse tree produced by the {@code SpaceExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitSpaceExp(InfixParser.SpaceExpContext ctx) {
        return Types.UNIT;
    }

    /**
     * Visit a parse tree produced by the {@code NewLineExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitNewLineExp(InfixParser.NewLineExpContext ctx) {
        return Types.UNIT;
    }

    /**
     * Visit a parse tree produced by the {@code SkipExp}
     * labeled alternative in {@link InfixParser#exp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitSkipExp(InfixParser.SkipExpContext ctx) {
        return Types.UNIT;
    }

    /**
     * Visit a parse tree produced by {@link InfixParser#args}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitArgs(InfixParser.ArgsContext ctx) {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by the {@code EqBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitEqBinop(InfixParser.EqBinopContext ctx)
    {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by the {@code GreaterBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitGreaterBinop(InfixParser.GreaterBinopContext ctx)
    {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by the {@code LessBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitLessBinop(InfixParser.LessBinopContext ctx)
    {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by the {@code GreaterEqBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitGreaterEqBinop(InfixParser.GreaterEqBinopContext ctx)
    {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by the {@code LessEqBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitLessEqBinop(InfixParser.LessEqBinopContext ctx)
    {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by the {@code PlusBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitPlusBinop(InfixParser.PlusBinopContext ctx)
    {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by the {@code MinusBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitMinusBinop(InfixParser.MinusBinopContext ctx)
    {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by the {@code MultiplyBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitMultiplyBinop(InfixParser.MultiplyBinopContext ctx)
    {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by the {@code DivideBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitDivideBinop(InfixParser.DivideBinopContext ctx)
    {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by the {@code AndBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitAndBinop(InfixParser.AndBinopContext ctx)
    {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by the {@code OrBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitOrBinop(InfixParser.OrBinopContext ctx)
    {
        throw new RuntimeException("Invalid Expression");
    }

    /**
     * Visit a parse tree produced by the {@code XorBinop}
     * labeled alternative in {@link InfixParser#binop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Types visitXorBinop(InfixParser.XorBinopContext ctx)
    {
        throw new RuntimeException("Invalid Expression");
    }
}
