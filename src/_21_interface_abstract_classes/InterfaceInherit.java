package _21_interface_abstract_classes;

public class InterfaceInherit extends Thread {
  public static void main(String[] a) {
    new InterfaceInherit().start();
  }
  public void run() {
    if (this instanceof InterfaceInherit)
    System.out.println("This is InterfaceInherit");
    if (this instanceof Thread)
    System.out.println("This is Thread");
    if (this instanceof Runnable)
    System.out.println("This is Thread -- Interfaces ARE inherited!");
  }
}