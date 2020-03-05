package Scanner;

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

    
    /***** TEST COMMENTS & WHITESPACE
     * @throws java.lang.Exception *****/
    
    /* Tests whitespace */
    @Test
    public void whiteSpace() throws Exception {
        // 10 spaces, 1 tab, 3 more spaces
        String test = "          \t   ";
        Scanner s = new Scanner(new StringReader(test));
        Token actual = null;
        
        for (int i = 0; i < 14; i++) {
            actual = s.nextToken();
        }
        assertEquals(actual, s.getEND());     
    }
    
    /* Happy Test 1 for single line comments */
    @Test
    public void singleLineComment() throws Exception {
	String test = "// COMMENT \n";
        Scanner s = new Scanner(new StringReader(test));
        Token actual = null;

        for (int i = 0; i < 100; i++) {
                actual = s.nextToken();
        }
        assertEquals(actual, s.getEND());     
    }
    
    /* Happy Test 1 for traditional comments */
    @Test
    public void traditionalCommentHappy1() throws Exception {
	String test = "/* COMMENT */";
        Scanner s = new Scanner(new StringReader(test));
        Token actual = null;

        for (int i = 0; i < 100; i++) {
                actual = s.nextToken();
        }
        assertEquals(actual, s.getEND());     
    }
    
    /* Happy Test 2 for traditional comments */
    @Test
    public void traditionalCommentHappy2() throws Exception {
	String test = "/* COMMENT LINE 1 \n * LINE 2 */";
        Scanner s = new Scanner(new StringReader(test));
        Token actual = null;

        for (int i = 0; i < 100; i++) {
                actual = s.nextToken();
        }
        assertEquals(actual, s.getEND());     
    }
    
    /* Sad Test 1 for traditional comments */
    @Test
    public void traditionalCommentSad1() throws Exception {
	String test = "/* COMMENT ";
        Scanner s = new Scanner(new StringReader(test));
        Token actual = null;
        
        try {
            for (int i = 0; i < 100; i++) {
                    actual = s.nextToken();
            }
            fail("The Sad Test didn't fail!!");
        } catch(RuntimeException e) {
            String expected = "Unterminated Comment!";
            assertEquals(expected, e.getMessage());
        } 
    }
    
    
    /***** nextToken() Happy Tests
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
        String test = "CCode/SingleLine.txt";
        
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
        expected = new Token("4", TokenType.NUMBER);
        assertEquals(expected, actual);
        
        actual = s.nextToken();
        expected = new Token("=", TokenType.ASSIGNOP);
        assertEquals(expected, actual);
        
        actual = s.nextToken();
        expected = new Token("7", TokenType.NUMBER);
        assertEquals(expected, actual);
        
        actual = s.nextToken();
        assertEquals(actual, s.getEND());   
    }
    
	
    /***** ILLEGAL CHARACTER
     * @throws java.io.IOException *****/
	 
    /* Tests what happens when an illegal symbol is found */
    @Test
    public void illegalChar() throws IOException {
        String test = "#";
        Scanner s = new Scanner(new StringReader(test));

        try {
            Token actual = s.nextToken(); 
            fail("The Sad Test didn't fail!!");
        } catch ( RuntimeException e) {
            String expected = "Illegal Character!";
            assertEquals(expected, e.getMessage());
        }
    }

}
