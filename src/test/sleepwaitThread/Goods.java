package test.sleepwaitThread;
/**
 * 商品类
 * @author 濮玉婷
 */
public class Goods {
    private String band;//品牌
    private String name;//商品名
    private int num;    //商品数量
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
		return "商品 [品牌=" + band + ", 商品名=" + name + ", 商品数量=" + num + "]";
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