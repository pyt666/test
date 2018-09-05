package test.Total;

import java.util.logging.Handler;

import test.thread.testThread1;
import test.thread.testThread2;

public class testTotal {
	
	public static void main(String[] args) {
		 int count =10;
	
		// TODO Auto-generated method stub
		for(int i = 0;i<10;i++) {
			testThread1 th1  = new testThread1();
			th1.start();
		}
		
		/*testThread2 th2 = new testThread2();
		Runnable target = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("²âÊÔÏß³Ì3");
				
			}
		};
		Thread th = new Thread(target);*/
	
		

	}

}
