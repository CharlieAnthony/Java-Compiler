import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class    DemoLangInterpreter extends AbstractParseTreeVisitor<Integer> implements DemoLangVisitor<Integer>
{

    private final Map<String, Integer> localVars = new HashMap<>();

    public Integer visitProgram(DemoLangParser.ProgContext ctx, String[] args)
    {

        for (int i = 0; i < args.length; ++i) {
            if (args[i].equals("true")) {
                localVars.put(ctx.args().Idfr(i).getText(), 1);
            } else if (args[i].equals("false")) {
                localVars.put(ctx.args().Idfr(i).getText(), 0);
            } else {
                localVars.put(ctx.args().Idfr(i).getText(), Integer.parseInt(args[i]));
            }
        }

        return visit(ctx.body());

    }

    @Override public Integer visitProg(DemoLangParser.ProgContext ctx)
    {
        // We no longer need this method as we already have our custom replacement "visitProgram"
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitArgs(DemoLangParser.ArgsContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitBody(DemoLangParser.BodyContext ctx)
    {
        for (int i = 0; i < ctx.localvars.size(); ++i) {
            localVars.put(ctx.localvars.get(i).getText(), visit(ctx.localvarsexps.get(i)));
        }

        Integer returnValue = null;
        for (int i = 0; i < ctx.ene.size(); ++i) {
            returnValue = visit(ctx.ene.get(i));
        }
        return returnValue;
    }
    @Override public Integer visitAssignExpr(DemoLangParser.AssignExprContext ctx)
    {
        localVars.replace(ctx.Idfr().getText(), visit(ctx.exp()));
        return null;
    }
    @Override public Integer visitBinOpExpr(DemoLangParser.BinOpExprContext ctx)
    {
        Integer oprnd1 = visit(ctx.exp(0));
        Integer oprnd2 = visit(ctx.exp(1));

        switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()) {

            case DemoLangParser.LessEq -> {

                return ((oprnd1 <= oprnd2) ? 1 : 0);

            }
            case DemoLangParser.Plus -> {

                return oprnd1 + oprnd2;

            }
            case DemoLangParser.Minus -> {

                return oprnd1 - oprnd2;

            }
            case DemoLangParser.And -> {

                return oprnd1 & oprnd2;

            }
            case DemoLangParser.Xor -> {

                return oprnd1 ^ oprnd2;

            }
            default -> {
                throw new RuntimeException("Shouldn't be here - wrong binary operator.");
            }

        }
    }
    @Override public Integer visitWhileExpr(DemoLangParser.WhileExprContext ctx)
    {

        while (visit(ctx.exp()) > 0) {
            visit(ctx.block());
        }

        return null;
    }
    @Override public Integer visitIntExpr(DemoLangParser.IntExprContext ctx)
    {
        return Integer.parseInt(ctx.IntLit().getText());
    }
    @Override public Integer visitIdExpr(DemoLangParser.IdExprContext ctx)
    {
        return localVars.get(ctx.Idfr().getText());
    }
    @Override public Integer visitBlock(DemoLangParser.BlockContext ctx)
    {
        for (int i = 0; i < ctx.exps.size(); ++i) {
            visit(ctx.exps.get(i));
        }
        return null;
    }
    @Override public Integer visitLessEqBinop(DemoLangParser.LessEqBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitPlusBinop(DemoLangParser.PlusBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitMinusBinop(DemoLangParser.MinusBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitAndBinop(DemoLangParser.AndBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitXorBinop(DemoLangParser.XorBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

}
