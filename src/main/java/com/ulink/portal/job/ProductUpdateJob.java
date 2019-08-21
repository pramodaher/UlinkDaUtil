package com.ulink.portal.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ulink.portal.service.ProductUpdateService;

@Component
public class ProductUpdateJob {
	
	@Autowired
	ProductUpdateService productUpdateService;
	
	
	//@Scheduled(fixedDelay = 1000)
	@Scheduled(cron = "0 57 09 * * ?")
	public void test() {
		
		//productUpdateService.updateStorageSystem();
		System.out.println("Hello");
	}

}
