package homework.DTO;



import java.util.Date;

public class EmployeeDetailsDTO {
	
	private int empId;
	private String fname;
	private String lname;
	private double salary;
	private Date hireDate;
	private String deptName;
	
	public EmployeeDetailsDTO(int empId,String fname,String lname,double salary,Date hireDate,String deptName)
	{
		this.empId =empId;
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
		this.hireDate = hireDate;
		this.deptName = deptName;
		
	}
	
	
	public int getEmpId() {
		return empId;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public Date getHireDate() {
		return hireDate;
	}



	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}



	public String getDeptName() {
		return deptName;
	}



	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	public String toString()
	{
		return "Employee [ EMPID = " + empId + " FNAME = " + fname+ " LNAME = "+ lname + " SALARY = " +salary + " HIREDATE = "+hireDate + " DEPTNAME =" +deptName + "]";
	}
	
	
	
}
