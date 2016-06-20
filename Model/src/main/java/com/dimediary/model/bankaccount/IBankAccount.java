package com.dimediary.model.bankaccount;

import java.util.Date;
import java.util.Map;

import com.dimediary.model.user.IUser;

public interface IBankAccount {

	public String getIBAN();
	public String getBIC();
	public Map<Date, Double> getAccountBalance();
	public String getName();
	public IUser getOwner();
}
