package _28_string;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.StringWriter;

import junit.framework.TestCase;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Stack;

/**
 * SimpleCalc -- simple calculator to show StringTokenizer
 * 
 * @author Ian Darwin, http://www.darwinsys.com/
 * @version $Id: SimpleCalcStreamTok.java,v 1.10 2004/03/10 18:22:26 ian Exp $
 */
class SimpleCalcTest {
  /** The StreamTokenizer Input */
  protected StreamTokenizer tf;

  /** The Output File */
  protected PrintWriter out = new PrintWriter(System.out, true);

  /** The variable name (not used in this version) */
  protected String variable;

  /** The operand stack */
  protected Stack s;

  /* Driver - main program */
  public static void main(String[] av) throws IOException {
    if (av.length == 0)
      new SimpleCalcTest(new InputStreamReader(System.in)).doCalc();
    else
      for (int i = 0; i < av.length; i++)
        new SimpleCalcTest(av[i]).doCalc();
  }

  /** Construct by filename */
  public SimpleCalcTest(String fileName) throws IOException {
    this(new FileReader(fileName));
  }

  /** Construct from an existing Reader */
  public SimpleCalcTest(Reader rdr) throws IOException {
    tf = new StreamTokenizer(rdr);
    // Control the input character set:
    tf.slashSlashComments(true); // treat "//" as comments
    tf.ordinaryChar('-'); // used for subtraction
    tf.ordinaryChar('/'); // used for division

    s = new Stack();
  }

  /**
   * Construct from a Reader and a PrintWriter
   */
  public SimpleCalcTest(Reader in, PrintWriter out) throws IOException {
    this(in);
    setOutput(out);
  }

  /**
   * Change the output destination.
   */
  public void setOutput(PrintWriter out) {
    this.out = out;
  }

  protected void doCalc() throws IOException {
    int iType;
    double tmp;

    while ((iType = tf.nextToken()) != StreamTokenizer.TT_EOF) {
      switch (iType) {
      case StreamTokenizer.TT_NUMBER: // Found a number, push value to
                      // stack
        push(tf.nval);
        break;
      case StreamTokenizer.TT_WORD:
        // Found a variable, save its name. Not used here.
        variable = tf.sval;
        break;
      case '+':
        // + operator is commutative.
        push(pop() + pop());
        break;
      case '-':
        // - operator: order matters.
        tmp = pop();
        push(pop() - tmp);
        break;
      case '*':
        // Multiply is commutative
        push(pop() * pop());
        break;
      case '/':
        // Handle division carefully: order matters!
        tmp = pop();
        push(pop() / tmp);
        break;
      case '=':
        out.println(peek());
        break;
      default:
        out.println("What's this? iType = " + iType);
      }
    }
  }

  void push(double val) {
    s.push(new Double(val));
  }

  double pop() {
    return ((Double) s.pop()).doubleValue();
  }

  double peek() {
    return ((Double) s.peek()).doubleValue();
  }

  void clearStack() {
    s.removeAllElements();
  }
}

public class SimpleCalcStreamTok extends TestCase {

  final String TEST = "// This file is a test of the SimpleCalc class\n"
      + "2 4 + = 3 / =  // should print 6, 2\n"
      + "22 7 / =    // should print 3.141592857...\n";

  final String EXPECT = "6.0\n" + "2.0\n" + "3.142857142857143\n";

  public void testIt() throws Exception {
    BufferedReader is = new BufferedReader(new StringReader(TEST));
    StringWriter fluffy = new StringWriter();
    PrintWriter ps = new PrintWriter(fluffy);

    SimpleCalcTest sc = new SimpleCalcTest(is, ps);
    assertEquals(EXPECT, fluffy.getBuffer().toString());
  }
}