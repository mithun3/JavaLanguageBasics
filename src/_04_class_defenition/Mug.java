package _04_class_defenition;

class Mugs {
  Mugs(int marker) {
    System.out.println("Mug(" + marker + ")");
  }

  void f(int marker) {
    System.out.println("f(" + marker + ")");
  }
}

public class Mug {
  Mugs c1;

  Mugs c2;
  {
    c1 = new Mugs(1);
    c2 = new Mugs(2);
    System.out.println("c1 & c2 initialized");
  }

  Mug() {
    System.out.println("Mugs()");
  }

  public static void main(String[] args) {
    System.out.println("Inside main()");
    Mug x = new Mug();
  }
} ///:~