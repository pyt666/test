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
			synchronized(goods) {//��goodsͬ�������߳�1���߳�2�õ���һ��ʱ����
				if(goods.getNum()<=0) {
					try {
						goods.wait();//�߳�2��ͣ
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.println("---------------------------");
				System.out.println("����һ����Ʒ");
				goods.setNum(goods.getNum()-1);
				System.out.println("����Ʒ������"+goods.getNum());
				System.out.println(new Date().getSeconds());
				System.out.println("�߳�2");
				try {
					Thread.sleep(1000);//�߳���ͣ1s
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				goods.notify();//�����л������߳�1
			}
		}while(true);		
	}

}
