package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SellingProjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Servlet implementation class SellingProjectsAPI
 */
@WebServlet("/SellingProjectsAPI")
public class SellingProjectsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SellingProjects sellingProjectsObj = new SellingProjects();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellingProjectsAPI() {
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
		String output = sellingProjectsObj.insertProject(request.getParameter("Proj_type"), request.getParameter("Proj_name"),
				request.getParameter("Proj_link"),request.getParameter("Proj_Desc"),request.getParameter("Price"),request.getParameter("Submit_date"));
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
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = sellingProjectsObj.updateProject(paras.get("hidItemIDSave").toString(), paras.get("Proj_type").toString(),
				paras.get("Proj_name").toString(), paras.get("Proj_link").toString(), paras.get("Proj_Desc").toString(),paras.get("Price").toString(),paras.get("Submit_date").toString());
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request);
		String output = sellingProjectsObj.deleteProject(paras.get("Proj_id").toString());
		response.getWriter().write(output);
	}

}
