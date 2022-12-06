package com.rachel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Share {
	
	// define fields of share obejcts
	private int shareId;
	private String shareName;
	private double marketPrice;

}
