package assignment2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee, employee2;
		employee = new PermanentEmployee("106,Eric Miller,Finance,35000.00");
		employee.displayEmployeeDetails();
		
		employee2 = new ContractEmployee("111,Roger Steven,Sales,5,750000.00");
		employee2.displayEmployeeDetails();
	}

}
