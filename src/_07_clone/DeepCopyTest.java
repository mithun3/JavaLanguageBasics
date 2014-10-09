package _07_clone;

class Person2 implements Cloneable {
  //Lower-level object
  private Car car;

  private String name;

  public Car getCar() {
    return car;
  }

  public String getName() {
    return name;
  }

  public void setName(String s) {
    name = s;
  }

  public Person2(String s, String t) {
    name = s;
    car = new Car(t);
  }

  public Object clone() {
    //Deep copy
    Person2 p = new Person2(name, car.getName());
    return p;
  }
}

class Car2 {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String s) {
    name = s;
  }

  public Car2(String s) {
    name = s;
  }
}

public class DeepCopyTest {

  public static void main(String[] args) {
    //Original Object
    Person p = new Person("Person-A", "Civic");
    System.out.println("Original (orginal values): " + p.getName() + " - "
        + p.getCar().getName());

    //Clone as a shallow copy
    Person q = (Person) p.clone();

    System.out.println("Clone (before change): " + q.getName() + " - "
        + q.getCar().getName());

    //change the primitive member
    q.setName("Person-B");

    //change the lower-level object
    q.getCar().setName("Accord");

    System.out.println("Clone (after change): " + q.getName() + " - "
        + q.getCar().getName());

    System.out.println("Original (after clone is modified): " + p.getName()
        + " - " + p.getCar().getName());

  }
}