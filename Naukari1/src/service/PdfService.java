package service;

import data.AdvertiseDao;
import data.UserDaoImpl;
import java.io.IOException;
import model.Advertise;
import model.User;
import org.apache.log4j.Logger;
import util.PdfCreator;



public class PdfService
{
  static final Logger log = Logger.getLogger(PdfService.class);
  private String email = null; private String addId = null;
  
  private String pdfPath = "\\pdf";
  private String pdfTemplate = "\\template.pdf";
  


  public PdfService(String email, String addId, String pdfPath)
  {
    this.email = email;
    this.addId = addId;
    this.pdfPath = (pdfPath + this.pdfPath);
    pdfTemplate = (pdfPath + pdfTemplate);
  }
  


  public String getPdfLink()
    throws Exception, Exception
  {
    User user = new UserDaoImpl().getUser(email);
    Advertise adv = new AdvertiseDao().getAddById(addId);
    if ((email == null) || (addId == null)) {
      throw new IOException("email and addId should not be null");
    }
    


    PdfCreator pd = new PdfCreator(pdfPath + "\\" + getPdfName(), pdfTemplate);
    pd.setPdfContents(adv.getTitle(), adv.getPosts(), adv.getEndDate(), user.getCenterName(), user.getAddress(), user.getPhno());
    pd.setPdfPassword(user.getPass());
    pd.createPdfDoc();
    


    return pdfPath + "\\" + getPdfName();
  }
  
  private String getPdfName()
  {
    return email + addId;
  }
}