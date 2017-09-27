package com.Login;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.sql.*;

public class LoginServlet extends HttpServlet {
	private Connection con = null;
	private static final long serialVersionUID = 1L;	
	String resultt="";
	String resulttt="";
	boolean chklogin = false;
	
	public LoginServlet() {
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
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String passwd = request.getParameter("password");
		String duseremail = "";
	    String duserpassword = "";
	    String user_id ="";
		String user_category="";
	    boolean chklogin = false;
	 
		try{
			Statement stm = con.createStatement();
		    ResultSet result = stm.executeQuery("select * from user_table");
	    	HttpClient client = new DefaultHttpClient();
		    HttpPost post = new HttpPost("http://140.119.163.23:8080/BLE_Transcation/services/LoginApi");
		    HttpResponse responsep = client.execute(post);
		    HttpEntity resEntite = responsep.getEntity();
		    resulttt = EntityUtils.toString(resEntite);
		    System.out.print(resulttt);
		  	HttpClient clientt = new DefaultHttpClient();
		    HttpGet get = new HttpGet("http://140.119.163.23:8080/BLE_Transcation/services/LoginApi");
		    HttpResponse responsee = clientt.execute(get);
		    HttpEntity resEntity = responsee.getEntity();
		    resultt = EntityUtils.toString(resEntity);
		    System.out.print(resultt);
		    
		    while(result.next()){
		        duseremail = result.getString("user_email");
		        duserpassword = result.getString("user_password");	 
		        if((user.equals(duseremail)) && (passwd.equals(duserpassword))){
		          chklogin = true;
		          user_id = result.getString("id");
		          user_category = result.getString("user_category");
		          break;
		        }
		    }
		    result.close();
		    stm.close();
			if(chklogin==true) {		
				HttpSession  session =request.getSession();
				session.setAttribute("user_category",user_category);
				session.setAttribute("user_id",user_id);
				session.setAttribute("user", user);
				request.getRequestDispatcher("Home.jsp").forward(request, response);  
				
			} else {
				response.sendRedirect("");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
