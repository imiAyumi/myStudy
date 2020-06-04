package Lambda;

public class Example {
	public static void main(String[] args) {

		Runnable r = () -> System.out.println("OK");

		Thread t = new Thread(r);
		t.start();
	}

}