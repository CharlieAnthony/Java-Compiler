# Task 2: RISC-V Code generator

## Summary

In this task, you are going to implement a *code generator* targeting RISC-V assembly for the same [simple programming language](language.md). For this task, we assume that the input program has passed both the syntax and semantic analysis ([Task 1](task1.md)). We will once again use the parser generator [ANTLR](https://www.antlr.org/) as our main tool to reduce the amount of hand-written code required.

The generated code, which is printed to `System.out`, should be valid and executable RISC-V assembly code, and in particular contains a label `main` (where the program starts execution). For your reference, we provide the [assembler interface](RARSInterface.java) (based on [RARS](https://github.com/TheThirdOne/rars)'s Java API) that we use to verify your generated code.

## Input / output specification

Your code generator will read a string (the input program in our [simple programming language](language.md)) from `System.in`; the input program is assumed to satisfy all the type deduction rules of [Task 1](task1.md). It will generate RISC-V assembly code that implements the input program — in particular, the generated code can be simulated by [RARS](https://github.com/TheThirdOne/rars) through the provided [assembler interface](RARSInterface.java), which does the following (with a "bootstrap loader" snippet) before jumping to the label `main`:

1) Pushes a **return value** onto the stack (whose value will be modified by your generated code).
2) Pushes the **arguments** (by convention, in reverse order) onto the stack.
3) Pushes the **return address** — the address right after the jump — onto the stack.

After the generated code finishes its operations, it should jump back to the return address (3. above), and the only value left on the stack should be the return value of `main` (1. above). As a concrete example, [twoargs.asm](twoargs.asm) is generated from a `main` function that takes two integer arguments and prints them to the screen. If we have placed `rars_27a7c1f.jar` and `RARSInterface.java` in the current folder, we can run [twoargs.asm](twoargs.asm) as follows:

- On -nix based systems:

    We can pipe RISC-V assembly code into [RARS](https://github.com/TheThirdOne/rars) with the shell command:
    
    `cat twoargs.asm | java -classpath ./rars_27a7c1f.jar ./RARSInterface.java 3 5 `
    
- On Windows systems:

    We can pipe RISC-V assembly code into [RARS](https://github.com/TheThirdOne/rars) on the command line using:
   
    `cmd /c "(type .\twoargs.asm) | java -classpath .\rars_27a7c1f.jar .\RARSInterface.java 3 5"`
