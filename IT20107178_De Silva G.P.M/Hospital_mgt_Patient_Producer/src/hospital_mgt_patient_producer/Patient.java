package hospital_mgt_patient_producer;

public class Patient {

	private int  id;
	private int age;
	private String name;
	private String disease;
	private String type;
	private int totalvalue;
	
	
	public Patient(int id, int age, String name, String disease, String type) {
		super();
		this.id=id;
		this.age = age;
		this.name = name;
		this.disease = disease;
		this.type = type;
		caltotalValue();	
	}
	

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}


	public int getage() {
		return age;
	}


	public void setage(int age) {
		this.age = age;
	}


	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	
	public String getdisease() {
		return disease;
	}

	public void setdisease(String disease) {
		this.disease = disease;
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
		this.totalvalue=this.id*this.age;
		
	}
	
}
