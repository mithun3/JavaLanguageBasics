package _27_static_import;

import _27_static_import.Fruits.*;


public class StaticTest {
    public static void main(String args[])
    {
        System.out.println("orange = " + Fruits.orange);
        System.out.println("color orange = " + Colors.orange);
        System.out.println("Fruity orange = " + Fruits.orange);
    }
}