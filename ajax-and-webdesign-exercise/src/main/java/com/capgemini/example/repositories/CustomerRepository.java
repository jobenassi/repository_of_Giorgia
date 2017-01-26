package com.capgemini.example.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.example.domain.Customer;

/**
 * The Interface CustomerRepository.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("select c from Customer c where c.name LIKE (CONCAT('%',:term, '%'))")
	List<Customer> findCustomerName(@Param("term") String term);
	
	List<Customer> findCustomerByIdOrNameOrSurname( Long id, String name, String surname);
	
	@Transactional
	@Modifying
	@Query("delete from Customer c where c.id = :id")
	void deleteById(@Param("id") Long id);
		
}
