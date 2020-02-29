/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import scanner.Scanner;
import scanner.Token;
import scanner.TokenType;

/**
 * Tests the nextToken function of the Scanner class.
 * CSC 450
 * @author Chase Webber
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
        
    /***** TEST TYPES
     * @throws java.lang.Exception *****/

    /* Test integer */
    @Test
    public void testNum1() throws Exception {
        String test = "3";
        Scanner s = new Scanner(new StringReader(test));

        Token actual = s.nextToken();
        Token expected = new Token("3", TokenType.NUMBER);
        assertEquals(expected, actual);

        actual = s.nextToken();
        assertEquals(actual, s.getEND());     
    }

    /* Test floating point */
    @Test
    public void testNum2() throws Exception {
        String test = "3.14";
        Scanner s = new Scanner(new StringReader(test));

        Token actual = s.nextToken();
        Token expected = new Token("3.14", TokenType.NUMBER);
        assertEquals(expected, actual);

        actual = s.nextToken();
        assertEquals(actual, s.getEND());     
    }

    /* Test scientific notation */
    @Test
    public void testNum3() throws Exception {
        String test = "3.14159E7";
        Scanner s = new Scanner(new StringReader(test));

        Token actual = s.nextToken();
        Token expected = new Token("3.14159E7", TokenType.NUMBER);
        assertEquals(expected, actual);

        actual = s.nextToken();
        assertEquals(actual, s.getEND());     
    }

    /* Tests whitespace */
    /*@Test
    public void whiteSpace() throws Exception {
		// 10 spaces, 1 tab, 3 more spaces
		String test = "          \t   ";
		Scanner s = new Scanner(new StringReader(test));

		for (int i = 0; i < 14; i++) {
			Token actual = s.nextToken();
			assertEquals(actual, s.getEND());     
		}
    }*/
    
    // FIXME
    /* Test traditional comment */
    /*@Test
    public void traditionalComment1() throws Exception {
	String test = "";
    Scanner s = new Scanner(new StringReader(test));

		for (int i = 0; i < 100; i++) {
			Token actual = s.nextToken();
			assertEquals(actual, s.getEND());     
		}
    }*/
    
    // FIXME
    /* Test traditional comment */
    /*@Test
    public void traditionalComment2() throws IOException {
		String test = "/* testing";
		Scanner s = new Scanner(new StringReader(test));

		Token actual = s.nextToken();
		Token expected = new Token("/", TokenType.DIVIDEDBY);
		assertEquals(expected, actual);		

		actual = s.nextToken();
		expected = new Token("*", TokenType.TIMES);
		assertEquals(expected, actual);		

		actual = s.nextToken();
		expected = new Token("testing", TokenType.ID);
		assertEquals(expected, actual);	

		actual = s.nextToken();
		expected = new Token("traditional", TokenType.ID);
		assertEquals(expected, actual);	

		actual = s.nextToken();
		expected = new Token("comment", TokenType.ID);
		assertEquals(expected, actual);	

		actual = s.nextToken();
		expected = new Token("!", TokenType.NOT);
		assertEquals(expected, actual);	

		actual = s.nextToken();
        assertEquals(actual, s.getEND());     
    }*/
    
    
    /***** HAPPY TESTS
     * @throws java.lang.Exception *****/

    /* Tests a basic math expression */
    @Test
    public void nextTokenHappy1() throws Exception {
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
        assertEquals(actual, s.getEND());     
    }
    
    /* Tests that Scanner can read a file */
    // 3+3=6\n\n2*2=4
    @Test
    public void fileReading() throws Exception {
        String test = "CCode/SmallFile.txt";
        
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(test);
        } catch (FileNotFoundException e) {
            System.out.println("No file!");
        }
        InputStreamReader isr = new InputStreamReader(fis);
        
        Scanner s = new Scanner(isr);

        Token actual = s.nextToken();
        Token expected = new Token("3", TokenType.NUMBER);
        assertEquals(expected, actual);
        
        actual = s.nextToken();
        expected = new Token("+", TokenType.PLUS);
        assertEquals(expected, actual);
        
        actual = s.nextToken();
        expected = new Token("3", TokenType.NUMBER);
        assertEquals(expected, actual);
        
        actual = s.nextToken();
        expected = new Token("=", TokenType.ASSIGNOP);
        assertEquals(expected, actual);
        
        actual = s.nextToken();
        expected = new Token("6", TokenType.NUMBER);
        assertEquals(expected, actual);
        
        actual = s.nextToken();
        assertEquals(actual, s.getEND());   
    }
    
    
	
    /***** SAD TESTS
     * @throws java.io.IOException *****/
	 
    /* Tests what happens when an illegal symbol is found */
    @Test
    public void nextTokenSad1() throws IOException {
        String test = "#";
        Scanner s = new Scanner(new StringReader(test));

        try {
            Token actual = s.nextToken(); 
            fail("Yikes! The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Illegal Character!";
            assertEquals(expected, e.getMessage());
        }
    }

}
