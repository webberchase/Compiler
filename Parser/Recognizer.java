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
	 * Executes the rule for the program non-terminal symbol. 
	 */
	public void program() {
		functionDeclarations();
		match(TokenType.MAIN);
		match(TokenType.LPAREN);
		match(TokenType.RPAREN);
		compoundStatement();
		functionDefinitions();
	}
	
	/**
	 * Executes the rule for the identifierList non-terminal symbol. 
	 */
	public void identifierList() {
		match(TokenType.ID)
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
	 */
	public void declarations() {
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
	 */
	public void type() {
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
	 */
	public void functionDeclarations() {
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
	 */
	public void functionDeclaration() {
		type();
		match(TokenType.ID);
		parameters();
	}
	
	/**
	 * Executes the rule for the functionDefinitions non-terminal symbol. 
	 */
	public void functionDefinitions() {
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
	 */
	public void functionDefinition() {
		type();
		match(TokenType.ID);
		parameters();
		compoundStatement();
	}
	
	/**
	 * Executes the rule for the parameters non-terminal symbol. 
	 */
	public void parameters() {
		match(TokenType.LPAREN);
		parameterList();
		match(TokenType.RPAREN);
	}
	
	/**
	 * Executes the rule for the parameterList non-terminal symbol. 
	 */
	public void parameterList() {
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
	 */
	public void compoundStatement() {
		match(TokenType.LCURLY);
		declarations();
		optionalStatements();
		match(TokenType.RCURLY);
	}
	
	/**
	 * Executes the rule for the optionalStatements non-terminal symbol. 
	 */
	public void optionalStatements() {
		if (isStatement(lookahead)) { 
			statementList();
		}
		else {
			// Lambda option!
		}
	}
	
	/**
	 * Executes the rule for the statementList non-terminal symbol. 
	 */
	public void statementList() {
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
	 */
	public void statement() {
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
	 */
	public void variable() {
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
	 */
	public void procedureStatement() {
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
	 */
	public void expressionList() {
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
	 */
	public void expression() {
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
	 */
	public void simpleExpression() {
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
	 * Exceutes the rule for the simplePart non-terminal symbol.
	 */
	public void simplePart() {
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
	 */
	public void term() {
		factor();
		termPart();
	}
	
	/** 
	 * Exeecutes the rule for the termPart non-terminal symbol.
	 */
	public void termPart() {
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
	 */
	public void factor() {
		switch (lookahead.getType()) {
			case ID:
				match(TokenType.ID);
				switch (lookahead.getType()) {
					case LSQUARE:
						match(TokenType.LSQUARE);
						expression();
						match(TokenType.LSQUARE);
						break;
					case LPAREN:
						match(TokenType.LPAREN);
						expressionList();
						match(TokenType.LPAREN);
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
	 * Excecutes the rule for the sign non-terminal symbol. 
	 */
	public void sign() {
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
	 * Excecutes the rule for the relop non-terminal symbol.
	 */
	public void relop() {
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
				error("Addop");				
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
	private boolean nextIs(TokenType type) {
		if (lookahead.getType() == type) {
			return true;
		}
		else {
			return false;
		}
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
				token.getType == TokenType.MINUS) {
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
				token.getType == TokenType.DIVIDEDBY) {
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
		if (token.getType() == ID ||
				token.getType() == LCURLY ||
				token.getType() == IF ||
				token.getType() == WHILE ||
				token.getType() == READ ||
				token.getType() == WRITE ||
				token.getType() == RETURN ||) {
			result = true; 
		}
		return result;
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