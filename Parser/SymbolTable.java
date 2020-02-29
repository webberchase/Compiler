package parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Creates a Symbol Table for keeping track of IDs.
 * Used by the Recognizer
 * CSC 451 Compilers
 * @author Chase Webber
 */
public class SymbolTable {
    
    private HashMap<String, STRow> st = null;
	
    /**
     * Basic Constructor
     */
    public SymbolTable() {
        st = new HashMap<String, STRow>();
    }
    
    /***** FunName Methods *****/
    
    /**
     * Adds a new function name to the table.
     * @param ID name of the function
     */
    public void addFunName(String ID) {
        // Check for duplicate FunName
        if (st.containsKey(ID)) {
            if (st.get(ID).kind == Kind.FUN_NAME) {
                error("Duplicate FunName");
                return;
            }
        }
        STRow newRow = new STRow(ID, Kind.FUN_NAME);
        st.put(ID, newRow);

    }
    
    /**
     * Checks if given ID is the name of a function.
     * @param ID The name we are testing
     * @return True if this is a function name, otherwise false
     */
    public boolean isFunName(String ID) {
        // Case: This ID is not in the table!
        if (!st.containsKey(ID)) {
            return false;
        }
        else if (st.get(ID).kind == Kind.FUN_NAME) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /***** VarName Methods *****/
    
    /**
     * Adds a new variable name to the table.
     * @param ID name of the variable
     */
    public void addVarName(String ID) {
        // Check for duplicate VarName
        if (st.containsKey(ID)) {
            if (st.get(ID).kind == Kind.VAR_NAME) {
                error("Duplicate VarName");
                return;
            }
        }
        STRow newRow = new STRow(ID, Kind.VAR_NAME);
        st.put(ID, newRow);
    }
    
    /**
     * Checks if given ID is the name of a variable.
     * @param ID The name we are testing
     * @return True if this is a variable name, otherwise false
     */
    public boolean isVarName(String ID) {
        // Case: This ID is not in the table!
        if (!st.containsKey(ID)) {
            return false;
        }
        else if (st.get(ID).kind == Kind.VAR_NAME) {
            return true;
        }
        else {
            return false;
        }
    }

    
    
    /**
     * Internal Structure: 
     * This is one row of the table!
     * Variables are equivalent to fields
     */
    private class STRow {
        String ID;
        Kind kind;  
        Type type;
        
        /** Constructor with unspecified Type */
        private STRow(String newID, Kind newKind) {
            this.ID = newID;
            this.kind = newKind;
            this.type = null;
        }            

        /* Constructor with specified Type */
        private STRow(String newID, Kind newKind, Type newType) {
            this.ID = newID;
            this.kind = newKind;
            this.type = newType;
        }

        
        
    }
    
    /**
     * What kind of IDs are possible?
     */
    private enum Kind {
        FUN_NAME,
        VAR_NAME,
    }
 
    /**
     * What is the type associated with this ID?
     * If it is a variable, this is the data type
     * If it is a function, this is the return type
     */
    private enum Type {
        VOID,
        INT,
        FLOAT,
    }
    
    
    public String toString() {
        String result = "";
        int rowCount = 0;
        
        Set set = st.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
           Map.Entry entry = (Map.Entry)iterator.next();
           String key = entry.getKey().toString();
           STRow row = (STRow)entry.getValue();
           
           if (!key.equals(row.ID)) {
               error("IDs don't match (in toString)");
           }
           
           result += " - ROW " + rowCount + " -\n";
           result += "ID: " + row.ID + ", ";
           result += "kind: " + row.kind + ", ";
           result += "type: " + row.type + ".\n";
           
           rowCount++;
        }
        
        return result;
    }

    
    /**
	 * Errors out of the symbol Table.Prints an error message 
         * @param message The error message to print. 
	 */
	public void error(String message) {
		System.out.println("Symbol Table Error " + message); 
                throw new RuntimeException(message + " Error in Symbol Table!");
	}
    
}
