package com.ulink.portal.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ulink.portal.dto.Response;


@RestController
public class EmailUtilController {
	

	@Autowired
	com.ulink.portal.service.SendGridEmailService sendGridEmailService;

	@PostMapping(
			path = {"/send-email"},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> sendEmail()
	{
		final String from="pramodaher33@hotmail.com";
		final String to="apramod@agsft.com";
		final String subject="SendGridFirestMail";
		final String body="Hii how are you";
		 sendGridEmailService.sendText(from,to ,subject ,body );
		return ResponseEntity.ok(new Response(200, true, "Email send sucessfully", null));
	}
}
