grammar Infix;

prog
    : dec+ EOF
;

dec
    : type IDFR LPAREN vardec RPAREN body
;

vardec : ( type IDFR (COMMA type IDFR)* )
       | ;

body : '{' (type IDFR ASSEQUAL exp SEMICOLON)* ene '}' ;

block : '{' ene '}' ;

ene : exp (SEMICOLON exp)* ;

type : INT | BOOL | UNIT ;

exp
    : IDFR ASSEQUAL exp                     #AssExp
    | '(' exp binop exp ')'                 #BinopExp
    | IDFR '(' args ')'                     #FuncExp
    | block                                 #BlockExp
    | 'if' exp 'then' block 'else' block    #IfThenElseExp
    | WHILE exp DO block                    #WhileExp
    | REPEAT block UNTIL exp                #RepeatExp
    | PRINT exp                             #PrintExp
    | SPACE                                 #SpaceExp
    | NEWLINE                               #NewLineExp
    | EXPSKIP                               #SkipExp
    | IDFR                                  #IdentifierExp
    | INTLIT                                #IntLitExp
    | BOOLLIT                               #BoolLitExp
;

args : (exp (COMMA exp)*)? ;

binop
    : EQUAL                                 #EqBinop
    | GREATER                               #GreaterBinop
    | LESS                                  #LessBinop
    | GREATEREQ                             #GreaterEqBinop
    | LESSEQ                                #LessEqBinop
    | PLUS                                  #PlusBinop
    | MINUS                                 #MinusBinop
    | MULTIPLY                              #MultiplyBinop
    | DIVIDE                                #DivideBinop
    | AND                                   #AndBinop
    | OR                                    #OrBinop
    | XOR                                   #XorBinop
;

BOOLLIT : TRUE | FALSE ;



SEMICOLON : ';' ;
ASSEQUAL : ':=' ;
LPAREN : '(' ;
RPAREN : ')' ;
COMMA : ',' ;
IF : 'if' ;
THEN : 'then' ;
ELSE: 'else' ;
WHILE : 'while' ;
DO : 'do' ;
REPEAT: 'repeat' ;
UNTIL: 'until' ;
PRINT : 'print' ;
SPACE : 'space' ;
NEWLINE : 'newline' ;
EXPSKIP : 'skip' ;

EQUAL : '==' ;
GREATER : '<' ;
LESS : '>' ;
GREATEREQ : '<=' ;
LESSEQ : '>=' ;
PLUS : '+' ;
MINUS : '-' ;
MULTIPLY : '*' ;
DIVIDE : '/' ;
AND : '&' ;
OR : '|' ;
XOR : '^' ;

INT : 'int' ;
BOOL : 'bool' ;
UNIT : 'unit' ;

TRUE : 'true' ;
FALSE : 'false' ;

INTLIT : '0' | ('-'? [1-9][0-9]*) ;
IDFR : [a-z][A-Za-z0-9_]* ;
WS     : [ \n\r\t]+ -> skip ;
/*
exp
    : exp op=(Times | Div) exp  # MulDiv
    | exp op=(Plus | Minus) exp # AddSub
    | IntLit                      # Int
    | FloatLit                    # Float
    | '(' exp ')'                # Parens
;



Times  : '*' ;
Div    : '/' ;
Plus   : '+' ;
Minus  : '-' ;
IntLit : '0' | [1-9][0-9]* ;

*/