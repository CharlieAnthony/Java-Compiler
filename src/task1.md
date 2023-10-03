# Task 1: Creating an Interpreter
## Summary
In this task you will write an interpreter for a [simple programming language](language.md); this will involve writing a lexer, a parser (or their combination, if suitable), and doing a bit of semantic analysis. We will use the parser generator [ANTLR](https://www.antlr.org/) as our main tool to reduce the amount of hand-written code required.

## Execution Model
In our [simple programming language](language.md), the main function is a function `int main(...)`, which may occur anywhere in the function declarations. The return value of a function is the value of the final expression in its body. All arguments to functions are passed by value, and the only identifiers defined in any function are as follows:
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

| Operation | Expression |
| --------- | ---------- |  
| Integer constants | `                        `<br/>`     Γ ⊢ INTLIT : int     ` |
| Addition | `Γ ⊢ P : int` `Γ ⊢ Q : int`<br/>`    Γ ⊢ (P + Q) : int     ` |
| Subtraction | `Γ ⊢ P : int` `Γ ⊢ Q : int`<br/>`    Γ ⊢ (P - Q) : int     ` |
| Multiplication | `Γ ⊢ P : int` `Γ ⊢ Q : int`<br/>`    Γ ⊢ (P * Q) : int     ` |
| Division | `Γ ⊢ P : int` `Γ ⊢ Q : int`<br/>`    Γ ⊢ (P / Q) : int     ` |

### Comparisons
Comparison expressions are ones which relate two expressions of type `int`, to produce an expression of type `bool`. Any expression involving a comparison operator as below, where one of the sub-expressions involved is not of type `int`, should result in an error.

| Operation | Expression |
| --------- | ---------- |
| Equality | `Γ ⊢ P : int` `Γ ⊢ Q : int`<br/>`    Γ ⊢ (P == Q) : bool   ` |
| Less than | `Γ ⊢ P : int` `Γ ⊢ Q : int`<br/>`    Γ ⊢ (P < Q) : bool    ` |
| Greater than | `Γ ⊢ P : int` `Γ ⊢ Q : int`<br/>`    Γ ⊢ (P > Q) : bool    ` |
| Less than or equal | `Γ ⊢ P : int` `Γ ⊢ Q : int`<br/>`   Γ ⊢ (P <= Q) : bool    ` |
| Greater than or equal | `Γ ⊢ P : int` `Γ ⊢ Q : int`<br/>`   Γ ⊢ (P >= Q) : bool    ` |

### Boolean operations
These are expressions which combine two values of type `bool` using a logical operation, to produce another value of type `bool`. Any expression involving a logical operator as below, where one of the sub-expressions involved is not of type `bool`, should result in an error.

| Operation | Expression |
| --------- | ---------- |  
| Boolean constants | `                          `<br/>`     Γ ⊢ BOOLLIT : bool     ` |
| Logical AND | `Γ ⊢ P : bool` `Γ ⊢ Q : bool`<br/>`     Γ ⊢ (P & Q) : bool     ` |
| Logical OR | `Γ ⊢ P : bool` `Γ ⊢ Q : bool`<br/>`     Γ ⊢ (P \| Q) : bool     ` |
| Logical XOR | `Γ ⊢ P : bool` `Γ ⊢ Q : bool`<br/>`     Γ ⊢ (P ^ Q) : bool     ` |

### Statements
These are 'expressions' which represent statements — not having an interesting value (represented by assigning them the type `unit`). Any statement such as those below, which involve a mismatch of types where type-agreement is required, or which involve an expression other than type `bool` where a Boolean expression is expected, should result in an error. In particular, `print` must be followed by either `space` or `newline`, or an expression of type `int`.
| Operation | Expression |
| --------- | ---------- |  
| Print statements | `           Γ ⊢ E : int           `<br/>`        Γ ⊢ print E : unit       `<hr/>`            E = space            `<br/>`        Γ ⊢ print E : unit       `<hr/>`           E = newline           `<br/>`        Γ ⊢ print E : unit       ` |
| Space statements | `                               `<br/>`         Γ ⊢ space : unit        ` |
| Newline statements | `                               `<br/>`        Γ ⊢ newline : unit       ` |
| Skip statements | `                               `<br/>`         Γ ⊢ skip : unit         ` |
| Assignment | `    Γ ⊢ x : α    ` `    Γ ⊢ P : α    `<br/>`        Γ ⊢ x := P : unit         ` |
| While loops | `  Γ ⊢ C : bool   ` `   Γ ⊢ B : unit  `<br/>`    Γ ⊢ while C do {B} : unit     ` |
| Repeat loops | `  Γ ⊢ B : unit   ` `   Γ ⊢ C : bool  `<br/>`  Γ ⊢ repeat {B} until C : unit   ` |

### Generic expressions
These are expressions, whose types depend entirely on the types of other identifiers or expressions. Any expression involving a mismatch of types should result in an error.

| Operation            | Expression                                                                                        |
| --- | --- |  
| Function invocations | `Γ ⊢ subr : (α₁ , ... , αₙ) → β     Γ ⊢ E₁ : α₁   ...   Γ ⊢ Eₙ : αₙ`<br/>`                    Γ ⊢ subr (E1, ... , En) : β                    ` |
| Block expressions    | `Γ ⊢ E₁ : α₁   ...   Γ ⊢ Eₙ : αₙ`<br/>`      Γ ⊢ E₁;  ...  ;Eₙ : αₙ     ` |
| If statements        | `Γ ⊢ C : bool` `Γ ⊢ B₁ : α` `Γ ⊢ B₂ : α`<br/>`   Γ ⊢ if C then {B₁} else {B₂} : α   ` |                       | Q) : bool     ` |

## Input / Output specification
Your interpreter will read a string (the input program in our [simple programming language](language.md)) from `System.in`. It also reads the command-line arguments, where each argument (as specified on the command line) must be either an `INTLIT` or a `BOOLLIT`. The interpreter will conduct the following checks (you do not necessarily need to do the checks in the order below):

1. Check that the program has a `main` function, which has return type `int`;
2. Check that all the functions have distinct names, and all the parameters and local variables of each function have distinct names (that do not clash with function names);
3. Check that all the identifiers used in a function, are either the names of parameters or local variables of that function, or the names of other functions which are defined somewhere;
4. Based on the type deduction rules above, type-check the function bodies. Note that you do **not** need to check that the types of the parameters of `main` matches the types of the command-line arguments passed to the interpreter — we assume that this is always the case.

If any one of these conditions fail, your program will throw an instance of [a custom RuntimeException class](TypeException.java) that we provide. The exception should be caught by the main method in your Java code, which should then invoke the report method of the exception like below:

```java
    try {
        ...(run your type checker on the parse tree)...
    } catch (TypeException ex) {
        System.out.println(ex.report());
    }
```

If the input program passes all these checks (i.e. it is syntactically and semantically valid), then your interpreter can start simulating the program. The semantics of the language constructs should be self-explanatory; in particular, your interpreter will print to `System.out` as requested by `print` statements in the input program, followed by a line separator (`System.out.println()`), and then two separate lines: the first contains the string `NORMAL_TERMINATION`, and the second contains the return value of `main`.

Some input / output examples can be found in [this file].
