package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SellingItems {
	
	//A common method to connect to the DB
		private Connection connect()
		{
			Connection con = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");

				//Provide the correct details: DBServer/DBName, username, password
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gadgetbadget", "root", "sachi123");
			}
			catch (Exception e)
			{e.printStackTrace();}
			return con;
		} 
			
		//insert items
		public String insertItem(String Item_Name, String Item_Desc, String Item_price,String Stock_qty)
		{
			String output = "";
			
			//validation
			//int stockqty=0;
			
			//check fields are empty
			//if(Item_Name.isEmpty() || Item_Desc.isEmpty() || Item_price.isEmpty() || Stock_qty.isEmpty()) {
				//output = "cannot empty!";
			//}
			//stock qty cannot be zero
			//if(!(Integer.parseInt(Stock_qty) > stockqty)) {
				//output="cannot inserted!";
				
			//}
			//price shold be grater than 100
			//else if(Item_price.length() < 3) {
				//output ="price should greater than 100!";
			//}
			//else {
			try
			{
				Connection con = connect();
					
					if (con == null)
						{
							return "Error while connecting to the database for inserting."; 
						}
					
				// create a prepared statement
				String query = " insert into items (`Item_id`,`Item_Name`,`Item_Desc`,`Item_price`,`Stock_qty`) values (?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				
					
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, Item_Name);
				preparedStmt.setString(3, Item_Desc);
				preparedStmt.setDouble(4, Double.parseDouble(Item_price));
				preparedStmt.setInt(5,Integer.parseInt(Stock_qty));
					
					
				// execute the statement
				preparedStmt.execute();
				con.close();
				String newItems = readItem();
				 output = "{\"status\":\"success\", \"data\": \"" +
				 newItems + "\"}";
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
				 System.err.println(e.getMessage()); 
			}
				
				return output;
		}
			
		//read items
		public String readItem()
		{
			String output = "";
			try
			{
				Connection con = connect();
					if (con == null)
						{
							return "Error while connecting to the database for reading."; 
						}
				 
				 // Prepare the html table to be displayed
				 output = "<table border='1'><tr><th class='bg-info'>ItemName</th><th class='bg-info'>ItemDescription</th>" +
				 "<th class='bg-info'>ItemPrice</th>" +
				 "<th class='bg-info'>StockQty</th>" +
				 "<th class='bg-info'>Update</th><th class='bg-info'>Remove</th></tr>";
			
				 String query = "select * from items";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 
				 	// iterate through the rows in the result set
				 	while (rs.next())
				 	{
						 String Item_id = Integer.toString(rs.getInt("Item_id"));
						 String Item_Name = rs.getString("Item_Name");
						 String Item_Desc = rs.getString("Item_Desc");
						 String Item_price = Double.toString(rs.getDouble("Item_price"));
						 String Stock_qty  = Integer.toString(rs.getInt("Stock_qty"));
						
					 
						 // Add into the html table
						 output += "<tr class='table-secondary' ><td>" + Item_Name + "</td>";
						 output += "<td>" + Item_Desc + "</td>";
						 output += "<td>" + Item_price + "</td>";
						 output += "<td>" + Stock_qty + "</td>";
						 
						 
						 // buttons
						 output += "<td ><input name='btnUpdate' type='button' value='Update' "
								 + "class='btnUpdate  bg-success' data-itemid='" + Item_id + "'></td>"
								 + "<td><input name='btnRemove' type='button' value='Remove' "
								 + "class='btnRemove bg-danger' data-itemid='" + Item_id + "'></td></tr>";
								  } 
						con.close();
						// Complete the html table
						output += "</table>";
			 }
			 catch (Exception e)
			 {
				 output = "Error while reading the items.";
				 System.err.println(e.getMessage());
			 }
			 	return output;
			 } 
			
		 //update items
		 public String updateItem(String Item_id,String Item_Name, String Item_Desc, String Item_price, String Stock_qty)
		 {
			 String output = "";
			 try
			 {
				 Connection con = connect();
				 	if (con == null)
					{
				 		return "Error while connecting to the database for updating."; 
					}
					 
				 // create a prepared statement
					 
				 String query = "UPDATE items SET Item_Name=?,Item_Desc=?,Item_price=?,Stock_qty=? WHERE Item_id=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 
				 // binding values
				
				 preparedStmt.setString(1, Item_Name);
				 preparedStmt.setString(2, Item_Desc);
				 preparedStmt.setDouble(3, Double.parseDouble(Item_price));
				 preparedStmt.setInt(4, Integer.parseInt(Stock_qty));
				 preparedStmt.setInt(5, Integer.parseInt(Item_id));
				 
				
				 // execute the statement
				 preparedStmt.execute();
				 con.close();
				 String newItems = readItem();
				 output = "{\"status\":\"success\", \"data\": \"" +
				 newItems + "\"}";
			 }
			 catch (Exception e)
			 {
				 output = "{\"status\":\"error\", \"data\":\"Error while updating the item.\"}";
				 System.err.println(e.getMessage());
			 }
				 return output;
		}
		
		//delete items
		public String deleteItem(String Item_id)
		{
			String output = "";
			try
			{
				Connection con = connect();
					if (con == null)
					{
						return "Error while connecting to the database for deleting."; 
					}
				// create a prepared statement
				String query = "delete from items where Item_id=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
			 
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(Item_id));
			 
				// execute the statement
				preparedStmt.execute();
				con.close();
				String newItems = readItem();
				 output = "{\"status\":\"success\", \"data\": \"" +
				 newItems + "\"}"; 
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\":\"Error while deleting the item.\"}";
				System.err.println(e.getMessage());
			}
				return output;
			} 
		
		
	


}
