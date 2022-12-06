package com.rachel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetail {

	private int customerId;
	private String shareName;
	private double quantity;
	private double marketPrice;
	private double totalValuation = quantity * marketPrice;
	private String shareType;

}
