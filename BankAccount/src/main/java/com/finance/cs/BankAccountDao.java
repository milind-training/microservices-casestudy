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
	
	public BankAccount create()
	{
		Integer accountNo = accountNumberGenerator.getNextAccountNo();
		BankAccount bankAccount = new BankAccount(accountNo,"Savings",new Long(accountNo*100));
		accounts.put(accountNo, bankAccount);
		return bankAccount;
	}
	
	public BankAccount get(Integer bankAccountId)
	{
		return accounts.get(bankAccountId);
	}
	
	class AccountNumberGenerator {
		private Integer accountNo = 100;
		
		Integer getNextAccountNo()
		{
			Integer result =  accountNo;
			accountNo+=100;
			return result;
		}
	}

}
