package com.miage.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	
    	LOGGER.info("GET: /hello");
    
        model.addAttribute("name", name);
        return "hello";
    }
}