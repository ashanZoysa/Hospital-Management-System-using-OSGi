package hospital_mgt_room_producer;

import java.util.List;


public class RoomServiceImpl implements RoomActivaterService {


	@Override
	public synchronized int  addItems(int no_of_room,double price,double discount,String type) {

		Room newItem = new Room( no_of_room, price,discount,type);
		RoomDataStore.itemsList.add(newItem);

	return 1;		
	}


	@Override
	public  synchronized int removeItems1(String type) {

		boolean invalid = true;
		int count = -1;
		for (Room tempItem :RoomDataStore.itemsList) {
			count++;
			if (tempItem.gettype().equalsIgnoreCase(type)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			RoomDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String type) {
		boolean valid = false;
	
		for (Room tempItem : RoomDataStore.itemsList) {
		
			if (tempItem.gettype().equalsIgnoreCase(type)) {

				valid = true;
				break;

			}			

		}
		if(valid) {
			return 1;
			
		}
		else {
			return -1;
		}
		
	}

	@Override
	public List<Room> listItems() {

		return RoomDataStore.itemsList;
	}

	@Override
	public List<Room> listItems1() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
