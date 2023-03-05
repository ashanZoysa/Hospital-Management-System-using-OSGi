package hospital_mgt_medicineinventory_producer;

import java.util.List;

public interface MedicalActivatorService {

List<Medical> listItems();
	
	public  int  addItems(String name,int qty,int price,String model);//Adds the new items to the item list
	
	public   int removeItems1(String model);//Removes the items from the list
	
	public   int searchitems(String model);//Searches and item by name
	
	public   List<Medical> listItems1();//Returns the item list

}
