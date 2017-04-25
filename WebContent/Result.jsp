<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ page import="homework.DAO.*" %><%@ page import="homework.DTO.*" %><%@ page import = "java.sql.SQLException"%><%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href = "bootstrap/css/bootstrap.min.css" rel= "stylesheet" type= "text/css"/>
	<link href = "bootstrap/css/style.css" rel= "stylesheet" type= "text/css"/>
	<script type="text/javascript" src="bootstrap/js/jQuery.js"></script>
	<script  src = "bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Employee Result Page</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top no-margin">
  	<div class="container-fluid">
    	<div class="navbar-header">
     	<a class="navbar-brand" href="#">Employee Space</a>
    	</div>
    	<div>
      		<ul class="nav navbar-nav">
        	<li><a href="Welcome.html">Home</a></li>
        	<li><a href="#">About</a></li> 
       	 	<li><a href="#">Contact</a></li> 
      		</ul>
      		<ul class="nav navbar-nav navbar-right">
        	<li class="active"><a href="EmpLogin.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        	<li><a href="#"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
      		</ul>
    	</div>
  	</div>
</nav>

<!-- End of the navigation bar(header of the page)-->
<% EmployeeAccessDAO dao = new EmployeeAccessDAO();%>
<div class="container">
  	<h2>Employee Information Table</h2>           
  	<table class="table">
    	<thead>
      		<tr>
        	<th>EMPID</th>
        	<th>FIRSTNAME</th>
        	<th>LASTNAME</th>
        	<th>SALARY</th>
        	<th>HIREDATE</th>
        	<th>DEPTNAME</th>
      		</tr>
    	</thead>
 
<% 
ArrayList<EmployeeDetailsDTO> arryList = (ArrayList<EmployeeDetailsDTO>)session.getAttribute("employee");
for(EmployeeDetailsDTO e: arryList)
{	  
		
	    out.println("<tbody>");
	    out.println("<tr class = info>");
	    out.println("<td> " + e.getEmpId() + "</td>");
	    out.println("<td> " + e.getFname() + "</td>");
	    out.println("<td> " + e.getLname() + "</td>");
	    out.println("<td> " + e.getSalary() + "</td>");
	    out.println("<td> " + e.getHireDate() + "</td>");
	    out.println("<td> " + e.getDeptName() + "</td>");
	    out.println("</tr>");
	    out.println("</tbody>");
}  
 %>   
    	
  </table>
</div>

<!-- End of Table-->
<div class = "navbar navbar-inverse navbar-fixed-bottom">
	<div class = "container">
	<p class = "navbar-text pull-left">@Copyright 2015</p>
	</div>
</div>
<!-- End of Footer-->

</body>
</html>