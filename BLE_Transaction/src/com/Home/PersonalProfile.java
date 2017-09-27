package com.Home;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonalProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	public void init(ServletConfig config)
			throws ServletException{
	}
	public PersonalProfile() {
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
			Statement stm = con.createStatement();

			ResultSet result = stm.executeQuery("select * from user_table");

			String identity="";
			String account_amount="";
			String id=""; 
			String username="";
			String useremail="";
			String usercardnum="";
			String createtime="";
			while(result.next()){
				useremail = result.getString("user_email");
				
				if(useremail.equals(request.getSession().getAttribute("user"))){
					id = result.getString("id");
					username = result.getString("user_name");
					useremail = result.getString("user_email");
					usercardnum = result.getString("user_cardnum");
					createtime = result.getString("create_time");
					identity = result.getString("user_category");
					account_amount = result.getString("account_amount");
					if( identity.equals("0")){
						identity = "Root";
					}else if(identity.equals("1")){
						identity = "Buyer";
					}else if(identity.equals("2")){
						identity = "Store";
					}
					break;
				}		
			}
			request.setAttribute("id",id);
			request.setAttribute("username",username);
			request.setAttribute("useremail",useremail);
			request.setAttribute("identity",identity);
			request.setAttribute("usercardnum",usercardnum);
			request.setAttribute("accountamount",account_amount);
			request.setAttribute("createtime",createtime);

			result.close ();
			stm.close ();
			RequestDispatcher rd = request.getRequestDispatcher("/PersonalProfile.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			System.out.println("Exception is ;"+e);
		}
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
