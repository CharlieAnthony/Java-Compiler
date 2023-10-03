import org.antlr.v4.runtime.*;

public class DemoTask1 {

    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        CharStream input = CharStreams.fromStream(System.in);

        // create a lexer that feeds off of input CharStream
        DemoLangLexer lexer = new DemoLangLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        DemoLangParser parser = new DemoLangParser(tokens);
        DemoLangParser.ProgContext tree = parser.prog(); // begin parsing at prog rule

        DemoLangChecker checker = new DemoLangChecker();
        try {
            checker.visit(tree);
        } catch (DemoTypeException ex) {
            System.out.println(ex.report());
            return;
        }

        DemoLangInterpreter interpreter = new DemoLangInterpreter();
        Integer mainReturnValue = interpreter.visitProgram(tree, args);
        System.out.println("NORMAL_TERMINATION");
        System.out.println(mainReturnValue);

    }
}