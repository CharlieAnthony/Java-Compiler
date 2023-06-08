# Task 1: Creating an Interpreter
## Summary
In this task you will write an interpreter for a [simple programming language]; this will involve writing a lexer, a parser (or their combination, if suitable), and doing a bit of semantic analysis. We will use the parser generator [ANTLR](https://www.antlr.org/) as our main tool to reduce the amount of hand-written code required.

## Execution Model
In our simple programming language, the main function is a function `int main(...)`, which may occur anywhere in the function declarations. The return value of a function is the value of the final expression in its body. All arguments to functions are passed by value, and the only identifiers defined in any function are as follows:
- The names of other functions (which may be defined before or after the current function in the source file);
- The parameters taken by the current function;
- The local variables (defined at the top of the current function's body).

In other words, all functions are side-effect-free and of 'global scope', while parameters and local variables are of 'function scope'. **There is one special case: when a local variable is being initialised, only the first two items above and local variables defined before it are available.** We summarise the rules about arguments, scoping, and return values as follows:
- No two functions may have the same name;
- The definition of a function `fnA` may involve the invocation other functions that are defined before or after the function `fnA`;
- No two parameters or local variables of the same function `fnA` may have the same name;
- No parameter or local variable may have the same name as a function;
- Parameters and local variables of `fnA` are only in-scope in the body of `fnA`;
- All parameters or local variables must have either `int` or `bool` types;
- The `main` function must return `int`.

## Type Deduction Rules
The following are the rules which specify how expressions of various kinds are to be typed.

### Numerical expressions
These are expressions which take values of type `int`, in particular arising from arithmetic operations on two values of type `int`. Any expression involving an arithmetic operator as below, where one of the sub-expressions involved is not of type `int`, should result in an error.





