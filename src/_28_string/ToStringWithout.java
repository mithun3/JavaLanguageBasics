package _28_string;

public class ToStringWithout {
  int x, y;

  /** Simple constructor */
  public ToStringWithout(int anX, int aY) {
    x = anX; y = aY;
  }

  /** Main just creates and prints an object */
  public static void main(String[] args) { 
    System.out.println(new ToStringWithout(42, 86));
  }
}