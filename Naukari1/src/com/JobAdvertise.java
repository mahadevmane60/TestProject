package com;

import data.AdvertiseDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Advertise;
import org.apache.log4j.Logger;

@WebServlet(description="provides  Job Advertise titles (list)", urlPatterns={"/JobAdvertise"})
public class JobAdvertise extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  static final Logger log = Logger.getLogger(JobAdvertise.class);
  

  public JobAdvertise() {}
  
  protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    try
    {
      List<Advertise> adds = new AdvertiseDao().getAdevertise();
      if (adds.size() > 0) {
        request.setAttribute("msg", ".");
        request.setAttribute("adds", adds);
      }
      else {
        request.setAttribute("msg", "No Advertise Available yet");
      }
      request.getRequestDispatcher("jobAdvertise.jsp").forward(request, response);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}