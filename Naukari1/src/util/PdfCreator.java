package util;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class PdfCreator
{
  static final Logger log = Logger.getLogger(PdfCreator.class);
  private PDDocument document = null;
  private PDPage page = null;
  private PDPageContentStream contentStream = null;
  private String docName = null;
  
  private String title = "";
  private String totalPostsValue = "";
  private String lastDateValue = "";
  private String centerName = "";
  private String address = "";
  private String ph = "";
  
  public PdfCreator(String docPathAndName, String templateName) throws InvalidPasswordException, IOException {
    docName = (docPathAndName + ".pdf");
    
    document = PDDocument.load(new File(templateName));
    

    page = document.getPage(0);
    page.setArtBox(PDRectangle.A4);
  }
  
  public void setPdfContents(String title, String posts, String lastDate, String centerName, String address, String phno)
    throws IOException
  {
    this.title = title;
    totalPostsValue = posts;
    lastDateValue = lastDate;
    this.centerName = centerName;
    this.address = address;
    ph = phno;
  }
  
  public void setPdfPassword(String password) throws IOException {
    document.protect(setPassword(password));
  }
  
  public void createPdfDoc() throws IOException
  {
    contentStream = new PDPageContentStream(document, page, true, true);
    contentStream.beginText();
    
    contentStream.setFont(PDType1Font.TIMES_ROMAN, 35.0F);
    contentStream.setLeading(70.5F);
    contentStream.newLineAtOffset(25.0F, 600.0F);
    contentStream.newLine();
    contentStream.showText(title);
    

    contentStream.setFont(PDType1Font.TIMES_ROMAN, 40.0F);
    contentStream.newLine();
    contentStream.newLine();
    contentStream.newLine();
    contentStream.showText(lastDateValue);
    contentStream.showText("              " + totalPostsValue);
    

    contentStream.setFont(PDType1Font.TIMES_ROMAN, 30.0F);
    contentStream.newLine();
    contentStream.showText(centerName);
    
    contentStream.newLine();
    contentStream.setFont(PDType1Font.TIMES_ROMAN, 30.0F);
    contentStream.newLine();
    contentStream.showText(address);
    
    contentStream.setFont(PDType1Font.TIMES_ROMAN, 40.0F);
    contentStream.newLine();
    contentStream.showText(ph);
    
    contentStream.endText();
    
    System.out.println("Content added");
    contentStream.close();
    



    document.save(docName);
    System.out.println("done...");
    document.close();
  }
  




  private StandardProtectionPolicy setPassword(String pass)
  {
    AccessPermission ap = new AccessPermission();
    StandardProtectionPolicy spp = new StandardProtectionPolicy(pass, pass, ap);
    spp.setEncryptionKeyLength(128);
    spp.setPermissions(ap);
    return spp;
  }
}