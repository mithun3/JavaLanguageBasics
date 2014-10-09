package _11_data_type_number;

public class BooleanAndOr {
  public static void main(String[] a) {
    String s = null;

    // These use the conventional logical "and" (&&) and "or" (||).
    try {
      if ((s != null) && (s.length() > 0))
        System.out.println("At Point One");
      if ((s != null) || (s.length() > 0))
        System.out.println("At Point Two");
    } catch (Exception e) {
      System.out.print("Logical section threw ");
      e.printStackTrace();
    }

    // These use bitwise "and" (&) and "or" (|); is it valid? What results?
    try {
      if ((s == null) & (s.length() > 0))
        System.out.println("At Point Three");
      if ((s == null) | (s.length() > 0))
        System.out.println("At Point Four");
    } catch (Exception e) {
      System.out.print("Bitwise section threw ");
      e.printStackTrace();
    }
  }
}