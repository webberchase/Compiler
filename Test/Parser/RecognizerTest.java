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
    
    
    /* Happy Test for sign function of Recognizer */
    @Test
    public void testSignH() throws Exception {
        String test = "+\n-";
        Recognizer rec = new Recognizer(test, false);
        
        rec.sign();
        rec.sign();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test for sign function of Recognizer */
    @Test
    public void testSignS() throws Exception {
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

    /* Happy Test for relop function of Recognizer */
    @Test
    public void testRelopH() throws Exception {
        String test = "<=\n==";
        Recognizer rec = new Recognizer(test, false);
        
        rec.relop();
        rec.relop();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test for relop function of Recognizer */
    @Test
    public void testRelopS() throws Exception {
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
 
    /* Happy Test for addop function of Recognizer */
    @Test
    public void testAddopH() throws Exception {
        String test = "+\n+";
        Recognizer rec = new Recognizer(test, false);
        
        rec.addop();
        rec.addop();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
   
    /* Sad Test for addop function of Recognizer */
    @Test
    public void testAddopS() throws Exception {
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
   
    /* Happy Test for mulop function of Recognizer */
    @Test
    public void testMulopH() throws Exception {
        String test = "/\n*";
        Recognizer rec = new Recognizer(test, false);
        
        rec.mulop();
        rec.mulop();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test for mulop function of Recognizer */
    @Test
    public void testMulopS() throws Exception {
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

    /* Happy Test 1 for factor function of Recognizer */
    @Test
    public void testFactor1H() throws Exception {
        String test = "ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.factor();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for factor function of Recognizer */
    @Test
    public void testFactor2H() throws Exception {
        String test = "!5";
        Recognizer rec = new Recognizer(test, false);
        
        rec.factor();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for factor function of Recognizer */
    @Test
    public void testFactor1S() throws Exception {
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

    /* Sad Test 2 for factor function of Recognizer */
    @Test
    public void testFactor2S() throws Exception {
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
 
    /* Happy Test 1 for termPart function of Recognizer */
    @Test
    public void testTermPart1H() throws Exception {
        String test = "*3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.termPart();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for termPart function of Recognizer */
    @Test
    public void testTermPart2H() throws Exception {
        String test = "*3*!5";
        Recognizer rec = new Recognizer(test, false);
        
        rec.termPart();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for termPart function of Recognizer */
    @Test
    public void testTermPart1S() throws Exception {
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
    
    /* Sad Test 2 for termPart function of Recognizer */
    @Test
    public void testTermPart2S() throws Exception {
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
    
    /* Happy Test 1 for term function of Recognizer */
    @Test
    public void testTerm1H() throws Exception {
        String test = "ident*3*!5";
        Recognizer rec = new Recognizer(test, false);
        
        rec.term();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for term function of Recognizer */
    @Test
    public void testTerm2H() throws Exception {
        String test = "ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.term();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for term function of Recognizer */
    @Test
    public void testTerm1S() throws Exception {
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
    
    /* Sad Test 2 for term function of Recognizer */
    @Test
    public void testTerm2S() throws Exception {
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
    
    /* Happy Test 1 for simplePart function of Recognizer */
    @Test
    public void testSimplePart1H() throws Exception {
        String test = "+ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.simplePart();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for simplePart function of Recognizer */
    @Test
    public void testSimplePart2H() throws Exception {
        String test = "+3+5*ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.simplePart();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for simplePart function of Recognizer */
    @Test
    public void testSimplePart1S() throws Exception {
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
    
    /* Sad Test 2 for simplePart function of Recognizer */
    @Test
    public void testSimplePart2S() throws Exception {
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
    
    /* Sad Test 3 for simplePart function of Recognizer */
    @Test
    public void testSimplePart3S() throws Exception {
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
        
    /* Happy Test 1 for simpleExpression function of Recognizer */
    @Test
    public void testSimpleExpression1H() throws Exception {
        String test = "-5*5+3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.simpleExpression();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for simpleExpression function of Recognizer */
    @Test
    public void testSimpleExpression2H() throws Exception {
        String test = "-5+5*3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.simpleExpression();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for simpleExpression function of Recognizer */
    @Test
    public void testSimpleExpression1S() throws Exception {
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
    
    /* Sad Test 2 for simpleExpression function of Recognizer */
    @Test
    public void testSimpleExpression2S() throws Exception {
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
    
    /* Sad Test 3 for simpleExpression function of Recognizer */
    @Test
    public void testSimpleExpression3S() throws Exception {
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
    
    
    /* Happy Test 1 for expression function of Recognizer */
    @Test
    public void testExpression1H() throws Exception {
        String test = "-5/5+3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.expression();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for expression function of Recognizer */
    @Test
    public void testExpression2H() throws Exception {
        String test = "-5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.expression();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for expression function of Recognizer */
    @Test
    public void testExpression1S() throws Exception {
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
    
    /* Sad Test 2 for expression function of Recognizer */
    @Test
    public void testExpression2S() throws Exception {
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
    
    /* Happy Test 1 for expressionList function of Recognizer */
    @Test
    public void testExpressionList1H() throws Exception {
        String test = "-5/5+3<=1+1,2";
        Recognizer rec = new Recognizer(test, false);
        
        rec.expressionList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for expressionList function of Recognizer */
    @Test
    public void testExpressionList2H() throws Exception {
        String test = "-5/5+3<=1+1,1+1,2";
        Recognizer rec = new Recognizer(test, false);
        
        rec.expressionList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for expressionList function of Recognizer */
    @Test
    public void testExpressionList1S() throws Exception {
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
    
    /* Sad Test 2 for expressionList function of Recognizer */
    @Test
    public void testExpressionList2S() throws Exception {
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
    
    /* Happy Test 1 for procedureStatement function of Recognizer */
    @Test
    public void testProcedureStatement1H() throws Exception {
        String test = "ident(-5/5+3<=1+1,1+1,2)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.procedureStatement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for procedureStatement function of Recognizer */
    @Test
    public void testProcedureStatement1S() throws Exception {
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
    
    /* Happy Test 1 for variable function of Recognizer */
    @Test
    public void testVariable1H() throws Exception {
        String test = "ident[-5/5+3<=1+1]";
        Recognizer rec = new Recognizer(test, false);
        
        rec.variable();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Sad Test 1 for variable function of Recognizer */
    @Test
    public void testVariable1S() throws Exception {
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
    
    /* Happy Test 1 for statement function of Recognizer */
    @Test
    public void testStatement1H() throws Exception {
        String test = "ident[-5/5+3<=1+1]=-5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 2 for statement function of Recognizer */
    @Test
    public void testStatement2H() throws Exception {
        String test = "if -5/5+3<=1+1 then ident[-5/5+3<=1+1]=-5/5+3<=1+1 "
                + "else ident[-5/5+3<=1+1]=-5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 3 for statement function of Recognizer */
    @Test
    public void testStatement3H() throws Exception {
        String test = "while -5/5+3<=1+1 do ident[-5/5+3<=1+1]=-5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Happy Test 4 for statement function of Recognizer */
    @Test
    public void testStatement4H() throws Exception {
        String test = "read (id)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Happy Test 5 for statement function of Recognizer */
    @Test
    public void testStatement5H() throws Exception {
        String test = "write(-5/5+3<=1+1)";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
	
	/* Happy Test 6 for statement function of Recognizer */
    @Test
    public void testStatement6H() throws Exception {
        String test = "return -5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statement();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for statement function of Recognizer */
    @Test
    public void testStatement1S() throws Exception {
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
    
    /* Sad Test 2 for statement function of Recognizer */
    @Test
    public void testStatement2S() throws Exception {
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
    
    /* Sad Test 3 for statement function of Recognizer */
    @Test
    public void testStatement3S() throws Exception {
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
    
    /* Sad Test 4 for statement function of Recognizer */
    @Test
    public void testStatement4S() throws Exception {
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
    
    /* Sad Test 5 for statement function of Recognizer */
    @Test
    public void testStatement5S() throws Exception {
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
    
    /* Sad Test 6 for statement function of Recognizer */
    @Test
    public void testStatement6S() throws Exception {
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
    
    /* Happy Test 1 for statementList function of Recognizer */
    @Test
    public void testStatement6H() throws Exception {
        String test = "return -5/5+3<=1+1; return -5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.statementList();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for statementList function of Recognizer */
    @Test
    public void testStatement6S() throws Exception {
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
    
	/* Happy Test 1 for optionalStatements function of Recognizer */
    @Test
    public void testStatement6H() throws Exception {
        String test = "return -5/5+3<=1+1; return -5/5+3<=1+1";
        Recognizer rec = new Recognizer(test, false);
        
        rec.optionalStatements();
        rec.isEnd();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }

    /* Sad Test 1 for optionalStatements function of Recognizer */
    @Test
    public void testStatement6S() throws Exception {
        String test = "void";
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
    
    
    
    
    
    
}
