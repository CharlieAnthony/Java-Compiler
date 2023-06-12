# Task 2: RISC-V Code generator

## Summary

In this task, you are going to implement a *code generator* targeting RISC-V assembly for the same [simple programming language](language.md). For this task, we assume that the input program has passed both the syntax and semantic analysis ([Task 1](task1.md)). We will once again use the parser generator [ANTLR](https://www.antlr.org/) as our main tool to reduce the amount of hand-written code required.

The generated code, which is printed to `System.out`, should be valid and executable RISC-V assembly code, and in particular contains a label `main` (where the program starts execution). For your reference, we provide the assembler interface (based on RARS's Java API) that we use to verify your generated code.

Please also carefully read the submission guidelines.
