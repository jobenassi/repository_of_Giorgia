package com.capgemini.example.domain;

/**
 * The Class StaticMethodsAndVariables.
 */
public class StaticMethodsAndVariables {

	/**
	 * Only static variables/methods for this class, so we declare the
	 * constructor private.
	 */
	private StaticMethodsAndVariables() {

	}

	/** The Constant TABLE_NAME_ACCOUNT_PREFIX. */
	public static final String TABLE_NAME_ACCOUNT_PREFIX = "ACCOUNT_OF_";

	/** The Constant TABLE_NAME_CUSTOMER_PREFIX. */
	public static final String TABLE_NAME_CUSTOMER_PREFIX = "CUSTOMER_OF_";

	/** The Constant YOUR_NAME. */
	//TODO: Al posto di "" inserire il proprio nome in maiuscolo
	public static final String YOUR_NAME = "GIORGIA"; 

	/** The Constant TABLE_NAME_ACCOUNT. */
	public static final String TABLE_NAME_ACCOUNT = TABLE_NAME_ACCOUNT_PREFIX + YOUR_NAME;

	/** The Constant TABLE_NAME_CUSTOMER. */
	public static final String TABLE_NAME_CUSTOMER = TABLE_NAME_CUSTOMER_PREFIX + YOUR_NAME;

	
}
