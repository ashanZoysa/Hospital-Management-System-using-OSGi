package hospital_mgt_room_consumer;


import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import hospital_mgt_room_producer.Room;
import hospital_mgt_room_producer.RoomActivaterService;

public class Activator implements BundleActivator {

	ServiceReference RoomService;
	Scanner input = new Scanner(System.in);

	boolean exit = false;

	@Override
	public void start(BundleContext context) throws Exception {//Start life cycle method
		
		System.out.println("Hospital Management Room consumer started.");
		
		RoomService = context.getServiceReference(RoomActivaterService.class.getName());
		
		@SuppressWarnings("unchecked")
		
		RoomActivaterService  roomActivaterService = (RoomActivaterService) context.getService(RoomService);//Instance of RoomService
		
		do {
		int selection = 7;
		do {
		System.out.println("----------------------------Welcome to Hosptial Management -------------------------------");
	
		System.out.println("Please Select an option to continue.....");
		System.out.println("Options");
		System.out.println("1.Book a new room ");
		System.out.println("2.Remove room");
		System.out.println("3.List Of the reserved rooms");
		System.out.println("4.Search reserved room by type");
		System.out.println("5.Exit to room Interface");
		
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
		if (selection == 1) {//Handles the adding process of new rooms to the list
			do {
			System.out.println("Enter the Number of rooms..");
			int no_of_room = input.nextInt();

			System.out.println("Enter the Price of room..");
			int price = input.nextInt();
			
			System.out.println("Enter Discount Percentege (%): ");
			double discount = input.nextDouble();
			input.nextLine();

			System.out.println("Enter The type Of the room: (Available type:General Ward,Semi-Private Room & Private Room)");
			String type = input.nextLine();
			
			int result =roomActivaterService.addItems(no_of_room, price, discount, type);//Consumes the RoomService addItems()
			 String msg = (result ==1) ? "Successfully added the Stock!" :"please enter a valid name";
			   System.out.println(msg);
			System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if (selection == 2) {//Handles the removing process of an existing item in the list 
			do {
			System.out.println("Enter the type name need to remove..:");

			String type = input.nextLine();
			int result =roomActivaterService.removeItems1(type);//Consumes the RoomService removeItems()
			   String msg = (result ==1) ? "Successfully Removed the item!" :"please enter a valid name";
			   System.out.println(msg);
              System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 3) {//Handles displaying all items in the list
			do {
				List<Room> itemsList =roomActivaterService.listItems();//Consumes the RoomService listItems()
				System.out.println("-----------------------------------Reserved Room list--------------------------------------------");
				System.out.println("Quantity:"+"\t" +"Price:"+"\t" +"\t"+"type:"+"\t"+"\t" + "Discount:"+"\t" +"Total Amount:"+"\t" );
				
			for(Room tempItem: itemsList ) {
				System.out.println(tempItem.getno_of_room()+"\t         "+tempItem.getprice()+"\t         "+tempItem.gettype()+"\t  "+tempItem.getDiscount()+"%\t       "+tempItem.gettotal()+"\t              \n");
								
			}
			System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 4) {//Handles the searching process of an existing item in the list
			do {
			
			System.out.println("Enter the room type to search");
			

			String type = input.nextLine();
			int result =roomActivaterService.searchitems(type);//Consumes the RoomService searchItems()
			 String msg = (result ==1) ? "Item found!" :"Item not found!";
			   System.out.println(msg);
			
			System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));
		}
		else if(selection == 5) {//Exits form the room consumer program
			return;
		}
	}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//stop life cycle method
		System.out.println("============Room consumer stopped.============");
		context.ungetService(RoomService);
	}


}
