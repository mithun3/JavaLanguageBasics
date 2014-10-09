package _04_class_defenition;

public class MethodAndField {
  /** A method named "a" */
  int a() {
    return 42;
  }

  /** A field named a (whose value is computed by method a for good measure)
   */
  int a = a();

  /** A main method to show that it all works. */
  public static void main(String[] args) {
    System.out.println(new MethodAndField().a);
  }
}