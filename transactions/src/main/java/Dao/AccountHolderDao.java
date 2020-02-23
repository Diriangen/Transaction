package Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import models.AccountHolder;


@Repository
public class AccountHolderDao {
	
	private static List<AccountHolder> accountHolderList = new ArrayList<AccountHolder>();
	
	public List<AccountHolder> createAllAccountHolders(){
		if(accountHolderList.size()==0) {
			String[] names = {"john", "Johnny", "Tom"};
			String[] lastNames = {"M", "R", "Z"};
			int [] ages = {39,35,29};

			for(int i = 0; i <3; i++) {
				AccountHolder accountHolder = new AccountHolder();
				accountHolder.setId(i);
				accountHolder.setName(names[i]);
				accountHolder.setLastNAme(lastNames[i]);
				accountHolder.setAge(ages[i]);
				accountHolderList.add(accountHolder);
		}
		}
		return accountHolderList;
	}

}
