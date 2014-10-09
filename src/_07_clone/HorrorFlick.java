package _07_clone;

class Person1 {
}

class Hero extends Person1 {
}

class Scientist extends Person1 implements Cloneable {
  public Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException e) {
      // This should never happen: It's Cloneable already!
      throw new RuntimeException(e);
    }
  }
}

class MadScientist extends Scientist {
}

public class HorrorFlick {
  public static void main(String[] args) {
    Person1 p = new Person1();
    Hero h = new Hero();
    Scientist s = new Scientist();
    MadScientist m = new MadScientist();
    //! p = (Person)p.clone(); // Compile error
    //! h = (Hero)h.clone(); // Compile error
    s = (Scientist) s.clone();
    m = (MadScientist) m.clone();
  }
} ///:~