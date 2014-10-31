package _27_static_import;

import java.util.Arrays;

import static java.util.Arrays.sort;
import static java.util.Collections.sort;

public class SortImporter {

  public static void main(String[] args) {
    float[] f = new float[] {5, 4, 6, 3, 2, 1};

    sort(f);
  }
}