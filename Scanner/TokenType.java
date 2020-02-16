package scanner;

/**
 * TokenTpe enum - these are the possible Token Types! 
 * CSC 451
 * @author Chase Webber 
 */
public enum TokenType {
	ID, 			// any word except keyword
	NUMBER,			// an actual number
	
	/* KEYWORDS */
	CHAR,
	INT, 
	FLOAT, 
	IF, 
	ELSE, 
	WHILE, 
	PRINT, 
	READ, 
	RETURN, 
	FUNC, 
	PROGRAM, 
	END, 
	VOID, 
	MAIN,
	THEN,
	DO,
	WRITE,
	
	
	/* SYMBOLS */	
	SEMICOLON, 		// ;
	COMMA,			// ,
	LPAREN, 		// (
	RPAREN,			// )
	LSQUARE, 		// [
	RSQUARE, 		// ]
	LCURLY, 		// {
	RCURLY, 		// }
	ASSIGNOP, 		// =
	PLUS, 			// +
	MINUS, 			// -
	TIMES,			// *
	DIVIDEDBY,		// /
	LESSTHAN, 		// <
	GREATERTHAN, 	// >
	LESSEQUAL, 		// <=
	GREATEQUAL, 	// >=
	NOTEQUAL, 		// !=
	EQUAL,			// ==
	AND, 			// &&
	OR, 			// ||
	NOT, 			// !
}