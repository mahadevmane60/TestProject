package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import data.AdvertiseDao;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/SubmitAdd")

public class SubmitAdd extends HttpServlet {

	private static final long serialVersionUID = 1L;
	final static Logger log = Logger.getLogger(SubmitAdd.class);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String title, about, posts, payscale, qualification, agelimit, apply, note, startdate, enddate, aboutlink,
				location, applicationfees, authorisedwebsite, selectionproccess, pdflink, youtubelink, image;
		PrintWriter pw = response.getWriter();
		try {
			String IMG_PATH = getServletContext().getRealPath("/addimages");

			MultipartRequest request = new MultipartRequest(req, IMG_PATH);

			title = request.getParameter("title");

			about = request.getParameter("about");
			posts = request.getParameter("posts");
			payscale = request.getParameter("payscale");
			qualification = request.getParameter("qualification");
			agelimit = request.getParameter("agelimit");
			apply = request.getParameter("apply");
			note = request.getParameter("note");
			startdate = request.getParameter("startdate");
			enddate = request.getParameter("enddate");
			aboutlink = request.getParameter("aboutlink");
			location = request.getParameter("location");
			applicationfees = request.getParameter("applicationfees");
			authorisedwebsite = request.getParameter("authorisedwebsite");
			selectionproccess = request.getParameter("selectionproccess");
			pdflink = request.getParameter("pdflink");
			youtubelink = request.getParameter("youtubelink");
			image = request.getFile("image").getName();
			model.Advertise add = new model.Advertise(title, about, posts, payscale, qualification, agelimit, apply,
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
