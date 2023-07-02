package com.tasks.problem;
import java.time.LocalDate;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

public class Transaction {
	
	@CsvBindByName(column = "Type")
	private String type;
	
	@CsvBindByName(column = "Amount")
	private Double amount;
	
	@CsvBindByName(column = "Date")
	@CsvDate(value = "yyyy-MM-dd")
	private LocalDate date;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
