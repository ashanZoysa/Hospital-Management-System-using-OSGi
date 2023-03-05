package hospital_mgt_patient_consumer;

import java.util.List;
import java.util.Scanner;
import hospital_mgt_patient_producer.PatientActivaterService;
import hospital_mgt_patient_producer.Patient;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;









public class Activator implements BundleActivator {
	ServiceReference PatientService;
	Scanner input = new Scanner(System.in);

	boolean exit = false;

	@Override
	public void start(BundleContext context) throws Exception {//Start life cycle method
		
		System.out.println("============Hospital management Patient consumer started.============");
		
		PatientService = context.getServiceReference(PatientActivaterService.class.getName());
		
		@SuppressWarnings("unchecked")
		
		PatientActivaterService  patientActivaterService = (PatientActivaterService) context.getService(PatientService);//Instance of PatientService
		
		do {
		int selection = 7;
		do {
		System.out.println("----------------------------Welcome to Hospital management Patient -------------------------------");
	
		System.out.println("Please Select an option to continue.....");
		System.out.println("Options");
		System.out.println("1.Add new Patient");
		System.out.println("2.Remove Patient");
		System.out.println("3.List Of Current Patients");
		System.out.println("4.Search  available Patient by name");
		System.out.println("5.Exit to Patient Interface");
		
		System.out.println("Enter your selection...");
		 selection = input.nextInt();
		
		 input.nextLine();
		 if(selection == 5) {
			 exit = true;
		 }
		 
		 if(selection !=1 &&  selection !=2 && selection !=3 && selection !=4 && selection!=5) {
			 System.out.println("Please enter a valid selection");
		 }
		}while(selection !=1  && selection !=2 && selection !=3 && selection !=4 && selection!=5 );
		
	
        String  backToHome = null;
		if (selection == 1) {//Handles the adding process of new items to the list
			do {
			System.out.println("Enter the id of Patient..");
			int id = input.nextInt();

			System.out.println("Enter the age of Patient..");
			int age = input.nextInt();

			System.out.println("Enter The name Of the Patient..");
			String name = input.nextLine();
			name=input.nextLine();
			
			System.out.println("Enter The disease Of the Patient..");
			String disease = input.nextLine();
			//disease=input.nextLine();
	
			System.out.println("Enter The type Of the Patient..");
			String type = input.nextLine();
			//type=input.nextLine();
			
			int result =patientActivaterService.addItems(id, age, name,disease, type);//Consumes the PatientService addItems()
			 String msg = (result ==1) ? "Successfully added the Patient!" :"please enter a valid name";
			   System.out.println(msg);
			System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if (selection == 2) {//Handles the removing process of an existing item in the list 
			do {
			System.out.println("Enter the name need to remove..:");

			String name = input.nextLine();
			int result =patientActivaterService.removeItems1(name);//Consumes the PatientService removeItems()
			   String msg = (result ==1) ? "Successfully Removed the Patient!" :"please enter a valid name";
			   System.out.println(msg);
              System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 3) {//Handles displaying all items in the list
			do {
				List<Patient> itemsList =patientActivaterService.listItems();//Consumes the PatientService listItems()
				System.out.println("-----------------------------------Patient list--------------------------------------------");
				System.out.println("ID:"+"\t" +"Age:"+"\t"+"Name:"+"\t"+"Disease:"+"\t"+"Type:"+    "\t" +"\t" +"\t" +"\t" +"\t" +"\t" +"\t" +"\t" +"Total Value:"+"\t" );
				
			for(Patient tempItem: itemsList ) {
				System.out.println(tempItem.getid()+"\t"+tempItem.getage()+"\t "+tempItem.getname()+"\t"+tempItem.getdisease()+"\t "+"\t "+"\t "+tempItem.gettype()                   +"\t"+ "\t"+ "\t"+ "\t"+ "\t"+ "\t"+ "\t"+"\t"+"\t"+tempItem.gettotal()+"\t              \n");
								
			}
			System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 4) {//Handles the searching process of an existing item in the list
			do {
			
			System.out.println("Enter the patient name to search");
			

			String name = input.nextLine();
			int result =patientActivaterService.searchitems(name);//Consumes the PatientService searchItems()
			 String msg = (result ==1) ? "Patient found!" :"Patient not found!";
			   System.out.println(msg);
			
			System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));
		}
		else if(selection == 5) {//Exits form the patient consumer program
			return;
		}
	}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//stop life cycle method
		System.out.println("============Patient consumer stopped.============");
		context.ungetService(PatientService);
	}

}