/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

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
 *
 * @author chase
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
    
    /***** HAPPY TESTS
     * @throws java.lang.Exception *****/

    /* Test for sign function of Recognizer */
    @Test
    public void testSignH() throws Exception {
        String test = "+\n-";
        Recognizer rec = new Recognizer(test, false);
        
        rec.sign();
        rec.sign();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Test for relop function of Recognizer */
    @Test
    public void testRelopH() throws Exception {
        String test = "<=\n==";
        Recognizer rec = new Recognizer(test, false);
        
        rec.relop();
        rec.relop();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Test for addop function of Recognizer */
    @Test
    public void testAddopH() throws Exception {
        String test = "+\n+";
        Recognizer rec = new Recognizer(test, false);
        
        rec.addop();
        rec.addop();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Test for mulop function of Recognizer */
    @Test
    public void testMulopH() throws Exception {
        String test = "/\n*";
        Recognizer rec = new Recognizer(test, false);
        
        rec.mulop();
        rec.mulop();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Test 1 for factor function of Recognizer */
    @Test
    public void testFactor1H() throws Exception {
        String test = "ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.factor();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Test 2 for factor function of Recognizer */
    @Test
    public void testFactor2H() throws Exception {
        String test = "!5";
        Recognizer rec = new Recognizer(test, false);
        
        rec.factor();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Test 1 for termPart function of Recognizer */
    @Test
    public void testTermPart1H() throws Exception {
        String test = "*3";
        Recognizer rec = new Recognizer(test, false);
        
        rec.termPart();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Test 2 for termPart function of Recognizer */
    @Test
    public void testTermPart2H() throws Exception {
        String test = "*3*!5";
        Recognizer rec = new Recognizer(test, false);
        
        rec.termPart();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Test 1 for term function of Recognizer */
    @Test
    public void testTerm1H() throws Exception {
        String test = "ident*3*!5";
        Recognizer rec = new Recognizer(test, false);
        
        rec.term();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    /* Test 2 for term function of Recognizer */
    @Test
    public void testTerm2H() throws Exception {
        String test = "ident";
        Recognizer rec = new Recognizer(test, false);
        
        rec.term();
        
        assertEquals(rec.getLookahead(), rec.getEND());
    }
    
    
    
    
    /***** SAD TESTS
     * @throws java.lang.Exception *****/

    /* Test for sign function of Recognizer */
    @Test
    public void testSignS() throws Exception {
        String test = "/";
        Recognizer rec = new Recognizer(test, false);
        
        try {
            rec.sign();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Sign Error!";
            assertEquals(expected, e.getMessage());
        }
    }

    /* Test for relop function of Recognizer */
    @Test
    public void testRelopS() throws Exception {
        String test = "=";
        Recognizer rec = new Recognizer(test, false);
        
        try {
            rec.relop();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Relop Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Test for addop function of Recognizer */
    @Test
    public void testAddopS() throws Exception {
        String test = "*";
        Recognizer rec = new Recognizer(test, false);
        
        try {
            rec.addop();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Addop Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Test for mulop function of Recognizer */
    @Test
    public void testMulopS() throws Exception {
        String test = "+";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.mulop();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Mulop Error!";
            assertEquals(expected, e.getMessage());
        }
    }

    /* Test 1 for factor function of Recognizer */
    @Test
    public void testFactor1S() throws Exception {
        String test = "+";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.factor();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }

    /* Test 2 for factor function of Recognizer */
    @Test
    public void testFactor2S() throws Exception {
        String test = "!";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.factor();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }

    /* Test 1 for termPart function of Recognizer */
    @Test
    public void testTermPart1S() throws Exception {
        String test = "**5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.termPart();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Test 2 for termPart function of Recognizer */
    @Test
    public void testTermPart2S() throws Exception {
        String test = "*3*+5";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.termPart();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Test 1 for term function of Recognizer */
    @Test
    public void testTerm1S() throws Exception {
        String test = "*3";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.term();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    /* Test 2 for term function of Recognizer */
    @Test
    public void testTerm2S() throws Exception {
        String test = "3*/";
        Recognizer rec = new Recognizer(test, false);

        try {
            rec.term();
            fail("Yikes! The Sad Test didn't fail!!");
        } catch (Exception e) {
            String expected = "Factor Error!";
            assertEquals(expected, e.getMessage());
        }
    }
    
    
}
