package com.zoe.customer.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

//@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    int detailId;
    int customerId;
    int shareId;
    String shareType;
    int quantity;
}
