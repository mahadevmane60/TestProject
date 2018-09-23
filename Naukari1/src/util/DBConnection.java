package util;
import java.sql.*;

import org.apache.log4j.Logger;

public class DBConnection {
   static private Connection con = null;
   static final String DB_USER = "system";
   static final String DB_PASS = "sangola";
   static final String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521/XE";
   final static Logger log = Logger.getLogger(DBConnection.class); 
	public static Connection getConnection(){
		try{
		
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   con = DriverManager.getConnection(CONNECTION_URL,DB_USER,DB_PASS); 
		   log.info("Connection success");
		}catch(Exception e){System.out.println("Error in connection: "+e.getMessage());
	    	e.printStackTrace();
	    	log.error("Connection error: "+e.getMessage());
		}
		return con;
	}
	
}
