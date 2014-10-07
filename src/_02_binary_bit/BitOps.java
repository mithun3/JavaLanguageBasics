package _02_binary_bit;


class BitOps {
  public static void main(String[] args) {
    // Definition of bit field masks for double
    final long SIGN = 0x8000000000000000L;
    final long EXPN = 0x7ff0000000000000L;
    final long SGNF = 0x000fffffffffffffL;
    final long BIT1 = 0x8000000000000000L;
    // Storage for bit fields
    long s; // Sign
    long e; // Exponent field
    long m; // Significand (mantissa) field
    String eS; // For conversions

    double num;
    long binVal;
    long t;

    // Get user input
    num = 3.4d;
    binVal = Double.doubleToRawLongBits(num);

    // Display hex bits
    System.out.println("As long = " + Long.toHexString(binVal));

    // Display bit fields of double format
    s = binVal & SIGN;
    if (s != 0)
      System.out.println("Sign = -");
    else
      System.out.println("Sign = +");

    // Mask out exponent field
    e = (binVal & EXPN);
    eS = Long.toHexString(e);
    System.out.println("Exponent = " + eS);

    // Mask out significand field
    m = (binVal & SGNF);
    eS = Long.toHexString(m);
    System.out.println("Significand = " + eS);

    System.out.println("\nFields in binary");
    if (s != 0)
      System.out.println("Sign bit = 1");
    else
      System.out.println("Sign bit = 0");

    // Display binary exponent
    // Eliminate sign bit
    e = e << 1;
    System.out.print("Exponent = ");
    for (int k = 0; k < 11; k++) {
      t = e & BIT1;
      // System.out.println(Long.toHexString(t));
      if (t != 0)
        System.out.print("1");
      else
        System.out.print("0");
      e = e << 1;
    }
    System.out.println("\n           |-11 bits-|");
    // Display binary significand
    // Eliminate exponent and sign bits
    m = m << 12;
    System.out.print("Significand = 1.");
    for (int j = 0; j < 51; j++) {
      t = m & BIT1;
      if (t != 0)
        System.out.print("1");
      else
        System.out.print("0");
      m = m << 1;
    }
    System.out.println("\n              ^ |");
    System.out.println("implicit bit -| | ----- 52 bits -->");
  }
}