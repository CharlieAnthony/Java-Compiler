# Language Syntax

## Lexical description

### Token types / Lexemes

The lexical units of the language are keywords, integers, identifiers, special symbols, and white spaces. Any input string that contains only those components is lexically valid.

  - Keywords

    `if`, `then`, `else`, `while`, `do`, `repeat`, `until`, `print`, `space`, `newline`, `skip`, `int`, `bool`, `unit`, `true`, `false`. Note that keywords are case-sensitive and in all lowercase.

  - Integers

    Integers are strings consisting of either a 0, or an optional negative sign - followed by a non-empty string of digits 0–9 which does not begin with 0.
 
  - Identifiers

    Identifiers are strings consisting of letters (lower or upper case), digits, and the underscore character, apart from those which match a keyword as above. Identifiers must begin with a *lower-case alphabetic character*.
  
  - Operators and delimiters
 
    The special syntactic symbols (e.g., parentheses, assignment operator, etc.) consist of the following one- or two-character symbols:
    ` ;  (  )  ==  <  >  <=  >=  ,  {  }  :=  +  *  -  /  &  |  ^ `
    
  - White space

    White space is not a part of any token, and consists of any sequence of the characters. `⎵` (blank, ascii 32) ;  `\n` (newline, ascii 10) ;  `\r` (carriage return, ascii 13) ;  `\t` (tab, ascii 9) .    


Note that because whitespace doesn't belong to any token, a whitespace character will always separate tokens on either side of it — whatever (non whitespace) is to the left of a whitespace must be part of a different token than whatever is on the right of the whitespace. **However**0: two distinct tokens are not always separated by whitespace — for example:
  - the string `(())` consists of 4 tokens (representing the open and close parentheses
  - the string `65x` consists of two tokens (representing the integer 65 and an identifier "x");
  - the string `65if;` should be lexed into three tokens (representing the integer 65, the keyword "if", and a semicolon).

Similarly, because the operator and delimiter characters cannot be a part of any identifier or integer literal, they also serve to separate such tokens from one another.

### Disambiguation

The rules above are ambiguous. To disambiguate, use the following two policies.

  - Operate a 'longest match' policy to disambiguate: if the beginning of a string can be lexed in several ways, choose the tokensisation where the initial token removes the most from the beginning of the string.
  - If there are more than one longest match, give preference to keywords.

For example: the string `deff` should be lexed into a single identifier (and not, e.g., the token `def` followed by the identifier `f`.) Similarly, `===` must be lexed into a token representing `==` followed by a token representing `=`, and not as the other way round, or as three occurences of `=`.

## Syntax description

### The grammar

Here is the language syntax, given by the following context free grammar (note that we also make use of repetition operators `*` and `+`) with initial non-terminal symbol `PROG`.

```
PROG    →	DEC+
DEC     →	TYPE IDFR "(" VARDEC ")" BODY
VARDEC  →	(TYPE IDFR ("," TYPE IDFR)*)?
BODY    →	"{" (TYPE IDFR ":=" EXP ";")* ENE "}"
BLOCK   →	"{" ENE "}"
ENE     →	EXP (";" EXP)*
EXP     →	IDFR
        |	INTLIT
        |	BOOLLIT
        |	IDFR ":=" EXP
        |	"(" EXP BINOP EXP ")"
        |	IDFR "(" ARGS ")"
        |	BLOCK
        |	"if" EXP "then" BLOCK "else" BLOCK
        |	"while" EXP "do" BLOCK
        |	"repeat" BLOCK "until" EXP
        |	"print" EXP
        |	"space"
        |	"newline"
        |	"skip"
ARGS    →	(EXP ("," EXP)*)?
BINOP   →	"=="  |  "<"  |  ">"  |  "<="  |  ">="
|	 "+"  |  "-"  |  "*"  |   "/"  |  "&"  |  "|"  | "^"
TYPE    →	"int" | "bool" | "unit"
IDFR    →	(an identifier)
INTLIT  →	(an integer)
BOOLLIT →	"true" | "false"
```

## Example programs

Here are some example programs in the language:

### Example #1
```
int fun(int x, int y, int z) {
  if (x == y) then { z } else { 0 } }

int main() { fun(1, 2, 3) }
```

### Example #2
```
int main(int n) { fibo(n) }
int fibo(int n) {
  if ( n < 2 )
  then { n }
  else { (fibo((n - 1)) + fibo((n-2)) } }
```

### Example #3
```
unit doLoop (int i, int a) {
    while (i <= 100) do {
      a := (a + i);
      i := (i + 1) } }

int main() {
  doLoop(0, 5);
  print space;
  1337 }
```

### Example #4
```
int main() { print fact(10); 100 }

int fact(int n) {
  if (n == 0)
  then { 1 } 
  else { (n * fact((n - 1))) } }
```
