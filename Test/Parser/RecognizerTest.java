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
    
	
	/***** sign()
     * @throws java.lang.Exception *****/
    
    /* Happy Test for sign function */
    @Test
    public void signHappy() throws Exception {
        String test = "+\n-";
        Recognizer rec = new Recognizer(test, false);
        
        rec.sign();
        rec.sign();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test for sign function */
    @Test
    public void signSad() throws Exception {
        String test = "/";
        Recognizer rec = new Recognizer(test, false);
        
        try {
            rec.sign();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Sign Error!";
            assertEquals(expected, e.getMessage());
        }
    }


	/***** relop()
     * @throws java.lang.Exception *****/

    /* Happy Test for relop function */
    @Test
    public void relopHappy() throws Exception {
        String test = "<=\n==";
        Recognizer rec = new Recognizer(test, false);
        
        rec.relop();
        rec.relop();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test for relop function */
    @Test
    public void relopSad() throws Exception {
        String test = "=";
        Recognizer rec = new Recognizer(test, false);
        
        try {
            rec.relop();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Relop Error!";
            assertEquals(expected, e.getMessage());
        }
    }
 
 
 	/***** addop()
     * @throws java.lang.Exception *****/

    /* Happy Test for addop function */
    @Test
    public void addopHappy() throws Exception {
        String test = "+\n+";
        Recognizer rec = new Recognizer(test, false);
        
        rec.addop();
        rec.addop();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
   
    /* Sad Test for addop function */
    @Test
    public void addopSad() throws Exception {
        String test = "*";
        Recognizer rec = new Recognizer(test, false);
        
        try {
            rec.addop();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Addop Error!";
            assertEquals(expected, e.getMessage());
        }
    }
   
   
	/***** mulop()
     * @throws java.lang.Exception *****/
   
    /* Happy Test for mulop function */
    @Test
    public void mulopHappy() throws Exception {
        String test = "/\n*";
        Recognizer rec = new Recognizer(test, false);
        
        rec.mulop();
        rec.mulop();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test for mulop function */
    @Test
    public void mulopSad() throws Exception {
        String test = "+";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.mulop();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Mulop Error!";
            assertEquals(expected, e.getMessage());
        }
    }


	/***** factor()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for factor function */
    @Test
    public void factorHappy1() throws Exception {
        String test = "ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.factor();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for factor function */
    @Test
    public void factorHappy2() throws Exception {
        String test = "!5";
        Recognizer rec = new Recognizer(test, false);
        
        rec.factor();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for factor function */
    @Test
    public void factorSad1() throws Exception {
        String test = "+";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.factor();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }

    /* Sad Test 2 for factor function */
    @Test
    public void factorSad2() throws Exception {
        String test = "!";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.factor();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
 
 
 	/***** termPart()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for termPart function */
    @Test
    public void termPartHappy1() throws Exception {
        String test = "*3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.termPart();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for termPart function */
    @Test
    public void termPartHappy2() throws Exception {
        String test = "*3*!5";
        Recognizer rec = new Recognizer(test, false);
        
        rec.termPart();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for termPart function */
    @Test
    public void termPartSad1() throws Exception {
        String test = "**5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.termPart();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for termPart function */
    @Test
    public void termPartSad2() throws Exception {
        String test = "*3*+5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.termPart();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** term()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for term function */
    @Test
    public void termHappy1() throws Exception {
        String test = "ident*3*!5";
        Recognizer rec = new Recognizer(test, false);
        
        rec.term();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for term function */
    @Test
    public void termHappy2() throws Exception {
        String test = "ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.term();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for term function */
    @Test
    public void termSad1() throws Exception {
        String test = "*3";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.term();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for term function */
    @Test
    public void termSad2() throws Exception {
        String test = "3*/";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.term();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** simplePart()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for simplePart function */
    @Test
    public void simplePartHappy1() throws Exception {
        String test = "+ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.simplePart();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for simplePart function */
    @Test
    public void simplePartHappy2() throws Exception {
        String test = "+3+5*ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.simplePart();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for simplePart function */
    @Test
    public void simplePartSad1() throws Exception {
        String test = "++5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.simplePart();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for simplePart function */
    @Test
    public void simplePartSad2() throws Exception {
        String test = "+3*+5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.simplePart();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 3 for simplePart function */
    @Test
    public void simplePartSad3() throws Exception {
        String test = "<";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.simplePart();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "End of File Error!";
            assertEquals(expected, e.getMessage());
        }
    }
	
	
	/***** simpleExpression()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for simpleExpression function */
    @Test
    public void simpleExpressionHappy1() throws Exception {
        String test = "-5*5+3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.simpleExpression();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for simpleExpression function */
    @Test
    public void simpleExpressionHappy2() throws Exception {
        String test = "-5+5*3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.simpleExpression();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for simpleExpression function */
    @Test
    public void simpleExpressionSad1() throws Exception {
        String test = "+3*/5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.simpleExpression();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for simpleExpression function */
    @Test
    public void simpleExpressionSad2() throws Exception {
        String test = "++3+5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.simpleExpression();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 3 for simpleExpression function */
    @Test
    public void simpleExpressionSad3() throws Exception {
        String test = "-5/5+3<";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.simpleExpression();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "End of File Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** expression()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for expression function */
    @Test
    public void expressionHappy1() throws Exception {
        String test = "-5/5+3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.expression();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for expression function */
    @Test
    public void expressionHappy2() throws Exception {
        String test = "-5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.expression();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for expression function */
    @Test
    public void expressionSad1() throws Exception {
        String test = "<=-5/5+3";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.expression();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for expression function */
    @Test
    public void expressionSad2() throws Exception {
        String test = "-5<=-5/5+3<";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.expression();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "End of File Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** expressionList()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for expressionList function */
    @Test
    public void expressionListHappy1() throws Exception {
        String test = "-5/5+3<=1+1,2";
        Recognizer rec = new Recognizer(test, false);
        
        rec.expressionList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for expressionList function */
    @Test
    public void expressionListHappy2() throws Exception {
        String test = "-5/5+3<=1+1,1+1,2";
        Recognizer rec = new Recognizer(test, false);
        
        rec.expressionList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for expressionList function */
    @Test
    public void expressionListSad1() throws Exception {
        String test = "-5/5+3<=1+1;1+1,2";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.expressionList();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "End of File Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for expressionList function */
    @Test
    public void expressionListSad2() throws Exception {
        String test = "-5/5+3<=1+1,1+1,";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.expressionList();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** procedureStatement()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for procedureStatement function */
    @Test
    public void procedureStatementHappy1() throws Exception {
        String test = "ident(-5/5+3<=1+1,1+1,2)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.procedureStatement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for procedureStatement function */
    @Test
    public void procedureStatementSad1() throws Exception {
        String test = "((-5/5+3<=1+1,1+1,2))";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.procedureStatement();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Match of ID found LPAREN instead Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** variable()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for variable function */
    @Test
    public void variableHappy1() throws Exception {
        String test = "ident[-5/5+3<=1+1]";
        Recognizer rec = new Recognizer(test, false);
        
        rec.variable();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for variable function */
    @Test
    public void variableSad1() throws Exception {
        String test = "ident[-5/5+3<=1+1,1+1,2]";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.variable();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Match of RSQUARE found COMMA instead Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** statement()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for statement function */
    @Test
    public void statementHappy1() throws Exception {
        String test = "ident[-5/5+3<=1+1]=-5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for statement function */
    @Test
    public void statementHappy2() throws Exception {
        String test = "if -5/5+3<=1+1 then ident[-5/5+3<=1+1]=-5/5+3<=1+1 "
                + "else ident[-5/5+3<=1+1]=-5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 3 for statement function */
    @Test
    public void statementHappy3() throws Exception {
        String test = "while -5/5+3<=1+1 do ident[-5/5+3<=1+1]=-5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 4 for statement function */
    @Test
    public void statementHappy4() throws Exception {
        String test = "read (id)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Happy Test 5 for statement function */
    @Test
    public void statementHappy5() throws Exception {
        String test = "write(-5/5+3<=1+1)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
	
	/* Happy Test 6 for statement function */
    @Test
    public void statementHappy6() throws Exception {
        String test = "return -5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for statement function */
    @Test
    public void statementSad1() throws Exception {
        String test = "ident[-5/5+3<=1+1]=";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statement();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for statement function */
    @Test
    public void statementSad2() throws Exception {
        String test = "if -5/5+3<=1+1 then else";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statement();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Statement Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 3 for statement function */
    @Test
    public void statementSad3() throws Exception {
        String test = "while -5/5+3<=1+1 do -5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statement();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Statement Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 4 for statement function */
    @Test
    public void statementSad4() throws Exception {
        String test = "read (5)";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statement();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Match of ID found NUMBER instead Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 5 for statement function */
    @Test
    public void statementSad5() throws Exception {
        String test = "write(ident[-5/5+3<=1+1]=-5/5+3<=1+1)";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statement();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Match of RPAREN found ASSIGNOP instead Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 6 for statement function */
    @Test
    public void statementSad6() throws Exception {
        String test = "return";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statement();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** statementList()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for statementList function */
    @Test
    public void statementListHappy1() throws Exception {
        String test = "return -5/5+3<=1+1; return -5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statementList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

/* Happy Test 2 for statementList function */
    @Test
    public void statementListHappy2() throws Exception {
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
    public void statementListSad1() throws Exception {
        String test = "return -5/5+3<=1+1;";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.statementList();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Statement Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	/* Sad Test 2 for statementList function */
    @Test
    public void statementListSad2() throws Exception {
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
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Statement Error!";
            assertEquals(expected, e.getMessage());
        }
    }
	
	/***** optionalStatements()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for optionalStatements function */
    @Test
    public void optionalStatementsHappy1() throws Exception {
        String test = "return -5/5+3<=1+1; return -5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.optionalStatements();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for optionalStatements function */
    @Test
    public void optionalStatementsSad1() throws Exception {
        String test = "void";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.optionalStatements();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "End of File Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** identifierList()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for identifierList function */
    @Test
    public void identifierListHappy1() throws Exception {
        String test = "ident, ident1, ident2";
        Recognizer rec = new Recognizer(test, false);
        
        rec.identifierList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for identifierList function */
    @Test
    public void identifierListSad1() throws Exception {
        String test = "ident,";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.identifierList();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Match of ID found ENDOFFILE instead Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** declarations()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for declarations function */
    @Test
    public void declarationsHappy1() throws Exception {
        String test = "int ident, ident1, ident2; int ident, ident1, ident2;";
        Recognizer rec = new Recognizer(test, false);
        
        rec.declarations();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for declarations function */
    @Test
    public void declarationsSad1() throws Exception {
        String test = "ident, ident1, ident2;";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.declarations();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "End of File Error!";
            assertEquals(expected, e.getMessage());
        }
    }
	
	
	/***** compoundStatement()
     * @throws java.lang.Exception *****/

	/* Happy Test 1 for compoundStatement function */
    @Test
    public void compoundStatementHappy1() throws Exception {
        String test = "{int ident, ident1, ident2; return -5/5+3<=1+1; "
                + "return -5/5+3<=1+1}";
        Recognizer rec = new Recognizer(test, false);
        
        rec.compoundStatement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for compoundStatement function */
    @Test
    public void compoundStatementHappy2() throws Exception {
        String test = "{return -5/5+3<=1+1; return -5/5+3<=1+1}";
        Recognizer rec = new Recognizer(test, false);
        
        rec.compoundStatement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 3 for compoundStatement function */
    @Test
    public void compoundStatementHappy3() throws Exception {
        String test = "{}";
        Recognizer rec = new Recognizer(test, false);
        
        rec.compoundStatement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for compoundStatement function */
    @Test
    public void compoundStatementSad1() throws Exception {
        String test = "{-5/5+3<=1+1}";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.compoundStatement();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Match of RCURLY found MINUS instead Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 2 for compoundStatement function */
    @Test
    public void compoundStatementSad2() throws Exception {
        String test = "{ident[-5/5+3<=1+1]}";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.compoundStatement();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Match of ASSIGNOP found RCURLY instead Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Sad Test 3 for compoundStatement function */
    @Test
    public void compoundStatementSad3() throws Exception {
        String test = "{return -5/5+3<=1+1;";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.compoundStatement();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Statement Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** parameterList()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for parameterList function */
    @Test
    public void parameterListHappy1() throws Exception {
        String test = "void ident, int ident2, float ident3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.parameterList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for parameterList function */
    @Test
    public void parameterListSad1() throws Exception {
        String test = "void ident, int ident2, float ident3,";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.parameterList();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Type Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** parameters()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for parameters function */
    @Test
    public void parametersHappy1() throws Exception {
        String test = "(void ident, int ident2, float ident3)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.parameters();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for parameters function */
    @Test
    public void parametersSad1() throws Exception {
        String test = "()";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.parameters();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Type Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** functionDefinition()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for functionDefinition function */
    @Test
    public void functionDefinitionHappy1() throws Exception {
        String test = "void fun(void ident, int ident2, float ident3) "
                + "{int ident, ident1, ident2; return -5/5+3<=1+1}";
        Recognizer rec = new Recognizer(test, false);
        
        rec.functionDefinition();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for functionDefinition function */
    @Test
    public void functionDefinitionSad1() throws Exception {
        String test = "fun(void ident, int ident2, float ident3) "
                + "{int ident, ident1, ident2; return -5/5+3<=1+1}";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.functionDefinition();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Type Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** functionDefinitions()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for functionDefinitions function */
    @Test
    public void functionDefinitionsHappy1() throws Exception {
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
    public void functionDefinitionsSad1() throws Exception {
        String test = "void fun1(){} void fun2() {}";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.functionDefinitions();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Type Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** functionDeclaration()
     * @throws java.lang.Exception *****/

    /* Happy Test 1 for functionDeclaration function */
    @Test
    public void functionDeclarationHappy1() throws Exception {
        String test = "void fun(void ident, int ident2, float ident3)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.functionDeclaration();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for functionDeclaration function */
    @Test
    public void functionDeclarationSad1() throws Exception {
        String test = "void fun1()";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.functionDeclaration();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Type Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
	
	/***** functionDeclarations()
     * @throws java.lang.Exception *****/

	/* Happy Test 1 for functionDeclarations function */
    @Test
    public void functionDeclarationsHappy1() throws Exception {
        String test = "void fun(void ident, int ident2, float ident3); "
                + "void fun(void ident, int ident2, float ident3);";
        Recognizer rec = new Recognizer(test, false);
        
        rec.functionDeclarations();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for functionDeclarations function */
    @Test
    public void functionDeclarationsSad1() throws Exception {
        String test = "fun(void ident, int ident2, float ident3)";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.functionDeclarations();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "End of File Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    
    /***** program()
	 * NOTE: Recognizer's file reader doesn't function yet... 
	 * @throws java.lang.Exception *****/
	
    /* Happy Test 1 for program function */
    @Test
    public void programHappy1() throws Exception {
        String test = "void john (void ident, int ident2, float ident3);\n" +
"int rachael (void ident); \n" +
"float bruce (int ident2, float ident3);\n" +
"\n" +
"main() {\n" +
"\n" +
"	int id1, id2, id3; \n" +
"	float id4;\n" +
"	\n" +
"	john = -5/5+3 <= 1+1;\n" +
"	id[1+1] = 5/5+3<=2;\n" +
"	\n" +
"	{\n" +
"		int id1, id2, id3; \n" +
"		float id4;\n" +
"		\n" +
"		john = -5/5+3 <= 1+1;\n" +
"		id[1+1] = 5/5+3<=2;\n" +
"				\n" +
"		if -5/5+3 <= 1+1 \n" +
"			then ident[-5/5+3<=1+1] = -5/5+3<=1+1\n" +
"			else ident[-5/5+3<=1+1] = -5/5+3<=1+1;\n" +
"			\n" +
"		while -5/5+3 <= 1+1 do \n" +
"			ident[-5/5+3<=1+1]=-5/5+3<=1+1;\n" +
"			\n" +
"		read(id);\n" +
"		write(-5/5+3 <= 1+1);\n" +
"		\n" +
"		return -5/5+3 <= 1+1\n" +
"	};	\n" +
"	\n" +
"	if -5/5+3 <= 1+1 \n" +
"		then ident[-5/5+3<=1+1] = -5/5+3<=1+1\n" +
"		else ident[-5/5+3<=1+1] = -5/5+3<=1+1;\n" +
"		\n" +
"	while -5/5+3 <= 1+1 do \n" +
"		ident[-5/5+3<=1+1]=-5/5+3<=1+1;\n" +
"		\n" +
"	read(id);\n" +
"	write(-5/5+3 <= 1+1);\n" +
"	\n" +
"	return -5/5+3 <= 1+1\n" +
"}\n" +
"\n" +
"void john (void ident, int ident2, float ident3) {\n" +
"	int id1, id2, id3; \n" +
"	float id4;\n" +
"	\n" +
"	john = -5/5+3 <= 1+1;\n" +
"	id[1+1] = 5/5+3<=2;\n" +
"		\n" +
"	if -5/5+3 <= 1+1 \n" +
"		then ident[-5/5+3<=1+1] = -5/5+3<=1+1\n" +
"		else ident[-5/5+3<=1+1] = -5/5+3<=1+1;\n" +
"		\n" +
"	while -5/5+3 <= 1+1 do \n" +
"		ident[-5/5+3<=1+1]=-5/5+3<=1+1;\n" +
"		\n" +
"	read(id);\n" +
"	write(-5/5+3 <= 1+1);\n" +
"	\n" +
"	return -5/5+3 <= 1+1\n" +
"}	\n" +
"	\n" +
"int rachael (void ident) {\n" +
"	int id1, id2, id3; \n" +
"	float id4;\n" +
"	\n" +
"	john = -5/5+3 <= 1+1;\n" +
"	id[1+1] = 5/5+3<=2;\n" +
"		\n" +
"	if -5/5+3 <= 1+1 \n" +
"		then ident[-5/5+3<=1+1] = -5/5+3<=1+1\n" +
"		else ident[-5/5+3<=1+1] = -5/5+3<=1+1;\n" +
"		\n" +
"	while -5/5+3 <= 1+1 do \n" +
"		ident[-5/5+3<=1+1]=-5/5+3<=1+1;\n" +
"		\n" +
"	read(id);\n" +
"	write(-5/5+3 <= 1+1);\n" +
"	\n" +
"	return -5/5+3 <= 1+1\n" +
"}	\n" +
"	\n" +
"float bruce (int ident2, float ident3) {\n" +
"	int id1, id2, id3; \n" +
"	float id4;\n" +
"	\n" +
"	john = -5/5+3 <= 1+1;\n" +
"	id[1+1] = 5/5+3<=2;\n" +
"		\n" +
"	if -5/5+3 <= 1+1 \n" +
"		then ident[-5/5+3<=1+1] = -5/5+3<=1+1\n" +
"		else ident[-5/5+3<=1+1] = -5/5+3<=1+1;\n" +
"		\n" +
"	while -5/5+3 <= 1+1 do \n" +
"		ident[-5/5+3<=1+1]=-5/5+3<=1+1;\n" +
"		\n" +
"	read(id);\n" +
"	write(-5/5+3 <= 1+1);\n" +
"	\n" +
"	return -5/5+3 <= 1+1\n" +
"}	\n" +
"";
        Recognizer rec = new Recognizer(test, false);
        
        rec.program();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
	
    /* Sad Test 1 for program function */
    @Test
    public void programSad1() throws Exception {
        String test = "void john (void ident, int ident2, float ident3);\n" +
"int rachael (void ident); \n" +
"float bruce (int ident2, float ident3);\n" +
"\n" +
"main() {\n" +
"\n" +
"	int id1, id2, id3; \n" +
"	float id4;\n" +
"	\n" +
"	john = -5/5+3 <= 1+1;\n" +
"	id[1+1] = 5/5+3<=2;\n" +
"	\n" +
"	{\n" +
"		int id1, id2, id3; \n" +
"		float id4;\n" +
"		\n" +
"		john = -5/5+3 <= 1+1;\n" +
"		id[1+1] = 5/5+3<=2;\n" +
"				\n" +
"		if -5/5+3 <= 1+1 \n" +
"			then ident[-5/5+3<=1+1] = -5/5+3<=1+1\n" +
"			else ident[-5/5+3<=1+1] = -5/5+3<=1+1;\n" +
"			\n" +
"		while -5/5+3 <= 1+1 do \n" +
"			ident[-5/5+3<=1+1]=-5/5+3<=1+1;\n" +
"			\n" +
"		read(id);\n" +
"		write(-5/5+3 <= 1+1);\n" +
"		\n" +
"		return -5/5+3 <= 1+1\n" +
"	};	\n" +
"	\n" +
"	if -5/5+3 <= 1+1 \n" +
"		then ident[-5/5+3<=1+1] = -5/5+3<=1+1\n" +
"		else ident[-5/5+3<=1+1] = -5/5+3<=1+1;\n" +
"		\n" +
"	while -5/5+3 <= 1+1 do \n" +
"		ident[-5/5+3<=1+1]=-5/5+3<=1+1;\n" +
"		\n" +
"	read(id);\n" +
"	write(-5/5+3 <= 1+1);\n" +
"	\n" +
"	return -5/5+3 <= 1+1\n" +
"}\n" +
"\n" +
"void john (void ident, int ident2, float ident3) {\n" +
"	int id1, id2, id3; \n" +
"	float id4;\n" +
"	\n" +
"	john = -5/5+3 <= 1+1;\n" +
"	id[1+1] = 5/5+3<=2;\n" +
"		\n" +
"	if -5/5+3 <= 1+1 \n" +
"		then ident[-5/5+3<=1+1] = -5/5+3<=1+1\n" +
"		else ident[-5/5+3<=1+1] = -5/5+3<=1+1;\n" +
"		\n" +
"	while -5/5+3 <= 1+1 do \n" +
"		ident[-5/5+3<=1+1]=-5/5+3<=1+1;\n" +
"		\n" +
"	read(id);\n" +
"	write(-5/5+3 <= 1+1);\n" +
"	\n" +
"	return -5/5+3 <= 1+1\n" +
"}	\n" +
"	\n" +
"int rachael (void ident) {\n" +
"	int id1, id2, id3; \n" +
"	float id4;\n" +
"	\n" +
"	john = -5/5+3 <= 1+1;\n" +
"	id[1+1] = 5/5+3<=2;\n" +
"		\n" +
"	if -5/5+3 <= 1+1 \n" +
"		then ident[-5/5+3<=1+1] = -5/5+3<=1+1\n" +
"		else ident[-5/5+3<=1+1] = -5/5+3<=1+1;\n" +
"		\n" +
"	while -5/5+3 <= 1+1 do \n" +
"		ident[-5/5+3<=1+1]=-5/5+3<=1+1;\n" +
"		\n" +
"	read(id);\n" +
"	write(-5/5+3 <= 1+1);\n" +
"	\n" +
"	return -5/5+3 <= 1+1\n" +
"}	\n" +
"	\n" +
"float bruce (int ident2, float ident3) {\n" +
"	int id1, id2, id3; \n" +
"	float id4;\n" +
"	\n" +
"	john = -5/5+3 <= 1+1;\n" +
"	id[1+1] = 5/5+3<=2;\n" +
"		\n" +
"	if -5/5+3 <= 1+1 \n" +
"		then ident[-5/5+3<=1+1] = -5/5+3<=1+1\n" +
"		else ident[-5/5+3<=1+1] = -5/5+3<=1+1;\n" +
"		\n" +
"	while -5/5+3 <= 1+1 do \n" +
"		ident[-5/5+3<=1+1]=-5/5+3<=1+1;\n" +
"		\n" +
"	read(id);\n" +
"	write(-5/5+3 <= 1+1)\n" +
"	\n" +
"	return -5/5+3 <= 1+1\n" +
"}	\n" +
"";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.program();
            rec.isEnd();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Match of RCURLY found RETURN instead Error!";
            assertEquals(expected, e.getMessage());
        }
    }

    

}
