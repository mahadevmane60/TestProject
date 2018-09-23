
package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    
   static int add(){
     try{
          System.err.println("in try");
        }catch(Exception e){
          return 2;
        }
        finally{
            System.out.println("in finally");
            return 3;
        }
     
   }
    
    public static void main(String[] args) throws SQLException  {
       
        System.out.println("Done "+add());
    }
}
