package Dao;

import java.util.ArrayList;
import java.util.List;

import models.Account;
import models.Transaction;

public class TransactionDao {
	private static List<Transaction> transactionsList = new ArrayList<Transaction>();
	
	public void addTransaction(Transaction transaction) {
		if(transaction!=null) {
			transactionsList.add(transaction);
		}		
	}
	
	public List<Transaction> getTransactionByAccount(Integer accountNumber, int flag){
		List<Transaction> allTransactionsByAccount = new ArrayList<Transaction>();
		if(flag == 1) {
			for(Transaction tran: transactionsList) {
				if(tran.getOriginAccount().getAccountNumber().equals(accountNumber)) {
					allTransactionsByAccount.add(tran);
				}
				else if(tran.getDestinyAccount().getAccountNumber().equals(accountNumber)) {
					allTransactionsByAccount.add(tran);
				}
			}
		}
		else if(flag == 2) {
			for(Transaction tran: transactionsList) {
				if(tran.getOriginAccount().getAccountNumber().equals(accountNumber)) {
					allTransactionsByAccount.add(tran);
				}
			}
		}
		else if(flag == 3) {
			for(Transaction tran: transactionsList) {
				if(tran.getDestinyAccount().getAccountNumber().equals(accountNumber)) {
					allTransactionsByAccount.add(tran);
				}
			}
		}

		return allTransactionsByAccount;
	}

}
