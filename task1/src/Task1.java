import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class Task1 {

    public static void main(String[] args) throws Exception {
        //create a CharStream that reads from standard input
        CharStream input = CharStreams.fromStream(System.in);
        //CharStream input = CharStreams.fromFileName("C:\\Users\\charl\\OneDrive - University of Sussex\\Compilers\\Coursework\\coursework v0.3\\123456\\task1\\src\\test.txt");

        // create a lexer that feeds off of input CharStream
        InfixLexer lexer = new InfixLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        InfixParser parser = new InfixParser(tokens);
        ParseTree tree = parser.prog(); // begin parsing at expr rule

        InfixChecker checker = new InfixChecker();
        try {
            checker.visit(tree);
        } catch (TypeException ex) {
            System.out.println(ex.report());
            return;
        }

        InfixEvaluator evaluator = new InfixEvaluator();
        Integer returnValue = evaluator.visitProgram((InfixParser.ProgContext) tree, args);
        System.out.println("\nNORMAL_TERMINATION");
        System.out.println(returnValue);

    }
}