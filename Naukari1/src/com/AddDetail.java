package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import data.AdvertiseDao;
import model.Advertise;

@WebServlet("/AddDetail")
public class AddDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger log = Logger.getLogger(AddDetail.class); 
    public AddDetail() {
        super();
     
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String addId = request.getParameter("addid"); 
		if(addId!=null) {
	    try {
			Advertise add = new AdvertiseDao().getAddById(addId);
			if(add!=null) {
				log.info("Add available: "+add);
				
			  request.setAttribute("add", add);	
			  request.getRequestDispatcher("addDetail.jsp").forward(request, response);
			}
			else {
				  log.info("Add not available: "+addId);
				  request.setAttribute("msg", "alert(\"No such job ID\")");	
				  request.getRequestDispatcher("addDetail.jsp").forward(request, response);	
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
			response.sendRedirect("JobAdvertise");
		}		
		}
		else {
			response.sendRedirect("JobAdvertise");
		}
	}


}
