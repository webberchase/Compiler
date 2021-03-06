###### Chase Webber

#### This is a Compiler for CSC 451 at Augsburg. 


## Compiler Directory: 

### Scanner/
- Contains all scanner files
- **Scanner.jflex:** jflex file which includes lexical rules to build a scanner class using jflex.jar 
- **Scanner.java:** class created by jflex
- **Token.java:** class to create token objects when scanning
- **TokenType:** enumerated list of possible Token Types

### Parser/
- Contains the Recognizer and Symbol Table 
- **Recognizer.java:** determines if a given string conforms to the specified grammar 
- **SymbolTable.java:** used to keep track of differentiate between variable names

### Test/
Junit tests for Scanner, Recognizer, and Symbol Table

##### Scanner/
- **ScannerTest.java** includes junit tests for testing the nextToken() function of the scanner

##### Parser/
- **RecognizerTest.java:** includes junit tests for testing the various functions of the Recognizer. 
_NOTE: these are mostly in reverse order compared to Recognizer.java, test functions are organized from least to most complex._
- **SymbolTableTest.java:** includes junit tests for testing the various public functions of the Symbol Table. 
_NOTE: these are currently organized by Var functions and Fun functions (IDs which are variable names and IDs which are function names).

##### CCode/
- Contains useful code for testing, primarily example "Almsost C" files.
- **ProgramHappy1.txt:** used for Happy test of program() in Recognizer class. 
- **ProgramSad1.txt:** used for Sad test of program() ini Recognizer class. 
- **TestStrings.txt:** helpful strings which can be copied and pasted into various Recognizer tests. 

#### SDD.txt
Explains the project design and functionality

#### Grammar.pdf
"Almost C Grammar" defining production rules and lexical conventions

## Tools:

#### JFlex: 
* Download JFlex from https://www.jflex.de/download.html
_Recommend getting the .zip file..._
* After extracting, go into the `jflex-1.7.0/lib/` directory and find the .jar file. 
* Include this .jar file in the project folder in order to compile. 
* On the command line, type 
```
java -jar jflex-full-1.7.0.jar Scanner.jflex
```
* This should create the appropriate Scanner.java class

#### Compiling Java: 
```
javac Example.java 
java Example 
java -cp Example file.txt  //passing in a file...
```

### Running JUnit tests: 
- Create a new NetBeans project
- Copy the most current version of Scanner.java, Token.java, and TokenType.java into src/scanner/
- Copy the most current version of Recognizer.java into src/parser/
- **MAKE SURE:** the package statements are in place and the import statements are correct or NetBeans will throw a fit
- Coppy ScannerTest.java and RecognizerTest.java into test/ 
- In the "Run" tab of the navigation bar, click "Test File."
_can also be found by right-clicking anywhere in the project, or hitting Ctrl+F6)_

#### Creating new JUnit tests:
* Click "New File" or Ctrl+N
* Under "Categories" on the left, select "Unit Tests" 
* Under "File Types" on the right, select "Test for Existing Class"
* Hit "Next"
* Browse src/ for "Class to Test"
* Un-select "Default Method Bodies" button at the bottom, it's easier to write these from scratch 
* Hit "Finish"