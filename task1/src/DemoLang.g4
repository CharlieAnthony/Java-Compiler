grammar DemoLang;

prog
    : args body EOF
;

args
    : Idfr*
;

body
    : LBrace (Local localvars+=Idfr Assign localvarsexps+=exp Semicolon)* ene+=exp (Semicolon ene+=exp)* RBrace
;

exp
    : Idfr Assign exp                                       #AssignExpr
    | LParen exp binop exp RParen                           #BinOpExpr
    | While exp Do block                                    #WhileExpr
    | IntLit                                                #IntExpr
    | Idfr                                                  #IdExpr
;

block
    : LBrace (exps+=exp Semicolon)* RBrace
;

binop
    : LessEq          #LessEqBinop
    | Plus            #PlusBinop
    | Minus           #MinusBinop
    | And             #AndBinop
    | Xor             #XorBinop
;

LParen : '(' ;
Comma : ',' ;
RParen : ')' ;
LBrace : '{' ;
Semicolon : ';' ;
RBrace : '}' ;

LessEq : '<=' ;
Plus : '+' ;
Minus : '-' ;
And : '&' ;
Xor : '^' ;

Assign : ':=' ;

While : 'while' ;
Do : 'do' ;
Local : 'local' ;

IntLit : '0' | ('-'? [1-9][0-9]*) ;
Idfr : [a-z][A-Za-z0-9_]* ;
WS : [ \n\r\t]+ -> skip ;