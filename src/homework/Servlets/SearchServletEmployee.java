package homework.Servlets;


import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import homework.DAO.EmployeeAccessDAO;
import homework.DTO.EmployeeDetailsDTO;

@WebServlet("/SearchServletEmployeePath")
public class SearchServletEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String empIdStr = request.getParameter("empId");
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String deptName = request.getParameter("deptName");
		System.out.println(empIdStr);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(deptName);
		HttpSession session = request.getSession(false);
		
		EmployeeAccessDAO dao = new EmployeeAccessDAO();
		
		// To check employee records using fname and lname-----------------------------------//
		
		if(firstName.length() != 0 && lastName.length()!= 0)
		{
		  try 
		  {
			  ArrayList<EmployeeDetailsDTO> dtoEmp = dao.getEmployeedetailsbyDB(firstName,lastName);
			  session.setAttribute("employee", dtoEmp);
			  
			  if(dtoEmp.isEmpty())
			  {
				  out.println("NO RECORDS FOUND WITH THE GIVEN SEARCH");
			  }
			  else
			  {
				  
				  RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
				  rd.forward(request, response);
				 
			  }
		  } 
		  
		  
		  catch (SQLException e) 
		  {
			
			e.printStackTrace();
		  }
		
		}
		
		// To check employee records using empID-----------------------------------
		else if(empIdStr.length() != 0)
		{

			try 
			  {
				  Integer empId = Integer.parseInt(empIdStr);
				  ArrayList<EmployeeDetailsDTO> dtoEmp = dao.getEmployeeIdbyDB(empId);
				  session.setAttribute("employee", dtoEmp);
				  
				  if(dtoEmp.isEmpty())
				  {
					  out.println("NO RECORDS FOUND WITH THE GIVEN SEARCH");
				  }
				  else
				  {
					  
					  RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
					  rd.forward(request, response);
					 
				  }
			  } 
			  
			  
			  catch (SQLException e) 
			  {
				
				e.printStackTrace();
			  }
			
		}
		
		
		// To check employee records using deptName-----------------------------------
		else if(deptName.length()!= 0)
		{
			try 
			  {
				  ArrayList<EmployeeDetailsDTO> dtoEmp = dao.getEmployeeDepartmentbyDB(deptName);
				  
				  session.setAttribute("employee", dtoEmp);
				  
				  if(dtoEmp.isEmpty())
				  {
					  out.println("NO RECORDS FOUND WITH THE GIVEN SEARCH");
				  }
				  else
				  {
					  
					  RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
					  rd.forward(request, response);
					 
				  }
			  } 
			  
			  
			  catch (SQLException e) 
			  {
				e.printStackTrace();
			  }
			
		}
		
		else
		{
			out.println("Please fill any one of the feilds");
		}
		
	
	}


	

}
