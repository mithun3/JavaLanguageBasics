class FpError {
  public static void main(String[] args) {
    double res;
    double divisor = 0;
    double dividend, root;

    // Get user input for numerator
    System.out.println("Forcing division by zero error");
    dividend = 10d;
    res = dividend / divisor;
    // Test for negative invifinity
    if (res == Double.NEGATIVE_INFINITY)
      System.out.println("result is NEGATIVE_INFINITY");
    if (res == Double.POSITIVE_INFINITY)
      System.out.println("result is POSITIVE_INFINITY");    // Test for either infinity
    if (Double.isInfinite(res))
      System.out.println("result is infinite");

    // Get user input for square root
    System.out.println("\nCalculating square root (try negative)");
    root = 10d;
    res = Math.sqrt(root);
    if (Double.isNaN(res))
      System.out.println("result is Nan");
    else
      System.out.println("Square root = " + res);
  }
}