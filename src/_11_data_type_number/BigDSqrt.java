package _11_data_type_number;

import java.math.BigDecimal;

public class BigDSqrt {
  public static void main(String[] args) {
    double value = 1.0;
    String numS;
    int scale = 30;
    BigDecimal v = null;

    System.out.println("Big decimal square root routine\n");
    numS = Keyinn.inString("Enter value: ");
    scale = Keyinn.inInt("Enter scale: ");

    // Convert value to big decimal formatv = new BigDecimal(numS);
    System.out.println(sqrt(v, scale));
  }

  public static BigDecimal sqrt(BigDecimal n, int s) {
    BigDecimal TWO = BigDecimal.valueOf(2);

    // Obtain the first approximation
    BigDecimal x = n
        .divide(BigDecimal.valueOf(3), s, BigDecimal.ROUND_DOWN);
    BigDecimal lastX = BigDecimal.valueOf(0);

    // Proceed through 50 iterations
    for (int i = 0; i < 50; i++) {
      x = n.add(x.multiply(x)).divide(x.multiply(TWO), s,
          BigDecimal.ROUND_DOWN);
      if (x.compareTo(lastX) == 0)
        break;
      lastX = x;
    }
    return x;
  }
}

//**********************************************************
//**********************************************************
//Program: Keyinnn
//Reference: Session 20
//Topics:
//1. Using the read() method of the ImputStream class
//in the java.io package
//2. Developing a class for performing basic console
//input of character and numeric types
//**********************************************************
//**********************************************************

class Keyinn {

  //*******************************
  //   support methods
  //*******************************
  //Method to display the user's prompt string
  public static void printPrompt(String prompt) {
    System.out.print(prompt + " ");
    System.out.flush();
  }

  //Method to make sure no data is available in the
  //input stream
  public static void inputFlush() {
    int dummy;
    int bAvail;

    try {
      while ((System.in.available()) != 0)
        dummy = System.in.read();
    } catch (java.io.IOException e) {
      System.out.println("Input error");
    }
  }

  //********************************
  //  data input methods for
  //string, int, char, and double
  //********************************
  public static String inString(String prompt) {
    inputFlush();
    printPrompt(prompt);
    return inString();
  }

  public static String inString() {
    int aChar;
    String s = "";
    boolean finished = false;

    while (!finished) {
      try {
        aChar = System.in.read();
        if (aChar < 0 || (char) aChar == '\n')
          finished = true;
        else if ((char) aChar != '\r')
          s = s + (char) aChar; // Enter into string
      }

      catch (java.io.IOException e) {
        System.out.println("Input error");
        finished = true;
      }
    }
    return s;
  }

  public static int inInt(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Integer.valueOf(inString().trim()).intValue();
      }

      catch (NumberFormatException e) {
        System.out.println("Invalid input. Not an integer");
      }
    }
  }

  public static char inChar(String prompt) {
    int aChar = 0;

    inputFlush();
    printPrompt(prompt);

    try {
      aChar = System.in.read();
    }

    catch (java.io.IOException e) {
      System.out.println("Input error");
    }
    inputFlush();
    return (char) aChar;
  }

  public static double inDouble(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Double.valueOf(inString().trim()).doubleValue();
      }

      catch (NumberFormatException e) {
        System.out
            .println("Invalid input. Not a floating point number");
      }
    }
  }
}