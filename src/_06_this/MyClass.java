package _06_this;

public class MyClass {
  final static int MAXX=640, MAXY=480;  // low-res (VGA)
  int x, y;        // current location
  /** Construct a MyClass with x and y values */
  MyClass(int x, int y) {
    this.x = x;
    this.y = y;
        }
  /** Construct a MyClass with default values */
  MyClass() {
    this(MAXX/2, MAXY/2);   // Use the constructor above
        }

  public String toString() {
    return "[" + x + "," + y + "]";
  }

  /** Test main program */
  public static void main(String[] av) {
    System.out.println(new MyClass(300,100));
    System.out.println(new MyClass());
  }
}