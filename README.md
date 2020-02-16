COMPILER
CSC 451
Chase Webber


This is a Compiler for CSC 451 at Augsburg. 

Compiler Directory: 

* Scanner/ 	- Contains all scanner files
* Parser/ 	- Contains the Recognizer
* Test/ 	- Only thing currently being tested is the Scanner. 
* SDD 		- explains the Scanner design and functionality
* README
* .gitignore

Scanner Directory: 

* Scanner.jflex 	- jflex file which includes lexical rules to build a scanner class using jflex.jar 
* Scanner.java 		- class created by jflex
* Token.java 		- class to create token objects when scanning
* TokenType 		- enum list of possible Token Types

Parser Directory: 
* Recognizer.java

Test Directory: 

* TestScanner 		- includes junit tests for testing the nextToken() function of the scanner. 



JFLEX SCANNER


JFlex: 

* Download JFlex from https://www.jflex.de/download.html
* Recommend getting the .zip file... 
* After extracting, go into the jflex-1.7.0/lib/ directory and find the .jar file. 
* Include this .jar file in the project folder in order to compile. 
* On the command line, type "java -jar jflex-full-1.7.0.jar Scanner.jflex" 
* This should create the appropriate Scanner.java class


Compiling Java: 

* javac Main.java 
* java Main 
* or, with a file: java -cp Main file.txt


Running JUnit tests: 

* Create a new Netbeans project
* Copy the most current version of Scanner.java, Token.java, and TokenType.java into the src/scanner/ folder
* MAKE SURE: the package statements are in place and the import statements are correct in ScannerTest.java
* MAKE SURE: scanner class should be public, the constructor (line 262) should also be public.
* Coppy ScannerTest.java into the test/ folder
* In the "Run" tab of the navigation bar, click "Test File"
* ("Test File" can also be found by right-clicking anywhere in the project, or hitting Ctrl+F6)