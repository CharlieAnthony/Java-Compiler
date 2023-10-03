// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DemoLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DemoLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DemoLangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(DemoLangParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link DemoLangParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(DemoLangParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DemoLangParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(DemoLangParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link DemoLangParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(DemoLangParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinOpExpr}
	 * labeled alternative in {@link DemoLangParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinOpExpr(DemoLangParser.BinOpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileExpr}
	 * labeled alternative in {@link DemoLangParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileExpr(DemoLangParser.WhileExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntExpr}
	 * labeled alternative in {@link DemoLangParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(DemoLangParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link DemoLangParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(DemoLangParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DemoLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(DemoLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessEqBinop}
	 * labeled alternative in {@link DemoLangParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessEqBinop(DemoLangParser.LessEqBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PlusBinop}
	 * labeled alternative in {@link DemoLangParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusBinop(DemoLangParser.PlusBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MinusBinop}
	 * labeled alternative in {@link DemoLangParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusBinop(DemoLangParser.MinusBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndBinop}
	 * labeled alternative in {@link DemoLangParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndBinop(DemoLangParser.AndBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code XorBinop}
	 * labeled alternative in {@link DemoLangParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXorBinop(DemoLangParser.XorBinopContext ctx);
}