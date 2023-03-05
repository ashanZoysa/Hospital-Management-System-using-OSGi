package hospitalemployee_producer;

import java.util.HashMap;
import java.util.Scanner;

import HospitalEmployee_ProducerService.HospitalEmployeeService;

public class HospitalEmployeeServiceImpl implements HospitalEmployeeService {
	
	int noEmployees = 3;

	HashMap<Integer, String> name = new HashMap<Integer, String>();
	HashMap<Integer, String> address = new HashMap<Integer, String>();
	HashMap<Integer, String> email = new HashMap<Integer, String>();
	HashMap<Integer, String> designation = new HashMap<Integer, String>();


	@Override
	public void showEmployeeList() {
		// TODO Auto-generated method stub
		System.out.println("");
		System.out.println("Hospital Employee Detail List");
		System.out.println("");
		System.out.println("ID\t\tName\t\tAddress\t\tEmail\t\t         Designation");
		System.out.println("----------------------------------------------------------------------------------------------------------------------");

		for (int i = 1; i <= noEmployees; ++i) {
			if (name.get(i) != null) {
				System.out.print(i);
				System.out.print("\t\t");
				System.out.print(name.get(i));
				System.out.print("\t\t");
				System.out.print(address.get(i));
				System.out.print("\t\t");
				System.out.print(email.get(i));
				System.out.print("\t\t");
				System.out.println(designation.get(i));
			}
		}
		
		System.out.println("");
		System.out.println("******************************************************** END *********************************************************");
		
	}

	@Override
	public void addNewEmployee() {
		
		System.out.println("");
		System.out.println("---------------Add New Hospital Employee Details--------------");
		System.out.println("");

		System.out.print("Enter Employee Name       : ");
		Scanner empName = new Scanner(System.in);
		String empNameInput = empName.next();
		System.out.println("");
		
		System.out.print("Enter Employee Address    : ");
		Scanner empAddress = new Scanner(System.in);
		String empAddressInput = empAddress.next();
		System.out.println("");
		
		System.out.print("Enter Employee Email      : ");
		Scanner empEmail = new Scanner(System.in);
		String empEmailInput = empEmail.next();
		System.out.println("");

		System.out.print("Enter Employee Designation : ");
		Scanner empDesignation = new Scanner(System.in);
		String empDesignationInput = empDesignation.next();
		System.out.println("");

		noEmployees++;
		name.put(noEmployees, empNameInput);
		address.put(noEmployees, empAddressInput);
		email.put(noEmployees, empEmailInput);
		designation.put(noEmployees, empDesignationInput);
		System.out.println("Successfully Added " + empNameInput + "'s Employee Details");
		System.out.println("");
		
	}

	@Override
	public void deleteEmployee() {
		// TODO Auto-generated method stub
		System.out.println("");
		System.out.println("------------------Delete Employee Details-----------------");
		System.out.println("");

		showEmployeeList();

		System.out.println("");
		System.out.print("Enter Employee ID : ");
		Scanner empId = new Scanner(System.in);
		int empIdInput = empId.nextInt();
		System.out.println("");

		name.remove(empIdInput);
		email.remove(empIdInput);
		address.remove(empIdInput);
		designation.remove(empIdInput);

		System.out.println("Successfully Deleted " + empIdInput + "'s Employee Details");
		System.out.println("");
		
	}

	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub
		System.out.println("");
		System.out.println("Update Employee Details");
		System.out.println("");
		showEmployeeList();

		System.out.println("");
		System.out.print("Enter Employee ID : ");
		Scanner empId = new Scanner(System.in);
		int empIdInput = empId.nextInt();

		System.out.println("");
		System.out.print("Enter Employee Name : ");
		Scanner empName = new Scanner(System.in);
		String empNameInput = empName.next();
		
		System.out.println("");
		System.out.print("Enter Employee Address    : ");
		Scanner empAddress = new Scanner(System.in);
		String empAddressInput = empAddress.next();
		
		System.out.println("");
		System.out.print("Enter Employee Email      : ");
		Scanner empEmail = new Scanner(System.in);
		String empEmailInput = empEmail.next();
	
		

		System.out.println("");
		System.out.print("Enter Employee Designation : ");
		Scanner empDesignation = new Scanner(System.in);
		String empDesignationInput = empDesignation.next();

		name.put(empIdInput, empNameInput);
		address.put(empIdInput, empAddressInput);
		email.put(empIdInput, empEmailInput);
		designation.put(empIdInput, empDesignationInput);

		System.out.println("Successfully Updated " + empIdInput + " " + empNameInput + "'s Employee Details");
		System.out.println("");
		
	}

	@Override
	public void loadEmployee() {
		// TODO Auto-generated method stub
		name.put(1, "Peter");
		name.put(2, "Kevin");
		name.put(3, "Anne");
		
		
		address.put(1, "Colombo");
		address.put(2, "Kandy");
		address.put(3, "Galle");
		
		email.put(1, "peter@gmail.com");
		email.put(2, "kevin@gmail.com");
		email.put(3, "anne@gmail.com");
		

		designation.put(1, "Doctor");
		designation.put(2, "pharmacist");
		designation.put(3, "Nurse");

		
	}

	@Override
	public void searchEmployee() {
		// TODO Auto-generated method stub

		System.out.println("");
		System.out.println("Search an Employee");
		System.out.println("");
		System.out.print("Please Enter a Name: ");
		Scanner empName = new Scanner(System.in);
		String empNameInput = empName.next();

		Boolean value = false;
		for (int i = 1; i <= noEmployees; ++i) {
			if (name.get(i) != null) {
				if (name.get(i).equalsIgnoreCase(empNameInput)) {
					System.out.println("");
					System.out.print("ID");
					System.out.print("\t\t");
					System.out.print("Name");
					System.out.print("\t\t");
					System.out.print("Address");
					System.out.print("\t\t");
					System.out.print("Email");
					System.out.print("\t\t    ");
					System.out.println("Designation");

					System.out.println("----------------------------------------------------------------------------------");

					System.out.print(i);
					System.out.print("\t\t");
					System.out.print(name.get(i));
					System.out.print("\t\t");
					System.out.print(address.get(i));
					System.out.print("\t\t");
					System.out.print(email.get(i));
					System.out.print("\t\t");
					System.out.println(designation.get(i));
					value = true;
					break;
				}
			}

		}
		if (value == false) {
			System.out.println("");
			System.out.println("***** No Employee is Found by this Name *****");
		}

	}
		
	

}
