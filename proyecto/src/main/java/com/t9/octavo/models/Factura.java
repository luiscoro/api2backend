package com.t9.octavo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "factura")
public class Factura {

	@Id
	@Field("_id")
	private Long id;
	
	@Field("total")
	double total;

	public Factura() {
		
	}

	public Factura(Long id, double total) {
		super();
		this.id = id;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	
	
	
}
