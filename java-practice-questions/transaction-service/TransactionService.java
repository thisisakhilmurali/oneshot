package com.tasks.problem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class TransactionService {

	// public static void main(String[] args) {
		
	// }

	List<Transaction> transactions = new ArrayList<>();

	public List<Transaction> getAllTransactions() throws FileNotFoundException {
		try {
			CSVReader reader = new CSVReader(new FileReader("transactions.csv"));
			// @todo You can initialize CsvBean<T> class and then call the parse method to
			// get the list
			reader.skip(1);

			String[] line;
			while ((line = reader.readNext()) != null) {
				String type = line[0];
				Double amount = Double.parseDouble(line[1]);
				String date = line[2];

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

				LocalDate localDate = LocalDate.parse(date, formatter);

				Transaction transaction = new Transaction();
				transaction.setType(type);
				transaction.setDate(localDate);
				transaction.setAmount(amount);

				transactions.add(transaction);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactions;
	}

	public Double getTotalTransactionAmount() throws FileNotFoundException  {
		if (transactions == null) {
			getAllTransactions();
		}

		double tot = 0d;
		// @todo Write code to assign total transaction amount to amt variable

		tot = transactions.stream()
				.mapToDouble(Transaction::getAmount)
				.sum();

		return tot;

	}

	public Transaction getTransactionWithHighestAmount() throws FileNotFoundException {
		if (transactions == null) {
			getAllTransactions();
		}

		double tot = 0d;
		Transaction highestTransaction = null;
		// @todo Write code to get the transaction object with highest amount
		Optional<Transaction> maxTransaction = transactions.stream()
				.max(Comparator.comparingDouble(Transaction::getAmount));
		highestTransaction = maxTransaction.get();

		return highestTransaction;
	}

	public Transaction getTransactionWithLowestmount() throws FileNotFoundException {
		if (transactions == null) {
			getAllTransactions();
		}

		double tot = 0d;
		Transaction lowestTransaction = null;
		// @todo Write code to figure out transaction with lowest amount
		Optional<Transaction> minTransaction = transactions.stream()
				.min(Comparator.comparingDouble(Transaction::getAmount));
		lowestTransaction = minTransaction.get();

		return lowestTransaction;

	}

	public Double getAverageTransactionAmount() throws FileNotFoundException {
		if (transactions == null) {
			transactions = getAllTransactions();
		}

		// @todo Write code to get the average of transaction amounts & return it.
		double averageTransaction = transactions.stream()
				.mapToDouble(Transaction::getAmount)
				.average()
				.orElse(0.0);

		return averageTransaction;
	}

}
