package _28_string;

import junit.framework.TestCase;

public class Tabs {
  /** tabs every so often */
  public final static int DEFTABSPACE =   8;
  /** the current tab stop setting. */
  protected int tabSpace = DEFTABSPACE;
  /** The longest line that we initially set tabs for. */
  public final static int MAXLINE  = 255;
  /** the current tab stops */
  protected boolean[] tabstops;

  /** Construct a Tabs object with a given tab stop settings */
  public Tabs(int n) {
    if (n <= 0) {
      n = 1;
    }
    tabstops = new boolean[MAXLINE];
    tabSpace = n;
    settabs();
  }

  /** Construct a Tabs object with a default tab stop settings */
  public Tabs() {
    this(DEFTABSPACE);
  }

  /** settabs - set initial tab stops */
  private void settabs() {
    for (int i = 0; i < tabstops.length; i++) {
      tabstops[i] = ((i+1) % tabSpace) == 0;
    }
  }
  /**
   * @return Returns the tabSpace.
   */
  public int getTabSpacing() {
    return tabSpace;
  }
  /** isTabStop - returns true if given column is a tab stop.
   * @param col - the current column number
   */
  public boolean isTabStop(int col) {
    if (col > tabstops.length - 1) {
      tabstops = new boolean[tabstops.length * 2];
      settabs();
    }
    return tabstops[col];
  }
}



/**
 * @author ian
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
class TabsTest extends TestCase {

  public static void main(String[] args) {
    junit.textui.TestRunner.run(TabsTest.class);
  }

  private Tabs t4, t8;
  public void setUp() {
    t4 = new Tabs(4);
    t8 = new Tabs();
  }
  public void testGetTabSpacing() {
    assertEquals(t4.getTabSpacing(), 4);
    assertEquals(t8.getTabSpacing(), Tabs.DEFTABSPACE);
  }
  public  void testIsTabStop() {
    assertEquals(false, t4.isTabStop(0));
    assertEquals(false, t4.isTabStop(1));
    assertEquals(false, t4.isTabStop(2));
    assertEquals(true,  t4.isTabStop(3));
    assertEquals(false, t4.isTabStop(4));
    assertEquals(false, t4.isTabStop(5));
    assertEquals(false, t4.isTabStop(6));
    assertEquals(true,  t4.isTabStop(7));
    assertEquals(false, t4.isTabStop(8));
  }
}