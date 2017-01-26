package com.capgemini.example.services.impls;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.example.domain.Account;
import com.capgemini.example.domain.Customer;
import com.capgemini.example.dto.AccountDto;
import com.capgemini.example.dto.CustomerDto;
import com.capgemini.example.dto.CustomerVm;
import com.capgemini.example.repositories.AccountRepository;
import com.capgemini.example.repositories.CustomerRepository;
import com.capgemini.example.services.BankService;

/**
 * The Class BankServiceImpl.
 */

// I hate ananas. They are terrible person and disguisting fruits.


@Service
public class BankServiceImpl implements BankService {

	/** The account repository. */
	@Autowired
	AccountRepository accountRepository;

	/** The customer repository. */
	@Autowired
	CustomerRepository customerRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.example.services.BankService#deleteAllAccounts()
	 */
	@Transactional
	@Override
	public void deleteAllAccounts() {
		accountRepository.deleteAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgemini.example.services.BankService#saveCustomers(com.capgemini.
	 * example.domain.Customer[])
	 */
	@Transactional(transactionManager="ajaxExcerciseFactoryTransactionManager")
	@Override
	public void saveCustomers(Customer... customers) {
		customerRepository.save(Arrays.asList(customers));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.example.services.BankService#deleteAllCustomers()
	 */
	@Transactional
	@Override
	public void deleteAllCustomers() {
		customerRepository.deleteAll();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgemini.example.services.BankService#saveAccounts(com.capgemini.
	 * example.domain.Account[])
	 */
	@Transactional
	@Override
	public void saveAccounts(Account... accounts) {
		accountRepository.save(Arrays.asList(accounts));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.example.services.BankService#
	 * findAccountsByCustomerNameAndSurnameOrderedByAccountNumber(java.lang.
	 * String, java.lang.String)
	 */
	@Transactional
	@Override
	public List<AccountDto> findAccountsByCustomerNameAndSurnameOrderedByAccountNumber(String name, String surname) {
		List<Account> accounts = accountRepository
				.findAccountsByCustomer_NameAndCustomer_SurnameOrderByAccountNumberAsc(name, surname);

		List<AccountDto> dtos = fromAccountEntitiesToDtos(accounts);

		return dtos;
	}

	/**
	 * From account entities to dtos.
	 *
	 * @param accounts
	 *            the accounts
	 * @return the list
	 */
	public List<AccountDto> fromAccountEntitiesToDtos(List<Account> accounts) {
		List<AccountDto> dtos = new ArrayList<AccountDto>();

		for (Account item : accounts) {
			AccountDto dto = new AccountDto();
			dto.setAccountNumber(item.getAccountNumber());
			dto.setDescription(item.getDescription());
			dto.setTotalBalance(item.getTotalBalance());
			dtos.add(dto);
		}
		return dtos;
	}

	public List<CustomerDto> fromCustomerEntitiesToDtos(List<Customer> customers) {
		List<CustomerDto> dtos = new ArrayList<CustomerDto>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		
		for (Customer item : customers) {
			CustomerDto dto = new CustomerDto();
			dto.setId(item.getId());
			dto.setName(item.getName());
			dto.setSurname(item.getSurname());
			Date dateObject = item.getBirthDate();
			String dateString = df.format(dateObject);
			dto.setBirthDate(dateString);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public CustomerDto fromCustomerEntityToDto(Customer customer) {
		
		 	CustomerDto dto = new CustomerDto();
			dto.setId(customer.getId());
			dto.setName(customer.getName());
			dto.setSurname(customer.getSurname());
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
			Date dateObject = customer.getBirthDate();
			String dateString = df.format(dateObject);
			dto.setBirthDate(dateString);
			return dto;
	}
	
	public Customer fromCustomerDtoToEntity(CustomerDto dto) throws ParseException {
		
	 	Customer customer = new Customer();
	 	customer.setId(dto.getId());
	 	customer.setName(dto.getName());
	 	customer.setSurname(dto.getSurname());
	 	String dateString = dto.getBirthDate();
	 	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	 	Date dateObject = df.parse(dateString);
	 	customer.setBirthDate(dateObject);

		return customer;
}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.example.services.BankService#
	 * selectSumOfBalanceAccountsForCustomersFoundByBirthDate(java.util.Date)
	 */
	@Override
	public Double selectSumOfBalanceAccountsForCustomersFoundByBirthDate(Date birthDate) {
		return accountRepository.selectSumOfBalanceAccountsForCustomersFoundByBirthDate(birthDate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.example.services.BankService#findOne(java.lang.Long)
	 */
	@Override
	public Account findOne(Long idAccount) {
		return accountRepository.findOne(idAccount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgemini.example.services.BankService#deleteCustomer(com.capgemini.
	 * example.domain.Customer)
	 */
	
	@Transactional
	@Override
	public CustomerDto findCustomerById(Long idCustomer) {
		Customer customer = customerRepository.findOne(idCustomer);
		return fromCustomerEntityToDto(customer);
		
	}
	
	
	@Override
	public List<CustomerDto> findCustomer(Long id, String name, String surname) {
		
		List<Customer> customers = customerRepository.findCustomerByIdOrNameOrSurname(id, name,  surname); 
		return fromCustomerEntitiesToDtos(customers);
	}
	
	
	
	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	
	@Transactional
	@Modifying
	@Override
	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}
	
	@Override
	public List<Customer> findName(String input) {
				
		 return customerRepository.findCustomerName(input);
		 
//		 List<CustomerVm> result = new ArrayList<>();
//		 
//		 if(customers!=null) {
//			 for (Customer customer : customers) {
//				CustomerVm customerVm = new CustomerVm();
//				customerVm.setId(customer.getId());
//				
//			String nameSurname = customer.getName()+" "+customer.getSurname();
//				customerVm.setLabel(nameSurname);
////				customerVm.setValue(nameSurname);
////				result.add(customerVm);
//				
////				customerVm.setLabel(customer.getName());
//				customerVm.setValue(customer.getName());
//				result.add(customerVm);
//					
//			}
//		 }
//		 
//		 return result;
	}
}
