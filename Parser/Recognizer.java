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
	private final Token END = new Token("END", TokenType.ENDOFFILE); 
	
	
	/***** CONSTRUCTOR *****/
	
	/**
	 * Input string is either the text itself or it is a file name.
	 * @param text The text running through the Recognizer.
	 * @param isFilename Determines if this is the text or a file name.
	 * @throws java.lang.Exception
	 */
	public Recognizer(String text, boolean isFilename) throws Exception {
		if (isFilename) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(text);
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
	 * Executes the rule for the program non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void program() throws Exception {
		functionDeclarations();
		match(TokenType.MAIN);
		match(TokenType.LPAREN);
		match(TokenType.RPAREN);
		compoundStatement();
		functionDefinitions();
	}
	
	/**
	 * Executes the rule for the identifierList non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void identifierList() throws Exception {
		match(TokenType.ID);
		if (nextIs(TokenType.COMMA)) {
			match(TokenType.COMMA);
			identifierList();
		}
		else {
			// Lambda option! 
			// ID is matched in either case
		}
	}
	
	/**
	 * Executes the rule for the declarations non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void declarations() throws Exception {
		if (isType(lookahead)) {
			type();
			identifierList();
			match(TokenType.SEMICOLON);
			declarations();
		}
		else {
			// Lambda option!
		}	
	}
	
	/**
	 * Executes the rule for the type non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void type() throws Exception {
		switch (lookahead.getType()) {
			case VOID:
				match(TokenType.VOID);
				break;
			case INT:
				match(TokenType.INT);
				break;
			case FLOAT:
				match(TokenType.FLOAT);
				break;
			default:
				error("Type");
		}
	}
	
	/**
	 * Executes the rule for the functionDeclarations non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void functionDeclarations() throws Exception {
		if (isType(lookahead)) {
			functionDeclaration();
			match(TokenType.SEMICOLON);
			functionDeclarations();
		}
		else {
			// Lambda option!
		}
	}
	
	/**
	 * Executes the rule for the functionDeclaration non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void functionDeclaration() throws Exception {
		type();
		match(TokenType.ID);
		parameters();
	}
	
	/**
	 * Executes the rule for the functionDefinitions non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void functionDefinitions() throws Exception {
		if (isType(lookahead)) {
			functionDefinition();
			functionDefinitions();
		}
		else {
			// Lambda option!
		}
	}
	
	/**
	 * Executes the rule for the functionDefinition non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void functionDefinition() throws Exception {
		type();
		match(TokenType.ID);
		parameters();
		compoundStatement();
	}
	
	/**
	 * Executes the rule for the parameters non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void parameters() throws Exception {
		match(TokenType.LPAREN);
		parameterList();
		match(TokenType.RPAREN);
	}
	
	/**
	 * Executes the rule for the parameterList non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void parameterList() throws Exception {
		type();
		match(TokenType.ID);
		if (nextIs(TokenType.COMMA)) {
			match(TokenType.COMMA);
			parameterList();
		}
		else {
			// Lambda option!
			// type is called and ID is matched in either case
		}
	}
	
	/**
	 * Executes the rule for the compoundStatement non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void compoundStatement() throws Exception {
		match(TokenType.LCURLY);
		declarations();
		optionalStatements();
		match(TokenType.RCURLY);
	}
	
	/**
	 * Executes the rule for the optionalStatements non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void optionalStatements() throws Exception {
		if (isStatement(lookahead)) { 
			statementList();
		}
		else {
			// Lambda option!
		}
	}
	
	/**
	 * Executes the rule for the statementList non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void statementList() throws Exception {
		statement();
		if (nextIs(TokenType.SEMICOLON)) {
			match(TokenType.SEMICOLON);
			statementList();
		}
		else {
			// Lambda option!
			// statement is called in either case
		}
	}
	
	/**
	 * Executes the rule for the statement non-terminal symbol.
	 * NOTE: procedureStatement is ommitted for now.
	 * @throws java.lang.Exception
	 */
	public void statement() throws Exception {
		switch (lookahead.getType()) {
			case ID:
				variable();
				match(TokenType.ASSIGNOP);
				expression();
				break;
			// case left out for now: procedureStatement
			case LCURLY:
				compoundStatement();
				break;
			case IF:
				match(TokenType.IF);
				expression();
				match(TokenType.THEN);
				statement();
				match(TokenType.ELSE);
				statement();
				break;
			case WHILE:
				match(TokenType.WHILE);
				expression();
				match(TokenType.DO);
				statement();
				break;
			case READ:
				match(TokenType.READ);
				match(TokenType.LPAREN);
				match(TokenType.ID);
				match(TokenType.RPAREN);
				break;
			case WRITE:
				match(TokenType.WRITE);
				match(TokenType.LPAREN);
				expression();
				match(TokenType.RPAREN);
				break;
			case RETURN:
				match(TokenType.RETURN);
				expression();
				break;
			default:
				error("Statement");
		}		
	}
	
	/**
	 * Executes the rule for the variable non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void variable() throws Exception {
		match(TokenType.ID);
		if (nextIs(TokenType.LSQUARE)) {
			match(TokenType.LSQUARE);
			expression();
			match(TokenType.RSQUARE);
		}
		else {
			// Lambda option!
			// id is matched in either case	
		}
	}
	
	/**
	 * Executes the rule for the procedureStatement non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void procedureStatement() throws Exception {
		match(TokenType.ID);
		if (nextIs(TokenType.LPAREN)) {
			match(TokenType.LPAREN);
			expressionList();
			match(TokenType.RPAREN);
		}
		else {
			// Lambda option!
			// id is matched in either case	
		}		
	}
	
	/**
	 * Executes the rule for the expressionList non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void expressionList() throws Exception {
		expression();
		if (nextIs(TokenType.COMMA)) {
			match(TokenType.COMMA);
			expressionList();
		}
		else {
			// Lambda option! 
			// expression is called in either case
		}
	}
	
	/**
	 * Executes the rule for the expression non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void expression() throws Exception {
		simpleExpression();
		if (isRelop(lookahead)) {
			relop();
			simpleExpression();
		}
		else {
			// Lambda option! 
			// simpleExpression is called in either case
		}
	}
	
	/**
	 * Executes the rule for the simpleExpression non-terminal symbol.
	 * @throws java.lang.Exception
	 */
	public void simpleExpression() throws Exception {
		// isAddop() here can be considered isSign()
		// we're checking for PLUS or MINUS... 
		if (isAddop(lookahead)) {
			sign();
		}
		else {
			// Lambda option! 
			// term and simplePart are called in either case
		}
		term();
		simplePart();
	}
	
	/** 
	 * Executes the rule for the simplePart non-terminal symbol.
	 * @throws java.lang.Exception
	 */
	public void simplePart() throws Exception {
		if(isAddop(lookahead)) {
			addop();
			term();
			simplePart();
		}
		else {
			// Lambda option!
		}
	}
	
	/** 
	 * Executes the rule for the term non-terminal symbol.
	 * @throws java.lang.Exception
	 */
	public void term() throws Exception {
		factor();
		termPart();
	}
	
	/** 
	 * Executes the rule for the termPart non-terminal symbol.
	 * @throws java.lang.Exception
	 */
	public void termPart() throws Exception {
		if (isMulop(lookahead)) {
			mulop();
			factor();
			termPart();
		}
		else {
			// Lambda option!
		}
	}
	
	/** 
	 * Executes the rule for the factor non-terminal symbol.
	 * @throws java.lang.Exception
	 */
	public void factor() throws Exception {
		switch (lookahead.getType()) {
			case ID:
				match(TokenType.ID);
				switch (lookahead.getType()) {
					case LSQUARE:
						match(TokenType.LSQUARE);
						expression();
						match(TokenType.RSQUARE);
						break;
					case LPAREN:
						match(TokenType.LPAREN);
						expressionList();
						match(TokenType.RPAREN);
						break;
					default:
						// Lambda option!
						// id was matched in any case
						break;
				}
				break;
			case NUMBER:
				match(TokenType.NUMBER);
				break;
			case LPAREN:
				match(TokenType.LPAREN);
				expression();
				match(TokenType.RPAREN);
				break;
			case NOT:
				match(TokenType.NOT);
				factor();
				break;
			default:
				error("Factor");
		}
	}
		
	/**
	 * Executes the rule for the sign non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void sign() throws Exception {
		switch (lookahead.getType()) {
			case PLUS:
				match(TokenType.PLUS);
				break;
			case MINUS:	
				match(TokenType.MINUS);
				break;
			default:
				error("Sign");				
		}
	}
	
	/**
	 * Executes the rule for the relop non-terminal symbol.
	 * @throws java.lang.Exception
	 */
	public void relop() throws Exception {
		switch (lookahead.getType()) {
			case LESSTHAN:
				match(TokenType.LESSTHAN);
				break;
			case GREATERTHAN:
				match(TokenType.GREATERTHAN);
				break;
			case LESSEQUAL:
				match(TokenType.LESSEQUAL);
				break;
			case GREATEQUAL:
				match(TokenType.GREATEQUAL);
				break;
			case NOTEQUAL:
				match(TokenType.NOTEQUAL);
				break;
			case EQUAL:
				match(TokenType.EQUAL);
				break;
			default:
				error("Relop");
		}
	}
	
	/** 
	 * Executes the rule for the addop non-terminal symbol.
	 * @throws java.lang.Exception
	 */
	public void addop() throws Exception {
		switch (lookahead.getType()) {
			case PLUS:
				match(TokenType.PLUS);
				break;
			case MINUS:	
				match(TokenType.MINUS);
				break;
			default:
				error("Addop");				
		}
	}
	
	/**
	 * Executes the rule for the mulop non-terminal symbol. 
	 * @throws java.lang.Exception
	 */
	public void mulop() throws Exception {
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
	
	
	/***** HELPER FUNCTIONS *****/

	/**
	 * Retrieves the Lookahead Token for testing.
	 * @return lookahead token. 
	 */
	public Token getLookahead() {
		return this.lookahead;
	}
	
	/**
	 * Retrieves the END Token for testing.
	 * @return END token
	 */
	public Token getEND() {
		return this.END;
	}
	
	/**
	 * Matches the expected token. 
	 * If the current token in the input stream from the scanner 
	 * matches the token that is expected, the current token is 
	 * consumed and the scanner will move on to the next token
	 * in the input. 
	 * @param expected The expected token type. 
	 * @throws java.lang.Exception 
	 */
	public void match(TokenType expected) throws Exception {
		System.out.println("match( " + expected + ")");
		if (this.lookahead.getType() == expected) {
			try {
				this.lookahead = scanner.nextToken();
				Token temp = this.lookahead;
				while (temp == null) {
					this.lookahead = scanner.nextToken();
					temp = this.lookahead;
				}
			} catch (IOException e) {
				error("Scanner exception");
			}
		}
		else {
			error("Match of " + expected + " found " + 
					this.lookahead.getType() + " instead");
		}
	}

	/**
	 * Determines if the recognizer has reached the end of the String.
	 * Should be called after the recognizer should be done - if the 
	 * recognizer hasn't matched all the tokens, throw an error.
	 * @throws java.lang.Exception
	 */
	public void isEnd() throws Exception {
		if (!nextIs(TokenType.ENDOFFILE)) {
			error("End of File");
		}
	}
        
	/**
	 * Determines if the lookahead is of the specified Token Type. 
	 * @param tt The Token Type we are checking for. 
	 * @return true if Token Type matches lookahead.type, else false.
	 */
	private boolean nextIs(TokenType type) {
            return lookahead.getType() == type;
	}
	
	/**
	 * Determines whether the given token is a type token. 
	 * @param token The token to check. 
	 * @return true if the token is a type, otherwise false. 
	 */
	private boolean isType(Token token) {
		boolean result = false; 
		if (token.getType() == TokenType.VOID || 
				token.getType() == TokenType.INT || 
				token.getType() == TokenType.FLOAT) {
			result = true;	
		}
		return result;
	}
	
	/**
	 * Determines whether the given token is a relop token. 
	 * @param token The token to check. 
	 * @return true if the token is a relop, otherwise false.
	 */
	private boolean isRelop(Token token) {
		boolean result = false;
		if (token.getType() == TokenType.LESSTHAN ||
				token.getType() == TokenType.GREATERTHAN ||
				token.getType() == TokenType.LESSEQUAL ||
				token.getType() == TokenType.GREATEQUAL ||
				token.getType() == TokenType.NOTEQUAL ||
				token.getType() == TokenType.EQUAL) {
			result = true;
		}
		return result;
	}

	/**
	 * Determines whether the given token is an addop token. 
	 * @param token The token to check. 
	 * @return true if the token is an addop, otherwise false. 
	 */
	private boolean isAddop(Token token) {
		boolean result = false; 
		if (token.getType() == TokenType.PLUS || 
				token.getType() == TokenType.MINUS) {
			result = true;	
		}
		return result;
	}
	
	/**
	 * Determines whether the given token is a mulop token. 
	 * @param token The token to check. 
	 * @return true if the token is a mulop, otherwise false. 
	 */
	private boolean isMulop(Token token) {
		boolean result = false; 
		if (token.getType() == TokenType.TIMES || 
				token.getType() == TokenType.DIVIDEDBY) {
			result = true;	
		}
		return result;
	}
	
	/**
	 * Determines whether the given token begins a statement. 
	 * @param token The token to check. 
	 * @return true if the token begins a statement, else false. 
	 */
	private boolean isStatement(Token token) {
		boolean result = false;
		if (token.getType() == TokenType.ID ||
				token.getType() == TokenType.LCURLY ||
				token.getType() == TokenType.IF ||
				token.getType() == TokenType.WHILE ||
				token.getType() == TokenType.READ ||
				token.getType() == TokenType.WRITE ||
				token.getType() == TokenType.RETURN) {
			result = true; 
		}
		return result;
	}
	
	/**
	 * Errors out of the parser.Prints an error message (and then exits the program?).  
	 * @param message The error message to print.
	 * @throws java.lang.Exception 
	 */
	public void error(String message) throws Exception {
		System.out.println("Error " + message); 
		if (!this.scanner.equals(null)) {
			System.out.println(" at line " +
					this.scanner.getLine() + " column " +
					this.scanner.getColumn());
		}
		throw new java.io.IOException(message + " Error!");
	}
	
}