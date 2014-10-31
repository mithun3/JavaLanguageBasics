package _28_string;

public class StringRevChar {
  public static void main(String[] argv) {
    //+
    String sh = "FCGDAEB";
    System.out.println(sh + " -> " + new StringBuffer(sh).reverse());
    //-
  }
}