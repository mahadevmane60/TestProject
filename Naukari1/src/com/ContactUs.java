
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactUs extends HttpServlet {

  String name=null,city=null,subject=null,phnumber=null;
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        try{
        
        name = request.getParameter("name");
        city = request.getParameter("city");
        subject = request.getParameter("subject");
        phnumber  = request.getParameter("phnumber");
        if(name==null || city==null || subject == null|| phnumber == null){
          response.sendRedirect("contactus.jsp");
        }
        name = name.replace(",", "\"");
        city = city.replace(",", "\""); 
        subject = subject.replace(",", "\""); 
        phnumber = phnumber.replace(",", "\""); 
        
        model.ContactUs con = new model.ContactUs();
        con.setName(name);
        con.setCity(city);
        con.setPhnumber(phnumber);
        con.setSubject(subject);
        System.err.println("Contact us: "+con);
        if(new data.ContactUsDaoImpl().saveContactUS(con)){
            System.err.println("Contactus Success");
        }
            
        pw.print("success");
        pw.flush();
        pw.close();
        }catch(Exception e) {
            System.err.println(" Error:  "+e.getMessage());
           // e.printStackTrace();
            pw.write("fail");
            pw.flush();
            pw.close();
        }
    }
    
    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
           response.sendRedirect("index.jsp");
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
   }

}
