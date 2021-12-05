package assignment2;

public abstract class Employee {
	protected String employeeId;
	protected String employeeName;
	protected String department;
	private Double salary;
	protected Double tax;
	
	public void calculateTax() {};
	
	public double getTax() {
		return tax;
	}
	
	public void displayEmployeeDetails(String enployeeType){};
	public void displayEmployeeDetails(){};
	
	@Override
	public String toString() {
		return String.format("%-10s %-20s %-15s");
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
