package _17_finalize;

class Book {
  boolean checkedOut = false;

  Book(boolean checkOut) {
    checkedOut = checkOut;
  }

  void checkIn() {
    checkedOut = false;
  }

  public void finalize() {
    if (checkedOut)
      System.out.println("Error: checked out");
  }
}

public class TerminationCondition {
  public static void main(String[] args) {
    Book novel = new Book(true);
    // Proper cleanup:
    novel.checkIn();
    // Drop the reference, forget to clean up:
    new Book(true);
    // Force garbage collection & finalization:
    System.gc();
  }
} ///:~