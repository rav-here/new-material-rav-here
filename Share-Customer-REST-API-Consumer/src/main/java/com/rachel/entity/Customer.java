package com.rachel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok dependency does getters, setters and constructors for us
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	// define fields of customer objects
	private int detailId;
	private int customerId;
	private int shareId;
	private String shareType;
	private double quantity;
}
