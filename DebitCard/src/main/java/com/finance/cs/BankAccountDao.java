package com.finance.cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class BankAccountDao {
	
	private Map<Integer, BankAccount> accounts = new HashMap<>();
	private AccountNumberGenerator accountNumberGenerator = new AccountNumberGenerator();
	
	public BankAccount create(BankAccount bankAccount)
	{
		Integer accountNo = accountNumberGenerator.getNextAccountNo();
		bankAccount.setAccountNo(accountNo);
		accounts.put(accountNo, bankAccount);
		return bankAccount;
	}
	
	public BankAccount get(String bankAccountId)
	{
		return accounts.get(bankAccountId);
	}
	
	class AccountNumberGenerator {
		private Integer accountNo = 100;
		
		Integer getNextAccountNo()
		{
			return accountNo++;
		}
	}

}
