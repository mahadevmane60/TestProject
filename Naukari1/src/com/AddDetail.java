package com;

import data.AdvertiseDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Advertise;
import model.User;
import org.apache.log4j.Logger;
import service.PdfService;

@WebServlet({"/AddDetail"})
public class AddDetail extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  static final Logger log = Logger.getLogger(AddDetail.class);
  
  public AddDetail() {}
  
  protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String addId = request.getParameter("addid");
    User user = (User)request.getSession().getAttribute("user");
    Advertise add = null;
    PdfService ps = null;
    String pdfPath = getServletContext().getRealPath("/");
    if (addId != null) {
      try {
        addId = addId.trim();
        
        add = new AdvertiseDao().getAddById(addId);
        ps = new PdfService(user.getEmail(), addId, pdfPath);
        add.setPdflink(ps.getPdfLink());
        log.info(ps.getPdfLink());
        if (add == null) return;
        log.info("Add available: " + add);
        
        request.setAttribute("add", add);
        request.getRequestDispatcher("addDetail.jsp").forward(request, response);

      }
      catch (Exception e)
      {
        log.error(e.getMessage());
        e.printStackTrace();
        response.sendRedirect("JobAdvertise");
      }
      
    } else {
      response.sendRedirect("JobAdvertise");
    }
  }
}