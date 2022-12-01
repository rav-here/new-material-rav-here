package com.rachel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name= "AccountsTable")
public class Account {
	
	@Id
	private int accountId;
	private String password;
	private String name;
	private String address;
	private String phoneNumber;
	private double balance;
	

}
