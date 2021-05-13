<%@page import="model.SellingProjects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/mainProjects.js"></script>
<meta charset="ISO-8859-1">
<title>Selling Projects Service</title>

<style>
.h1{
	font-family: "Lucida Console", "Courier New", monospace;
}
.name{
	border-left: 6px solid #43BFC7;
  background-color: #E5E4E2;
  width:500px;
}
.btn{
	 background-color: #3090C7;
	margin-top: 20px;
	width:500px;
	font-family: "Lucida Console", "Courier New", monospace;
}
.text{
font-family: "Lucida Console", "Courier New", monospace;
	
}
</style>
</head>
<body>

<div class="container"><div class="row"><div class="col-6">
<h1 class="h1" >Projects</h1>
<form id="formProjects" name="formProjects">

<div class = "text">Project Type:</div>
<input id="Proj_type" name="Proj_type" type="text"
 class="name">
 
<br> <div class = "text">Project Name:</div>
<input id="Proj_name" name="Proj_name" type="text"
class="name">
 
<br><div class = "text"> Project link:</div>
<input id="Proj_link" name="Proj_link" type="text"
class="name">
 
 <br> <div class = "text">Project Description:</div>
 <input id="Proj_Desc" name="Proj_Desc" type="text"
  class="name">
 
 <br><div class = "text"> Project Price:</div>
 <input id="Price" name="Price" type="text"
  class="name">
 
 <br> <div class = "text">Submit Date:</div>
 <input id="Submit_date" name="Submit_date" type="text"
  class="name">
 <br>
 
 <input id="btnSave" name="btnSave" type="button" value="Save"
 class="btn">
 <input type="hidden" id="hidItemIDSave"
 name="hidItemIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divItemsGrid">
 <%
 SellingProjects sellingProjectsObj = new SellingProjects();
 out.print(sellingProjectsObj.readProjects());
 %>
</div>
</div> </div> </div>

</body>
</html>