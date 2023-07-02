package com.tasks.problem;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class Product {
	
	@CsvBindByName(column = "Name")
	private String name;
	
	@CsvBindByName(column = "Category")
	private String category;
	
	@CsvBindByName(column = "Price")
	private Double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
	
	
	
	
}
