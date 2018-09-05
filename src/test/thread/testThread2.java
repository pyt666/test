package test.thread;

public class testThread2 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("线程2");
		testThread3 th3 = new testThread3();
		th3.start();
	}

}
