package com.del.productms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	private String productId;
	
	private String productName;
	
	private float price;
	
	
}
