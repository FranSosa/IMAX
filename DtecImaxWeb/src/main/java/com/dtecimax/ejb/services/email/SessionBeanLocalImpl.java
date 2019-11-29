package com.dtecimax.ejb.services.email;

import java.util.Properties;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless 
public class SessionBeanLocalImpl implements SessionBeanLocal {


	@Override
	public void sendEmail(String pTo
			            , String pSubject
			            , String pBody
			            ) {
		
		    System.out.println("pTo:"+pTo);
		    System.out.println("pSubject:"+pSubject);
		    System.out.println("pBody:"+pBody);
		    
		    Properties properties = new Properties();
	        properties.put("mail.smtp.auth","true");
	        properties.put("mail.smtp.starttls.enable","true");
	        properties.put("mail.smtp.host","smtp.gmail.com");
	        properties.put("mail.smtp.port","587");
	        Session session = Session.getInstance(properties,new javax.mail.Authenticator(){
	                                                        protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
	                                                         return new javax.mail.PasswordAuthentication ("daglr029@gmail.com","Aguilar.304");
	                                                        }
	                                                        }
	                                               );
	       Message message = new MimeMessage(session);

	        try {
	            message.setFrom( new InternetAddress("daglr029@gmail.com"));
	            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(pTo));
	            message.setSubject(pSubject);
	            message.setText(pBody);
	            Transport.send(message);
	        } catch (MessagingException me) {
	            System.out.println("MessagingException:"+me.getMessage());
	        }
	        
	}

}
