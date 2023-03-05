package hospital_mgt_room_producer;

import java.util.List;


public interface RoomActivaterService {
	
	List<Room> listItems();
	
	public  int  addItems(int no_of_room,double price,double discount,String type);//Adds the new room to the reserved list
	
	public   int removeItems1(String type);//Removes the items from the list
	
	public   int searchitems(String type);//Searches and item by name
	
	public   List<Room> listItems1();//Returns the room reserved list

	public interface DiscountService {
	    public double calculateDiscount(Room room);
	}
	
}
