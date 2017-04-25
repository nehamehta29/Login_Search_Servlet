<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href = "bootstrap/css/bootstrap.min.css" rel= "stylesheet" type= "text/css"/>
	<link href = "bootstrap/css/style.css" rel= "stylesheet" type= "text/css"/>
	<script type="text/javascript" src="bootstrap/js/jQuery.js"></script>
	<script  src = "bootstrap/js/bootstrap.min.js"></script>
<title>Search</title>
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

<div class="panel panel-default">
  <div class="panel-heading">Employee Search Information</div>
  <div class="panel-body">
 		<form method = "post" action = "SearchServletEmployeePath" role = "form">
			<div class="form-group">
    		<label for="fname">FirstName</label>
    		<input type="text" class="form-control" id="fname" placeholder="FirstName" name = "fname">
  			</div>
  			<div class="form-group">
    		<label for="lname">LastName</label>
    		<input type="text" class="form-control" id="lname" placeholder="LastName" name = "lname">
  			</div>
  			<p>OR</p>
  			<div class="form-group">
    		<label for="empId">EmpID</label>
    		<input type="text" class="form-control" id="empId" placeholder="EmpID" name = "empId">
  			</div>
  			<p>OR</p>
  			<div class="form-group">
    		<label for="DeptName">DeptName</label>
    		<input type="text" class="form-control" id="DeptName" placeholder="DeptName" name = "deptName">
  			</div>
  			
  			<div class="container pull-left no-padding">    
  			<input type="submit" class="btn btn-success" name = "submit" value = "Search"/>
			</div>
  		</form>
  	</div>
 </div>
 
<div class = "navbar navbar-inverse navbar-fixed-bottom">
	<div class = "container">
	<p class = "navbar-text pull-left">@Copyright 2015</p>
	</div>
</div>

</body>
<!-- End of the Search form -->
</html>