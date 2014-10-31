package _29_sub_class;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectRefTest {
  public static void main(String[] args) {
    try {
      Employee[] staff = new Employee[3];

      Employee harry = new Employee("Harry Sample", 35000);
      staff[0] = harry;
      staff[1] = new Manager("Carl Java", 75000, harry);
      staff[2] = new Manager("Tony Java2s", 38000, harry);

      ObjectOutputStream out = new ObjectOutputStream(
          new FileOutputStream("employee.dat"));
      out.writeObject(staff);
      out.close();

      ObjectInputStream in = new ObjectInputStream(new FileInputStream(
          "employee.dat"));
      Employee[] newStaff = (Employee[]) in.readObject();

      for (int i = 0; i < newStaff.length; i++)
        newStaff[i].raiseSalary(100);
      for (int i = 0; i < newStaff.length; i++)
        newStaff[i].print();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}

class Employee implements Serializable {
  public Employee(String n, double s) {
    name = n;
    salary = s;
  }

  public Employee() {
  }

  public void raiseSalary(double byPercent) {
    salary *= 1 + byPercent / 100;
  }

  public void print() {
    System.out.println(name + " " + salary);
  }

  private String name;

  private double salary;

}

class Manager extends Employee {
  private Employee secretary;

  public Manager(String n, double s, Employee e) {
    super(n, s);
    secretary = e;
  }

  public Manager() {
  }

  public void raiseSalary(double byPercent) {
    super.raiseSalary(byPercent + 10);
  }

  public void print() {
    super.print();
    System.out.print("Secretary: ");
    if (secretary != null)
      secretary.print();
  }

}