/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import scanner.Scanner;
import scanner.Token;
import scanner.TokenType;
import parser.Recognizer;

/**
 * Tests the non-terminal functions of the Recognizer class.
 * CSC 451
 * @author Chase Webber
 */
public class RecognizerTest {
    
    public RecognizerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
	
	/***** sign() *****/
    
    /* Happy Test for sign function */
    @Test
    public void signHappy() {
        String test = "+\n-";
        Recognizer rec = new Recognizer(test, false);
        
        rec.sign();
        rec.sign();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test for sign function */
    @Test
    public void signSad() {
        String test = "/";
        Recognizer rec = new Recognizer(test, false);
        
        try {
            rec.sign();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Sign Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }


	/***** relop() *****/

    /* Happy Test for relop function */
    @Test
    public void relopHappy() {
        String test = "<=\n==";
        Recognizer rec = new Recognizer(test, false);
        
        rec.relop();
        rec.relop();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test for relop function */
    @Test
    public void relopSad() {
        String test = "=";
        Recognizer rec = new Recognizer(test, false);
        
        try {
            rec.relop();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Relop Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
 
 
 	/***** addop() *****/

    /* Happy Test for addop function */
    @Test
    public void addopHappy() {
        String test = "+\n+";
        Recognizer rec = new Recognizer(test, false);
        
        rec.addop();
        rec.addop();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
   
    /* Sad Test for addop function */
    @Test
    public void addopSad() {
        String test = "*";
        Recognizer rec = new Recognizer(test, false);
        
        try {
            rec.addop();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Addop Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
   
   
	/***** mulop() *****/
   
    /* Happy Test for mulop function */
    @Test
    public void mulopHappy() {
        String test = "/\n*";
        Recognizer rec = new Recognizer(test, false);
        
        rec.mulop();
        rec.mulop();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test for mulop function */
    @Test
    public void mulopSad() {
        String test = "+";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.mulop();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Mulop Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }


	/***** factor() *****/

    /* Happy Test 1 for factor function */
    @Test
    public void factorHappy1() {
        String test = "ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.factor();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for factor function */
    @Test
    public void factorHappy2() {
        String test = "!5";
        Recognizer rec = new Recognizer(test, false);
        
        rec.factor();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for factor function */
    @Test
    public void factorSad1() {
        String test = "+";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.factor();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }

    /* Sad Test 2 for factor function */
    @Test
    public void factorSad2() {
        String test = "!";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.factor();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
 
 
 	/***** termPart() *****/

    /* Happy Test 1 for termPart function */
    @Test
    public void termPartHappy1() {
        String test = "*3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.termPart();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for termPart function */
    @Test
    public void termPartHappy2() {
        String test = "*3*!5";
        Recognizer rec = new Recognizer(test, false);
        
        rec.termPart();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for termPart function */
    @Test
    public void termPartSad1() {
        String test = "**5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.termPart();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for termPart function */
    @Test
    public void termPartSad2() {
        String test = "*3*+5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.termPart();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** term() *****/

    /* Happy Test 1 for term function */
    @Test
    public void termHappy1() {
        String test = "ident*3*!5";
        Recognizer rec = new Recognizer(test, false);
        
        rec.term();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for term function */
    @Test
    public void termHappy2() {
        String test = "ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.term();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for term function */
    @Test
    public void termSad1() {
        String test = "*3";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.term();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for term function */
    @Test
    public void termSad2() {
        String test = "3*/";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.term();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** simplePart() *****/

    /* Happy Test 1 for simplePart function */
    @Test
    public void simplePartHappy1() {
        String test = "+ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.simplePart();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for simplePart function */
    @Test
    public void simplePartHappy2() {
        String test = "+3+5*ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.simplePart();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for simplePart function */
    @Test
    public void simplePartSad1() {
        String test = "++5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.simplePart();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for simplePart function */
    @Test
    public void simplePartSad2() {
        String test = "+3*+5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.simplePart();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 3 for simplePart function */
    @Test
    public void simplePartSad3() {
        String test = "<";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.simplePart();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "End of File Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
	
	
	/***** simpleExpression() *****/

    /* Happy Test 1 for simpleExpression function */
    @Test
    public void simpleExpressionHappy1() {
        String test = "-5*5+3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.simpleExpression();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for simpleExpression function */
    @Test
    public void simpleExpressionHappy2() {
        String test = "-5+5*3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.simpleExpression();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for simpleExpression function */
    @Test
    public void simpleExpressionSad1() {
        String test = "+3*/5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.simpleExpression();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for simpleExpression function */
    @Test
    public void simpleExpressionSad2() {
        String test = "++3+5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.simpleExpression();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 3 for simpleExpression function */
    @Test
    public void simpleExpressionSad3() {
        String test = "-5/5+3<";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.simpleExpression();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "End of File Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** expression() *****/

    /* Happy Test 1 for expression function */
    @Test
    public void expressionHappy1() {
        String test = "-5/5+3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.expression();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for expression function */
    @Test
    public void expressionHappy2() {
        String test = "-5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.expression();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for expression function */
    @Test
    public void expressionSad1() {
        String test = "<=-5/5+3";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.expression();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for expression function */
    @Test
    public void expressionSad2() {
        String test = "-5<=-5/5+3<";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.expression();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "End of File Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** expressionList() *****/

    /* Happy Test 1 for expressionList function */
    @Test
    public void expressionListHappy1() {
        String test = "-5/5+3<=1+1,2";
        Recognizer rec = new Recognizer(test, false);
        
        rec.expressionList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for expressionList function */
    @Test
    public void expressionListHappy2() {
        String test = "-5/5+3<=1+1,1+1,2";
        Recognizer rec = new Recognizer(test, false);
        
        rec.expressionList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for expressionList function */
    @Test
    public void expressionListSad1() {
        String test = "-5/5+3<=1+1;1+1,2";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.expressionList();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "End of File Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for expressionList function */
    @Test
    public void expressionListSad2() {
        String test = "-5/5+3<=1+1,1+1,";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.expressionList();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** procedureStatement() *****/

    /* Happy Test 1 for procedureStatement function */
    @Test
    public void procedureStatementHappy1() {
        String test = "ident(-5/5+3<=1+1,1+1,2)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.procedureStatement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for procedureStatement function */
    @Test
    public void procedureStatementSad1() {
        String test = "((-5/5+3<=1+1,1+1,2))";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.procedureStatement();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Match of ID found LPAREN instead Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** variable() *****/

    /* Happy Test 1 for variable function */
    @Test
    public void variableHappy1() {
        String test = "ident[-5/5+3<=1+1]";
        Recognizer rec = new Recognizer(test, false);
        
        rec.variable();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for variable function */
    @Test
    public void variableSad1() {
        String test = "ident[-5/5+3<=1+1,1+1,2]";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.variable();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Match of RSQUARE found COMMA instead Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** statement() *****/

    /* Happy Test 1 for statement function */
    @Test
    public void statementHappy1() {
        String test = "ident[-5/5+3<=1+1]=-5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for statement function */
    @Test
    public void statementHappy2() {
        String test = "if -5/5+3<=1+1 then ident[-5/5+3<=1+1]=-5/5+3<=1+1 "
                + "else ident[-5/5+3<=1+1]=-5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 3 for statement function */
    @Test
    public void statementHappy3() {
        String test = "while -5/5+3<=1+1 do ident[-5/5+3<=1+1]=-5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 4 for statement function */
    @Test
    public void statementHappy4() {
        String test = "read (id)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Happy Test 5 for statement function */
    @Test
    public void statementHappy5() {
        String test = "write(-5/5+3<=1+1)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
	
	/* Happy Test 6 for statement function */
    @Test
    public void statementHappy6() {
        String test = "return -5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for statement function */
    @Test
    public void statementSad1() {
        String test = "ident[-5/5+3<=1+1]=";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statement();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for statement function */
    @Test
    public void statementSad2() {
        String test = "if -5/5+3<=1+1 then else";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statement();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Statement Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 3 for statement function */
    @Test
    public void statementSad3() {
        String test = "while -5/5+3<=1+1 do -5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statement();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Statement Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 4 for statement function */
    @Test
    public void statementSad4() {
        String test = "read (5)";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statement();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Match of ID found NUMBER instead Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 5 for statement function */
    @Test
    public void statementSad5() {
        String test = "write(ident[-5/5+3<=1+1]=-5/5+3<=1+1)";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statement();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Match of RPAREN found ASSIGNOP instead Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 6 for statement function */
    @Test
    public void statementSad6() {
        String test = "return";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statement();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Factor Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** statementList() *****/

    /* Happy Test 1 for statementList function */
    @Test
    public void statementListHappy1() {
        String test = "return -5/5+3<=1+1; return -5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statementList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

/* Happy Test 2 for statementList function */
    @Test
    public void statementListHappy2() {
        String test = 
				"john = -5/5+3 <= 1+1;\n" +
				"id[1+1] = 5/5+3<=2;\n" +
				"\n" +
				"if -5/5+3 <= 1+1 \n" +
				"	then ident[-5/5+3<=1+1] = -5/5+3<=1+1\n" +
				"	else ident[-5/5+3<=1+1] = -5/5+3<=1+1;\n" +
				"\n" +
				"while -5/5+3 <= 1+1 do \n" +
				"	ident[-5/5+3<=1+1]=-5/5+3<=1+1;\n" +
				"\n" +
				"read(id);\n" +
				"write(-5/5+3 <= 1+1);\n" +
				"\n" +
				"return -5/5+3 <= 1+1\n";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statementList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }


    /* Sad Test 1 for statementList function */
    @Test
    public void statementListSad1() {
        String test = "return -5/5+3<=1+1;";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statementList();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Statement Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	/* Sad Test 2 for statementList function */
    @Test
    public void statementListSad2() {
        String test = 
				"john = -5/5+3 <= 1+1;\n" +
				"id[1+1] = 5/5+3<=2;\n" +
				"\n" +
				"if -5/5+3 <= 1+1 \n" +
				"	then ident[-5/5+3<=1+1] = -5/5+3<=1+1\n" +
				"	else ident[-5/5+3<=1+1] = -5/5+3<=1+1;\n" +
				"\n" +
				"while -5/5+3 <= 1+1 do \n" +
				"	ident[-5/5+3<=1+1]=-5/5+3<=1+1;\n" +
				"\n" +
				"read(id);\n" +
				"write(-5/5+3 <= 1+1);\n" +
				"\n" +
				"return -5/5+3 <= 1+1\n;";       
		Recognizer rec = new Recognizer(test, false);

        try {
            rec.statementList();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Statement Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
	
	/***** optionalStatements() *****/

    /* Happy Test 1 for optionalStatements function */
    @Test
    public void optionalStatementsHappy1() {
        String test = "return -5/5+3<=1+1; return -5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.optionalStatements();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for optionalStatements function */
    @Test
    public void optionalStatementsSad1() {
        String test = "void";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.optionalStatements();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "End of File Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** identifierList() *****/

    /* Happy Test 1 for identifierList function */
    @Test
    public void identifierListHappy1() {
        String test = "ident, ident1, ident2";
        Recognizer rec = new Recognizer(test, false);
        
        rec.identifierList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for identifierList function */
    @Test
    public void identifierListSad1() {
        String test = "ident,";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.identifierList();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Match of ID found ENDOFFILE instead Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** declarations() *****/

    /* Happy Test 1 for declarations function */
    @Test
    public void declarationsHappy1() {
        String test = "int ident, ident1, ident2; int ident, ident1, ident2;";
        Recognizer rec = new Recognizer(test, false);
        
        rec.declarations();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for declarations function */
    @Test
    public void declarationsSad1() {
        String test = "ident, ident1, ident2;";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.declarations();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "End of File Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
	
	
	/***** compoundStatement() *****/

	/* Happy Test 1 for compoundStatement function */
    @Test
    public void compoundStatementHappy1() {
        String test = "{int ident, ident1, ident2; return -5/5+3<=1+1; "
                + "return -5/5+3<=1+1}";
        Recognizer rec = new Recognizer(test, false);
        
        rec.compoundStatement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for compoundStatement function */
    @Test
    public void compoundStatementHappy2() {
        String test = "{return -5/5+3<=1+1; return -5/5+3<=1+1}";
        Recognizer rec = new Recognizer(test, false);
        
        rec.compoundStatement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 3 for compoundStatement function */
    @Test
    public void compoundStatementHappy3() {
        String test = "{}";
        Recognizer rec = new Recognizer(test, false);
        
        rec.compoundStatement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for compoundStatement function */
    @Test
    public void compoundStatementSad1() {
        String test = "{-5/5+3<=1+1}";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.compoundStatement();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Match of RCURLY found MINUS instead Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for compoundStatement function */
    @Test
    public void compoundStatementSad2() {
        String test = "{ident[-5/5+3<=1+1]}";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.compoundStatement();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Match of ASSIGNOP found RCURLY instead Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 3 for compoundStatement function */
    @Test
    public void compoundStatementSad3() {
        String test = "{return -5/5+3<=1+1;";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.compoundStatement();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Statement Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** parameterList() *****/

    /* Happy Test 1 for parameterList function */
    @Test
    public void parameterListHappy1() {
        String test = "void ident, int ident2, float ident3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.parameterList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for parameterList function */
    @Test
    public void parameterListSad1() {
        String test = "void ident, int ident2, float ident3,";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.parameterList();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Type Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** parameters() *****/

    /* Happy Test 1 for parameters function */
    @Test
    public void parametersHappy1() {
        String test = "(void ident, int ident2, float ident3)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.parameters();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for parameters function */
    @Test
    public void parametersSad1() {
        String test = "()";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.parameters();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Type Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** functionDefinition() *****/

    /* Happy Test 1 for functionDefinition function */
    @Test
    public void functionDefinitionHappy1() {
        String test = "void fun(void ident, int ident2, float ident3) "
                + "{int ident, ident1, ident2; return -5/5+3<=1+1}";
        Recognizer rec = new Recognizer(test, false);
        
        rec.functionDefinition();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for functionDefinition function */
    @Test
    public void functionDefinitionSad1() {
        String test = "fun(void ident, int ident2, float ident3) "
                + "{int ident, ident1, ident2; return -5/5+3<=1+1}";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.functionDefinition();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Type Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** functionDefinitions() *****/

    /* Happy Test 1 for functionDefinitions function */
    @Test
    public void functionDefinitionsHappy1() {
        String test = "void fun(void ident, int ident2, float ident3) "
                + "{int ident, ident1, ident2; return -5/5+3<=1+1} "
                + "void fun(void ident, int ident2, float ident3) "
                + "{int ident, ident1, ident2; return -5/5+3<=1+1}";
        Recognizer rec = new Recognizer(test, false);
        
        rec.functionDefinitions();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for functionDefinitions function */
    @Test
    public void functionDefinitionsSad1() {
        String test = "void fun1(){} void fun2() {}";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.functionDefinitions();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Type Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** functionDeclaration() *****/

    /* Happy Test 1 for functionDeclaration function */
    @Test
    public void functionDeclarationHappy1() {
        String test = "void fun(void ident, int ident2, float ident3)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.functionDeclaration();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for functionDeclaration function */
    @Test
    public void functionDeclarationSad1() {
        String test = "void fun1()";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.functionDeclaration();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Type Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** functionDeclarations() *****/

	/* Happy Test 1 for functionDeclarations function */
    @Test
    public void functionDeclarationsHappy1() {
        String test = "void fun(void ident, int ident2, float ident3); "
                + "void fun(void ident, int ident2, float ident3);";
        Recognizer rec = new Recognizer(test, false);
        
        rec.functionDeclarations();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for functionDeclarations function */
    @Test
    public void functionDeclarationsSad1() {
        String test = "fun(void ident, int ident2, float ident3)";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.functionDeclarations();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "End of File Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    
    /***** program() *****/
	
    /* Happy Test 1 for program function */
    @Test
    public void programHappy1() {
        String test = "CCode/ProgramHappy1.txt";
        Recognizer rec = new Recognizer(test, true);
        
        rec.program();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
	
    /* Sad Test 1 for program function */
    @Test
    public void programSad1() {
        String test = "CCode/ProgramSad1.txt";
        Recognizer rec = new Recognizer(test, true);

        try {
            rec.program();
            rec.isEnd();
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Match of RCURLY found RETURN instead Error in Recognizer!";
            assertEquals(expected, e.getMessage());
        }
    }


}
