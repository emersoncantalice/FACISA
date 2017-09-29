/* Generated By:JavaCC: Do not edit this line. comp.java */
class comp implements compConstants {
        public static void main( String[] args )throws ParseException
        {
                try
                {
                        comp analizador = new comp( System.in ) ;
                        analizador.Programa() ;
                }
                catch(ParseException e)
                {
                        System.out.println(e.getMessage());
                        System.out.println("Analizador: erro durante o processo de an\u00c3\u00a1lise.");
                }
        }

  static final public void Programa() throws ParseException {
    jj_consume_token(PROGRAMA);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(LBRACE);
    Bloque();
    jj_consume_token(RBRACE);
    jj_consume_token(0);
  }

  static final public void Bloque() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TYPES:
      DeclaracionGlobal();
      break;
    case MAIN:
      Principal();
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void DeclaracionGlobal() throws ParseException {
    jj_consume_token(TYPES);
    VariablesGlobales();
  }

  static final public void VariablesGlobales() throws ParseException {
    jj_consume_token(IDENTIFIER);
    jj_consume_token(SEMICOLON);
    W();
  }

  static final public void W() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TYPES:
      DeclaracionGlobal();
      break;
    case MAIN:
      Principal();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Principal() throws ParseException {
    jj_consume_token(MAIN);
    jj_consume_token(LBRACE);
    Sentencias();
    jj_consume_token(RBRACE);
  }

  static final public void DeclaracionLocal() throws ParseException {
    jj_consume_token(TYPES);
    VariablesLocales();
  }

  static final public void VariablesLocales() throws ParseException {
    jj_consume_token(IDENTIFIER);
    jj_consume_token(SEMICOLON);
    VS();
  }

  static final public void VS() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TYPES:
      DeclaracionLocal();
      break;
    default:
      jj_la1[2] = jj_gen;
      Sentencias();
    }
  }

  static final public void Sentencias() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 0:
      case TYPES:
      case IDENTIFIER:
      case IF:
      case FOR:
      case DO:
      case WRITE:
      case READ:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TYPES:
        DeclaracionLocal();
        break;
      case IF:
        SentenciaIf();
        break;
      case FOR:
        SentenciaFor();
        break;
      case DO:
        SentenciaDo();
        break;
      case IDENTIFIER:
        SentenciaAsignacion();
        break;
      case WRITE:
        SentenciaWrite();
        break;
      case READ:
        SentenciaRead();
        break;
      case 0:
        jj_consume_token(0);
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

//Sentencia IF
  static final public void SentenciaIf() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(LPAREN);
    A();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    Sentencias();
    jj_consume_token(RBRACE);
  }

/*void Sino():
{}
{
	"iotro " "{ "Sentencias()"} "
}*/
  static final public void A() throws ParseException {
    Comparaciones();
  }

//Fin sentencia if
  static final public void Comparaciones() throws ParseException {
    Valor();
    Operadores();
    Valor();
  }

  static final public void Valor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      break;
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Expresion() throws ParseException {
    jj_consume_token(IDENTIFIER);
    jj_consume_token(PLUS);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(SEMICOLON);
  }

  static final public void Operadores() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQ:
      jj_consume_token(EQ);
      break;
    case LE:
      jj_consume_token(LE);
      break;
    case GE:
      jj_consume_token(GE);
      break;
    case NE:
      jj_consume_token(NE);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void OpAritmetico() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
      break;
    case MINUS:
      jj_consume_token(MINUS);
      break;
    case MULTIPLY:
      jj_consume_token(MULTIPLY);
      break;
    case DIVIDE:
      jj_consume_token(DIVIDE);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//Sentencia FOR
  static final public void SentenciaFor() throws ParseException {
    jj_consume_token(FOR);
    jj_consume_token(LPAREN);
    SentenciaAsignacion();
    jj_consume_token(SEMICOLON);
    Comparaciones();
    SentenciaAsignacion();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    Sentencias();
    jj_consume_token(RBRACE);
  }

//Sentencia DO
  static final public void SentenciaDo() throws ParseException {
    jj_consume_token(DO);
    jj_consume_token(LBRACE);
    Sentencias();
    jj_consume_token(RBRACE);
    jj_consume_token(WHILE);
    jj_consume_token(LPAREN);
    Comparaciones();
    jj_consume_token(RPAREN);
  }

//Sentencia ASIGNACION
  static final public void SentenciaAsignacion() throws ParseException {
    jj_consume_token(IDENTIFIER);
    jj_consume_token(ASIGNACION);
    Expresion();
  }

//Sentencia WRITE
  static final public void SentenciaWrite() throws ParseException {
    jj_consume_token(WRITE);
    jj_consume_token(LPAREN);
    Expresion();
    jj_consume_token(RPAREN);
    jj_consume_token(SEMICOLON);
  }

//Sentencia READ
  static final public void SentenciaRead() throws ParseException {
    jj_consume_token(READ);
    jj_consume_token(LPAREN);
    jj_consume_token(RPAREN);
    jj_consume_token(SEMICOLON);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public compTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[8];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x10020,0x10020,0x20,0x342400a1,0x342400a1,0xc0,0x0,0x3c00,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x780,0x0,};
   }

  /** Constructor with InputStream. */
  public comp(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public comp(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new compTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public comp(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new compTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public comp(compTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(compTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[45];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 8; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 45; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
