public class ThrowsUnchecked {

  public static void main(String[] argv) {
    new ThrowsUnchecked().doTheWork();
  }

  /** This method demonstrates calling a method that might throw
   * an exception, and catching the resulting exception.
   */
  public void doTheWork() {
    String s = " 42";
    int i = testit(s);  // Note: compiles with no try/catch.
    System.out.println("parseit(" + s + ") returned " + i);
  }

  /** Model of a method that might throw an unchecked exception.
   * @exception  NumberFormatException  if called with value 1.
   */
  public int testit(String input) throws NumberFormatException {
    return Integer.parseInt(input);
  }
}