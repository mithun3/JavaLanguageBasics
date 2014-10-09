package _04_class_defenition;

class Mutable {
  private int data;

  public Mutable(int initVal) {
    data = initVal;
  }

  public Mutable add(int x) {
    data += x;
    return this;
  }

  public Mutable multiply(int x) {
    data *= x;
    return this;
  }

  public Imutable2 makeImutable2() {
    return new Imutable2(data);
  }
}

public class Imutable2 {

  private int data;

  public Imutable2(int initVal) {
    data = initVal;
  }

  public int read() {
    return data;
  }

  public boolean nonzero() {
    return data != 0;
  }

  public Imutable2 add(int x) {
    return new Imutable2(data + x);
  }

  public Imutable2 multiply(int x) {
    return new Imutable2(data * x);
  }

  public Imutable2 makeMutable() {
    return new Imutable2(data);
  }

  public static Imutable2 modify1(Imutable2 y) {
    Imutable2 val = y.add(12);
    val = val.multiply(3);
    val = val.add(11);
    val = val.multiply(2);
    return val;
  }

  // This produces the same result:
  public static Imutable2 modify2(Imutable2 y) {
    Imutable2 m = y.makeMutable();
    m.add(12).multiply(3).add(11).multiply(2);
    return m.makeMutable();
  }

  public static void main(String[] args) {
    Imutable2 i2 = new Imutable2(47);
    Imutable2 r1 = modify1(i2);
    Imutable2 r2 = modify2(i2);
    System.out.println("i2 = " + i2.read());
    System.out.println("r1 = " + r1.read());
    System.out.println("r2 = " + r2.read());

  }
} ///:~