package _02_binary_bit;

public class BinaryDigits {
  public static void main(String[] argv) {
    //+
    String bin = "101010";
    System.out.println(bin + " as an integer is " + Integer.valueOf(bin, 2));
    int i = 42;
    System.out.println(i + " as binary digits (bits) is " + 
      Integer.toBinaryString(i));
    //-
  }
}