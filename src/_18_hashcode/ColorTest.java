package _18_hashcode;

import java.awt.Color;

public class ColorTest {
  public static void main(String[] args) {
    Color c = new Color(130, 130, 130, 130);
    System.out.println(c + "; " + c.hashCode());
  }
}