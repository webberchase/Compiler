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
other			= .
letter			= [A-Za-z]
word			= {letter}+
digit			= [1-9]
number			= {digit}+

whitespace		= [ \n\t]+


%%

/* Lexical Rules */

- ADD SYMBOLS 
- DIFFERENTIATE ID AND KEYWORDS... 

{word}			{
					//System.out.println("Found a word: " + yytext());
					Token t = new Token(); 
					t.lexeme = yytext(); 
					t.type = TokenType.NUMBER; 
					return( yytext());
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



