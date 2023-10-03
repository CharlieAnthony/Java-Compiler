import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class DemoLangChecker extends AbstractParseTreeVisitor<DemoTypes> implements DemoLangVisitor<DemoTypes>
{


    // In DemoLang, since all variables are INT, these are just for checking whether
    // variables are defined when they are used
    private final Map<String, DemoTypes> localVars = new HashMap<>();


    @Override public DemoTypes visitProg(DemoLangParser.ProgContext ctx)
    {

        for (int i = 0; i < ctx.args().Idfr().size(); ++i) {
            if (localVars.containsKey(ctx.args().Idfr(i).getText())) {
                throw new DemoTypeException().duplicatedVarError();
            }
            localVars.put(ctx.args().Idfr(i).getText(), DemoTypes.INT);
        }

        DemoTypes returnType = visit(ctx.body());
        if (returnType != DemoTypes.INT) {
            throw new DemoTypeException().returnTypeError();
        }

        return returnType;

    }
    @Override public DemoTypes visitArgs(DemoLangParser.ArgsContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public DemoTypes visitBody(DemoLangParser.BodyContext ctx)
    {

        for (int i = 0; i < ctx.localvars.size(); ++i) {
            DemoTypes expType = visit(ctx.localvarsexps.get(i));
            if (expType != DemoTypes.INT) {
                throw new DemoTypeException().assignError();
            }
            if (localVars.containsKey(ctx.localvars.get(i).getText())) {
                throw new DemoTypeException().duplicatedVarError();
            }
            localVars.put(ctx.localvars.get(i).getText(), DemoTypes.INT);
        }

        DemoTypes returnType = DemoTypes.UNKNOWN;
        for (int i = 0; i < ctx.ene.size(); ++i) {
            DemoLangParser.ExpContext exp = ctx.ene.get(i);
            returnType = visit(exp);
        }
        return returnType;        // Return the type of the last expr in body.

    }
    @Override public DemoTypes visitAssignExpr(DemoLangParser.AssignExprContext ctx)
    {
        if (!localVars.containsKey(ctx.Idfr().getText())) {
            throw new DemoTypeException().undefinedVarError();
        }
        if (visit(ctx.exp()) != DemoTypes.INT) {
            throw new DemoTypeException().assignError();
        }
        return DemoTypes.UNKNOWN;   // Doesn't matter
    }
    @Override public DemoTypes visitBinOpExpr(DemoLangParser.BinOpExprContext ctx)
    {
        DemoTypes operand1Type = visit(ctx.exp(0));
        DemoTypes operand2Type = visit(ctx.exp(1));

        return switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()) {

            case DemoLangParser.LessEq ->  {

                if (operand1Type != DemoTypes.INT || operand2Type != DemoTypes.INT) {
                    throw new DemoTypeException().incompatibleOperandsError();
                }
                yield DemoTypes.BOOL;

            }

            case DemoLangParser.Plus, DemoLangParser.Minus -> {

                if (operand1Type != DemoTypes.INT || operand2Type != DemoTypes.INT) {
                    throw new DemoTypeException().incompatibleOperandsError();
                }
                yield DemoTypes.INT;

            }

            case DemoLangParser.And, DemoLangParser.Xor -> {

                if (operand1Type != DemoTypes.BOOL || operand2Type != DemoTypes.BOOL) {
                    throw new DemoTypeException().incompatibleOperandsError();
                }
                yield DemoTypes.BOOL;

            }

            default -> {
                throw new RuntimeException("Shouldn't be here - wrong binary operator.");
            }

        };

    }
    @Override public DemoTypes visitWhileExpr(DemoLangParser.WhileExprContext ctx)
    {

        if (visit(ctx.exp()) != DemoTypes.BOOL) {
            throw new DemoTypeException().condError();
        }

        visit(ctx.block());

        return DemoTypes.UNKNOWN;

    }
    @Override public DemoTypes visitIntExpr(DemoLangParser.IntExprContext ctx)
    {
        return DemoTypes.INT;
    }
    @Override public DemoTypes visitIdExpr(DemoLangParser.IdExprContext ctx)
    {
        if (!localVars.containsKey(ctx.Idfr().getText())) {
            throw new DemoTypeException().undefinedVarError();
        }
        return DemoTypes.INT;   // Well, because we only have INT variables..
    }
    @Override public DemoTypes visitBlock(DemoLangParser.BlockContext ctx)
    {
        for (int i = 0; i < ctx.exps.size(); ++i) {
            visit(ctx.exps.get(i));
        }
        return DemoTypes.UNKNOWN;
    }
    @Override public DemoTypes visitLessEqBinop(DemoLangParser.LessEqBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public DemoTypes visitPlusBinop(DemoLangParser.PlusBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public DemoTypes visitMinusBinop(DemoLangParser.MinusBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public DemoTypes visitAndBinop(DemoLangParser.AndBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }
    @Override public DemoTypes visitXorBinop(DemoLangParser.XorBinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

}
