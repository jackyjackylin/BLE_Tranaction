package com.Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	private ResultSet result = null;
	private Statement stm = null;
	  
	private PreparedStatement pStatement;
	boolean checkregister = false;
    String duseremail = "";
    String user_email  = "";
    public RegisterServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		 		
		try{		 			
				 String id = UUID.randomUUID().toString();
				 String user_name= request.getParameter("username");
				 String user_password = request.getParameter("password");
				 user_email = request.getParameter("email");
				 String user_cardnum = request.getParameter("IDnumber");
				 java.util.Date now = new java.util.Date(); //取得現在時間
				 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
				 String sGMT = sf.format(now);			 
				 String createtime =sGMT;
				 String user_category = request.getParameter("category");
				 				 
				 String insertdbSQL = 
				 "insert into user_table(id,user_name,user_password,user_email,user_cardnum,create_time,user_category)"
				 + "values(?,?,?,?,?,?,?)";
				 pStatement = con.prepareStatement(insertdbSQL);
				 
				 pStatement.setString(1, id);
				 pStatement.setString(2, user_name);
				 pStatement.setString(3, user_password);
				 pStatement.setString(4, user_email);
				 pStatement.setString(5, user_cardnum);
				 pStatement.setString(6, createtime);
				 pStatement.setString(7, user_category);
				 
				 System.out.println(insertdbSQL);
				 pStatement.executeUpdate();		
				 checkregister = true;
				 
					
		 } catch (SQLException e) {
			e.printStackTrace();
			}finally{
	            closedb();
	     }
		if(checkregister==true) {		
			response.sendRedirect("RegisterSuccess.jsp");
		} else {
			response.sendRedirect("");
		}
	}
	 public void closedb(){
	        try {
	        	if(con!=null){
	        		con.close();
	        		con = null;
	        	}
	            if (result!=null){
	                result.close();
	                result = null;
	            }
	            if (stm != null) {
	            	stm.close();
	            	stm = null;
	            }
	            if (pStatement != null) {
	                pStatement.close();
	                pStatement = null;
	            }
	        } catch (SQLException e) {
	            //System.out.println(e);
	        }
	    }
}
