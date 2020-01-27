COMPILER
CSC 450
Chase Webber


This is a Compiler for CSC 451 at Augsburg. 

Compiler Directory: 

* Scanner/ - Contains all scanner files.
* Test/ - Only thing currently being tested is the Scanner. 
* SDD - explains the Scanner design and functionality
* README
* .gitignore

Scanner Directory: 

* Scanner.jflex - jflex file which includes lexical rules to build a scanner class using jflex.jar 
* Scanner.java - class created by jflex
* Token.java - class to create token objects when scanning
* TokenType - enum list of possible Token Types

Test Directory: 

* TestScanner - includes junit tests for testing the nextToken() function of the scanner. 
* SadTestException - not currently in use... 



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

* TestScanner includes instructions for running JUnit on the command line.
* Also possible to run JUnit from an IDE. 
* More detailed instructions coming soon... neither of these options are working for me! 



You must create a compiler project and put your existing and improved scanner class into a scanner package and test it. This project must be committed to a repository, and the repository must be shared with steinmee@augsburg.edu on bitbucket.

You must name your project on bitbucket as your last name followed by the word compiler. For example, if your last name is Augsburg, then your project should be named AugsburgCompiler.

You must use the JUnit library to create unit tests for some of the functions in your scanner class. You must test at least the nextToken() function.

Submit this assignment by entering the tag of the corresponding commit in your repository.

Here are the ten grading criteria, 10 points each:
* Organized repository shared on Bitbucket, tagged commit named on Moodle, working and master branch.
* README.md explains the purpose of the project, where the files are.
* SDD with overview and scanner chapter.
* Scanner in a scanner package.
* Scanner handles numbers including scientific notation.
* Scanner handles keywords separately from IDs.
* Scanner has comments from the jflex file.
* Comments in the Token, TokenType, JUnit classes.
* JUnit testing of the nextToken() function - happy paths.
* JUnit testing of the nextToken() function - sad paths.