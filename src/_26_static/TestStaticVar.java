package _26_static;

class Box {
  double width;
  public static int numBoxes = 0; // static variable is declared and initialized
  public Box() {			
    width = 5.0;
    numBoxes++; // numBoxes is incremented to count number of objects.
  }
}
public class TestStaticVar {
  public static void main (String args[]) {
    Box box1 = new Box();
    Box box2 = new Box();
    System.out.println("Number of objects = " + Box.numBoxes);
  } 
}