package _22_object_oriented_design;

public class Customer extends Person {
  private int customerNumber;

  public Customer(String firstName, String lastName, int number) {
    super(firstName, lastName);
    setCustomerNumber(number);
  }

  public void setCustomerNumber(int n) {
    if (n < 1)
      throw new IllegalArgumentException("Invalid customer number " + n);
    customerNumber = n;
  }
}
class Person {
  String firstName;
  String lastName;
  Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
class Employee extends Person {
  private short deptCode;
  private int staffNumber;

  public Employee(String firstName, String lastName, short dept, int number) {
    super(firstName, lastName);
    setDeptCode(dept);
    setStaffID(number);
  }

  public void setDeptCode(short dept) {
    deptCode = dept;
  }

  public void setStaffID(int number) {
    if (number < 1)
      throw new IllegalArgumentException("Invalid staff number " +
        number);
    staffNumber = number;
  }
}