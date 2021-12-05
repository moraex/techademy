package assignment2;

public class PermanentEmployee extends Employee {
	private Double monthlySalary;
	private String prefixId = "P";
	private Double pf;
	private Double tax;
	
	public void calculateTax()
	{
		this.tax = (12 * monthlySalary) * 0.10;
	}
	
	public void calculatePf() {
		this.pf = 0.15 * monthlySalary;
	}
	
	public Double getPf() {
		return pf;
	}
	
	@Override
	public String toString() {
		return String.format("%-15s %-15s");
	}
	
	public void displayEmployeeDetails(String employeeType)
	{
		if(employeeType.charAt(0) == prefixId.charAt(0))
		{
			System.out.println(employeeId+","+employeeName+","+department+","+monthlySalary);
		}
	}
	
	public void displayEmployeeDetails()
	{
		System.out.println(employeeId+","+employeeName+","+department+","+monthlySalary);
	}
	
	public PermanentEmployee(String employee)
	{
		String[] employeeInfo = employee.split(",");
		
		setEmployeeId(prefixId + employeeInfo[0]);
		setEmployeeName(employeeInfo[1]);
		setDepartment(employeeInfo[2]);
		setMonthlySalary(Double.parseDouble(employeeInfo[3]));
		calculatePf();
	}
	
	public void setMonthlySalary(double salary)
	{
		this.monthlySalary = salary;
	}
}
