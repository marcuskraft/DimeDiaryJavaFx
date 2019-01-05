package com.dimediary.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Category;
import com.dimediary.model.entities.Transaction;
import com.dimediary.services.database.DatabaseService;

public class CategoryService {

	public static Map<Category, Double> calculatePercentageFromTo(final BankAccount bankAccount, final LocalDate from,
			final LocalDate to) {
		final Map<Category, Double> calculatedPercentage = new HashMap<>();

		final Map<Category, Double> calculatedAbsolute = new HashMap<>();

		final List<Transaction> transactions = DatabaseService.getInstance().getTransactions(from, to, bankAccount);

		Double amountBasis = Double.valueOf(0.0);
		for (final Transaction transaction : transactions) {
			final Double amount = transaction.getAmount();
			if (transaction.getCategory() != null && amount < 0) {
				amountBasis += amount;
				final Category category = transaction.getCategory();

				if (!calculatedAbsolute.containsKey(category)) {
					calculatedAbsolute.put(category, amount);
				} else {
					calculatedAbsolute.replace(category, calculatedAbsolute.get(category) + amount);
				}
			}
		}

		if (amountBasis.equals(0.0)) {
			return calculatedPercentage;
		}

		for (final Entry<Category, Double> entry : calculatedAbsolute.entrySet()) {
			final Double percentage = entry.getValue() / amountBasis;
			calculatedPercentage.put(entry.getKey(), percentage);
		}

		return calculatedPercentage;
	}

}
