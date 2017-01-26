package com.capgemini.jeeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.example.domain.Customer;
import com.capgemini.example.dto.AccountDto;
import com.capgemini.example.dto.CustomerDto;
import com.capgemini.example.dto.CustomerVm;
import com.capgemini.example.services.BankService;
import com.capgemini.example.services.impls.BankServiceImpl;

/**
 * The Class CustomerController.
 */
@Controller
public class CustomerController {
	
	/** The bank service. */
	@Autowired
	BankService bankService;
	
	/**
	 * Welcome page.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage() {
	    return "home";
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
	    return "index";
	}
	
	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
	public String newCustomer() {
	    return "newCustomer";
	}
	
	@RequestMapping(value = "/manageCustomer", method = RequestMethod.GET)
	public String manageCustomer() {
	    return "manageCustomer";
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.GET)
	public String updateCustomer() {
	    return "updateCustomer";
	}
	
	@RequestMapping(value = "/manageAccount", method = RequestMethod.GET)
	public String manageAccount() {
	    return "manageAccount";
	}
	
	/**
	 * Post customer.
	 *
	 * @param customer the customer
	 * @return the list
	 */
	@RequestMapping(value="/customer", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AccountDto> postCustomer(@RequestBody Customer customer) {
	    
		System.out.println(customer.getName() + " " + customer.getSurname());
	    
	    return bankService.findAccountsByCustomerNameAndSurnameOrderedByAccountNumber(customer.getName(), customer.getSurname());
	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public @ResponseBody String saveCustomer(@RequestBody CustomerDto customerDto) {
		
		Customer customer = bankService.fromCustomerDtoToEntity(customerDto);
			
		bankService.saveCustomers(customer);
		
		if(bankService.findCustomerById(customer.getId())!=null)
			return "Utente correttamente serito sul DB";
		else
			return "Errore";
	} 
	
	@RequestMapping(value="/findCustomer", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CustomerDto> findCustomer(@RequestBody CustomerDto customer) {
	    
		System.out.println(customer.getId() + " " + customer.getName() + " " + customer.getSurname());
	    
	    return bankService.findCustomer(customer.getId(), customer.getName(), customer.getSurname());
	}
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
	public @ResponseBody String deleteCustomer(@RequestBody Long id) {
			
		bankService.deleteCustomerById(id);
		
		if(bankService.findCustomerById(id)==null)
			return "Utente correttamente rimosso da DB";
		else
			return "Errore durante la cancellazione";
	}
	
}
	
//	@RequestMapping(value="/autocomplete", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody List<Customer> postName(@RequestParam String q) {
//	    
//	    
//	    return bankService.findName(q);
//	    
//	}
		

