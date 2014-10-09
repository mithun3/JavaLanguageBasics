package _11_data_type_number;

class FpComp {
  public static void main(String[] args) {
    double num1 = -0.0;
    double num2 = 0.0;
    double sqrPos = Math.sqrt(4.0);
    double sqrNeg1 = Math.sqrt(-4.0);
    double sqrNeg2 = Math.sqrt(-9.0);

    // Comparing signed zeros using the == operator
    System.out.println("Using == to compare 0.0 and -0.0 ");
    if (num1 == num2)
      System.out.println("numbers are equal");
    else
      System.out.println("numbers are not equal");

    // Comparing using the equals() method
    // First convert primtive doubles to Double objects
    Double n1 = new Double(num1);
    Double n2 = new Double(num2);
    System.out.println("Using equals() method to compare 0.0 and -0.0 ");
    if (n1.equals(n2))
      System.out.println("numbers are equal");
    else
      System.out.println("numbers are not equal");

    // Comparing NanS
    Double sp1 = new Double(sqrPos);
    Double sn1 = new Double(sqrNeg1);
    Double sn2 = new Double(sqrNeg2);
    System.out.println("Using equals() method to compare two NaNs ");
    if (sn1.equals(sn2))
      System.out.println("NaNs are equal");
    else
      System.out.println("NaNs are not equal");
  }
}