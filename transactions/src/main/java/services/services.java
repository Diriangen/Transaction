package services;

import java.util.ArrayList;
import java.util.List;


import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Dao.AccountDao;
import Dao.TransactionDao;
import models.Account;
import models.Transaction;;

public class services {
	
	public String validateAccountResource(JSONObject jsonObject) throws JSONException {
		String response = "";
		//Cargo las cuentas existentes
		List<Account> accountList = new ArrayList<Account>();
		AccountDao accountDao = new AccountDao();
		accountList = accountDao.createAccounts();
		Integer idOriginAccount = (Integer)jsonObject.get("fromAccount");
		Integer idDestinyAccount = (Integer)jsonObject.get("toAccount");
		Double amountTransaction = (Double)jsonObject.get("amount");
		if(idOriginAccount != null && idOriginAccount >0) {
			for(Account ac: accountList) {
				Integer id = new Integer(ac.getAccountNumber());
				idOriginAccount = new Integer(idOriginAccount);
				if(idOriginAccount.equals(id)) {
					if(amountTransaction <= ac.getAmount()) {
						Double newAmount = ac.getAmount() - amountTransaction;
						ac.setAmount(newAmount);
						response= setAmount(idDestinyAccount,accountList,amountTransaction,ac);
						break;
					}
					else {
						response = "La cuenta origen no cuenta con la cantidad suficiente para realizar la transferencia";
						break;
					}
				}
				else {
					response = "El número de cuenta origen proporcionado no existe en nuestra base de datos.";
				}
			}
		}
		return response;
	}
	
	public String setAmount(Integer idDestinyAccount, List<Account> accountList, Double amountTransaction, Account originAccount) {
		String response = "";
		for(Account ac: accountList) {
			if(ac.getAccountNumber().equals(idDestinyAccount)){
				Double newAmount = ac.getAmount() + amountTransaction;
				ac.setAmount(newAmount);
				response = "La transacción se realizó de manera exitosa";
				//Se agrega la transacción a nuestra base de datos
				Transaction transaction = new Transaction();
				transaction.setId((int)Math.random()*100);
				transaction.setAmount(amountTransaction);
				transaction.setOriginAccount(originAccount);
				transaction.setDestinyAccount(ac);
				TransactionDao transactionDao = new TransactionDao();
				transactionDao.addTransaction(transaction);
				break;
			}
			else {
				response = "El número de cuenta destino proporcionado no existe en nuestra base de datos.";
			}
		}
		return response;
	}
	
	public List<Transaction> getTransactionsByAccount(String accountNumber, int flag) {
		List<Transaction> allTransactionsByAccountNumber = new ArrayList<Transaction>();
		Integer accountNumberInt = new Integer(accountNumber);
		TransactionDao transactionDao = new TransactionDao();
		allTransactionsByAccountNumber = transactionDao.getTransactionByAccount(accountNumberInt, flag);

		return allTransactionsByAccountNumber;
	}
	
	public String getBalance(String accountNumber) {
		String arr2 = "";
		Integer accountNumberInt = new Integer(accountNumber);
		List<Account> accountList = new ArrayList<Account>();
		AccountDao accountDao = new AccountDao();
		accountList = accountDao.createAccounts();
		for(Account ac: accountList) {
			if(ac.getAccountNumber().equals(accountNumberInt)) {
			String account = ac.getAccountNumber().toString();
			String balance = ac.getAmount().toString();
			String owner = ac.getAccountHolder().getName();		
			String arr[]=	{"balance:"+"{"+"account:"+ account + ", balance:"+ balance + ", owner:"+ owner + ", createdAt:"+"}"};
			Gson gson=new GsonBuilder().create();
			String jsonArray=gson.toJson(arr);
			return jsonArray;
			}
		}
		return arr2;
	}
	
	public List<Account> getAllAccounts(){
		List<Account> accountList = new ArrayList<Account>();
		AccountDao accountDao = new AccountDao();
		accountList = accountDao.createAccounts();
		return accountList;
	}
}
