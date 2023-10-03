import org.antlr.v4.runtime.*;

public class DemoTask2 {

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
                    
                    .macro CompLE
                        Popt1t2
                        li          t0, 1
                        sw          t0, (sp)
                        ble         t1, t2, exit
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
                    
                    .macro    LogicalAnd
                        Popt1t2
                        and         t1, t1, t2
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

        DemoLangCodeGenerator codegen = new DemoLangCodeGenerator();
        System.out.println(stackMachineMacros + codegen.visit(tree));

    }
}