// Generated from C:/Users/charl/OneDrive - University of Sussex/Compilers/Coursework/coursework v0.3/123456/task1/src\Infix.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InfixParser}.
 */
public interface InfixListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InfixParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(InfixParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(InfixParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(InfixParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(InfixParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixParser#vardec}.
	 * @param ctx the parse tree
	 */
	void enterVardec(InfixParser.VardecContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#vardec}.
	 * @param ctx the parse tree
	 */
	void exitVardec(InfixParser.VardecContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(InfixParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(InfixParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(InfixParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(InfixParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixParser#ene}.
	 * @param ctx the parse tree
	 */
	void enterEne(InfixParser.EneContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#ene}.
	 * @param ctx the parse tree
	 */
	void exitEne(InfixParser.EneContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(InfixParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(InfixParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAssExp(InfixParser.AssExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAssExp(InfixParser.AssExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinopExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBinopExp(InfixParser.BinopExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinopExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBinopExp(InfixParser.BinopExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFuncExp(InfixParser.FuncExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFuncExp(InfixParser.FuncExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBlockExp(InfixParser.BlockExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBlockExp(InfixParser.BlockExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfThenElseExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseExp(InfixParser.IfThenElseExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfThenElseExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseExp(InfixParser.IfThenElseExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterWhileExp(InfixParser.WhileExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitWhileExp(InfixParser.WhileExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RepeatExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterRepeatExp(InfixParser.RepeatExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RepeatExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitRepeatExp(InfixParser.RepeatExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterPrintExp(InfixParser.PrintExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitPrintExp(InfixParser.PrintExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SpaceExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSpaceExp(InfixParser.SpaceExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SpaceExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSpaceExp(InfixParser.SpaceExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewLineExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNewLineExp(InfixParser.NewLineExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewLineExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNewLineExp(InfixParser.NewLineExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SkipExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSkipExp(InfixParser.SkipExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SkipExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSkipExp(InfixParser.SkipExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExp(InfixParser.IdentifierExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExp(InfixParser.IdentifierExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntLitExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIntLitExp(InfixParser.IntLitExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntLitExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIntLitExp(InfixParser.IntLitExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolLitExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBoolLitExp(InfixParser.BoolLitExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolLitExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBoolLitExp(InfixParser.BoolLitExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link InfixParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(InfixParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InfixParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(InfixParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterEqBinop(InfixParser.EqBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitEqBinop(InfixParser.EqBinopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterGreaterBinop(InfixParser.GreaterBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitGreaterBinop(InfixParser.GreaterBinopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterLessBinop(InfixParser.LessBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitLessBinop(InfixParser.LessBinopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterEqBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterGreaterEqBinop(InfixParser.GreaterEqBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterEqBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitGreaterEqBinop(InfixParser.GreaterEqBinopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessEqBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterLessEqBinop(InfixParser.LessEqBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessEqBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitLessEqBinop(InfixParser.LessEqBinopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PlusBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterPlusBinop(InfixParser.PlusBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PlusBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitPlusBinop(InfixParser.PlusBinopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MinusBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterMinusBinop(InfixParser.MinusBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MinusBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitMinusBinop(InfixParser.MinusBinopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplyBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyBinop(InfixParser.MultiplyBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplyBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyBinop(InfixParser.MultiplyBinopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DivideBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterDivideBinop(InfixParser.DivideBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DivideBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitDivideBinop(InfixParser.DivideBinopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterAndBinop(InfixParser.AndBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitAndBinop(InfixParser.AndBinopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterOrBinop(InfixParser.OrBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitOrBinop(InfixParser.OrBinopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XorBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterXorBinop(InfixParser.XorBinopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XorBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitXorBinop(InfixParser.XorBinopContext ctx);
}