package test.sleepwaitThread;

public class Test {

	public static void main(String[] args) {
		System.out.println("-------------线程开始--------------");
		Goods goods = new Goods();
		goods.setNum(0);
		// TODO Auto-generated method stub	
		Thread1 th1 = new Thread1();
		th1.setGoods(goods);
		Thread2 th2 = new Thread2();
		th2.setGoods(goods);
		th1.start();
		th2.start();
	}

}
