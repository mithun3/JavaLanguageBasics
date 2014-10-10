package _21_interface_abstract_classes;

interface Act {
  void act();
}

class Actor1 implements Act {
  public void act() {
    System.out.println("To be, or not to be");
  }
}

class Actor2 implements Act {
  public void act() {
    System.out.println("Wherefore art thou Romeo?");
  }
}

public class TryOut {
  public static void main(String args[]) {
    Actor1 hamlet = new Actor1();
    Actor2 juliet = new Actor2();
    tryout(hamlet);
    tryout(juliet);
  }

  private static void tryout(Act actor) {
    actor.act();
  }
}