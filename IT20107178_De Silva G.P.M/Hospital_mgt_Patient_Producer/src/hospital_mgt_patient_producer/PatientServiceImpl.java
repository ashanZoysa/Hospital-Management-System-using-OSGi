package hospital_mgt_patient_producer;

import java.util.List;




public class PatientServiceImpl implements PatientActivaterService {


	@Override
	public synchronized int  addItems(int id,int age,String name,String disease,String type) {

		Patient newItem = new Patient( id, age, name, disease, type);
		PatientDataStore.itemsList.add(newItem);

	return 1;		
	}


	@Override
	public  synchronized int removeItems1(String name) {

		boolean invalid = true;
		int count = -1;
		for (Patient tempItem :PatientDataStore.itemsList) {
			count++;
			if (tempItem.getname().equalsIgnoreCase(name)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			PatientDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String name) {
		boolean valid = false;
	
		for (Patient tempItem : PatientDataStore.itemsList) {
		
			if (tempItem.getname().equalsIgnoreCase(name)) {

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
	public List<Patient> listItems() {

		return PatientDataStore.itemsList;
	}

	@Override
	public List<Patient> listItems1() {
		// TODO Auto-generated method stub
		return null;
	}
}
