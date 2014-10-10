package _21_interface_abstract_classes;
public class MultiSuperInterfaces {
  public interface Marker extends java.io.Serializable, java.rmi.Remote,
      java.lang.Runnable {
  }

  public class Marked implements Marker {
    public void run() {
      // needed for Runnable
    }
  }

  public static void main(String[] args) {
    new MultiSuperInterfaces().print();
  }

  void print() {
    Object o = new Marked();
    if (o instanceof java.io.Serializable) {
      System.out.println("Is Serializable");
    }
    if (o instanceof java.rmi.Remote) {
      System.out.println("Is Remote");
    }
    if (o instanceof java.lang.Runnable) {
      System.out.println("Is Runnable");
    }
  }
}