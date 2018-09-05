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
			synchronized(goods) {//��goodsͬ�����߳�1���߳�2�õ���һ��ʱ����
				if(goods.getNum()>=5) {
					try {
						goods.wait();//��ͣ�߳�1
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.println("---------------------------");
				System.out.println("����һ����Ʒ");
				goods.setNum(goods.getNum()+1);
				System.out.println("����Ʒ����"+goods.getNum());
				System.out.println(new Date().getSeconds());
				System.out.println("�߳�1");
				try {
					Thread.sleep(2000);//�߳�ͣ2s
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				goods.notify();//�����л������߳�2
			}			
		}while(true);

		
	}

}
