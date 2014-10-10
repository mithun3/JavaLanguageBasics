package _23_overload;

public class Point {
  int x, y;

  Point(int x, int y) // Overloaded constructor
  {
    this.x = x;
    this.y = y;
  }

  Point(Point p) // Overloaded constructor
  {
    this(p.x, p.y);
  } // Calls the first constructor

  void move(int dx, int dy) {
    x += dx;
    y += dy;
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}