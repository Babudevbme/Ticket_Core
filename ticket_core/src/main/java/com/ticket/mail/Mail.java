package com.ticket.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Mail {
	private Mail() {
	}

	// User mail
	

	public static void sendSimpleMail(String mail, String message, String solution) throws EmailException {
		Email email = new SimpleEmail();
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("babudevkvcet@gmail.com", "babudev7"));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		email.setSSLOnConnect(true);
		email.setFrom("babudevkvcet@gmail.com");
		email.setSubject("Ticket Management System");
		email.setMsg("ticket" + "" + "created");
		email.addTo("babudev95@gmail.com");
		email.setStartTLSEnabled(true);
		email.send();

	}

	
	

}
