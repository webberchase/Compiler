package scanner;

/**
 * Token Class for use with Scanner.jflex
 * CSC 451
 * @author Chase Webber 
 */
 public class Token {
	String lexeme; 
	TokenType type; 
	
	/**
	 * Constructor method - takes in lexeme and type 
	 * @param lexeme The lexeme String
	 * @param type The Token Type 
	 */
	public Token(String lexeme, TokenType type) {
		this.setLexeme(lexeme); 
		this.setType(type);
	}
	
	/** 
	 * Setter method - defines this token's lexeme. 
	 * @param newLex The lexeme String
	 */
	public void setLexeme(String newLex) {
		this.lexeme = newLex;
	}
	
	/** 
	 * Setter method - defines this token's Token Type. 
	 * @param tt The Token Type
	 */
	public void setType(TokenType tt) {
		this.type = tt;
	}
	
	/** 
	 * Getter method - returns this token's Token Type. 
	 * @return The Token Type
	 */
	public TokenType getType() {
		return this.type;
	}
	
	
	@Override 
	public boolean equals(Object o) {
		if (o == this) { return true; }
		
		if (!(o instanceof Token)) { return false; }
		
		Token t = (Token) o; 
		return (lexeme.equals(t.lexeme)) && (type.equals(t.type)); 
	}
	
	@Override
	public String toString() {
		return lexeme + " : " + type;
	}
 
 }