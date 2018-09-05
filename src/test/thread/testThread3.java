package test.thread;

public class testThread3 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("线程3");
		testThread1 th1 = new testThread1();
		th1.start();
	}

}
