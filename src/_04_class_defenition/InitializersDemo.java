package _04_class_defenition;

public class InitializersDemo {
  public Object o;
  public int i;

  public static void main(String[] av) {
    Object mo = null;
    int mi = 0;
    InitializersDemo t = new InitializersDemo();
    if (t.o == null)
      System.out.println("o is null");
    if (t.i == 0)
      System.out.println("i is zero");
    if (mo == null)    // EXPECT COMPILE ERROR
      System.out.println("mo is null");
    if (mi == 0)    // EXPECT COMPILE ERROR
      System.out.println("mi is zero");
  }
}