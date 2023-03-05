package hospital_mgt_investor_producer;

import java.util.List;



public interface InvestorActivatorService {
	
List<Investor> listItems();
	
	public  int  addItems(String name,int month,int amount,String type);//Adds the new items to the item list
	
	public   int removeItems1(String model);//Removes the items from the list
	
	public   int searchitems(String model);//Searches and item by name
	
	public   List<Investor> listItems1();//Returns the item list

}
