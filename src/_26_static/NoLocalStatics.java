package _26_static;

public class NoLocalStatics {
  public static void main(String[] argv) {
    NoLocalStatics t = new NoLocalStatics();
    t.process();
  }
  void process() {
    int a = 42;      // EXPECT COMPILE ERROR > static int a = 42; 
    System.out.println("Process: " + a);
  }
}