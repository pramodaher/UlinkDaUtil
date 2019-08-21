package com.ulink.portal.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ulink.portal.service.GenrateData;
import com.ulink.portal.service.ProductUpdateService;

@RestController
public class GenrateDataController {
	
	@Autowired
	GenrateData genrateData;
	
	@Autowired
	ProductUpdateService productUpdateService;
	
	@GetMapping("/")
	public String genrateData()throws Exception {
		genrateData.genrate(1);
		//productUpdateService.updateStorageSystem();
		
		return "dataGenrate sucesfully";
		
	}

}
