package _28_string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringBuilderTester {

  public static String appendItems(List list) {
    StringBuilder b = new StringBuilder();

    for (Iterator i = list.iterator(); i.hasNext(); ) {
      b.append(i.next())
       .append(" ");
    }

    return b.toString();
  }

  public static void main(String[] args) {
    List list = new ArrayList();
    list.add("I");
    list.add("play");
    list.add("Bourgeois");
    list.add("guitars");
    list.add("and");
    list.add("Huber");
    list.add("banjos");

    System.out.println(StringBuilderTester.appendItems(list));
  }
}