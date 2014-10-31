package _27_static_import; 
public class Msg { 
  public static final int UPPER = 1; 
  public static final int LOWER = 2; 
  public static final int MIXED = 3; 
  private String msg; 
  // Display a message in the specified case. 
  public void showMsg(int how) { 
    String str; 
    switch(how) { 
      case UPPER: 
        str = msg.toUpperCase(); 
        break; 
      case LOWER: 
        str = msg.toLowerCase(); 
        break; 
      case MIXED: 
        str = msg; 
        break; 
      default: 
        System.out.println("Invalid command."); 
        return; 
    } 
    System.out.println(str); 
  } 
  public Msg(String s) { msg = s; } 
}


// Static import user-defined static fields. 
/*
class Test {  
  public static void main(String args[]) {  
    Msg m = new Msg("Testing static import."); 
    m.showMsg(MIXED); 
    m.showMsg(LOWER); 
    m.showMsg(UPPER); 
  }  
}*/