package _23_overload;

public class Overloading {
  double method(int i) {
    return i;
  }

  boolean method(boolean b) {
    return !b;
  }

  static double method(int x, double y) {
    return x + y + 1;
  }

  static double method(double x, double y) {
    return x + y + 3;
  }

  public static void main(String[] args) {
    System.out.println(method(10, 20)); 
    System.out.println(method(10, 20.0)); 
    System.out.println(method(10.0, 20)); 
    System.out.println(method(10.0, 20.0)); 
  }
}