package com;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SellingItems;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Servlet implementation class SellingItemsAPI
 */
@WebServlet("/SellingItemsAPI")
public class SellingItemsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SellingItems SellingItemsObj = new SellingItems();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellingItemsAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = SellingItemsObj.insertItem(request.getParameter("Item_Name"), request.getParameter("Item_Desc"),
				request.getParameter("Item_price"),request.getParameter("Stock_qty"));
		response.getWriter().write(output);
	}
	
	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}
	


	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		String output = SellingItemsObj.updateItem(paras.get("hidItemIDSave").toString(), paras.get("Item_Name").toString(),
				paras.get("Item_Desc").toString(), paras.get("Item_price").toString(), paras.get("Stock_qty").toString());
		response.getWriter().write(output);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request);
		String output = SellingItemsObj.deleteItem(paras.get("Item_id").toString());
		response.getWriter().write(output);
	}

}
