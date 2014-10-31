package _28_string;
public class BostonAccentDemo {
  private static void bostonAccent(String sentence) {
    char r = 'r';
    char h = 'h';
    String translatedSentence = sentence.replace(r, h);
    System.out.println(translatedSentence);
  }

  public static void main(String[] args) {
    String translateThis = "Park the car in Harvard yard.";
    bostonAccent(translateThis);
  }
}