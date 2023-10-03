// Generated from C:/Users/charl/OneDrive - University of Sussex/Compilers/Coursework/coursework v0.3/123456/task1/src\Infix.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InfixParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InfixVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InfixParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(InfixParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link InfixParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(InfixParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by {@link InfixParser#vardec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardec(InfixParser.VardecContext ctx);
	/**
	 * Visit a parse tree produced by {@link InfixParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(InfixParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link InfixParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(InfixParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link InfixParser#ene}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEne(InfixParser.EneContext ctx);
	/**
	 * Visit a parse tree produced by {@link InfixParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(InfixParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssExp(InfixParser.AssExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinopExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinopExp(InfixParser.BinopExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExp(InfixParser.FuncExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockExp(InfixParser.BlockExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfThenElseExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseExp(InfixParser.IfThenElseExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileExp(InfixParser.WhileExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RepeatExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatExp(InfixParser.RepeatExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExp(InfixParser.PrintExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SpaceExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpaceExp(InfixParser.SpaceExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewLineExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewLineExp(InfixParser.NewLineExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SkipExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipExp(InfixParser.SkipExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExp(InfixParser.IdentifierExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntLitExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLitExp(InfixParser.IntLitExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolLitExp}
	 * labeled alternative in {@link InfixParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLitExp(InfixParser.BoolLitExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link InfixParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(InfixParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqBinop(InfixParser.EqBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterBinop(InfixParser.GreaterBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessBinop(InfixParser.LessBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterEqBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterEqBinop(InfixParser.GreaterEqBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessEqBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessEqBinop(InfixParser.LessEqBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PlusBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusBinop(InfixParser.PlusBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MinusBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusBinop(InfixParser.MinusBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplyBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyBinop(InfixParser.MultiplyBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivideBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivideBinop(InfixParser.DivideBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndBinop(InfixParser.AndBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrBinop(InfixParser.OrBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XorBinop}
	 * labeled alternative in {@link InfixParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXorBinop(InfixParser.XorBinopContext ctx);
}