package hospital_mgt_medicineinventory_consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import hospital_mgt_medicineinventory_producer.Medical;
import hospital_mgt_medicineinventory_producer.MedicalActivatorService;
import java.util.List;
import java.util.Scanner;
import org.osgi.framework.ServiceReference;





public class Activator implements BundleActivator {

	ServiceReference MedicalService;
	Scanner input = new Scanner(System.in);

	boolean exit = false;

	@Override
	public void start(BundleContext context) throws Exception {//Start life cycle method
		
		System.out.println("**************** Medical consumer started ****************");
		
		MedicalService = context.getServiceReference(MedicalActivatorService.class.getName());
		
		@SuppressWarnings("unchecked")
		
		MedicalActivatorService  medicalActivatorService = (MedicalActivatorService) context.getService(MedicalService);//Instance of managerService
		
		do {
		int selection = 7;
		do {
		System.out.println("************************** Welcome to Hospital Managemnt ****************************");
	
		System.out.println("Please Select an option to continue.....");
		System.out.println("Options");
		System.out.println("1.Add new medicine ");
		System.out.println("2.Remove brands of medicine");
		System.out.println("3.List Of Available medidcine with brands");
		System.out.println("4.Search  available medicines by Brand");
		System.out.println("5.Exit to Medical Interface");
		
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
			
			System.out.println("Enter the Name of the Medicine ");
			String name = input.nextLine();
				
			System.out.println("Enter the Quaninty of Medicines..");
			int qty = input.nextInt();

			System.out.println("Enter the Price of Medicine..");
			int price = input.nextInt();

			System.out.println("Enter The Brand Of the Medicine..");
			String model = input.nextLine();
			model=input.nextLine();
			
			int result =medicalActivatorService.addItems(name,qty, price, model);//Consumes the MedicalService addItems()
			 String msg = (result ==1) ? "Successfully added the Medicine!" :"please enter a valid name";
			   System.out.println(msg);
			System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if (selection == 2) {//Handles the removing process of an existing item in the list 
			do {
			System.out.println("Enter the Brand name that needs to be removed :");

			String model = input.nextLine();
			int result =medicalActivatorService.removeItems1(model);//Consumes the MedicalService removeItems()
			   String msg = (result ==1) ? "Successfully Removed the Brand!" :"please enter a valid name";
			   System.out.println(msg);
              System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 3) {//Handles displaying all items in the list
			do {
				List<Medical> itemsList =medicalActivatorService.listItems();//Consumes the MedicalService listItems()
				System.out.println("-----------------------------------Medicine Stock list--------------------------------------------");
				System.out.println( "Name:"+"\t" +"Quantity:"+"\t" +"Price:"+"\t"+"\t" +"Brand:"+"\t"+"\t" +"Total Value:"+"\t");
				
			for(Medical tempItem: itemsList ) {
				System.out.println(tempItem.getname()+"\t       "+tempItem.getqty()+"\t    "+tempItem.getprice()+"\t        "+tempItem.getbrand()+"\t              "+tempItem.gettotal()+"\t              \n");
								
			}
			System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 4) {//Handles the searching process of an existing item in the list
			do {
			
			System.out.println("Enter the brand name to search");
			

			String model = input.nextLine();
			int result =medicalActivatorService.searchitems(model);//Consumes the MedicalService searchItems()
			 String msg = (result ==1) ? "The given Brand is available!" :" The given Brand is not available!";
			   System.out.println(msg);
			
			System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));
		}
		else if(selection == 5) {//Exits form the Medical consumer program
			return;
		}
	}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//stop life cycle method
		System.out.println("============Medical consumer stopped.============");
		context.ungetService(MedicalService);
	}

}
