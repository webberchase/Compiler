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
	
	/* SYMBOLS */	
	SEMICOLON, 		// ;
	LPAREN, 		// (
	RPAREN,			// )
	LSQUARE, 		// [
	RSQUARE, 		// ]
	LCURLY, 		// {
	RCURLY, 		// }
	EQUAL, 			// =
	PLUS, 			// +
	MINUS, 			// -
	TIMES,			// *
	DIVIDEDBY,		// /
	LESSTHAN, 		// <
	GREATERTHAN, 	// >
	LESSEQUAL, 		// <=
	GREATEQUAL, 	// >=
	NOTEQUAL, 		// !=
	AND, 			// &&
	OR, 			// ||
	NOT, 			// !
	TRASH, 			// unknown symbol
}