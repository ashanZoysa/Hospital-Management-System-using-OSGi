package hospital_mgt_medicineinventory_producer;

import java.util.List;

public class MedicalServiceImpl implements MedicalActivatorService {


	@Override
	public synchronized int  addItems(String name,int qty,int price,String brand) {

		Medical newItem = new Medical( name,qty, price, brand);
		MedicalDataStore.itemsList.add(newItem);

	return 1;		
	}


	@Override
	public  synchronized int removeItems1(String brand) {

		boolean invalid = true;
		int count = -1;
		for (Medical tempItem :MedicalDataStore.itemsList) {
			count++;
			if (tempItem.getbrand().equalsIgnoreCase(brand)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			MedicalDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String brand) {
		boolean valid = false;
	
		for (Medical tempItem : MedicalDataStore.itemsList) {
		
			if (tempItem.getbrand().equalsIgnoreCase(brand)) {

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
	public List<Medical> listItems() {

		return MedicalDataStore.itemsList;
	}

	@Override
	public List<Medical> listItems1() {
		// TODO Auto-generated method stub
		return null;
	}
}
