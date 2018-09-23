package data;

import com.SubmitAdd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Advertise;
import oracle.jdbc.OraclePreparedStatement;
import org.apache.log4j.Logger;
import util.DBConnection;
import util.DateUtil;



public class AdvertiseDao
{
  static final Logger log = Logger.getLogger(SubmitAdd.class);
  Connection con = null;
  static List<Advertise> ls = null;
  




  private static final String ALL_LIST = "select ADV_ID,ADV_TITLE,ADV_ABOUT,TOTAL_POSTS ,PAYSCALE,EDU_QUALIFICATION,AGE_LIMITS,HOW_TO_APPLY,NOTE,STARTING_DATE, LAST_DATE, ABOUT_LINK,LOCATION\r\n\t,APPLICATION_FEES, \r\n\tAUTHORISED_WEBSITE, \r\n\tSELECTION_PROCESS, \r\n\tPDF_LINK,  \r\n\tYOTUBE_LINK, \r\n\tUPDATE_DATE,\r\n\tADV_IMAGE from ADVERTISEMENT order by UPDATE_DATE";
  




  private static final String ADD_BY_ID = "select ADV_ID,ADV_TITLE,ADV_ABOUT,TOTAL_POSTS ,PAYSCALE,EDU_QUALIFICATION,AGE_LIMITS,HOW_TO_APPLY,NOTE,STARTING_DATE, LAST_DATE, ABOUT_LINK,LOCATION\r\n\t,APPLICATION_FEES, \r\n\tAUTHORISED_WEBSITE, \r\n\tSELECTION_PROCESS, \r\n\tPDF_LINK,  \r\n\tYOTUBE_LINK, \r\n\tUPDATE_DATE,\r\n\tADV_IMAGE from ADVERTISEMENT where adv_id=? order by UPDATE_DATE";
  



  PreparedStatement pst = null;
  String SUB_ADD = "insert into ADVERTISEMENT values(add_id.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  
  public AdvertiseDao() {}
  
  public boolean submitAdd(Advertise add) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ParseException { con = DBConnection.getConnection();
    pst = ((OraclePreparedStatement)con.prepareStatement(SUB_ADD));
    pst.setString(1, add.getTitle());
    pst.setString(2, add.getAbout());
    pst.setString(3, add.getPosts());
    pst.setString(4, add.getPayscale());
    pst.setString(5, add.getQualification());
    pst.setString(6, add.getAgelimit());
    pst.setString(7, add.getApply());
    pst.setString(8, add.getNote());
    pst.setDate(9, new java.sql.Date(DateUtil.getHtmlToJavaDate(add.getStartDate()).getTime()));
    pst.setDate(10, new java.sql.Date(DateUtil.getHtmlToJavaDate(add.getEndDate()).getTime()));
    pst.setString(11, add.getAboutlink());
    pst.setString(12, add.getLocation());
    pst.setString(13, add.getApplicationfees());
    pst.setString(14, add.getAuthorisedwebsite());
    pst.setString(15, add.getSelectionproccess());
    pst.setString(16, add.getPdflink());
    pst.setString(17, add.getYoutubelink());
    pst.setDate(18, new java.sql.Date(new java.util.Date().getTime()));
    pst.setString(19, add.getImage());
    log.info("adding addvertisement:  ");
    pst.execute();
    pst.close();
    con.close();
    
    return true;
  }
  
  public List<Advertise> getAdevertise() throws Exception {
    Advertise ad = null;
    ls = new ArrayList();
    con = DBConnection.getConnection();
    pst = con.prepareStatement("select ADV_ID,ADV_TITLE,ADV_ABOUT,TOTAL_POSTS ,PAYSCALE,EDU_QUALIFICATION,AGE_LIMITS,HOW_TO_APPLY,NOTE,STARTING_DATE, LAST_DATE, ABOUT_LINK,LOCATION\r\n\t,APPLICATION_FEES, \r\n\tAUTHORISED_WEBSITE, \r\n\tSELECTION_PROCESS, \r\n\tPDF_LINK,  \r\n\tYOTUBE_LINK, \r\n\tUPDATE_DATE,\r\n\tADV_IMAGE from ADVERTISEMENT order by UPDATE_DATE");
    ResultSet rs = pst.executeQuery();
    while (rs.next()) {
      ad = new Advertise();
      
      ad.setAddId(rs.getString(1));
      ad.setTitle(rs.getString(2));
      ad.setAbout(rs.getString(3));
      
      ad.setPosts(rs.getString(4));
      ad.setPayscale(rs.getString(5));
      ad.setQualification(rs.getString(6));
      ad.setAgelimit(rs.getString(7));
      ad.setApply(rs.getString(8));
      ad.setNote(rs.getString(9));
      ad.setStartDate(rs.getString(10));
      ad.setEndDate(rs.getString(11));
      ad.setAboutlink(rs.getString(12));
      ad.setLocation(rs.getString(13));
      ad.setApplicationfees(rs.getString(14));
      ad.setAuthorisedwebsite(rs.getString(15));
      ad.setSelectionproccess(rs.getString(16));
      ad.setPdflink(rs.getString(17));
      ad.setYoutubelink(rs.getString(18));
      ad.setUpdateDate(rs.getString(19));
      ad.setImage(rs.getString(20));
      ls.add(ad);
    }
    log.info("total adds: " + ls.size());
    pst.close();
    con.close();
    return ls;
  }
  
  public Advertise getAddById(String id) throws Exception {
    id = id.trim();
    Advertise ad = null;
    con = DBConnection.getConnection();
    pst = con.prepareStatement("select ADV_ID,ADV_TITLE,ADV_ABOUT,TOTAL_POSTS ,PAYSCALE,EDU_QUALIFICATION,AGE_LIMITS,HOW_TO_APPLY,NOTE,STARTING_DATE, LAST_DATE, ABOUT_LINK,LOCATION\r\n\t,APPLICATION_FEES, \r\n\tAUTHORISED_WEBSITE, \r\n\tSELECTION_PROCESS, \r\n\tPDF_LINK,  \r\n\tYOTUBE_LINK, \r\n\tUPDATE_DATE,\r\n\tADV_IMAGE from ADVERTISEMENT where adv_id=? order by UPDATE_DATE");
    pst.setString(1, id);
    ResultSet rs = pst.executeQuery();
    if (rs.next()) {
      ad = new Advertise();
      
      ad.setAddId(rs.getString(1));
      ad.setTitle(rs.getString(2));
      ad.setAbout(rs.getString(3));
      ad.setPosts(rs.getString(4));
      ad.setPayscale(rs.getString(5));
      ad.setQualification(rs.getString(6));
      ad.setAgelimit(rs.getString(7));
      ad.setApply(rs.getString(8));
      ad.setNote(rs.getString(9));
      ad.setStartDate(rs.getString(10));
      ad.setEndDate(rs.getString(11));
      ad.setAboutlink(rs.getString(12));
      ad.setLocation(rs.getString(13));
      ad.setApplicationfees(rs.getString(14));
      ad.setAuthorisedwebsite(rs.getString(15));
      ad.setSelectionproccess(rs.getString(16));
      ad.setPdflink(rs.getString(17));
      ad.setYoutubelink(rs.getString(18));
      ad.setUpdateDate(rs.getString(19));
      ad.setImage(rs.getString(20));
    }
    
    pst.close();
    con.close();
    return ad;
  }
}