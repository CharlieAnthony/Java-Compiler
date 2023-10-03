import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class DemoLangCodeGenerator extends AbstractParseTreeVisitor<String> implements DemoLangVisitor<String>
{

    private int numOfArgs;
    private List<TerminalNode> args;
    private final Map<String, Integer> localVars = new HashMap<>();

    private int labelCounter = 0;

    @Override public String visitProg(DemoLangParser.ProgContext ctx)
    {
        numOfArgs = ctx.args().Idfr().size();
        args = ctx.args().Idfr();
        return visit(ctx.body());
    }
    @Override public String visitArgs(DemoLangParser.ArgsContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public String visitBody(DemoLangParser.BodyContext ctx)
    {
        if (numOfArgs + ctx.localvars.size() > 22) {     // x10 - x31
            throw new RuntimeException("Too many local variables.");
        }

        StringBuilder sb = new StringBuilder();

        sb.append("""
                main:
                    lw          ra, 4(sp)
                    addi        sp, sp, 4
                """
        );

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

        for (int i = 0; i < ctx.localvars.size(); ++i) {
            localVars.put(ctx.localvars.get(i).getText(), i + regOffset);
            sb.append(visit(ctx.localvarsexps.get(i)));
            sb.append(
                String.format("""
                    lw          x%2d, 4(sp)
                    addi        sp, sp, 4
                """,
                i + regOffset
                )
            );
        }

        for (int i = 0; i < ctx.ene.size(); ++i) {
            sb.append(visit(ctx.ene.get(i)));
        }

        sb.append("""
                    ret
                """
        );

        return sb.toString();

    }
    @Override public String visitAssignExpr(DemoLangParser.AssignExprContext ctx)
    {

        StringBuilder sb = new StringBuilder();
        sb.append(visit(ctx.exp()));
        sb.append(
                String.format("""
                    PopReg      x%2d
                """,
                localVars.get(ctx.Idfr().getText())
                )
        );
        return sb.toString();
    }
    @Override public String visitBinOpExpr(DemoLangParser.BinOpExprContext ctx)
    {

        StringBuilder sb = new StringBuilder();

        sb.append(visit(ctx.exp(1)));
        sb.append(visit(ctx.exp(0)));

        switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()) {

            case DemoLangParser.LessEq -> {

                sb.append("""
                    CompLE
                """
                );

            }
            case DemoLangParser.Plus -> {

                sb.append("""
                    Plus
                """
                );

            }
            case DemoLangParser.Minus -> {

                sb.append("""
                    Minus
                """
                );

            }
            case DemoLangParser.And -> {

                sb.append("""
                    LogicalAnd
                """
                );

            }
            case DemoLangParser.Xor -> {

                sb.append("""
                    LogicalXor
                """
                );

            }
            default -> {
                throw new RuntimeException("Shouldn't be here - wrong binary operator.");
            }

        }

        return sb.toString();
    }
    @Override public String visitWhileExpr(DemoLangParser.WhileExprContext ctx)
    {

        StringBuilder sb = new StringBuilder();
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
                    PushImm     1
                    LogicalXor
                    JumpTrue    %s
                """,
                exitLabel)
        );

        sb.append(visit(ctx.block()));

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
    @Override public String visitIntExpr(DemoLangParser.IntExprContext ctx)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(
                String.format("""
                    PushImm      %d
                """,
                Integer.parseInt(ctx.IntLit().getText())
                )
        );
        return sb.toString();
    }
    @Override public String visitIdExpr(DemoLangParser.IdExprContext ctx)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(
                String.format("""
                    PushReg     x%2d
                """,
                localVars.get(ctx.Idfr().getText())
                )
        );
        return sb.toString();
    }
    @Override public String visitBlock(DemoLangParser.BlockContext ctx)
    {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ctx.exps.size(); ++i) {
            sb.append(visit(ctx.exps.get(i)));

            if (
                   ctx.exps.get(i) instanceof DemoLangParser.BinOpExprContext
                || ctx.exps.get(i) instanceof DemoLangParser.IntExprContext
                || ctx.exps.get(i) instanceof DemoLangParser.IdExprContext
                ) {

                sb.append("""
                    Discard     4
                """
                );

            }

        }

        return sb.toString();

    }
    @Override public String visitLessEqBinop(DemoLangParser.LessEqBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public String visitPlusBinop(DemoLangParser.PlusBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public String visitMinusBinop(DemoLangParser.MinusBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public String visitAndBinop(DemoLangParser.AndBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public String visitXorBinop(DemoLangParser.XorBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

}
