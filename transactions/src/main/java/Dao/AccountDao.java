package Dao;

import java.util.ArrayList;
import java.util.List;

import models.Account;
import models.AccountHolder;

public class AccountDao {
	
	private static List<Account> accountList = new ArrayList<Account>();
	
	public List<Account> createAccounts() {
		if(accountList.size()== 0) {
			AccountHolderDao daoAccountHolder = new AccountHolderDao();
			List<AccountHolder> holders = new ArrayList<AccountHolder>();
			int [] accountNumbers = {1000,2000,3000};
			double [] amounts = {5000,20000,18000};
			holders = daoAccountHolder.createAllAccountHolders();
			for(int i = 0; i<3;i++) {
				Account account = new Account();
				account.setId(i);
				account.setAccountNumber(accountNumbers[i]);
				account.setAccountHolder(holders.get(i));
				account.setAmount(amounts[i]);
				accountList.add(account);
			}
		}
		return accountList;
		
		
	}
}
