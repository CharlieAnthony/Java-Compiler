# Simple Programming Language Interpreter and RISC-V Code Generator

This project involves two main tasks, creating an interpreter and a RISC-V code generator, for a [simple programming language](/src/language.md). The language is based on a subset of the standard programming language features, and this project will help you to understand the fundamental concepts of interpreting and code generation.

The project has been split into two main tasks for easier navigation and understanding.

## Task 1: Creating an Interpreter

The first task involves creating an interpreter for our [simple programming language](/src/language.md). You will write a lexer, parser, and a bit of semantic analysis for this task. We'll be using the parser generator [ANTLR](https://www.antlr.org/) to ease the creation of this interpreter.

You can find all the details related to this task in the [task1.md](/src/task1.md) file.

This file provides a detailed description of:

- Execution Model of the language
- Type Deduction Rules
- Input/Output specifications

In the execution model, you'll understand how to structure the main function and the role of identifiers. The type deduction rules will help you understand the various types of expressions and their implementation. The input/output specification will guide you in understanding how to read a string and implement error handling.

## Task 2: RISC-V Code Generator

The second task is to create a code generator targeting RISC-V assembly for the same simple programming language. This task assumes that the input program has passed both the syntax and semantic analysis of the first task.

The code generator will read a string (the input program in our [simple programming language](/src/language.md) from `System.in` and generate RISC-V assembly code that can be simulated by [RARS](https://github.com/TheThirdOne/rars). You can find all the details related to this task in the [task2.md](/src/task2.md) file.

This file provides a detailed description of:

- The Input/Output specifications
- How to use the provided [assembler interface](/src/RARSInterface.java)

## How to Use

To use this project, you need to follow the steps below:

1) Clone or download this project to your local machine.
2) Navigate to each task (task1 and task2), and follow the instructions provided in their respective markdown files. You will need to understand the requirements and implement the interpreter and code generator accordingly.
3) Verify your implementation using the examples provided.

## Dependencies

- The ANTLR parser generator is required for both tasks. You can download it from [here](https://www.antlr.org/).
- The [RARS](https://github.com/TheThirdOne/rars) is required for task 2.

## Contributing

Contributions, issues, and feature requests are welcome. Feel free to check the issues page if you want to contribute.

## Contact

If you have any questions, feel free to reach out to me. My discord handle is `charlieanthony`.

## Acknowledgements
- [ANTLR](https://www.antlr.org/)
- [RARS](https://github.com/TheThirdOne/rars)
