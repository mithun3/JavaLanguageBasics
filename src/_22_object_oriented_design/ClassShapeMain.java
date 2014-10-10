package _22_object_oriented_design;

import java.util.*;

/** Part of a main program using Shape objects */
public class ClassShapeMain {

  Collection allShapes;  // created in a Constructor, not shown

  /** Iterate over all the Shapes, getting their areas */
  public double totalAreas() {
    Iterator it = allShapes.iterator();
    double total = 0.0;
    while (it.hasNext()) {
      Shape s = (Shape)it.next();
      total += s.computeArea();
    }
    return total;
  }
}
class Circle extends Shape {
  double radius;
  public double computeArea() {
    return Math.PI * radius * radius;
  }
}
class Rectangle extends Shape {
  double width, height;
  public double computeArea() {
    return width * height;
  }
}
abstract class Shape {
  protected int x, y;
  public abstract double computeArea();
}