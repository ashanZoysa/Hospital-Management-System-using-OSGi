package hospitalemployee_consumer;

import HospitalEmployee_ProducerService.HospitalEmployeeService;


import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ServiceActivator implements BundleActivator {

	ServiceReference <?> serviceReferenceEmployee;


	public void start(BundleContext context) throws Exception {
		System.out.println("Start Hospital Employee Consumer");
		serviceReferenceEmployee = context.getServiceReference(HospitalEmployeeService.class.getName());
		HospitalEmployeeService employeeService = (HospitalEmployeeService) context.getService(serviceReferenceEmployee);
		
		employeeService.loadEmployee();
		
		while (true) {

			System.out.println("----------------Hospital Employee Management----------------");
			System.out.println("");
			System.out.println("Display Hospital Employee Details :   1");
			System.out.println("Add New Hospital Employee Details :   2");
			System.out.println("Update Hospital Employee Details  :   3");
			System.out.println("Delete Hospital Employee Details  :   4");
			System.out.println("Search Hospital Employee Details  :   5");

			System.out.print("Select the service that you want to access : ");
			Scanner scanner = new Scanner(System.in);
			int selectedService = scanner.nextInt();

			switch (selectedService) {

			case 1:
				employeeService.showEmployeeList();
				break;

			case 2:
				employeeService.addNewEmployee();
				break;

			case 3:
				employeeService.updateEmployee();
				break;

			case 4:
				employeeService.deleteEmployee();
				break;

			case 5:
				employeeService.searchEmployee();
				break;

			default:
				System.out.println("You Have Entered A Invalid Number! Please Enter a Valid Number");
				continue;
			}

			System.out.println("");
			System.out.print("Do You Want To Exit? (y/n) :");
			Scanner scannerQuit = new Scanner(System.in);
			String quit = scannerQuit.next();

			if (quit.equalsIgnoreCase("y")) {
				System.out.println("");
				System.out.println("******************** Thank you **********************");
				
				break;
			} else {
				continue;
			}
		}
		
		
	}

	public void stop(BundleContext context) throws Exception {
		
		context.ungetService(serviceReferenceEmployee);
		System.out.println("Stop Hospital Employee Consumer");
		
	}

}
