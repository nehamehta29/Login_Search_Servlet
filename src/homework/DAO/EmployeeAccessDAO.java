package homework.DAO;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import homework.ConnectionFactory.ConnectionFactory;
import homework.DTO.EmployeeDetailsDTO;
import homework.DTO.EmployeeLoginDetailsDTO;

public class EmployeeAccessDAO {
	
	
	HashMap<String,EmployeeLoginDetailsDTO> userInfo;
	
	
	public EmployeeAccessDAO()
	{
		
		userInfo = new HashMap<String,EmployeeLoginDetailsDTO>();
		
	}

	
	//To get the login details from the database and populate it in the HashMap
	public void getUserLoginDetailsByDB()throws SQLException
	{
		Connection loginConn = ConnectionFactory.getConnection();
		Statement loginStmt = loginConn.createStatement();
		String sql = "select * from empinfo.logindetail";
		ResultSet loginRs = loginStmt.executeQuery(sql);
		while(loginRs.next())
		{
			String username = loginRs.getString(1);
			String password = loginRs.getString(2);
			System.out.println("username" + username + " " + password);
			//Creating the object of Employeelogindetails Class
			EmployeeLoginDetailsDTO loginObj = new EmployeeLoginDetailsDTO(username,password);
			
			// putting all the created objects in HashMap
			userInfo.put(loginObj.getUserName(),loginObj);
			
		}
		
	}
	
	
	
	public ArrayList<EmployeeDetailsDTO> getEmployeedetailsbyDB(String firstName,String lastName) throws SQLException
	{
		Connection myConn = ConnectionFactory.getConnection();
		String sql = "select * from empdetails where first_name = ? and last_name = ?";
		PreparedStatement myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, firstName);
		myStmt.setString(2, lastName);
		ResultSet myRs = myStmt.executeQuery();
		ArrayList<EmployeeDetailsDTO> empInfo = new ArrayList<>();
		while(myRs.next())
		{
			int  empId = myRs.getInt(1);
			String fname = myRs.getString(2);
			String lname = myRs.getString(3);
			double salary = myRs.getDouble(4);
			Date hiredate = myRs.getDate(5);
			String deptName = myRs.getString(6);
			
			EmployeeDetailsDTO dtoObj = new EmployeeDetailsDTO(empId, fname, lname, salary, hiredate, deptName);
			//to return more than one object u can use arraylist
		}
		
		return empInfo;
	}
	
	
	public ArrayList<EmployeeDetailsDTO> getEmployeeIdbyDB(Integer empID) throws SQLException
	{
		Connection myConn = ConnectionFactory.getConnection();
		String sql = "select * from empinfo.empdetails where emp_id = ?";
		PreparedStatement myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, empID);
		ResultSet myRs = myStmt.executeQuery();
		ArrayList<EmployeeDetailsDTO> empInfo = new ArrayList<>();
		while(myRs.next())
		{
			int  empId = myRs.getInt(1);
			String fname = myRs.getString(2);
			String lname = myRs.getString(3);
			double salary = myRs.getDouble(4);
			Date hiredate = myRs.getDate(5);
			String deptName = myRs.getString(6);
			
			EmployeeDetailsDTO dtoObj = new EmployeeDetailsDTO(empId, fname, lname, salary, hiredate, deptName);
			empInfo.add(dtoObj);
		}
		
		return empInfo;
	}
	
	
	public ArrayList<EmployeeDetailsDTO> getEmployeeDepartmentbyDB(String depName) throws SQLException
	{
		Connection myConn = ConnectionFactory.getConnection();
		String sql = "select * from empdetails where dept_name = ?";
		PreparedStatement myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, depName);
		ResultSet myRs = myStmt.executeQuery();
		ArrayList<EmployeeDetailsDTO> empInfo = new ArrayList<>();
		while(myRs.next())
		{
			int  empId = myRs.getInt(1);
			String fname = myRs.getString(2);
			String lname = myRs.getString(3);
			double salary = myRs.getDouble(4);
			Date hiredate = myRs.getDate(5);
			String deptName = myRs.getString(6);
			
			EmployeeDetailsDTO dtoObj = new EmployeeDetailsDTO(empId, fname, lname, salary, hiredate, deptName);
			empInfo.add(dtoObj);
			
			
			//to return more than one object u can use arraylist
		}
		return empInfo;
		
	}
	
	
	
	
	
	
	
	public boolean validate(String inputUsername , String inputPassword)
	{
		//System.out.println(inputUsername +"  "+ inputPassword);
		
		if(userInfo.containsKey(inputUsername))
		{
			//Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
			EmployeeLoginDetailsDTO dtoObj = userInfo.get(inputUsername);
			if((dtoObj.getPassword()).equals(inputPassword))
			{
				return true;
			}
			
		}
		
		return false;
		
	}
	
	
	
	
	
	

}
