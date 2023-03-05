package hospital_mgt_investor_consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import hospital_mgt_investor_producer.InvestorActivatorService;
import hospital_mgt_investor_producer.Investor;
import java.util.List;
import java.util.Scanner;
import org.osgi.framework.ServiceReference;


public class Activator implements BundleActivator {

	
		ServiceReference InvestorService;
		Scanner input = new Scanner(System.in);

		boolean exit = false;

		@Override
		public void start(BundleContext context) throws Exception {//Start life cycle method
			
			System.out.println("**************** Medical consumer started ****************");
			
			InvestorService = context.getServiceReference(InvestorActivatorService.class.getName());
			
			@SuppressWarnings("unchecked")
			
			InvestorActivatorService  investorActivatorService = (InvestorActivatorService) context.getService(InvestorService);//Instance of managerService
			
			do {
			int selection = 7;
			do {
			System.out.println("************************** Welcome to Hospital Managemnt ****************************");
		
			System.out.println("Please Select an option to continue.....");
			System.out.println("Options");
			System.out.println("1.Add new Investor ");
			System.out.println("2.Remove Investors");
			System.out.println("3.List Of Available Investors according to the type");
			System.out.println("4.Search  available Investors according to the type");
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
				
				System.out.println("Enter the Name of the Investor ");
				String name = input.nextLine();
					
				System.out.println("Enter the number of months of investment ");
				int month = input.nextInt();

				System.out.println("Enter the monthly investment amount ");
				int amount = input.nextInt();

				System.out.println("Enter The Type of investment..");
				String type = input.nextLine();
				type=input.nextLine();
				
				int result =investorActivatorService.addItems(name,month,amount,type);//Consumes the MedicalService addItems()
				 String msg = (result ==1) ? "Successfully added the Investor!" :"please enter a valid name";
				   System.out.println(msg);
				System.out.println("Press 0 to navigate back to home or press any other key to continue....");
				
				backToHome=input.nextLine();
				
				}
				
				while(!(backToHome.equals("0")));

			}
			else if (selection == 2) {//Handles the removing process of an existing item in the list 
				do {
				System.out.println("Enter the Investor type that needs to be removed :");

				String type = input.nextLine();
				int result =investorActivatorService.removeItems1(type);//Consumes the MedicalService removeItems()
				   String msg = (result ==1) ? "Successfully Removed the Investor type!" :"please enter a valid name";
				   System.out.println(msg);
	              System.out.println("Press 0 to navigate back to home or press any other key to continue....");
				
				backToHome=input.nextLine();
				
				}
				
				while(!(backToHome.equals("0")));

			}
			else if(selection == 3) {//Handles displaying all items in the list
				do {
					List<Investor> itemsList =investorActivatorService.listItems();//Consumes the MedicalService listItems()
					System.out.println("-----------------------------------Medicine Stock list--------------------------------------------");
					System.out.println( "Name:"+"\t" +"Month:"+"\t" +"Amount:"+"\t"+"\t" +  "Type:"+"\t"+"\t" + "Total Value:"+"\t");
					
				for(Investor tempItem: itemsList ) {
					System.out.println(tempItem.getname()+"\t    "+tempItem.getmonth()+"\t  "+tempItem.getamount()+"\t      "+tempItem.gettype()+"\t      "+tempItem.gettotal()+"\t    \n");
									
				}
				System.out.println("-----------------------------------------------------------------------------------------");
	            System.out.println("Press 0 to navigate back to home or press any other key to continue....");
				
				backToHome=input.nextLine();
				
				}
				
				while(!(backToHome.equals("0")));

			}
			else if(selection == 4) {//Handles the searching process of an existing item in the list
				do {
				
				System.out.println("Enter the type name to search");
				

				String type = input.nextLine();
				int result =investorActivatorService.searchitems(type);//Consumes the MedicalService searchItems()
				 String msg = (result ==1) ? "The given type is available!" :" The given type is not available!";
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
			context.ungetService(InvestorService);
		}

}
