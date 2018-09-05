package com.pyt;
/**
 * ��������
 * @author �����
 */
public class Customer implements Runnable {
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
                if(goods.getNum()<=0){
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goods.setNum((goods.getNum()-1));
                System.out.println("商品商标：" + goods.getBand() + "商品名：" + goods.getName());
                goods.notify();
            }
        }
    }

}