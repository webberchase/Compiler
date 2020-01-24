/**
 * Token Class for use with Scanner.jflex
 * CSC 451
 * @author Chase Webber 
 */
 public class Token {
	String lexeme; 
	TokenType type; 
	
	@Override
	public String toString() {
		return lexeme + " : " + type;
	}
 
 }