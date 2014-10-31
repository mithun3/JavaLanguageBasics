package _26_static;

public class StaticIniDemo {

  /** A static initializer - called when class is loaded. */
  static {
    System.out.println("In static initializer");
  }

  /** A constructor -- called when object is instantiated. */
  public StaticIniDemo() {
    System.out.println("In Constructor");
  }

  public static void main(String[] a) {
    try {
      System.err.println("About to load class");
      Class c = Class.forName("StaticIniDemo");
      System.err.println("About to construct instance");
      Object sd = c.newInstance();
      System.err.println("Object is " + sd);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}