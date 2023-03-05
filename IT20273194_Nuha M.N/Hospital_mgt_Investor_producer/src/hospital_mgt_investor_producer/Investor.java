package hospital_mgt_investor_producer;

public class Investor {

	private String name;
	private int  month;
	private int amount;
	private String type;
	private int totalvalue;
	
	
	public Investor( String name,int month, int amount, String type) {
		super();
		this.name=name;
		this.month=month;
		this.amount = amount;
		this.type = type;
		caltotalValue();	
	}
	

	public String getname() {
		return name;
	}
	public int getmonth() {
		return month;
	}

	public void setmonth(int month) {
		this.month = month;
	}


	public int getamount() {
		return amount;
	}


	public void setamount(int amount) {
		this.amount = amount;
	}


	public String gettype() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}

	public int gettotal() {
		return totalvalue;
	}

	public void settotal(int totalvalue) {
		this.totalvalue = totalvalue;
	}


	void caltotalValue() {
		this.totalvalue=this.month*this.amount;
		
	}
}
