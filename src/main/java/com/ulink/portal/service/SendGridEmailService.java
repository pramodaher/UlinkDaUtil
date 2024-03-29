package com.ulink.portal.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service
public class SendGridEmailService {
	
	private static final Logger log = LoggerFactory.getLogger(SendGridEmailService.class);

	@Autowired
	private SendGrid sendGridClient;

	public void sendText(String from, String to, String subject, String body) {
		Response response = sendEmail(from, to, subject, new Content("text/plain", body));
		if(response==null) {
			log.error("Unable to send email");
		}
	}

	public void sendHTML(String from, String to, String subject, String body) {
		Response response = sendEmail(from, to, subject, new Content("text/html", body));
		if(response==null) {
			log.error("Unable to send email");
		}	
	}

	private Response sendEmail(String from, String to, String subject, Content content) {
		Mail mail = new Mail(new Email(from), subject, new Email(to), content);
		mail.setReplyTo(new Email("pramodaher33@hotmail.com"));
		Request request = new Request();
		Response response = null;
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			response=this.sendGridClient.api(request);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}
}