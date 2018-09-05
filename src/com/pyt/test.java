package com.pyt;
/**
 * ������
 * @author �����
 */
public class test {
    public static void main(String[] args) {
        Goods goods=new Goods();
        
     
        Producer p=new Producer();
        p.setGoods(goods);
        
        
        Customer c=new Customer();
        c.setGoods(goods);
        
        new Thread(p).start();
        new Thread(c).start();
    }
}
