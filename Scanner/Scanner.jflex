package scanner;

/* IMPORTANT: 
 * To test in Netbeans, make sure this class is public. 
 * Also make sure the constructor is public - line 252 in Scanner.java
 */

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

whitespace		= [ \n\t]+

letter			= [A-Za-z]
word			= {letter}+
id 				= {letter}({letter}|{digit})*

digit					= [1-9]
digits					= {digit}+
optional_fraction		= (\.{digits})?
optional_exponent		= ([eE][+-]?{digits})?
number 					= {digits}{optional_fraction}{optional_exponent}

symbol			= ";"|","|"("|")"|"["|"]"|"{"|"}"|"="|"+"|"-"|"*"|
				  "/"|"<"|">"|"<="|">="|"!="|"=="|"&&"|"||"|"!"
				  
comment 		= "/*".*"*/"
oneline			= "//".*"\n"

%%

/* Lexical Rules */


{whitespace}	{  
					/* Ignore Whitespace */ 
					return null;
				}

{comment}		{  
					/* Ignore Traditional Comments */ 
					return null;
				}

{oneline}		{  
					/* Ignore Oneline Comments */ 
					return null;
				}


{word}			{
					/* NOTE: a word that is not a keyword is treated as an identifier. */
					//System.out.println("Found a word: " + yytext());
					Token t;
					switch (yytext()) {
						case "char": 
							// System.out.println("It's a CHAR token!"); 
							t = new Token(yytext(), TokenType.CHAR);
							break; 
						case "int":
							// System.out.println("It's an INT token!"); 
							t = new Token(yytext(), TokenType.INT);
							break; 
						case "float":
							// System.out.println("It's a FLOAT token!"); 
							t = new Token(yytext(), TokenType.FLOAT);
							break; 
						case "if":
							// System.out.println("It's an IF token!"); 
							t = new Token(yytext(), TokenType.IF);
							break; 
						case "else":
							// System.out.println("It's an ELSE token!"); 
							t = new Token(yytext(), TokenType.ELSE);
							break; 
						case "while":
							// System.out.println("It's a WHILE token!"); 
							t = new Token(yytext(), TokenType.WHILE);
							break; 
						case "print":
							// System.out.println("It's a PRINT token!"); 
							t = new Token(yytext(), TokenType.PRINT);
							break; 
						case "read":
							// System.out.println("It's a READ token!"); 
							t = new Token(yytext(), TokenType.READ);
							break; 
						case "return":
							// System.out.println("It's a RETURN token!"); 
							t = new Token(yytext(), TokenType.RETURN);
							break; 
						case "func":
							// System.out.println("It's a FUNC token!"); 
							t = new Token(yytext(), TokenType.FUNC);
							break; 
						case "program":
							// System.out.println("It's a PROGRAM token!"); 
							t = new Token(yytext(), TokenType.PROGRAM);
							break; 
						case "end":
							// System.out.println("It's an END token!"); 
							t = new Token(yytext(), TokenType.END);
							break; 
						case "void":
							// System.out.println("It's a VOID token!"); 
							t = new Token(yytext(), TokenType.VOID);
							break; 
						case "main":
							// System.out.println("It's a MAIN token!"); 
							t = new Token(yytext(), TokenType.MAIN);
							break; 
						case "then":
							// System.out.println("It's a THEN token!"); 
							t = new Token(yytext(), TokenType.THEN);
							break; 
						case "do":
							// System.out.println("It's a DO token!"); 
							t = new Token(yytext(), TokenType.DO);
							break; 
						case "write":
							// System.out.println("It's a WRITE token!"); 
							t = new Token(yytext(), TokenType.WRITE);
							break; 
						default: 
							// System.out.println("It's an ID!"); 
							t = new Token(yytext(), TokenType.ID);
					}
					return( t);
				}
				
{id}			{ 
					//System.out.println("Found an identifier: " + yytext());
					Token t = new Token(yytext(), TokenType.ID);
					return( t);
				}

{number}		{
					//System.out.println("Found a number: " + yytext());
					Token t = new Token(yytext(), TokenType.NUMBER);
					return( t);
				}

{symbol}		{ 
					//System.out.println("Found a symbol: " + yytext());
					Token t;
					switch (yytext()) {
						case ";": 
							// System.out.println("It's a semicolon!"); 
							t = new Token(yytext(), TokenType.SEMICOLON);
							break; 
						case ",": 
							// System.out.println("It's a comma!"); 
							t = new Token(yytext(), TokenType.COMMA);
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
							// System.out.println("It's an assignop!"); 
							t = new Token(yytext(), TokenType.ASSIGNOP);
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
						case "==": 
							// System.out.println("It's an equal!"); 
							t = new Token(yytext(), TokenType.EQUAL);
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
							t = null;
					}
					return( t);
				}

.				{
					//System.out.println("Found an illegal character: " + yytext());
					throw new java.io.IOException("Illegal Character!");
				}