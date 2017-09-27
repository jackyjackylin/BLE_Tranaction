package com.Home;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class AccountTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null; 
	
	
	public void init(ServletConfig config)
			throws ServletException{
	}
	
    public AccountTable() {
    	try { 		    
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection( 
					"jdbc:mysql://140.119.163.23/ble_transaction?useUnicode=true&characterEncoding=Big5", 
					"admin","nccutest");   
		}catch(ClassNotFoundException e) 
		{ 
			System.out.println("DriverClassNotFound :"+e.toString()); 
		}
		catch(SQLException e) { 
			System.out.println("Exception :"+e.toString()); 
		} 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			List<String> dataList = new ArrayList<String>();
			Statement stm = con.createStatement();
			ResultSet result = stm.executeQuery("select * from account_table");
			while(result.next()){				
				if(result.getString("userid").equals(request.getSession().getAttribute("user_id"))){
					dataList.add(result.getString("userid"));
			        dataList.add(result.getString("amount"));
					dataList.add(result.getString("deposit_time"));
				}
			}
			result.close();
			stm.close();
			request.setAttribute("data",dataList);
			RequestDispatcher rd = request.getRequestDispatcher("/AccountTable.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			System.out.println("Exception is ;"+e);
		}	
	}

}
