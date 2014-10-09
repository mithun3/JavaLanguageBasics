package _11_data_type_number;

public class CastNeeded {
  //+
  public static void main(String[] argv) {
    int i;
    double j = 2.75;
    i = (int) j;      // EXPECT COMPILE ERROR if you dont cast
    i = (int)j;    // with cast; i gets 2
    System.out.println("i =" + i);
    byte b;
    b = (byte) i;      // EXPECT COMPILE ERROR if you dont cast
    b = (byte)i;  // with cast, i gets 2
    System.out.println("b =" + b);
  }
  //-
}