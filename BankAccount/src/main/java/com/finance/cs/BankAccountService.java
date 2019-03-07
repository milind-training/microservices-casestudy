package com.finance.cs;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bankAccounts")
public class BankAccountService {
	
	@Autowired
	private BankAccountDao bankAccountDao;
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public BankAccount create(BankAccount bankAccount)
	{
		return bankAccountDao.create();
	}
	
	@RequestMapping(value="/{bankAccountId}",method=RequestMethod.GET)
	public BankAccount getBankAccount(@PathVariable String bankAccountId )
	{
		return bankAccountDao.get(Integer.valueOf(bankAccountId));
	}
	
	

}
