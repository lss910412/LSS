package com.biz.common;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  

public class SendMailTest  {  
	
	public static void main(String [] args){  
		String from = "oracl@ssu.ac.kr";  
		String to = "oracl@ssu.ac.kr";  
		String host = "localhost";	//or IP address  

		//Get the session object  
		Properties properties = System.getProperties();  
		properties.setProperty("mail.smtp.host", host);  
		Session session = Session.getDefaultInstance(properties);  

		//compose the message  
		try{  
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress(from));  
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			message.setSubject("Web Mail subject .....");  
			message.setText("Hello, this is example of sending email  ");  

			// Send message  
			Transport.send(message);  
			System.out.println("message sent successfully....");  

		}catch (MessagingException e) {
			e.printStackTrace();
		}  
	}  
}  