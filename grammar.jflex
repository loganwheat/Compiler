import java_cup.runtime.*;

%%

%cup
%line
%column
%unicode
%class Lexer

%{

Symbol newSym(int tokenId) {
	return new Symbol(tokenId, yyline, yycolumn);
}

Symbol newSym(int tokenId, Object value) {
	return new Symbol(tokenId, yyline, yycolumn, value);
}

%}

/*
 * regular expressions, patterns
 */

//------
tab	= \\t
newline	= \\n
slash	= \\
escapeapos	= {slash}'
escapequote	= {slash}\"
letter	= [A-Za-z]
digit	= [0-9]
id	= {letter}({letter}|{digit})*
intlit	= {digit}+
charchar  = [[^\\]&&[^']]|{newline}|{tab}|{escapeapos}|{slash}{slash}
charlit = '{charchar}'
stringchar	= [[[^\\]&&[^\"]]&&[[^\n]&&[^\t]]]|{newline}|{tab}|{escapequote}|{slash}{slash}
strlit = \"{stringchar}*\"
floatlit = {intlit}+\.{intlit}+
comment	= {slash}{slash}.*(\n|\r|\r\n)
blockcomments	= {slash}\*
blockcommente	= \*{slash}
commentbody	= ([^\*]|(\*+[^\\]))
blockcomment	= {blockcomments}{commentbody}*?{blockcommente}
whitespace	= [ \n\t\r] 
//------

%%

// Lex rules

class        {return newSym(sym.CLASS, "class");}
final        {return newSym(sym.FINAL, "final");}
void         {return newSym(sym.VOID, "void");}
int          {return newSym(sym.INT, "int");}
char         {return newSym(sym.CHAR, "char");}
bool         {return newSym(sym.BOOL, "bool");}
float        {return newSym(sym.FLOAT, "float");}
if           {return newSym(sym.IF, "if");}
fi           {return newSym(sym.FI, "fi");}
while        {return newSym(sym.WHILE, "while");}
return       {return newSym(sym.RETURN, "return");}
else         {return newSym(sym.ELSE, "else");}
true         {return newSym(sym.TRUE, "true");}
false        {return newSym(sym.FALSE, "false");}
read         {return newSym(sym.READ, "read");}
print        {return newSym(sym.PRINT, "print");}
printline    {return newSym(sym.PRINTL, "printline");}


";"          {return newSym(sym.SEMI, ";");}
","          {return newSym(sym.COMMA, ",");}
"("          {return newSym(sym.OPENP, "(");}
")"          {return newSym(sym.CLOSEP, ")");}
"["          {return newSym(sym.OPENSB, "[");}
"]"          {return newSym(sym.CLOSESB, "]");}
"{"          {return newSym(sym.OPENCB, "{");}
"}"          {return newSym(sym.CLOSECB, "}");}
"~"          {return newSym(sym.TILDE, "~");}
"="          {return newSym(sym.ASSMNT, "=");}
"*"          {return newSym(sym.MULT, "*");}
"/"          {return newSym(sym.DIV, "/");}
"+"          {return newSym(sym.PLUS, "+");}
"-"          {return newSym(sym.MINUS, "-");}
"<"          {return newSym(sym.LESSTHAN, "<");}
">"          {return newSym(sym.GREATERTHAN, ">");}
"<="         {return newSym(sym.LEQ, "<=");}
">="         {return newSym(sym.GEQ, ">=");}
"=="         {return newSym(sym.EQUALTO, "==");}
"<>"         {return newSym(sym.ANGLEB, "<>");}
"||"         {return newSym(sym.OR, "||");}
"&&"         {return newSym(sym.AND, "&&");}
"++"         {return newSym(sym.INCREMENT, "++");}
"--"         {return newSym(sym.DECREMENT, "--");}
"?"          {return newSym(sym.QUESTIONMARK, "?");}
":"          {return newSym(sym.COLON, ":");}


{intlit}     {return newSym(sym.INTLIT, new Integer(yytext()));}
{charlit}    {return newSym(sym.CHARLIT, yytext());}
{strlit}     {return newSym(sym.STRLIT, yytext());}
{floatlit}   {return newSym(sym.FLOATLIT, yytext());}
{id}         {return newSym(sym.ID, yytext());}

{whitespace} {/* whitespace */}
{comment}    {/* comment */}
{blockcomment}   {/* block comment */}

. {System.out.println("Illegal character, " + yytext() + " line:" + yyline + " col:" + yychar);}

