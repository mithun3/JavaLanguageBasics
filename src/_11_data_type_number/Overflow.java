package _11_data_type_number;

public class Overflow {


  public static void main(String[] args) {

    int big = 0x7fffffff; // max int value

    System.out.println("big = " + big);

    int bigger = big * 4;

    System.out.println("bigger = " + bigger);


  }
} ///:~