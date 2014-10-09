package _07_clone;

import java.util.Date;

class Enemy {
  public void munge(SideEffects md) {
    System.out.println("Object is " + md);
    md.year = 0;
    md.td.setYear(71);    // Ignore deprecation warnings
  }
}

public class SideEffects implements Cloneable {
  /** When we clone a "SideEffects", this REFERENCE gets cloned */
  public Date td;  
  /** When we clone a "SideEffects", this integer does NOT get cloned */
  volatile int year;

  public static void main(String[] argv) throws CloneNotSupportedException {
    new SideEffects().process();
  }

  SideEffects() {
    td = new Date();  // today
    year = td.getYear();
  }

  public void process() throws CloneNotSupportedException {
    Enemy r = new Enemy();
    System.out.println("We have seen the enemy, and he is " + r);
    System.out.println("Today is " + td + "; nice weather, isn't it?");
    System.out.println("And the year is " + year);
    r.munge((SideEffects)this.clone());
    System.out.println("Why, I believe it is now " + td);
    if (year == 0)    // should not happen!!
      System.out.println("** PANIC IN YEAR ZERO **");
    System.out.println("But wait, the year is still " + year);
    r.munge(this);
    System.out.println("Now I'm certain that it's " + td);
    System.out.println("Now the year is  " + year);
  }
}