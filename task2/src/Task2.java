import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class Task2 {

    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        CharStream input = CharStreams.fromStream(System.in);
        //CharStream input = CharStreams.fromFileName("C:\\Users\\charl\\OneDrive - University of Sussex\\Compilers\\Coursework\\coursework v0.3\\123456\\task1\\src\\test.txt");


        // create a lexer that feeds off of input CharStream
        InfixLexer lexer = new InfixLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        InfixParser parser = new InfixParser(tokens);
        ParseTree tree = parser.prog(); // begin parsing at prog rule

        String stackMachineMacros = """
                    .macro    PushImm        $number
                        li          t0, $number
                        sw          t0, (sp)
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro    PushReg        $reg
                        sw          $reg, (sp)
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro    PopReg        $reg
                        lw          $reg, 4(sp)
                        addi        sp, sp, 4
                    .end_macro
                    
                    .macro    Discard        $bytes
                        addi        sp, sp, $bytes
                    .end_macro
                    
                    .macro    Popt1t2
                        lw          t1, 4(sp)
                        addi        sp, sp, 4
                        lw          t2, 4(sp)
                        addi        sp, sp, 4
                    .end_macro
                    
                    .macro Equal
                        Popt1t2
                        li          t0, 1
                        sw          t0, (sp)
                        beq         t1, t2, exit
                        sw          zero, (sp)
                    exit:
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro CompLE
                        Popt1t2
                        li          t0, 1
                        sw          t0, (sp)
                        ble         t1, t2, exit
                        sw          zero, (sp)
                    exit:
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro CompL
                        Popt1t2
                        sub         t1, t1, 1
                        li          t0, 1
                        sw          t0, (sp)
                        ble         t1, t2, exit
                        sw          zero, (sp)
                    exit:
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro CompGE
                        Popt1t2
                        li          t0, 1
                        sw          t0, (sp)
                        bge         t1, t2, exit
                        sw          zero, (sp)
                    exit:
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro CompG
                        Popt1t2
                        add         t1, t1, 1
                        li          t0, 1
                        sw          t0, (sp)
                        bge         t1, t2, exit
                        sw          zero, (sp)
                    exit:
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro    Plus
                        Popt1t2
                        add         t1, t1, t2
                        sw          t1, (sp)
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro    Minus
                        Popt1t2
                        sub         t1, t1, t2
                        sw          t1, (sp)
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro    Multiply
                        Popt1t2
                        mul         t1, t1, t2
                        sw          t1, (sp)
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro    Divide
                        Popt1t2
                        div         t1, t1, t2
                        sw          t1, (sp)
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro    LogicalAnd
                        Popt1t2
                        and         t1, t1, t2
                        sw          t1, (sp)
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro    LogicalOr
                        Popt1t2
                        or         t1, t1, t2
                        sw          t1, (sp)
                        addi        sp, sp, -4
                    .end_macro
                    
                    .macro    LogicalXor
                        Popt1t2
                        xor         t1, t1, t2
                        sw          t1, (sp)
                        addi        sp, sp, -4
                    .end_macro
                            
                    .macro    Jump        $address
                        j           $address
                    .end_macro
                    
                    .macro    JumpTrue    $address
                        lw          t1, 4(sp)
                        addi        sp, sp, 4
                        beqz        t1, exit
                        j           $address
                    exit:
                    .end_macro
                    
                    """;


        InfixChecker checker = new InfixChecker();
        try {
            checker.visit(tree);
        } catch (TypeException ex) {
            System.out.println(ex.report());
            return;
        }

        InfixCodeGenerator codegen = new InfixCodeGenerator();
        System.out.println(stackMachineMacros + codegen.visit(tree));

    }
}
