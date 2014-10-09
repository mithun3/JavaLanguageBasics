package _04_class_defenition;

import java.util.ArrayList;
import java.util.List;

public class ImmutableInteger {
  public static void main(String[] args) {
    List v = new ArrayList();
    for (int i = 0; i < 10; i++)
      v.add(new Integer(i));
    // But how do you change the int inside the Integer?
  }
} ///:~