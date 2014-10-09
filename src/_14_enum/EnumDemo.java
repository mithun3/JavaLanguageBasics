package _14_enum;

enum AppleThree {  
  Jonathan, GoldenDel, RedDel, Winsap, Cortland 
} 
public class EnumDemo { 
  public static void main(String args[])  
  { 
    AppleThree ap; 
    ap = AppleThree.RedDel; 
    // Output an enum value. 
    System.out.println("Value of ap: " + ap); 
    System.out.println(); 
    ap = AppleThree.GoldenDel; 
    // Compare two enum values. 
    if(ap == AppleThree.GoldenDel)  
      System.out.println("ap conatins GoldenDel.\n"); 
    // Use an enum to control a switch statement. 
    switch(ap) { 
      case Jonathan: 
        System.out.println("Jonathan is red."); 
        break; 
      case GoldenDel: 
        System.out.println("Golden Delicious is yellow."); 
        break; 
      case RedDel:  
        System.out.println("Red Delicious is red."); 
        break; 
      case Winsap: 
        System.out.println("Winsap is red."); 
        break; 
      case Cortland: 
        System.out.println("Cortland is red."); 
        break; 
    } 
  } 
}