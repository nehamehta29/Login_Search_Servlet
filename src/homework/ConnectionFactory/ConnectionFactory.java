package homework.ConnectionFactory;
import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection myConn = null;
	
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			myConn = DriverManager.getConnection("jdbc:mysql://localhost/empinfo","root","root");
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	public static void CloseConnection()
	{
		try
		{
			myConn.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	
	public static Connection getConnection() 
	{
		return myConn;
	}
	
	

}
