package hospital_mgt_investor_producer;

import java.util.List;

import hospital_mgt_investor_producer.Investor;
import hospital_mgt_investor_producer.InvestorActivatorService;
import hospital_mgt_investor_producer.Investor;

public class InvestorServiceImpl implements InvestorActivatorService {


	@Override
	public synchronized int  addItems(String name,int month,int amount,String type) {

		Investor newItem = new Investor( name,month,amount,type);
		InvestorDataStore.itemsList.add(newItem);

	return 1;		
	}


	@Override
	public  synchronized int removeItems1(String type) {

		boolean invalid = true;
		int count = -1;
		for (Investor tempItem :InvestorDataStore.itemsList) {
			count++;
			if (tempItem.gettype().equalsIgnoreCase(type)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			InvestorDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String type) {
		boolean valid = false;
	
		for (Investor tempItem : InvestorDataStore.itemsList) {
		
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
	public List<Investor> listItems() {

		return InvestorDataStore.itemsList;
	}

	@Override
	public List<Investor> listItems1() {
		// TODO Auto-generated method stub
		return null;
	}

}
