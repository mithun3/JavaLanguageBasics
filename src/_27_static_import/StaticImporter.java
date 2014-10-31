package _27_static_import;

import static java.lang.System.err;
import static java.lang.System.out;

import java.io.IOException;
import java.io.PrintStream;

public class StaticImporter {

  public static void writeError(PrintStream err, String msg) 
    throws IOException {
    // Note that err in the parameter list overshadows the imported err
    err.println(msg); 
  }

  public static void main(String[] args) {
    out.println("Good morning, " + "java2s");
    out.println("Have a day!");

    try {
      writeError(System.out, "Error occurred.");
    } catch (IOException e) {   e.printStackTrace();
    }
  }
}