/* The following code was generated by JFlex 1.7.0 */

// Scanner.jflex

/**
 * Scanner with Tokens
 * Finds the lexemes for numbers, symbols, identifiers, 
 * CSC 450
 * @author Chase Webber
 */

class Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\16\1\1\1\17\1\17\1\17\22\0\1\16\1\14\4\0"+
    "\1\15\1\0\1\7\1\7\1\12\1\11\1\0\1\11\1\4\1\13"+
    "\1\0\11\3\1\0\1\7\1\14\1\10\1\14\2\0\4\2\1\5"+
    "\25\2\1\7\1\0\1\7\3\0\4\2\1\5\25\2\1\7\1\6"+
    "\1\7\7\0\1\17\u1fa2\0\1\17\1\17\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\2\1\3\1\4\1\5\1\4\1\2\3\6"+
    "\1\2\1\7\5\0\1\5\1\0\1\1\7\0\1\10"+
    "\6\0\1\5\2\0\1\11\1\0\1\11";

  private static int [] zzUnpackAction() {
    int [] result = new int[40];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\20\0\40\0\60\0\100\0\120\0\140\0\20"+
    "\0\160\0\200\0\220\0\240\0\260\0\300\0\320\0\340"+
    "\0\360\0\u0100\0\u0110\0\320\0\u0120\0\u0130\0\u0140\0\u0150"+
    "\0\u0160\0\u0170\0\u0180\0\20\0\u0190\0\u01a0\0\u01b0\0\u01c0"+
    "\0\u01d0\0\u01e0\0\u0110\0\u01f0\0\u0200\0\u0130\0\u0210\0\20";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[40];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\2\1\6\1\7\4\10"+
    "\1\11\1\12\1\13\1\3\22\0\1\3\14\0\1\3"+
    "\3\0\1\4\1\14\1\0\1\4\15\0\1\5\1\15"+
    "\1\16\14\0\1\4\1\14\1\0\1\4\1\17\2\0"+
    "\1\17\14\0\1\10\23\0\1\20\1\21\14\0\1\10"+
    "\24\0\1\10\4\0\2\14\1\0\1\14\15\0\1\22"+
    "\22\0\1\23\2\0\1\23\11\0\1\24\15\0\1\25"+
    "\2\26\1\27\1\30\1\31\3\26\1\32\2\26\1\33"+
    "\1\25\2\0\1\34\2\35\1\36\1\37\1\40\6\35"+
    "\1\41\1\42\4\0\1\22\1\0\1\16\15\0\1\43"+
    "\15\0\1\25\10\0\1\44\3\0\1\25\3\0\2\26"+
    "\1\27\1\30\1\31\3\26\1\32\2\26\1\33\5\0"+
    "\1\26\16\0\2\26\1\27\1\30\1\45\3\26\1\32"+
    "\2\26\1\33\10\0\1\26\13\0\2\26\1\27\1\30"+
    "\1\31\3\26\1\32\1\46\1\26\1\33\17\0\1\26"+
    "\3\0\1\34\2\35\1\36\1\37\1\40\6\35\1\41"+
    "\5\0\1\35\15\0\1\34\2\35\1\36\1\37\1\47"+
    "\6\35\1\41\10\0\1\35\26\0\1\35\3\0\1\34"+
    "\14\0\1\42\14\0\1\50\7\0\1\26\2\0\1\26"+
    "\14\0\1\35\2\0\1\35\11\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[544];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\1\11\5\1\1\11\4\1\5\0\1\1\1\0"+
    "\1\1\7\0\1\11\6\0\1\1\2\0\1\1\1\0"+
    "\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[40];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Scanner(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 126) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Token nextToken() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
          { 	return null;
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { System.out.println("Found an Optional Exponent!" + yytext());
            } 
            // fall through
          case 10: break;
          case 2: 
            { //System.out.println("Found an illegal character: " + yytext());
					throw new java.io.IOException("Illegal Character!");
            } 
            // fall through
          case 11: break;
          case 3: 
            { /* Ignore Whitespace */ 
					return null;
            } 
            // fall through
          case 12: break;
          case 4: 
            { /* NOTE: a word that is not a keyword is treated as an identifier. */
					//System.out.println("Found a word: " + yytext());
					Token t;
					switch (yytext()) {
						case "char": 
							// System.out.println("It's a CHAR token!"); 
							t = new Token(yytext(), TokenType.CHAR);
							break; 
						case "int":
							// System.out.println("It's an INT token!"); 
							t = new Token(yytext(), TokenType.INT);
							break; 
						case "float":
							// System.out.println("It's a FLOAT token!"); 
							t = new Token(yytext(), TokenType.FLOAT);
							break; 
						case "if":
							// System.out.println("It's an IF token!"); 
							t = new Token(yytext(), TokenType.IF);
							break; 
						case "else":
							// System.out.println("It's an ELSE token!"); 
							t = new Token(yytext(), TokenType.ELSE);
							break; 
						case "while":
							// System.out.println("It's a WHILE token!"); 
							t = new Token(yytext(), TokenType.WHILE);
							break; 
						case "print":
							// System.out.println("It's a PRINT token!"); 
							t = new Token(yytext(), TokenType.PRINT);
							break; 
						case "read":
							// System.out.println("It's a READ token!"); 
							t = new Token(yytext(), TokenType.READ);
							break; 
						case "return":
							// System.out.println("It's a RETURN token!"); 
							t = new Token(yytext(), TokenType.RETURN);
							break; 
						case "func":
							// System.out.println("It's a FUNC token!"); 
							t = new Token(yytext(), TokenType.FUNC);
							break; 
						case "program":
							// System.out.println("It's a PROGRAM token!"); 
							t = new Token(yytext(), TokenType.PROGRAM);
							break; 
						case "end":
							// System.out.println("It's an END token!"); 
							t = new Token(yytext(), TokenType.END);
							break; 
						default: 
							// System.out.println("It's an ID!"); 
							t = new Token(yytext(), TokenType.ID);
					}
					return( t);
            } 
            // fall through
          case 13: break;
          case 5: 
            { //System.out.println("Found a number: " + yytext());
					Token t = new Token(yytext(), TokenType.NUMBER);
					return( t);
            } 
            // fall through
          case 14: break;
          case 6: 
            { //System.out.println("Found a symbol: " + yytext());
					Token t;
					switch (yytext()) {
						case ";": 
							// System.out.println("It's a semicolon!"); 
							t = new Token(yytext(), TokenType.SEMICOLON);
							break; 
						case "(": 
							// System.out.println("It's a left parenthesis!"); 
							t = new Token(yytext(), TokenType.LPAREN);
							break; 
						case ")": 
							// System.out.println("It's a right parenthesis!"); 
							t = new Token(yytext(), TokenType.RPAREN);
							break; 	
						case "[": 
							// System.out.println("It's a left square!"); 
							t = new Token(yytext(), TokenType.LSQUARE);
							break; 	
						case "]": 
							// System.out.println("It's a right square!"); 
							t = new Token(yytext(), TokenType.RSQUARE);
							break; 	
						case "{": 
							// System.out.println("It's a left curly!"); 
							t = new Token(yytext(), TokenType.LCURLY);
							break; 	
						case "}": 
							// System.out.println("It's a right curly!"); 
							t = new Token(yytext(), TokenType.RCURLY);
							break; 	
						case "=": 
							// System.out.println("It's an equals!"); 
							t = new Token(yytext(), TokenType.EQUALS);
							break; 	
						case "+": 
							// System.out.println("It's a plus!"); 
							t = new Token(yytext(), TokenType.PLUS);
							break;	
						case "-": 
							// System.out.println("It's a minus!"); 
							t = new Token(yytext(), TokenType.MINUS);
							break; 	
						case "*": 
							// System.out.println("It's a times!"); 
							t = new Token(yytext(), TokenType.TIMES);
							break; 	
						case "/": 
							// System.out.println("It's a divide by!"); 
							t = new Token(yytext(), TokenType.DIVIDEBY);
							break; 	
						case "<": 
							// System.out.println("It's a less than!"); 
							t = new Token(yytext(), TokenType.LESSTHAN);
							break; 	
						case ">": 
							// System.out.println("It's a greater than!"); 
							t = new Token(yytext(), TokenType.GREATERTHAN);
							break; 
						case "<=": 
							// System.out.println("It's a less than or equal to!"); 
							t = new Token(yytext(), TokenType.LESSEQUAL);
							break; 	
						case ">=": 
							// System.out.println("It's a greater than or equal to!"); 
							t = new Token(yytext(), TokenType.GREATEQUAL);
							break; 	
						case "!=": 
							// System.out.println("It's a not equal to!"); 
							t = new Token(yytext(), TokenType.NOTEQUAL);
							break; 	
						case "&&": 
							// System.out.println("It's a logical and!"); 
							t = new Token(yytext(), TokenType.AND);
							break; 	
						case "||": 
							// System.out.println("It's a logical or!"); 
							t = new Token(yytext(), TokenType.OR);
							break; 
						case "!": 
							// System.out.println("It's a not!"); 
							t = new Token(yytext(), TokenType.LSQUARE);
							break; 	
						default:
							t = null;
					}
					return( t);
            } 
            // fall through
          case 15: break;
          case 7: 
            { //System.out.println("Found an identifier: " + yytext());
					Token t = new Token(yytext(), TokenType.ID);
					return( t);
            } 
            // fall through
          case 16: break;
          case 8: 
            { /* Ignore Oneline Comments */ 
					return null;
            } 
            // fall through
          case 17: break;
          case 9: 
            { /* Ignore Traditional Comments */ 
					return null;
            } 
            // fall through
          case 18: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
