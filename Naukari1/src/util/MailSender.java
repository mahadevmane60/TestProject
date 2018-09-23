package util;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
/*
 * Compatible with only hotmail server.
 * parm sequence body, subject, to
 */
 
 
public class MailSender {
	static final String user = "mahadevmane60@hotmail.com"; 
	static final String password = "M@h@dev70";
	public boolean sendmail(String body,String subject,String to) throws Exception {
	
		Properties props = new Properties();
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

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);
			System.out.println("Mail sent to "+to);
			return true;
		} catch (MessagingException e) {
			return false;
		}
	}
	
}
