/* Generated By:JavaCC: Do not edit this line. JsonParser.java */
package com.google.gson;

@SuppressWarnings("all")
final class JsonParser implements JsonParserConstants {

  final public JsonElement parse() throws ParseException {
  JsonElement json = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 20:
      json = JsonObject();
      break;
    case 25:
      json = JsonArray();
      break;
    case DIGITS:
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
    case 27:
    case 28:
    case 29:
      json = JsonPrimitive();
      break;
    case 22:
      json = JsonNull();
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return json;}
    throw new Error("Missing return statement in function");
  }

  final private JsonObject JsonObject() throws ParseException {
  JsonObject o = new JsonObject();
    jj_consume_token(20);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
      Members(o);
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    jj_consume_token(21);
    {if (true) return o;}
    throw new Error("Missing return statement in function");
  }

  final private JsonNull JsonNull() throws ParseException {
  JsonNull json = JsonNull.INSTANCE;
    jj_consume_token(22);
    {if (true) return json;}
    throw new Error("Missing return statement in function");
  }

  final private void Members(JsonObject o) throws ParseException {
    Pair(o);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 23:
      jj_consume_token(23);
      Members(o);
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
  }

  final private void Pair(JsonObject o) throws ParseException {
  JsonPrimitive property;
  JsonElement value;
    property = JsonString();
    jj_consume_token(24);
    value = JsonValue();
    o.add(property.getAsString(), value);
  }

  final private JsonArray JsonArray() throws ParseException {
  JsonArray array = new JsonArray();
    jj_consume_token(25);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DIGITS:
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
    case 20:
    case 22:
    case 25:
    case 27:
    case 28:
    case 29:
      Elements(array);
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(26);
    array.reverse();
    {if (true) return array;}
    throw new Error("Missing return statement in function");
  }

  final private void Elements(JsonArray array) throws ParseException {
  JsonElement element;
    element = JsonValue();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 23:
      jj_consume_token(23);
      Elements(array);
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    array.add(element);
  }

  final private JsonElement JsonValue() throws ParseException {
  JsonElement o = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
      o = JsonString();
      break;
    case DIGITS:
    case 29:
      o = JsonNumber();
      break;
    case 20:
      o = JsonObject();
      break;
    case 25:
      o = JsonArray();
      break;
    case 27:
      jj_consume_token(27);
             o = new JsonPrimitive(true);
      break;
    case 28:
      jj_consume_token(28);
              o = new JsonPrimitive(false);
      break;
    case 22:
      jj_consume_token(22);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return o;}
    throw new Error("Missing return statement in function");
  }

  final private JsonPrimitive JsonPrimitive() throws ParseException {
  JsonPrimitive value;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINGLE_QUOTE_LITERAL:
    case DOUBLE_QUOTE_LITERAL:
      value = JsonString();
                          {if (true) return value;}
      break;
    case DIGITS:
    case 29:
      value = JsonNumber();
                          {if (true) return value;}
      break;
    case 27:
      jj_consume_token(27);
             {if (true) return new JsonPrimitive(true);}
      break;
    case 28:
      jj_consume_token(28);
              {if (true) return new JsonPrimitive(false);}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final private JsonPrimitive JsonNumber() throws ParseException {
  String intpart = null,
         fracpart = null,
         exppart = null;
    intpart = JsonInt();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 30:
      fracpart = JsonFrac();
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case E:
      exppart = JsonExp();
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    Number n;
    if (exppart != null) {
      fracpart = (fracpart == null) ? "" : fracpart;
      n = new java.math.BigDecimal(intpart + fracpart + exppart);
    } else if (fracpart != null) {
      n = new Double(intpart + fracpart);
    } else {
      // See if the number fits in an integer, or long
      // Use BigInteger only if it is big enough.
      if (intpart.length() < 10) {
        n = new Integer(intpart);
      } else if (intpart.length() < 19) {
        n = new Long(intpart);
      } else {
        n = new java.math.BigInteger(intpart);
      }
    }
    {if (true) return new JsonPrimitive(n);}
    throw new Error("Missing return statement in function");
  }

  final private String JsonInt() throws ParseException {
  String digits;
  boolean negative = false;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 29:
      jj_consume_token(29);
         negative = true;
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    digits = Digits();
    if(negative)
      {if (true) return "-" + digits;}
    {if (true) return digits;}
    throw new Error("Missing return statement in function");
  }

  final private String JsonFrac() throws ParseException {
  String digits;
    jj_consume_token(30);
    digits = Digits();
    {if (true) return "." + digits;}
    throw new Error("Missing return statement in function");
  }

  final private String JsonExp() throws ParseException {
  Token t;
  String digits;
    t = jj_consume_token(E);
    digits = Digits();
    {if (true) return t.image + digits;}
    throw new Error("Missing return statement in function");
  }

  final private String Digits() throws ParseException {
  Token t;
    t = jj_consume_token(DIGITS);
    {if (true) return t.image;}
    throw new Error("Missing return statement in function");
  }

  final private JsonPrimitive JsonString() throws ParseException {
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SINGLE_QUOTE_LITERAL:
      t = jj_consume_token(SINGLE_QUOTE_LITERAL);
      break;
    case DOUBLE_QUOTE_LITERAL:
      t = jj_consume_token(DOUBLE_QUOTE_LITERAL);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    String value = StringUnmarshaller.unmarshall(t.image);
    {if (true) return new JsonPrimitive(value);}
    throw new Error("Missing return statement in function");
  }

  public JsonParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[11];
  static private int[] jj_la1_0;
  static {
      jj_la1_0();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x3a500c40,0xc00,0x800000,0x3a500c40,0x800000,0x3a500c40,0x38000c40,0x40000000,0x20,0x20000000,0xc00,};
   }

  public JsonParser(java.io.InputStream stream) {
     this(stream, null);
  }
  public JsonParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JsonParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  public JsonParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new JsonParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  public JsonParser(JsonParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  public void ReInit(JsonParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  final private Token jj_consume_token(int kind) throws ParseException {
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

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[31];
    for (int i = 0; i < 31; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 11; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 31; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

}
