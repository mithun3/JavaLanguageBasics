import java.awt.*;
import java.awt.event.*;

public class GetNumber {
  private static Number NAN = new Double(Double.NaN);

  /* Process one String, returning it as a Number subclass
   * Does not require the GUI.
   */
  public static Number process(String s) {
    if (s.matches(".*[.dDeEfF]")) {
      try {
        double dValue = Double.parseDouble(s);
        System.out.println("It's a double: " + dValue);
        return new Double(dValue);
      } catch (NumberFormatException e) {
        System.out.println("Invalid a double: " + s);
        return NAN;
      }
    } else // did not contain . d e or f, so try as int.
      try {
        int iValue = Integer.parseInt(s);
        System.out.println("It's an int: " + iValue);
        return new Integer(iValue);
      } catch (NumberFormatException e2) {
        System.out.println("Not a number:" + s);
        return NAN;
      }
  }

  public static void main(String[] ap) {
    process("0");
    process("1111111111");
  }
}