package _14_enum;

import java.io.IOException;
import java.io.PrintStream;

enum Grade { A, B, C, D, F, INCOMPLETE };

class Student {

  private String firstName;
  private String lastName;
  private Grade grade;

  public Student(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFullName() {
    return new StringBuffer(firstName)
           .append(" ")
           .append(lastName)
           .toString();
  }

  public void assignGrade(Grade grade) {
    this.grade = grade;
  }

  public Grade getGrade() {
    return grade;
  }
}

public class GradeTester {

  private Student student1, student2, student3;

  public GradeTester() { 
    student1 = new Student("Brett", "McLaughlin");
    student2 = new Student("Ben", "Rochester");
    student3 = new Student("Dennis", "Erwin");
  }

  public void testGradeAssignment(PrintStream out) throws IOException {
    student1.assignGrade(Grade.B);
    student2.assignGrade(Grade.INCOMPLETE);
    student3.assignGrade(Grade.A);
  }

  public void listGradeValues(PrintStream out) throws IOException {
    Grade[] gradeValues = Grade.values();

    // for loop
    for (int i=0; i<gradeValues.length; i++) {
      out.println("Allowed value: '" + gradeValues[i] + "'");
    }

    // for/in loop
    for (Grade g : gradeValues ) {
      out.println("Allowed value: '" + g + "'");
    }
  }

  public void testSwitchStatement(PrintStream out) throws IOException {
    StringBuffer outputText = new StringBuffer(student1.getFullName()); switch (student1.getGrade()) {
      case A: 
        outputText.append(" excelled with a grade of A");
        break;   
      case B: // fall through to C
      case C: 
        outputText.append(" passed with a grade of ")
                  .append(student1.getGrade().toString());
        break;
      case D: // fall through to F
      case F:
        outputText.append(" failed with a grade of ")
                  .append(student1.getGrade().toString());
        break;
      case INCOMPLETE:
        outputText.append(" did not complete the class.");
        break;
      default:
        outputText.append(" has a grade of ")
                  .append(student1.getGrade().toString());
        break;
    }

    out.println(outputText.toString());
  }

  public static void main(String[] args) {
    try {
      GradeTester tester = new GradeTester();
      tester.testGradeAssignment(System.out);
      tester.listGradeValues(System.out);
      tester.testSwitchStatement(System.out);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
} 