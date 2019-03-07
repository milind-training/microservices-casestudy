package com.finance.cs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customers")
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public Customer create()
	{
		return customerDao.create();
	}
	
	@RequestMapping(value="/{customerId}",method=RequestMethod.GET)
	public BankAccount getBankDetails(@PathVariable String customerId)
	{
		return getBankAccountDetails(customerDao.getBankAccountId(Integer.valueOf(customerId)));
	}


	private BankAccount getBankAccountDetails(Integer bankAccountId) {
		
		return restTemplate.exchange("http://bankaccount-service/bankAccounts/{bankAccountId}",HttpMethod.GET, null, new ParameterizedTypeReference<BankAccount>() {},bankAccountId).getBody();
		
	}
	
	@Bean
	@LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	

}
