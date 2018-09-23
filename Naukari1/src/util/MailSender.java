	package util;

	import java.util.Properties;
	import javax.mail.Message;
	import javax.mail.Message.RecipientType;
	import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;
	import org.apache.log4j.Logger;




	public class MailSender
	{
	  static final Logger log = Logger.getLogger(MailSender.class);
	  static final String user = "online-seva@hotmail.com";
	  
	  public MailSender() {}
	  
	  public boolean sendmail(String body, String subject, String to) throws Exception { Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.live.com");
	    props.put("mail.smtp.port", "25");
	    
	    Session session = Session.getInstance(props,
	  		  new javax.mail.Authenticator() {
	  			protected PasswordAuthentication getPasswordAuthentication() {
	  				return new PasswordAuthentication(user, password);
	  			}
	  		  });
	  	

	    try
	    {
	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress("online-seva@hotmail.com"));
	      message.setRecipients(Message.RecipientType.TO, 
	        InternetAddress.parse(to));
	      message.setSubject(subject);
	      message.setText(body);
	      Transport.send(message);
	      log.info("Mail sent to " + to);
	      return true;
	    } catch (MessagingException e) {
	      log.error(e.getMessage() + " : " + to); }
	    return false;
	  }
	  
	  static final String password = "Swapnil@1993";
	}