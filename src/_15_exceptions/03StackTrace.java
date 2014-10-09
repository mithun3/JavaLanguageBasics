public class StackTrace {

  IllegalArgumentException ex;

  public static void main(String[] argv) {
    StackTrace st = new StackTrace();
    st.makeit();
    System.out.println("CONSTRUCTED BUT NOT THROWN");
    st.ex.printStackTrace();  
    st.throwit();
    // MAY BE NOTREACHED - THINK ABOUT IT!
    System.out.println("CONSTRUCTED BUT NOT THROWN");
    st.ex.printStackTrace();
  }

  public void makeit() {
    ex = new IllegalArgumentException("Don't like the weather today");
  }
  public void throwit() throws IllegalArgumentException {
    throw ex;
  }
}