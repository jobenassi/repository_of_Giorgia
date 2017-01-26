package com.capgemini.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**A data transfer object (DTO) is an object that carries data between processes. 
 * The Transfer Object pattern is used when we want to pass data with multiple attributes in one shot from client to server. 
 * Transfer object is also known as Value Object. Transfer Object is a simple POJO class having getter/setter methods and is 
 * serializable so that it can be transferred over the network. 
 * It does not have any behavior. Server Side business class normally fetches data from the database and fills the POJO and 
 * send it to the client or pass it by value. 
 */
@Data

/**
 * Instantiates a new account dto.
 *
 * @param accountNumber the account number
 * @param description the description
 * @param totalBalance the total balance
 */
@AllArgsConstructor

/**
 * Instantiates a new account dto.
 */
@NoArgsConstructor
public class AccountDto {

	/** The account number. */
	private Long accountNumber;

	/** The description. */
	private String description;

	/** The total balance. */
	private Double totalBalance;

}
