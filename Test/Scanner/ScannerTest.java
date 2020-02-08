/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.StringReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chase
 */
public class ScannerTest {
    
    public ScannerTest() {
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

    /***** TEST NUMBERS *****/

    /* Test integer */
    @Test
    public void testNumber1() throws Exception {
        String test = "3";
        Scanner s = new Scanner(new StringReader(test));

        Token actual = s.nextToken();
        Token expected = new Token("3", TokenType.NUMBER);
        assertEquals(expected, actual);

        actual = s.nextToken();
        assertNull(actual);        
    }

    /* Test floating point */
    @Test
    public void testNumber2() throws Exception {
        String test = "3.14";
        Scanner s = new Scanner(new StringReader(test));

        Token actual = s.nextToken();
        Token expected = new Token("3.14", TokenType.NUMBER);
        assertEquals(expected, actual);

        actual = s.nextToken();
        assertNull(actual);        
    }

	// FIXME
    /* Test scientific notation */
    @Test
    public void testNumber3() throws Exception {
        String test = "3.14159E7";
        Scanner s = new Scanner(new StringReader(test));

        Token actual = s.nextToken();
        Token expected = new Token("3.14159E7", TokenType.NUMBER);
        assertEquals(expected, actual);

        actual = s.nextToken();
        assertNull(actual);        
    }

    /***** HAPPY TESTS *****/

    /* Tests a basic math expression */
    @Test
    public void testNextTokenHappy1() throws Exception {
        String test = "14+3";
        Scanner s = new Scanner(new StringReader(test));
        
        Token actual = s.nextToken();
        Token expected = new Token("14", TokenType.NUMBER);
        assertEquals(expected, actual);
        
        actual = s.nextToken();
        expected = new Token("+", TokenType.PLUS);
        assertEquals(expected, actual);
        
        actual = s.nextToken();
        expected = new Token("3", TokenType.NUMBER);
        assertEquals(expected, actual);
        
        actual = s.nextToken();
        assertNull(actual);        
    }
	
    /***** SAD TESTS *****/

    /* Tests what happens when an illegal symbol is found */
    @Test
    public void testNextTokenSad1() throws Exception {
        String test = "#";
        Scanner s = new Scanner(new StringReader(test));

        try {
            Token actual = s.nextToken(); 
            // Scanner.java should throw an exception if it finds 
            // an unknown symbol. Should it do something else? 
            // Result: "Error, could not match input"
            fail("Yikes! The Sad Test didn't fail!!");
        } catch ( Exception e) {
            // FIXME
            // Cannot get into the catch clause!
            System.out.println("Hello World");
            System.out.println(e.getMessage());
	}

		
		
		
	
	}

}
