package _10_constructors;

class Rock {
  Rock() { // This is the constructor
    System.out.println("Creating Rock");
  }
}

public class SimpleConstructor {

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++)
      new Rock();
  }
} ///:~