package com.capgemini.example.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.example.domain.Account;

/**
 * The Interface AccountRepository.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

	/**
	 * Find accounts by customer_ name and customer_ surname order by account number asc.
	 *
	 * @param name the name
	 * @param surname the surname
	 * @return the list
	 */
	List<Account> findAccountsByCustomer_NameAndCustomer_SurnameOrderByAccountNumberAsc(String name, String surname);

	/**
	 * Select sum of balance accounts for customers found by birth date.
	 *
	 * @param birthDate the birth date
	 * @return the double
	 */
	
	@Query("select sum(a.totalBalance) from Account a where a.customer.birthDate=:birthDate")
	Double selectSumOfBalanceAccountsForCustomersFoundByBirthDate(@Param("birthDate") Date birthDate);

}
