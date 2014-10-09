package _14_enum;

enum AppleOne {  
  Jonathan, GoldenDel, RedDel, Winsap, Cortland 
} 
public class EnumDemo4 { 
  public static void main(String args[])  
  { 
    AppleOne ap, ap2, ap3; 
    // Obtain all ordinal values using ordinal(). 
    System.out.println("Here are all AppleOne constants" + 
                       " and their ordinal values: "); 
    for(AppleOne a : AppleOne.values()) 
      System.out.println(a + " " + a.ordinal()); 
    ap =  AppleOne.RedDel; 
    ap2 = AppleOne.GoldenDel; 
    ap3 = AppleOne.RedDel; 
    System.out.println(); 
    // Demonstrate compareTo() and equals() 
    if(ap.compareTo(ap2) < 0) 
      System.out.println(ap + " comes before " + ap2); 
    if(ap.compareTo(ap2) > 0) 
      System.out.println(ap2 + " comes before " + ap); 
    if(ap.compareTo(ap3) == 0) 
      System.out.println(ap + " equals " + ap3); 
    System.out.println(); 
    if(ap.equals(ap2)) 
      System.out.println("Error!"); 
    if(ap.equals(ap3)) 
      System.out.println(ap + " equals " + ap3); 
    if(ap == ap3) 
      System.out.println(ap + " == " + ap3); 
  } 
}  