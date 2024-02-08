package com.pp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.pp.bo.CustomerInfo;
import com.pp.service.ICustomerService;

@Controller
public class CustomerController {
	@Autowired
	ICustomerService service;
	
     @GetMapping("/cxlist")
	public String fetchCustomersData(Model model) {
    	List<CustomerInfo> customerList = service.getCustomers();
		customerList.forEach(c->System.out.println(c));
    	model.addAttribute("customers", customerList);
    	return "customerList";
	}
     @GetMapping("/showForm") 
     public String showFormPage(Map<String,Object> model) {
    	 CustomerInfo info=new CustomerInfo();
    	 model.put("customer", info);
    	 return "showForm"; 
     }
     
     @PostMapping("/registerController") 
     public String registerCx(Map<String,Object> model,@ModelAttribute("customer")CustomerInfo cx) {
    	service.registerCustomer(cx);
    	 return "redirect:/cxlist"; 
     }
     
     @GetMapping("/updateForm") 
     public String updateCx(@RequestParam("customerId")Integer id,Map<String,Object> model) {
    	CustomerInfo customer = service.getCx(id);
    	model.put("customer", customer);
    	 return "showForm"; 
     }
     
     @GetMapping("/deleteData") 
     public String deleteCx(@RequestParam("customerId")Integer id,Map<String,Object> model) {
    	service.deleteCx(id);
    	return "redirect:/cxlist"; 
     }
     
   
}

