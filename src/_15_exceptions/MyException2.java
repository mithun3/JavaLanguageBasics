package _15_exceptions;

public class MyException2 {

	public static void f() throws ExtraFeatures {
		System.out.println("Throwing MyException2 from f()");
		throw new ExtraFeatures();
	}

	public static void g() throws ExtraFeatures {
		System.out.println("Throwing MyException2 from g()");
		throw new ExtraFeatures("Originated in g()");
	}

	public static void h() throws ExtraFeatures {
		System.out.println("Throwing MyException2 from h()");
		throw new ExtraFeatures("Originated in h()", 47);
	}

	public static void main(String[] args) {
		try {
			f();
		} catch (ExtraFeatures e) {
			e.printStackTrace();
		}
		try {
			g();
		} catch (ExtraFeatures e) {
			e.printStackTrace();
		}
		try {
			h();
		} catch (ExtraFeatures e) {
			e.printStackTrace();
			System.err.println("e.val() = " + e.val());
		}
	}
} // /:~

class ExtraFeatures extends Exception {
	private int x;

	public ExtraFeatures() {
	}

	public ExtraFeatures(String msg) {
		super(msg);
	}

	public ExtraFeatures(String msg, int x) {
		super(msg);
		this.x = x;
	}

	public int val() {
		return x;
	}

	public String getMessage() {
		return "Detail Message: " + x + " " + super.getMessage();
	}
}
