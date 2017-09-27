package com.Home;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class TransactionTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	
	
	public void init(ServletConfig config)
			throws ServletException{
	}
	public TransactionTable() {
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
			ResultSet result = stm.executeQuery("select * from transaction_table");			
			while(result.next()){				
				if("0".equals(request.getSession().getAttribute("user_category")))
				{
					dataList.add(result.getString("id"));
			        dataList.add(result.getString("store_id"));
					dataList.add(result.getString("buyer_id"));
					dataList.add(result.getString("amount"));			    
			        dataList.add(result.getString("transaction_time"));			
				}
				else if(result.getString("buyer_id").equals(request.getSession().getAttribute("user_id"))
						&&"1".equals(request.getSession().getAttribute("user_category"))){
					dataList.add(result.getString("id"));
			        dataList.add(result.getString("store_id"));
					dataList.add(result.getString("buyer_id"));
					dataList.add(result.getString("amount"));			    
			        dataList.add(result.getString("transaction_time"));						
				}else if(result.getString("store_id").equals(request.getSession().getAttribute("user_id"))
						&&"2".equals(request.getSession().getAttribute("user_category"))){
					dataList.add(result.getString("id"));
			        dataList.add(result.getString("store_id"));
					dataList.add(result.getString("buyer_id"));
					dataList.add(result.getString("amount"));			    
			        dataList.add(result.getString("transaction_time"));	
				}			
			}
			result.close();
			stm.close();
			request.setAttribute("data",dataList);
			RequestDispatcher rd = request.getRequestDispatcher("/TransactionTable.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			System.out.println("Exception is ;"+e);
		}
	}	

}


