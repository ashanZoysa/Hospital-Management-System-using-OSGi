package hospital_mgt_room_producer;

public class Room {
	
	private int  no_of_room;
	private double price;
	private double discount;
	private String type;
	private double totalpayment;
	
	
	public Room(int no_of_room, double price,double discount, String type) {
		super();
		this.no_of_room=no_of_room;
		this.price = price;
		this.type = type;
		this.discount = discount;
		caltotalpayment();	
	}
	


	public int getno_of_room() {
		return no_of_room;
	}

	public void setno_of_room(int no_of_room) {
		this.no_of_room = no_of_room;
	}


	public double getprice() {
		return price;
	}


	public void setprice(double price) {
		this.price = price;
	}


	public String gettype() {
		return type;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public void settype(String type) {
		this.type = type;
	}

	public double gettotal() {
		return totalpayment;
	}

	public void settotal(int totalpayment) {
		this.totalpayment = totalpayment;
	}


	void caltotalpayment() {
		this.totalpayment= (no_of_room*price) * ((100.00- discount)/100.00) ;
	}
}
