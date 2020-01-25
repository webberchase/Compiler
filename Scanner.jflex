// Scanner.jflex

/**
 * Scanner with Tokens
 * Finds the lexemes for numbers, symbols, identifiers, 
 * CSC 450
 * @author Chase Webber
 */
%%

%class Scanner
%function nextToken
%type Token
%eofval{
	return null;
%eofval}

//FIX THESE - 
letter			= [A-Za-z]
word			= {letter}+
digit			= [1-9]
int				= {digit}+
float			= {digit}*'.'{digit}*
scinum			= {float}[eE][-|+|'']{int}
id 				= {word}+({number}|{word})*
other			= .

whitespace		= [ \n\t]+


%%

/* Lexical Rules */

- ADD SYMBOLS 
- DIFFERENTIATE ID AND KEYWORDS... 

{word}			{
					//System.out.println("Found a word: " + yytext());
					
					switch (yytext()) {
						case "char": 
							Token t = new Token(yytext(), TokenType.CHAR);
							break; 
						case "int":
							Token t = new Token(yytext(), TokenType.INT);
							break; 
						case "float":
							Token t = new Token(yytext(), TokenType.FLOAT);
							break; 
						case "if":
							Token t = new Token(yytext(), TokenType.IF);
							break; 
						case "else":
							Token t = new Token(yytext(), TokenType.ELSE);
							break; 
						case "while":
							Token t = new Token(yytext(), TokenType.WHILE);
							break; 
						case "print":
							Token t = new Token(yytext(), TokenType.PRINT);
							break; 
						case "read":
							Token t = new Token(yytext(), TokenType.READ);
							break; 
						case "return":
							Token t = new Token(yytext(), TokenType.RETURN);
							break; 
						case "func":
							Token t = new Token(yytext(), TokenType.FUNC);
							break; 
						case "program":
							Token t = new Token(yytext(), TokenType.PROGRAM);
							break; 
						case "end":
							Token t = new Token(yytext(), TokenType.END);
							break; 
						default: 
							Token t = new Token(yytext(), TokenType.ID);
					}
				}

{number}		{
					//System.out.println("Found a number: " + yytext());
					Token t = new Token();
					t.lexeme = yytext();
					t.type = TokenType.NUMBER;
					return( t);
				}

{whitespace}	{  
					/* Ignore Whitespace */ 
					return "";
				}

{other}			{ 
					//System.out.println("Illegal char: '" + yytext() + "' found.");
					Token t = new Token();
					t.lexeme = yytext(); 
					t.type = TokenType.TRASH; 
					return( t);
				}



