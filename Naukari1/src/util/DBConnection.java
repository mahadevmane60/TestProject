package util;

import java.sql.Connection;
import org.apache.log4j.Logger;

public class DBConnection
{
  private static Connection con = null;
  static final String DB_USER = "system";
  static final String DB_PASS = "sangola";
  static final String CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521/XE";
  static final Logger log = Logger.getLogger(DBConnection.class);
  
  public DBConnection() {}
  
  public static Connection getConnection() {
    try { Class.forName("oracle.jdbc.driver.OracleDriver");
      con = java.sql.DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "sangola");
      log.info("Connection success");
      return con;
    }
    catch (Exception e) {
      log.error("Connection error: " + e.getMessage()); }
    return null;
  }
}