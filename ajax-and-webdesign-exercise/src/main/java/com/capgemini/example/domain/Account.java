package com.capgemini.example.domain;

import static com.capgemini.example.domain.StaticMethodsAndVariables.TABLE_NAME_ACCOUNT;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Account.
 */
@Entity
@Table(name=TABLE_NAME_ACCOUNT)

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

// test
/**
 * Instantiates a new account.
 *
 * @param accountNumber the account number
 * @param description the description
 * @param totalBalance the total balance
 * @param customer the customer
 */
@AllArgsConstructor

/**
 * Instantiates a new account.
 */
@NoArgsConstructor
public class Account {

	/** The account number. */
	@Id
	@Column(name="ACCOUNT_NUMBER")
	private Long accountNumber;

	/** The description. */
	@Column(nullable = false)
	private String description;

	/** The total balance. */
	@Column(name="TOTAL_BALANCE")
	private Double totalBalance;
	

	/** The customer. */
	@ManyToOne
	private Customer customer;
	
	
}
