package _04_class_defenition;

public class MainNotSpecial {
  public static void main() {
    System.out.println("In no-argument main");
  }
  public static void main(String[] argv) {
    System.out.println("In String[] main");
  }
  public static void main(int argc, String argv[]) {
    System.out.println("In int,String[] main");
  }
  public static void main(String argv) {
    System.out.println("In String main");
  }
}