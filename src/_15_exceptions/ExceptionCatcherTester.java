package _15_exceptions;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.EventListener;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ExceptionCatcherTester {
  public ExceptionCatcherTester() {
    JFrame f = new JFrame("Exception Catcher Tester");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final JTextArea textArea = new JTextArea();
    textArea.setEditable(false);

    JButton button = new JButton("Alive");
    ActionListener buttonListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("I'm Alive");
      }
    };
    button.addActionListener(buttonListener);

    final JTextField textField = new JTextField();
    ActionListener textFieldListener = new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        // Code to load URL contents in separate thread
        Runnable r = new Runnable() {
          public void run() {
            textField.setEditable(false);
            String urlString = e.getActionCommand();
            try {
              System.out.println("Loading " + urlString);
              textArea.setText("");
              URL url = new URL(urlString);
              InputStream is = url.openStream();
              InputStreamReader isr = new InputStreamReader(is);
              BufferedReader br = new BufferedReader(isr);
              StringWriter sw = new StringWriter();
              char buf[] = new char[1024];
              int count;
              while ((count = br.read(buf, 0, 1024)) != -1) {
                sw.write(buf, 0, count);
              }
              System.out.println("Done Loading");
              updateTextArea(textArea, sw.toString());
            } catch (IOException e) {
              throw new ThreadException(this, e);
            } finally {
              textField.setEditable(true);
            }
          }
        };
        ExceptionCatcherThread runner = new ExceptionCatcherThread(r);

        // Listener in case of exception
        ThreadListener threadListener = new ThreadListener() {
          public void exceptionHappened(ThreadException e) {
            Throwable t = e.getSourceException();
            final String message = t.getClass().getName() + ": "
                + t.getMessage();
            Runnable r = new Runnable() {
              public void run() {
                JOptionPane.showMessageDialog(null, message);
              }
            };
            SwingUtilities.invokeLater(r);
          }
        };
        runner.addThreadExceptionListener(threadListener);

        runner.start();
      }
    };
    textField.addActionListener(textFieldListener);
    Container c = f.getContentPane();
    c.add(textField, BorderLayout.NORTH);
    JScrollPane pane = new JScrollPane(textArea);
    c.add(pane, BorderLayout.CENTER);
    c.add(button, BorderLayout.SOUTH);
    f.setSize(300, 300);
    f.show();
  }

  public void updateTextArea(final JTextArea ta, final String text) {
    // Because file loading happening not blocking event thread
    // We have to set text area in event thread
    Runnable r = new Runnable() {
      public void run() {
        ta.setText(text);
        ta.setCaretPosition(0);
      }
    };
    SwingUtilities.invokeLater(r);
  }

  public static void main(String args[]) {
    new ExceptionCatcherTester();
  }
}

class ExceptionCatcherThread extends ThreadGroup {

  private Runnable runnable;

  private Thread runner;

  private Vector listenerList = new Vector(3);

  /* For autonumbering our group. */
  private static int threadInitNumber;

  private static synchronized int nextThreadNum() {
    return threadInitNumber++;
  }

  public ExceptionCatcherThread(Runnable r) {
    super("ExceptionCatcherThread-" + nextThreadNum());
    runnable = r;
    // Create thread in this group
    runner = new Thread(this, runnable);
  }

  public void start() {
    runner.start();
  }

  /* Listener registration methods */

  public synchronized void addThreadExceptionListener(ThreadListener t) {
    listenerList.add(t);
  }

  public synchronized void removeThreadExceptionListener(ThreadListener t) {
    listenerList.remove(t);
  }

  public void uncaughtException(Thread source, Throwable t) {
    fireExceptionHappened(t);
    super.uncaughtException(source, t);
  }

  protected void fireExceptionHappened(Throwable t) {
    ThreadException e = (t instanceof ThreadException) ? (ThreadException) t
        : new ThreadException(runnable, t);
    Vector l;
    synchronized (this) {
      l = (Vector) listenerList.clone();
    }
    for (int i = 0, n = listenerList.size(); i < n; i++) {
      ThreadListener tl = (ThreadListener) l.get(i);
      tl.exceptionHappened(e);
    }
  }
}

class ThreadException extends RuntimeException {
  Runnable runnable;

  Throwable exception;

  public ThreadException(Runnable r, Throwable t) {
    runnable = r;
    exception = t;
  }

  public ThreadException(Runnable r, Throwable t, String message) {
    super(message);
    runnable = r;
    exception = t;
  }

  public Runnable getRunnable() {
    return runnable;
  }

  public Throwable getSourceException() {
    return exception;
  }
}

class ThreadExceptionEvent extends EventObject {
  public ThreadExceptionEvent(ThreadException source) {
    super(source);
  }

  public Runnable getRunnable() {
    ThreadException source = (ThreadException) getSource();
    return (Runnable) source.getRunnable();
  }
}

interface ThreadListener extends EventListener {
  public void exceptionHappened(ThreadException e);
}