package db;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
 


public class jdbcmysql {
	
	  private static Connection con = null; //Database objects 
	  
	  
	  public Connection getConnection () throws SQLException{
	 
		  try { 
			  Class.forName("com.mysql.jdbc.Driver"); 
			  con = DriverManager.getConnection( 
					"jdbc:mysql://localhost/ble_broadcast?useUnicode=true&characterEncoding=Big5", 
					"root","nccutest");   
		  }catch(SQLException e) { 
				System.out.println("Exception :"+e.toString()); 
		  } catch (ClassNotFoundException e) {
			e.printStackTrace();
		  }
		  return con;
	  }
	  
} 

