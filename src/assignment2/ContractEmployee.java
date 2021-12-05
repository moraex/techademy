package assignment2;

public class ContractEmployee extends Employee{
	private Integer contractPeriod;
	private Double contractAmount;
	private String prefixId = "C";
	
	public void calculateTax()
	{
		this.tax = (contractAmount / 12) * 0.10;
	}

	
	@Override
	public String toString() {
		return String.format("%-15s %-15s");
	}
	
	public void displayEmployeeDetails(String employeeType)
	{
		if(employeeType.charAt(0) == prefixId.charAt(0))
		{
			System.out.println(employeeId+","+employeeName+","+department+","+contractPeriod+","+contractAmount);
		}
	}
	
	public void displayEmployeeDetails()
	{
		System.out.println(employeeId+","+employeeName+","+department+","+contractPeriod+","+contractAmount);
	}
	
	public ContractEmployee(String employee)
	{
		String[] employeeInfo = employee.split(",");
		
		setEmployeeId(prefixId + employeeInfo[0]); 	// id
		setEmployeeName(employeeInfo[1]); 	// name
		setDepartment(employeeInfo[2]); 	// department
		setContractPeriod(Integer.parseInt(employeeInfo[3])); 	// period
		setContractAmount(Double.parseDouble(employeeInfo[4])); // amount
	}
	
	public Integer getContractPeriod() {
		return contractPeriod;
	}


	public void setContractPeriod(Integer contractPeriod) {
		this.contractPeriod = contractPeriod;
	}


	public Double getContractAmount() {
		return contractAmount;
	}


	public void setContractAmount(Double contractAmount) {
		this.contractAmount = contractAmount;
	}
	
}
