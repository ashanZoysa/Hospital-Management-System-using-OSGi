package hospital_mgt_medicineinventory_producer;

public class Medical {
  
	private String name;
	private int  qty;
	private int price;
	private String brand;
	private int totalvalue;
	
	
	public Medical( String name,int qty, int price, String brand) {
		super();
		this.name=name;
		this.qty=qty;
		this.price = price;
		this.brand = brand;
		caltotalValue();	
	}
	

	public String getname() {
		return name;
	}
	public int getqty() {
		return qty;
	}

	public void setqty(int qty) {
		this.qty = qty;
	}


	public int getprice() {
		return price;
	}


	public void setprice(int price) {
		this.price = price;
	}


	public String getbrand() {
		return brand;
	}

	public void setbrand(String brand) {
		this.brand = brand;
	}

	public int gettotal() {
		return totalvalue;
	}

	public void settotal(int totalvalue) {
		this.totalvalue = totalvalue;
	}


	void caltotalValue() {
		this.totalvalue=this.qty*this.price;
		
	}
}
