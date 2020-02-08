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

letter			= [A-Za-z]
word			= {letter}+
id 				= {word}+({int}|{word})*

digit			= [1-9]
int				= {digit}+
float			= {digit}*\.{digit}*
scinum			= {float}[eE][-|+|]{int}

whitespace		= [ \n\t]+

symbol			= ";"|"("|")"|"["|"]"|"{"|"}"|"="|"+"|"-"|"*"|
				  "/"|"<"|">"|"<="|">="|"!="|"&&"|"||"|"!"

%%

/* Lexical Rules */

{word}			{
					/* NOTE: a word that is not a keyword is treated as an identifier. */
					//System.out.println("Found a word: " + yytext());
					Token t;
					switch (yytext()) {
						case "char": 
							// System.out.println("It's a char!"); 
							t = new Token(yytext(), TokenType.CHAR);
							break; 
						case "int":
							// System.out.println("It's an int!"); 
							t = new Token(yytext(), TokenType.INT);
							break; 
						case "float":
							// System.out.println("It's a float!"); 
							t = new Token(yytext(), TokenType.FLOAT);
							break; 
						case "if":
							// System.out.println("It's an if!"); 
							t = new Token(yytext(), TokenType.IF);
							break; 
						case "else":
							// System.out.println("It's an else!"); 
							t = new Token(yytext(), TokenType.ELSE);
							break; 
						case "while":
							// System.out.println("It's a while!"); 
							t = new Token(yytext(), TokenType.WHILE);
							break; 
						case "print":
							// System.out.println("It's a print!"); 
							t = new Token(yytext(), TokenType.PRINT);
							break; 
						case "read":
							// System.out.println("It's a read!"); 
							t = new Token(yytext(), TokenType.READ);
							break; 
						case "return":
							// System.out.println("It's a return!"); 
							t = new Token(yytext(), TokenType.RETURN);
							break; 
						case "func":
							// System.out.println("It's a func!"); 
							t = new Token(yytext(), TokenType.FUNC);
							break; 
						case "program":
							// System.out.println("It's a program!"); 
							t = new Token(yytext(), TokenType.PROGRAM);
							break; 
						case "end":
							// System.out.println("It's an end!"); 
							t = new Token(yytext(), TokenType.END);
							break; 
						default: 
							// System.out.println("It's an identifier!"); 
							t = new Token(yytext(), TokenType.ID);
					}
					return( t);
				}
				
{id}			{ 
					//System.out.println("Found an identifier: " + yytext());
					Token t = new Token(yytext(), TokenType.ID);
					return( t);
				}

{int}			{
					//System.out.println("Found a number: " + yytext());
					Token t = new Token(yytext(), TokenType.NUMBER);
					return( t);
				}

{float}			{
					//System.out.println("Found a number: " + yytext());
					Token t = new Token(yytext(), TokenType.NUMBER);
					return( t);
				}		
	
{scinum}		{
					//System.out.println("Found a number: " + yytext());
					Token t = new Token(yytext(), TokenType.NUMBER);
					return( t);
				}

{whitespace}	{  
					/* Ignore Whitespace */ 
					return null;
				}

{symbol}			{ 
					//System.out.println("Found a symbol: " + yytext());
					Token t;
					switch (yytext()) {
						case ";": 
							// System.out.println("It's a semicolon!"); 
							t = new Token(yytext(), TokenType.SEMICOLON);
							break; 
						case "(": 
							// System.out.println("It's a left parenthesis!"); 
							t = new Token(yytext(), TokenType.LPAREN);
							break; 
						case ")": 
							// System.out.println("It's a right parenthesis!"); 
							t = new Token(yytext(), TokenType.RPAREN);
							break; 	
						case "[": 
							// System.out.println("It's a left square!"); 
							t = new Token(yytext(), TokenType.LSQUARE);
							break; 	
						case "]": 
							// System.out.println("It's a right square!"); 
							t = new Token(yytext(), TokenType.RSQUARE);
							break; 	
						case "{": 
							// System.out.println("It's a left curly!"); 
							t = new Token(yytext(), TokenType.LCURLY);
							break; 	
						case "}": 
							// System.out.println("It's a right curly!"); 
							t = new Token(yytext(), TokenType.RCURLY);
							break; 	
						case "=": 
							// System.out.println("It's an equals!"); 
							t = new Token(yytext(), TokenType.EQUALS);
							break; 	
						case "+": 
							// System.out.println("It's a plus!"); 
							t = new Token(yytext(), TokenType.PLUS);
							break;	
						case "-": 
							// System.out.println("It's a minus!"); 
							t = new Token(yytext(), TokenType.MINUS);
							break; 	
						case "*": 
							// System.out.println("It's a times!"); 
							t = new Token(yytext(), TokenType.TIMES);
							break; 	
						case "/": 
							// System.out.println("It's a divide by!"); 
							t = new Token(yytext(), TokenType.DIVIDEBY);
							break; 	
						case "<": 
							// System.out.println("It's a less than!"); 
							t = new Token(yytext(), TokenType.LESSTHAN);
							break; 	
						case ">": 
							// System.out.println("It's a greater than!"); 
							t = new Token(yytext(), TokenType.GREATERTHAN);
							break; 
						case "<=": 
							// System.out.println("It's a less than or equal to!"); 
							t = new Token(yytext(), TokenType.LESSEQUAL);
							break; 	
						case ">=": 
							// System.out.println("It's a greater than or equal to!"); 
							t = new Token(yytext(), TokenType.GREATEQUAL);
							break; 	
						case "!=": 
							// System.out.println("It's a not equal to!"); 
							t = new Token(yytext(), TokenType.NOTEQUAL);
							break; 	
						case "&&": 
							// System.out.println("It's a logical and!"); 
							t = new Token(yytext(), TokenType.AND);
							break; 	
						case "||": 
							// System.out.println("It's a logical or!"); 
							t = new Token(yytext(), TokenType.OR);
							break; 
						case "!": 
							// System.out.println("It's a not!"); 
							t = new Token(yytext(), TokenType.LSQUARE);
							break; 	
						default:
							throw new java.io.IOException();
					}
					return( t);
				}



