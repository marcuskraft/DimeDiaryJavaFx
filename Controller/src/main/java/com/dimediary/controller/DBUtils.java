package com.dimediary.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.dimediary.model.EntityManagerHolder;
import com.dimediary.model.entities.BankAccount;

public class DBUtils {

	public static ArrayList<String> getBankAccountNames() {
		final ArrayList<String> names = new ArrayList<>();

		final EntityManagerHolder entityManagerHolder = EntityManagerHolder.getInstance();
		final EntityManager entityManager = entityManagerHolder.getEntityManager();

		final TypedQuery<BankAccount> query = entityManager.createNamedQuery("allBankAccounts", BankAccount.class);
		final List<BankAccount> bankAccounts = query.getResultList();

		for (final BankAccount bankAccount : bankAccounts) {
			names.add(bankAccount.getName());
		}

		entityManagerHolder.close();

		return names;
	}

}
