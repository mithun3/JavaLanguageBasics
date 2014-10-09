package _04_class_defenition;

public class MemberClass {
  int counter = 0;

  public class Counter {
    int counter = 10;

    public void increaseCount() {
      counter++;
      MemberClass.this.counter++;
    }

    public void displayCounts() {
      System.out.println("Inner: " + counter);
      System.out.println("Outer: " + MemberClass.this.counter);
    }
  }

  public void go() {
    Counter ct = new Counter();
    ct.increaseCount();
    ct.increaseCount();
    ct.increaseCount();
    ct.displayCounts();
  }

  public static void main(String args[]) {
    MemberClass mc = new MemberClass();
    mc.go();
  }
}