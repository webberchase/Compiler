package Parser;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests functions of the SymbolTable class.
 * CSC 451 Compilers
 * @author Chase Webber
 */
public class SymbolTableTest {
    
    public SymbolTableTest() {
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

    
    /***** addFunName() *****/
    
    /**
     * Happy Test 1 of addFunName method.
     */
    @Test
    public void addFunNameHappy1() {
        String test = "myFun";
        SymbolTable st = new SymbolTable();
        
        st.addFunName(test);
        
        String expected = " - ROW 0 -\n";
        expected += "ID: myFun, ";
        expected += "kind: FUN_NAME, ";
        expected += "type: null.\n";
        
        String actual = st.toString();
        
        assertEquals(expected, actual);           
    }
    
    /**
     * Sad Test 1 of addFunName method. 
     */
    @Test
    public void addFunNameSad1() {
        String test = "myFun";
        SymbolTable st = new SymbolTable();
        
        try {
            st.addFunName(test);
            st.addFunName(test);
            fail("The Sad Test didn't fail!!");
        } catch (RuntimeException e) {
            String expected = "Duplicate FunName Error in Symbol Table!";
            assertEquals(expected, e.getMessage());
        }
    }

    
    /***** isFunName() *****/
    
    /**
     * Happy Test 1 of isFunName method.
     */
    @Test
    public void isFunNameHappy1() {
        String test = "myFun";
        SymbolTable st = new SymbolTable();
        
        st.addVarName(test);
        st.addFunName(test);
        
        boolean expected = true;
        boolean actual = st.isFunName(test);
                
        assertEquals(expected, actual);   
    }
    
    /**
     * Happy Test 2 of isFunName method. 
     */
    @Test
    public void isFunNameHappy2() {
        String test = "myFun";
        String fake = "fake";
        SymbolTable st = new SymbolTable();
        
        st.addFunName(fake);
        
        boolean expected = false;
        boolean actual = st.isFunName(test);
        
        assertEquals(expected, actual);
    }
    
    /**
     * Happy Test 3 of isFunName method. 
     */
    @Test
    public void isFunNameHappy3() {
        String test = "myFun";
        SymbolTable st = new SymbolTable();
        
        st.addVarName(test);
        
        boolean expected = false;
        boolean actual = st.isFunName(test);
        
        assertEquals(expected, actual);
    }
    

    /***** addVarName() *****/
    
    /**
     * Test of addVarName method.
     */
    @Test
    public void addVarNameHappy1() {
        String test = "myVar";
        SymbolTable st = new SymbolTable();
        
        st.addVarName(test);
        
        String expected = " - ROW 0 -\n";
        expected += "ID: myVar, ";
        expected += "kind: VAR_NAME, ";
        expected += "type: null.\n";
        
        String actual = st.toString();
        
        assertEquals(expected, actual);           
    }
    
    /**
     * Sad Test 1 of addVarName method. 
     */
    @Test
    public void addVarNameSad1() {
        String test = "myVar";
        SymbolTable st = new SymbolTable();
        
        try {
            st.addVarName(test);
            st.addVarName(test);
            fail("The Sad Test didn't fail!!");
        } catch (RuntimeException e) {
            String expected = "Duplicate VarName Error in Symbol Table!";
            assertEquals(expected, e.getMessage());
        }

    }

    
    /***** isVarName() *****/
    
    /**
     * Happy Test 1 of isVarName method.
     */
    @Test
    public void isVarNameHappy1() {
        String test = "myVar";
        SymbolTable st = new SymbolTable();
        
        st.addFunName(test);
        st.addVarName(test);
        
        boolean expected = true;
        boolean actual = st.isVarName(test);
                
        assertEquals(expected, actual);   
    }
    
    /**
     * Happy Test 2 of isVarName method. 
     */
    @Test
    public void isVarNameHappy2() {
        String test = "myVar";
        String fake = "fake";
        SymbolTable st = new SymbolTable();
        
        st.addVarName(fake);
        
        boolean expected = false;
        boolean actual = st.isVarName(test);
        
        assertEquals(expected, actual);
    }
    
    /**
     * Happy Test 3 of isVarName method. 
     */
    @Test
    public void isVarNameHappy3() {
        String test = "myVar";
        SymbolTable st = new SymbolTable();
        
        st.addFunName(test);
        
        boolean expected = false;
        boolean actual = st.isVarName(test);
        
        assertEquals(expected, actual);
    }
    
    
    
    
}
