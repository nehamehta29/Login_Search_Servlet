package homework.Servlets;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework.DAO.EmployeeAccessDAO;

@WebServlet("/LoginServletEmployeePath")
public class LoginServletEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		
		
		EmployeeAccessDAO dao = new EmployeeAccessDAO();
		try 
		{
			dao.getUserLoginDetailsByDB();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		if(dao.validate(username, password))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Search.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("Invalid Username and Password");
		}
		
		
	}

}
