package com.miage.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miage.business.exception.CustomException;

@Controller
public class TestExceptionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestExceptionController.class);

    @RequestMapping("/error/custom")
    public String greetingError(Model model) {
    	
    	LOGGER.error("GET: /error/custom");
    	
    	throw new CustomException("Testons une CustomException");
    }
    
    @RequestMapping("/error/error")
    public String greetingError2(Model model) {
    	
    	LOGGER.error("GET: /error/error");
    	
    	throw new RuntimeException("Testons une RuntimeException");
    }

}