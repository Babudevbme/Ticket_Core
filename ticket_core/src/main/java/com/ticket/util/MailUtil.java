package com.ticket.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class MailUtil {
	public static void sendSimpleMail( String emailId,int id,String sub) throws Exception {
		Email email = new SimpleEmail();
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator(MailConstants.MAIL_ID, MailConstants.PASSWORD));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		email.setFrom(MailConstants.MAIL_ID);
		email.setSubject("Hi");
		email.setMsg("You Created Ticket:User ID:"+id+" ,"+"Subject :"+sub);
		email.addTo(emailId);
		email.setStartTLSEnabled(true);
		email.send();
		System.out.println("Mail sent!");
	}

	
}
