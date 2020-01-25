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
id 				= {word}+({number}|{word})*

digit			= [1-9]
int				= {digit}+
float			= {digit}*'.'{digit}*
scinum			= {float}[eE][-|+|'']{int}

whitespace		= [ \n\t]+
other			= .

%%

/* Lexical Rules */

{word}			{
					//System.out.println("Found a word: " + yytext());
					
					switch (yytext()) {
						case "char": 
							// System.out.println("It's a char!"); 
							Token t = new Token(yytext(), TokenType.CHAR);
							break; 
						case "int":
							// System.out.println("It's an int!"); 
							Token t = new Token(yytext(), TokenType.INT);
							break; 
						case "float":
							// System.out.println("It's a float!"); 
							Token t = new Token(yytext(), TokenType.FLOAT);
							break; 
						case "if":
							// System.out.println("It's an if!"); 
							Token t = new Token(yytext(), TokenType.IF);
							break; 
						case "else":
							// System.out.println("It's an else!"); 
							Token t = new Token(yytext(), TokenType.ELSE);
							break; 
						case "while":
							// System.out.println("It's a while!"); 
							Token t = new Token(yytext(), TokenType.WHILE);
							break; 
						case "print":
							// System.out.println("It's a print!"); 
							Token t = new Token(yytext(), TokenType.PRINT);
							break; 
						case "read":
							// System.out.println("It's a read!"); 
							Token t = new Token(yytext(), TokenType.READ);
							break; 
						case "return":
							// System.out.println("It's a return!"); 
							Token t = new Token(yytext(), TokenType.RETURN);
							break; 
						case "func":
							// System.out.println("It's a func!"); 
							Token t = new Token(yytext(), TokenType.FUNC);
							break; 
						case "program":
							// System.out.println("It's a program!"); 
							Token t = new Token(yytext(), TokenType.PROGRAM);
							break; 
						case "end":
							// System.out.println("It's an end!"); 
							Token t = new Token(yytext(), TokenType.END);
							break; 
						default: 
							// System.out.println("It's an identifier!"); 
							Token t = new Token(yytext(), TokenType.ID);
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
					return "";
				}

{other}			{ 
					//System.out.println("Found a strange string: " + yytext());
					
					switch (yytext()) {
						case ";": 
							// System.out.println("It's a semicolon!"); 
							Token t = new Token(yytext(), TokenType.SEMICOLON);
							break; 
						case "(": 
							// System.out.println("It's a left parenthesis!"); 
							Token t = new Token(yytext(), TokenType.LPAREN);
							break; 
						case ")": 
							// System.out.println("It's a right parenthesis!"); 
							Token t = new Token(yytext(), TokenType.RPAREN);
							break; 	
						case "[": 
							// System.out.println("It's a left square!"); 
							Token t = new Token(yytext(), TokenType.LSQUARE);
							break; 	
						case "]": 
							// System.out.println("It's a right square!"); 
							Token t = new Token(yytext(), TokenType.RSQUARE);
							break; 	
						case "{": 
							// System.out.println("It's a left curly!"); 
							Token t = new Token(yytext(), TokenType.LCURLY);
							break; 	
						case "}": 
							// System.out.println("It's a right curly!"); 
							Token t = new Token(yytext(), TokenType.RCURLY);
							break; 	
						case "=": 
							// System.out.println("It's an equals!"); 
							Token t = new Token(yytext(), TokenType.EQUALS);
							break; 	
						case "+": 
							// System.out.println("It's a plus!"); 
							Token t = new Token(yytext(), TokenType.PLUS);
							break;	
						case "-": 
							// System.out.println("It's a minus!"); 
							Token t = new Token(yytext(), TokenType.MINUS);
							break; 	
						case "*": 
							// System.out.println("It's a times!"); 
							Token t = new Token(yytext(), TokenType.TIMES);
							break; 	
						case "/": 
							// System.out.println("It's a divide by!"); 
							Token t = new Token(yytext(), TokenType.DIVIDEBY);
							break; 	
						case "<": 
							// System.out.println("It's a less than!"); 
							Token t = new Token(yytext(), TokenType.LESSTHAN);
							break; 	
						case ">": 
							// System.out.println("It's a greater than!"); 
							Token t = new Token(yytext(), TokenType.GREATERTHAN);
							break; 
						case "<=": 
							// System.out.println("It's a less than or equal to!"); 
							Token t = new Token(yytext(), TokenType.LESSEQUAL);
							break; 	
						case ">=": 
							// System.out.println("It's a greater than or equal to!"); 
							Token t = new Token(yytext(), TokenType.GREATEQUAL);
							break; 	
						case "!=": 
							// System.out.println("It's a not equal to!"); 
							Token t = new Token(yytext(), TokenType.NOTEQUAL);
							break; 	
						case "&&": 
							// System.out.println("It's a logical and!"); 
							Token t = new Token(yytext(), TokenType.AND);
							break; 	
						case "||": 
							// System.out.println("It's a logical or!"); 
							Token t = new Token(yytext(), TokenType.OR);
							break; 
						case "!": 
							// System.out.println("It's a not!"); 
							Token t = new Token(yytext(), TokenType.LSQUARE);
							break; 	
						default: 
							// System.out.println("It's trash!!"); 
							Token t = new Token(yytext(), TokenType.TRASH);
					}
					return( t);
				}



