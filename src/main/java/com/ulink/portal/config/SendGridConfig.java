package com.ulink.portal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.sendgrid.SendGrid;

@Configuration

public class SendGridConfig {
	
    @Value("${mail.password}") 
    String sendGridAPIKey;
    
    @Bean
    public SendGrid sendGrid() {
    	return new SendGrid(sendGridAPIKey);
    }
 

}
