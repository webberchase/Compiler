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
 * Tests the Scanner class, particularly nextToken().
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
        
    /***** TEST NUMBERS
     * @throws java.lang.Exception *****/

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

    /***** HAPPY TESTS
     * @throws java.lang.Exception *****/

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
	
    /***** SAD TESTS
     * @throws java.lang.Exception *****/

    /* Tests what happens when an illegal symbol is found */
    @Test
    public void testNextTokenSad1() throws Exception {
        String test = "#";
        Scanner s = new Scanner(new StringReader(test));

        try {
            Token actual = s.nextToken(); 
            fail("Yikes! The Sad Test didn't fail!!");
        } catch ( Exception e) {
            String expected = "Illegal Character!";
            assertEquals(expected, e.getMessage());
        }
    }

}
