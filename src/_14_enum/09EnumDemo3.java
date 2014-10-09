enum Apple { 
  Jonathan(10), GoldenDel(9), RedDel(12), Winsap(15), Cortland(8); 
  private int price; // price of each apple 
  // Constructor 
  Apple(int p) { price = p; } 
  int getPrice() { return price; } 
} 
public class EnumDemo3 { 
  public static void main(String args[])  
  { 
    Apple ap; 
    // Display price of Winsap. 
    System.out.println("Winsap costs " + 
                       Apple.Winsap.getPrice() + 
                       " cents.\n"); 
    // Display all apples and prices. 
    System.out.println("All apple prices:"); 
    for(Apple a : Apple.values()) 
      System.out.println(a + " costs " + a.getPrice() + 
                         " cents."); 
  } 
}