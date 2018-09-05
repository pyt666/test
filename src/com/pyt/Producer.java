package com.pyt;
public class Producer implements Runnable {
    private Goods goods;
    public Goods getGoods() {
    	return goods;
    }
    public void setGoods(Goods goods) {
    	this.goods = goods;
    }
	@Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (goods) {
                if(goods.getNum()>0){
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
                if (i % 2 == 0) {
                    goods.setBand("娃哈哈");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    goods.setName("AD钙");

                } else {
                    goods.setBand("百世");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    goods.setName("可乐");
                }
                goods.setNum((goods.getNum()+1));
                System.out.println("商品商标：" + goods.getBand() + "，商品名：" + goods.getName());
                goods.notify();
            }
        }
    }
}
