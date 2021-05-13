<%@page import="model.SellingItems"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/mainItems.js"></script>
<meta charset="ISO-8859-1">
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
<title>Selling Items Service</title>
</head>
<body>

<div class="container"><div class="row"><div class="col-6">
<h1 class="h1">Handy Craft Items</h1>
<form id="formItem" name="formItem">

 <div class = "text">Item Name:</div>
 <input id="Item_Name" name="Item_Name" type="text"
  class="name">
 
 
 <br> <div class = "text">Item Descriptiion:</div>
 <input id="Item_Desc" name="Item_Desc" type="text"
 class="name">
 <br> <div class = "text">Item Price:</div>
 <input id="Item_price" name="Item_price" type="text"
 class="name">
 <br> <div class = "text">Stock_Qty:</div>
 <input id="Stock_qty" name="Stock_qty" type="text"
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
 SellingItems SellingItemsObj = new SellingItems();
 out.print(SellingItemsObj.readItem());
 %>
</div>
</div> </div> </div>

</body>
</html>