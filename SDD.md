###### Compiler Project
###### CSC 451
###### author Chase Webber

# FIXME
- Add comments to ProgramHappy1.txt and ProgramSad1.txt
- The grammar itself may have some flaws, make sure we're using the most recently updated PDF. 

## SCANNER 

#### Definitions

- **ID** must start with a letter, then it can contain either letters or words. 
- **Keyword** must only be a collection of chars, numbers and symbols are not included. 
- **Numbers** can be one of three categories: 
	- **integers** contain only digits 
	- **floating point numbers** contain digits and at most one '.' character 
	- **scientific notation numbers** begin with a floating point number, then an 'e' or 'E' symbol, an optional '-' or '+', and another integer
	- The scanner considers any of these a NUMBER token. 
- **Symbols** are defined from the list of symbols
- **Comments** can contain anything between "/*" and "*/" or anything between "//" and "\n"
	
#### Lexical Rules

- **word:** Uses a switch statement to see if this word is a keyword. If it is not, then this word is considered an identifier. 
- **id:** As described above, this is already considered to be an identifier. 
- **int, float, scinum:** Each of these is designated a NUMBER token. 	
- **whitespace:** Ignored. Return null. 
- **comments:** Ignored. Return null.
- **symbol:** The symbols are the same as the list of symbol tokens. These are matched up using a switch statement. 	
- **.**	If anything else is found, throw a RuntimeException with message "Illegal Character!"
- _See Grammar.pdf_

#### User Defined Scanner Functions
- **getLine()** returns yyline. Used in Recognizer's error message. 
- **getColumn()** returns yycolumn. Used in Recognizer's error message.
- **getEND()** returns an ENDOFFILE token. Used in testing.  
	
#### Token Class
- Token objects with String lexeme and TokenType type
- **Constructor method** takes in String and TokenType.
- Setter methods for lexeme and TokenType. Not used. 
- **getType()** returns the Token's TokenType. Used in Recognizer's switch statements. 
- **equals()** method to determine of two tokens are the same
- **toString()** prints the lexeme and TokenType. 

#### TokenType Enum
- An enum list of possible Token Types 
- **ID, NUMBER, list of Symbols, list of keywords,** 
- _See keywords.txt in Scanner/_

## Recognizer

#### Instance Variables
- **lookahead** marks the next token to be considered in the grammar
- **scanner** scanner used to read the file and create Token objects which will be processed by the recognizer
- **END** the end of file token

#### Constructor 
- **Recognizer(String text, boolean isFilename)** If isFilename is true, text is the name of a file. Otherwise, text is the string itself to be processed by the recognizer. 

#### Methods
- ***See Grammar.pdf for production rules.***
- The switch cases call error() as default case. 
- Some functions call other functions which have these switch cases. 
- However, some methods have a Lambda option. If the if statement is not entered, it is possible to get to the end of the file without matching all of the tokens...
- When any method is called, it is important to call isEnd() to check for un-matched tokens. isEnd() would call error in this case. 

#### Helper Functions
- **getLookahead()** returns the lookahead Token. Used in testing. 
- **getEND()** returns the END Token. Used in testing. 
- **match(expected)**
	- Checks if expected token type is the same as the lookahead's type. If not, throw Match Error.
	- Gets the next token using scanner.nextToken() and updates this.lookahead variable. 
	- _Uses a while loop to calls nextToken() as long as lookahead is null to ignore whitespace and comments, which the scanner returns as null._
- **isEnd()** intended to be called after every method call to check for un-matched Tokens. If any tokens are unmatched, call End of File Error.  
- **nextIs(type)** used to saves space; checks the type of lookahead. Used in if statements for methods with lambda options. 
- **isType(token)** checks if lookahead is a type token. Used in if statements for methods with lambda options. 
	- _VOID, INT, FLOAT_
- **isRelop(token)** checks if lookahead is a relop token. Used in if statements for methods with lambda options. 
	- _LESSTHAN, GREATERTHAN, LESSEQUAL, GREATEQUAL, NOTEQUAL, EQUAL_ 
- **isAddop(token)** checks if lookahead is an addop token. Used in if statements for methods with lambda options. This method is also used as synonymous for isSign() because + and - are the same symbols for addition and positive, subtraction and negative... 
	- _PLUS, MINUS_
- **isMulop(token)** checks if lookahead is a mulop token. Used in if statements for methods with lambda options. 
	- _TIMES, DIVIDEDBY_
- **isStatement(token)** checks if lookahead is a token which indicates that statement() will be called. Used only in optionalStatements().
	- _ID, LCURLY, IF, WHILE, READ, WRITE, RETURN_
- **error(message)** prints the error message using System.out.println, including the message given by the function which called error(). Also throws a RuntimeException with the provided error message. 
 
## Symbol Table

#### Instance Variables
- **st** HashMap object used as our Symbol Table. 
- *Key* is the ID, the name of the variable or function name
- *Value* is our internal structure called SymTabRow which contains all the information of this ID including the kind, data type, etc. 

#### Constructor 
- Creates an instance of st HashMap. 

#### Methods 
- Divided by FunName methods and VarName methods: FunName means our ID is the name of a function, VarName means our ID is the name of a variable. 
- **Add Methods** check to make sure we are not adding a duplicate ID. If so, throw an error. Otherwise, construct a new row in the symbol table specifying the type depending on whether addVarName() or addFunName() was called. 
- **Is Methods** verifies that the specified ID is in the table and that it is actually the name of a function or variable as the case may be. If neither of these apply, return false, otherwise return true. 

#### SymTabRow
- Private Class representing each row of the symbol table
- **Fields:** _ID, kind, type_
- Not fully utilizing data type field currently... 

#### ENUMS 
- **Kind** Private Enum for the kind of ID tracked by the symbol table
	- _FUN_NAME, VAR_NAME_
- **Type** Private Enum, refers to the type of the ID. If it is a variable that means it is the data type, if it is a function that means it is the return type. 
	- _VOID, INT, FLOAT_

#### Helper Functions
- **toString()** Prints out each row of the table including ID, kind, and type. 
- **error(message)** Calls System.out.println() to display the error message. Also throws a RunTimeException for a Symbol Table error displaying the specified message. 


## JUnit Tests
- Happy tests are expected to succeed... pass in a valid string. 
- Sad tests are expected to fail... pass in an invalid string. 

#### ScannerTest
- Test nextToken() methods: 
- **Test Number Functions**
	- Test each of the 3 types of number to make sure that they're each returning a NUMBER token type. 
- **Happy Test 1**
	- Tests a simple math expression... should return NUMBER, PLUS, NUMBER
- **Sad Test 1**
	- Tests an invalid symbol... should fail and throw the desired exception
- **Test comments and whitespace**
	- Tests whitespace and both comment types... should ignore comments. 

#### RecognizerTest
- Tests each of the Production Methods defined by Recognizer at least once each. 
- Some methods are tested more than once to check various cases. 
- These are generally in the opposite order from how they are organized in Recognizer.java : the methods at the beginning of the Class are found at the end of the Test. 
- Tests were created from most basic to most complicated : those methods which called few if any other functions to methods which call or can call many other functions.
- All Happy and Sad tests are grouped by the function they are testing.  

#### SymbolTableTest
- Tests each of the methods defined by Symbol Table at least once each.
- Some methods are tested more than once to check various cases. 
- No sad tests for "Is" methods because it is not necessary to throw an error. We only want to return true or false. Various cases were tested via Happy Tests. 
- Test functions are grouped in the same order as they are displayed in the SymbolTable class. 