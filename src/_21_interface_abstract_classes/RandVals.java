package _21_interface_abstract_classes;

import java.util.Random;

public interface RandVals {
  Random rand = new Random();

  int randomInt = rand.nextInt(10);

  long randomLong = rand.nextLong() * 10;

  float randomFloat = rand.nextLong() * 10;

  double randomDouble = rand.nextDouble() * 10;
} ///:~