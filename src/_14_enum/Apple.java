package _14_enum;

enum Apples { 
  Jonathan(10), GoldenDel(9), RedDel, Winsap(15), Cortland(8); 
  private int price; // price of each apple 
  // Constructor 
  Apples(int p) { price = p; } 
  // Overloaded constructor 
  Apples() { price = -1; } 
  int getPrice() { return price; } 
}