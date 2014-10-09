public class Layout { // Class declaration
  int a;

  Layout(int a) {
    this.a = a; // One-line body
  }

  int sum(int b) { // Multi-line body
    if (a > 0) { // If statement
      return a + b; // Single statement
    } else if (a < 0) { // Nested if-else, block statement
      int res = -a + b;
      return res * 117;
    } else { // a == 0 // Terminal else, block statement
      int sum = 0;
      for (int i = 0; i < 10; i++) { // For loop
        ;
      }
      return sum;
    }
  }

  static boolean checkdate(int mth, int day) {
    int length;
    switch (mth) { // Switch statement
    case 2: // Single case
      length = 28;
      break;
    case 4:
    case 6:
    case 9:
    case 11: // Multiple case
      length = 30;
      break;
    case 1:
    case 3:
    case 10:
    case 12:
      length = 31;
      break;
    default:
      return false;
    }
    return (day >= 1) && (day <= length);
  }
}