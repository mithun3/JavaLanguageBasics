package _11_data_type_number;

public class HexNeg {
  public static void main(String[] argv) {
    //+
    long data[] = { 0, 0x01, 0xff, 0x100, 0xffff, 0xffffff, 
      0x7fffffff, 0xffffffff };
    for (int i=0; i<data.length; i++)
      System.out.println("data["+i+"] = " + data[i]);
    //-
  }
}