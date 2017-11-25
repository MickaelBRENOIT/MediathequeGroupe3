package com.miage.web.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miage.business.entity.Product;
import com.miage.business.service.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public String productList(Model model) {
		
		// find all products
		model.addAttribute("products", productService.findAll());
		
		// return view products list
		return "product/list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String productCreate(Model model) {
		
		// create product and add it to the form model
		model.addAttribute("product", new Product());
		
		// return view form
		return "product/form";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String productCreateSubmit(@ModelAttribute @Valid Product product, BindingResult bindingResult) {
		
		// check if form is valid before save, according to annotations in entity product
		if (bindingResult.hasErrors()) {
			
			// return view form
            return "product/form";
        }
		
		// save product
		productService.save(product);
		
		// redirect to route /product
		return "redirect:/product";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String productEdit(@PathVariable("id") Long id, Model model) {
		
		// find existing product and add it to the form model
		model.addAttribute("product", productService.findById(id));
		
		// return view form
		return "product/form";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String productEditSubmit(@ModelAttribute @Valid Product product, BindingResult bindingResult) {
		
		// check if form is valid before save, according to annotations in entity product
		if (bindingResult.hasErrors()) {
			
			// return View form
            return "product/form";
        }
		
		// save product
		productService.save(product);
		
		// redirect to route /product
		return "redirect:/product";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteProduct(@RequestParam("id") Long id) {
		
		// delete product by id
		productService.deleteById(id);

		// redirect to route /product
		return "redirect:/product";
	}
	
}
