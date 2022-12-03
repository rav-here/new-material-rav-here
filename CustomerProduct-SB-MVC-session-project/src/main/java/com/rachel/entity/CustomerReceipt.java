package com.rachel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomerReceipt {
	
	private Customer customer;
	private Product product;
	private int itemsBought;
	private double totalSpent;
	
}
