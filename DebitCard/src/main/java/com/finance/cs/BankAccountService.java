package com.finance.cs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountService {
	
	@Autowired
	private BankAccountDao bankAccountDao;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public BankAccount create(BankAccount bankAccount)
	{
		return bankAccountDao.create(bankAccount);
	}
	
	@RequestMapping(value="/{bankAccountId}",method=RequestMethod.GET)
	public BankAccount getBankAccount(@RequestParam String bankAccountId )
	{
		return bankAccountDao.get(bankAccountId);
	}
	
	

}
