package com;

import com.oreilly.servlet.MultipartRequest;
import data.AdvertiseDao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Advertise;
import org.apache.log4j.Logger;

@WebServlet({"/SubmitAdd"})
public class SubmitAdd extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  static final Logger log = Logger.getLogger(SubmitAdd.class);
  
  public SubmitAdd() {}
  
  protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException
  {
    PrintWriter pw = response.getWriter();
    try {
      String IMG_PATH = getServletContext().getRealPath("/addimages");
      
      MultipartRequest request = new MultipartRequest(req, IMG_PATH);
      
      String title = request.getParameter("title");
      
      String about = request.getParameter("about");
      String posts = request.getParameter("posts");
      String payscale = request.getParameter("payscale");
      String qualification = request.getParameter("qualification");
      String agelimit = request.getParameter("agelimit");
      String apply = request.getParameter("apply");
      String note = request.getParameter("note");
      String startdate = request.getParameter("startdate");
      String enddate = request.getParameter("enddate");
      String aboutlink = request.getParameter("aboutlink");
      String location = request.getParameter("location");
      String applicationfees = request.getParameter("applicationfees");
      String authorisedwebsite = request.getParameter("authorisedwebsite");
      String selectionproccess = request.getParameter("selectionproccess");
      String pdflink = request.getParameter("pdflink");
      String youtubelink = request.getParameter("youtubelink");
      String image = request.getFile("image").getName();
      Advertise add = new Advertise(title, about, posts, payscale, qualification, agelimit, apply, 
        note, startdate, enddate, aboutlink, location, applicationfees, authorisedwebsite, 
        selectionproccess, pdflink, youtubelink, image);
      log.info(add);
      if (new AdvertiseDao().submitAdd(add)) {
        log.info(" successfully added advetisement ");
        pw.write("added succesfully...");
        pw.flush();
        pw.close();
      }
      
      log.info(" successfully added advetisement2 ");
    } catch (Exception e) {
      pw.write("Error in submiting add: " + e.getMessage());
      pw.flush();
      pw.close();
      log.error(e.getMessage());
      e.printStackTrace();
    }
  }
}