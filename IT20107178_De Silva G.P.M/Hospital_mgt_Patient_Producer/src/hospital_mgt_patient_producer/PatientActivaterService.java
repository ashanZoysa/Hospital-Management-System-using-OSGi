package hospital_mgt_patient_producer;

import java.util.List;



public interface PatientActivaterService {

  List<Patient> listItems();
	
	public  int  addItems(int id,int age,String name,String disease,String type);//Adds the new items to the item list
	
	public   int removeItems1(String name);//Removes the items from the list
	
	public   int searchitems(String name);//Searches and item by name
	
	public   List<Patient> listItems1();//Returns the item list
}
