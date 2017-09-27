package com.Home;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	private Statement stm = null;
	private ResultSet result = null;
	private PreparedStatement pStatementi;
	private PreparedStatement pStatementu;
	boolean check = false;
    public Deposit() {
    	
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		try{		 
				 String amount= request.getParameter("Serial_Number");
				 java.util.Date now = new java.util.Date(); 
				 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
				 String sGMT = sf.format(now);			 
				 String createtime =sGMT;
							 				 
				 String insertdbSQL = 
				 "insert into account_table(userid,amount,deposit_time)"+ "values(?,?,?)";
				 String updatedbSQL = 
						 "UPDATE user_table SET account_amount = account_amount+ ? where id = ?";
				 
				 pStatementi = con.prepareStatement(insertdbSQL);
				 pStatementu = con.prepareStatement(updatedbSQL);
				 
				 pStatementi.setString(1, request.getSession().getAttribute("user_id").toString());
				 pStatementi.setString(2, amount);
				 pStatementi.setString(3, createtime);
				 pStatementu.setInt(1, Integer.valueOf(amount));
				 pStatementu.setString(2, request.getSession().getAttribute("user_id").toString());
				 System.out.println(updatedbSQL);
				 pStatementi.executeUpdate();		
				 pStatementu.executeUpdate();	
				 check = true;
		 } catch (SQLException e) {
			e.printStackTrace();
			}finally{
	           closedb();
	    }
		if(check==true) {		
			response.sendRedirect("DepositSuccess.jsp");
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
	           if (pStatementi != null) {
	               pStatementi.close();
	               pStatementi = null;
	           }
	           if (pStatementu != null) {
	               pStatementu.close();
	               pStatementu = null;
	           }
	       } catch (SQLException e) {
	       }
	   }
}
