package test.sleepwaitThread;

import java.util.Date;

public class Thread1 extends Thread {
	private Goods goods;
	
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public void run() {
		do {			
			synchronized(goods) {//对goods同步，线程1和线程2用的是一个时间线
				if(goods.getNum()>=5) {
					try {
						goods.wait();//暂停线程1
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.println("---------------------------");
				System.out.println("生产一件商品");
				goods.setNum(goods.getNum()+1);
				System.out.println("现商品数量"+goods.getNum());
				System.out.println(new Date().getSeconds());
				System.out.println("线程1");
				try {
					Thread.sleep(2000);//线程停2s
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				goods.notify();//提醒切换开启线程2
			}			
		}while(true);

		
	}

}
