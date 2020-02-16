package parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import scanner.Scanner;
import scanner.Token;
import scanner.TokenType;

/**
 * This Recognizer determines whether an input string
 * of tokens is an expression.
 * To use the Recognizer, create an instance pointing at a file, 
 * and then call the top-level function, 
 * <code>exp()</code>.
 * If the function returns without an error, the file 
 * contains the acceptable expression. 
 * @author Chase Webber
 */
public class Recognizer {
	
	/***** INSTANCE VARIABLES *****/
	
	private Token lookahead;
	private Scanner scanner;
	
	/***** CONSTRUCTOR *****/
	
	/**
	 * Input string is either the text itself or it is a file name.
	 * @param text The text running through the Recognizer.
	 * @param isFilename Determines if this is the text or a file name.
	 */
	public Recognizer(String text, boolean isFilename) {
		if (isFilename) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream("expressions/simplest.pas");
			} catch (FileNotFoundException e) {
				error("No file!");
			}
			InputStreamReader isr = new InputStreamReader(fis);
			scanner = new Scanner(isr);
		}
		else {
			scanner = new Scanner(new StringReader(text));
		}
		try {
			lookahead = scanner.nextToken();
		} catch (IOException e) {
			error("Scan error!");
		}
	}

	/***** METHODS *****/
	
	/**
	 * Executes the rule for the exp non-terminal symbol.
	 */
	public void exp() {
		term();
		expPrime();
	}
	
	/** 
	 * Exceutes the rule for the expPrime non-terminal symbol.
	 */
	public void expPrime() {
		if(nextIs(TokenType.PLUS) || nextIs(TokenType.MINUS)) {
			addop();
			term();
			expPrime();
		}
		else {
			// Lambda option!
		}
	}
	
	/** 
	 * Excecutes the rule for the addop non-terminal symbol.
	 */
	public void addop() {
		switch (lookahead.getType()) {
			case PLUS:
				match(TokenType.PLUS);
				break;
			case MINUS:	
				match(TokenType.MINUS);
				break;
			default:
				error("Addop!");				
		}
	}
	
	/** 
	 * Executes the rule for the term non-terminal symbol.
	 */
	public void term() {
		factor();
		termPrime();
	}
	
	/** 
	 * Exeecutes the rule for the termPrime non-terminal symbol.
	 */
	public void termPrime() {
		if (isMulop(lookahead)) {
			mulop();
			factor();
			termPrime();
		}
		else {
			// Lambda option!
		}
	}
	
	/**
	 * Excecutes the rule for the mulop non-terminal symbol. 
	 */
	public void mulop() {
		switch (lookahead.getType()) {
			case TIMES:
				match(TokenType.TIMES);
				break;
			case DIVIDEDBY:
				match(TokenType.DIVIDEDBY);
				break;
			default:
				error("Mulop");
		}
	}
	
	/** 
	 * Executes the rule for the factor non-terminal symbol.
	 */
	public void factor() {
		switch (lookahead.getType()) {
			case LPAREN:
				match(TokenType.LPAREN);
				exp();
				match(TokenType.RPAREN);
				break;
			case NUMBER:
				match(TokenType.NUMBER);
				break;
			default:
				error("Factor");
		}
	}
	
	
	

	/***** HELPER FUNCTIONS *****/

	/**
	 * Matches the expected token. 
	 * If the current token in the input stream from the scanner 
	 * matches the token that is expected, the current token is 
	 * consumed and the scanner will move on to the next token
	 * in the input. 
	 * The ull at the end of the file returned by the scanner 
	 * is replaced with a fake token containing no type. 
	 * @param expected The expected token type. 
	 */
	public void match(TokenType expected) {
		System.out.println("match( " + expected + ")");
		if (this.lookahead.getType() == expected) {
			try {
				this.lookahead = scanner.nextToken();
				if (this.lookahead == null) {
					this.lookahead = new Token("End of File", null);
				}
			} catch (IOException e) {
				error("Scanner exception");
			}
		}
		else {
			error("Match of " + expected + " found " + 
					this.lookahead.getType() + "instead.");
		}
	}

	/**
	 * Determines if the lookahead is of the specified Token Type. 
	 * @param tt The Token Type we are checking for. 
	 * @return true if Token Type matches lookahead.type, else false.
	 */
	private boolean nextIs(TokenType tt) {
		if (lookahead.getType() == tt) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Determines whether the given token is a mulop token. 
	 * @param token The token to check. 
	 * @return true if the token is a mulop, otherwise false. 
	 */
	private boolean isMulop(Token token) {
		boolean result = false; 
		if (token.getType() == TokenType.TIMES || 
				token.getType == TokenType.DIVIDEDBY) {
			answer = true;	
		}
		return answer;
	}
	
	/**
	 * Errors out of the parser. 
	 * Prints an error message (and then exits the program?). 
	 * @param message The error message to print. 
	 */
	public void error(String message) {
		System.out.println("Error " + message + " at line " +
				this.scanner.getLine() + " column " +
				this.scanner.getColumn());
	}
	
	
}