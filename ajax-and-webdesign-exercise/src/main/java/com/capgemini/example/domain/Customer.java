package com.capgemini.example.domain;

import static com.capgemini.example.domain.StaticMethodsAndVariables.TABLE_NAME_CUSTOMER;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Customer.
 */
@Entity
@Table(name=TABLE_NAME_CUSTOMER)

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new customer.
 *
 * @param id the id
 * @param name the name
 * @param surname the surname
 * @param birthDate the birth date
 * @param accounts the accounts
 */
@AllArgsConstructor

/**
 * Instantiates a new customer.
 */
@NoArgsConstructor
public class Customer {
	
	//testCustomer
	
	/** The id. */
	@Id
	private Long id;

	/** The name. */
	@Column
	private String name;
	
	/** The surname. */
	@Column
	private String surname;
	
	/** The birth date. */
	@Column(name="birth_date")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	/** The accounts. */
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	private Set<Account> accounts;
	
}
