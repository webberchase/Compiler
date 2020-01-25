import java.io.IOException;
import java.io.StringReader;
import org.junit.Test; 
import static org.junit.Assert.*;

/**
 * Unit tests of the Scanner class, to be run with JUnit. 
 * 
 * To compile against the JUnit classes on the command line:
 * javac -cp .;junit-4.13.jar;hamcrest-core-1.3.jar TestScanner.java
 * 
 * To run the tests in this class on the command line:
 * java -cp .;junit-4.13.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestScanner
 * 
 * @author chase
 */
public class TestScanner {
    
    public TestScanner() {
    }

    @Test
    void testNextTokenHappy1() throws IOException {
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

}
