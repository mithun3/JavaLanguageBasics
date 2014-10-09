package _14_enum;

enum AppleTwo { 
  Jonathan(10), GoldenDel(9), RedDel(12), Winsap(15), Cortland(8); 
  private int price; // price of each AppleTwo 
  // Constructor 
  AppleTwo(int p) { price = p; } 
  int getPrice() { return price; } 
} 
public class EnumDemo3 { 
  public static void main(String args[])  
  { 
    AppleTwo ap; 
    // Display price of Winsap. 
    System.out.println("Winsap costs " + 
                       AppleTwo.Winsap.getPrice() + 
                       " cents.\n"); 
    // Display all AppleTwos and prices. 
    System.out.println("All AppleTwo prices:"); 
    for(AppleTwo a : AppleTwo.values()) 
      System.out.println(a + " costs " + a.getPrice() + 
                         " cents."); 
  } 
}