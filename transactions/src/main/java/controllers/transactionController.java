package controllers;


import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Account;
import models.Transaction;
import services.services;


@RestController
@RequestMapping(path = "/transaction", produces= MediaType.APPLICATION_JSON_VALUE)
public class transactionController {
	
	services services = null; 
	
	
	@GetMapping(path="/getAllTransactionsByAccount", produces = "application/json")
    public List<Transaction> getAllTransactionsByAccount(@RequestBody String accountNumber) 
    {
		int flag = 1;
		services = new services();
		List<Transaction> listResponse = services.getTransactionsByAccount(accountNumber, flag);
		return listResponse;
    }
	
	@GetMapping(path="/getAllSentTransactions", produces = "application/json")
    public List<Transaction> getAllSentTransactions(@RequestBody String accountNumber) 
    {
		int flag = 2;
		services = new services();
		List<Transaction> listResponse = services.getTransactionsByAccount(accountNumber, flag);
		return listResponse;
    }
	
	@GetMapping(path="/getAllRecieveTransactions", produces = "application/json")
    public List<Transaction> getAllRecieveTransactions(@RequestBody String accountNumber) 
    {
		int flag = 3;
		services = new services();
		List<Transaction> listResponse = services.getTransactionsByAccount(accountNumber, flag);
		return listResponse;
    }
	
		
	@GetMapping(path="/getAccountBalance", produces = "application/json")
    public String getAccountBalance(@RequestBody String accountNumber) 
    {
		services = new services();
		return services.getBalance(accountNumber);
    }
	
    @PostMapping(path= "/transfer", consumes = "application/json", produces = "application/json")
    public String transfer(@RequestBody String transaction) throws JSONException 
    {
    	JSONObject jsonObject = new JSONObject(transaction);
    	services = new services();
    	String response = services.validateAccountResource(jsonObject);
    	return response;
    } 
    
	@GetMapping(path="/getAllAccounts")
    public List<Account> getAllAccounts() 
    {
		services = new services();
		return services.getAllAccounts();
    }

}
