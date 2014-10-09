package _11_data_type_number;

class IntFrac {
  public static void main(String[] args) {

    double num;
    long iPart;
    double fPart;

    // Get user input
    num = 2.3d;
    iPart = (long) num;
    fPart = num - iPart;
    System.out.println("Integer part = " + iPart);
    System.out.println("Fractional part = " + fPart);
  }
}