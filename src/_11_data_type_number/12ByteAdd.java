public class ByteAdd {
  public static void main(String[] argv) {
    System.out.println("ByteAdd Program");
    // bytes are signed integer, so can range from -127 to +127
    byte b1 = 10, b2 = 127;  
    System.out.println("b1 + b2 = " + (b1+b2));
    b1 = 127;
    System.out.println("b1 + b2 = " + (b1+b2));
  }
}