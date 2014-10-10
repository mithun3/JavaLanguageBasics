package _24_override;

class Shapee {
  void draw() {
    System.out.println(this + ".draw()");
  }
}

class Circlee extends Shapee {
  public String toString() {
    return "Circlee";
  }
}

class Squaree extends Shapee {
  public String toString() {
    return "Squaree";
  }
}

class Trianglee extends Shapee {
  public String toString() {
    return "Trianglee";
  }
}

public class Shapes {

  public static void main(String[] args) {
    // Array of Object, not Shapee:
    Object[] shapeList = { new Circlee(), new Squaree(), new Trianglee() };
    for (int i = 0; i < shapeList.length; i++)
      ((Shapee) shapeList[i]).draw(); // Must cast

  }
} ///:~