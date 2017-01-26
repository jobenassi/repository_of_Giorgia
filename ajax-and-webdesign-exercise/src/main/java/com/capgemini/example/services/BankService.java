package com.capgemini.example.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.capgemini.example.domain.Account;
import com.capgemini.example.domain.Customer;
import com.capgemini.example.dto.AccountDto;
import com.capgemini.example.dto.CustomerDto;
import com.capgemini.example.dto.CustomerVm;

/**
 * The Interface BankService.
 */
public interface BankService {

	/**
	 * Delete all accounts.
	 */
	public void deleteAllAccounts();

	/**
	 * Save customers.
	 *
	 * @param customers the customers
	 */
	public void saveCustomers(Customer... customers);

	/**
	 * Delete all customers.
	 */
	public void deleteAllCustomers();

	/**
	 * Save accounts.
	 *
	 * @param accounts the accounts
	 */
	public void saveAccounts(Account... accounts);

	/**
	 * Find accounts by customer name and surname ordered by account number.
	 *
	 * @param name the name
	 * @param surname the surname
	 * @return the list
	 */
	public List<AccountDto> findAccountsByCustomerNameAndSurnameOrderedByAccountNumber(String name,
			String surname);

	/**
	 * Select sum of balance accounts for customers found by birth date.
	 *
	 * @param birthDate the birth date
	 * @return the double
	 */
	public Double selectSumOfBalanceAccountsForCustomersFoundByBirthDate(Date birthDate);

	/**
	 * Find one.
	 *
	 * @param idAccount the id account
	 * @return the account
	 */
	public Account findOne(Long idAccount);

	/**
	 * Delete customer.
	 *
	 * @param customer the customer
	 */
	public void deleteCustomer(Customer customer);
	

	public List<Customer> findName(String input);

	public CustomerDto findCustomerById(Long idCustomer);
	
	public List<CustomerDto> findCustomer(Long id, String name, String surname);

	void deleteCustomerById(Long id);
	
	public List<AccountDto> fromAccountEntitiesToDtos(List<Account> accounts);
	public List<CustomerDto> fromCustomerEntitiesToDtos(List<Customer> customers);
	public CustomerDto fromCustomerEntityToDto(Customer customer);
	public Customer fromCustomerDtoToEntity(CustomerDto dto) throws ParseException;
	
	}


