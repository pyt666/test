package com.pyt;
/**
 * ��Ʒ��
 * @author �����
 */
public class Goods {
    private String band;
    private String name;
    private int num;  
    public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(String band, String name, int num) {
		super();
		this.band = band;
		this.name = name;
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "Goods [band=" + band + ", name=" + name + ", num=" + num + "]";
	}
	public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
  
    public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }    
}