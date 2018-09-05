package test.sleepwaitThread;

import java.util.Date;

public class Thread2 extends Thread {
private Goods goods;
	
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		do {
			synchronized(goods) {//对goods同步，即线程1和线程2用的是一个时间线
				if(goods.getNum()<=0) {
					try {
						goods.wait();//线程2暂停
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.println("---------------------------");
				System.out.println("消耗一件商品");
				goods.setNum(goods.getNum()-1);
				System.out.println("现商品数量："+goods.getNum());
				System.out.println(new Date().getSeconds());
				System.out.println("线程2");
				try {
					Thread.sleep(1000);//线程暂停1s
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				goods.notify();//提醒切换开启线程1
			}
		}while(true);		
	}

}
