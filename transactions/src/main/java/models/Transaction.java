package models;

public class Transaction {
	
	private Integer id;
	private Account originAccount;
	private Account destinyAccount;
	private Double amount;
	
	public Transaction() {
		originAccount = new Account();
		destinyAccount = new Account();
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Account getOriginAccount() {
		return originAccount;
	}


	public void setOriginAccount(Account originAccount) {
		this.originAccount = originAccount;
	}


	public Account getDestinyAccount() {
		return destinyAccount;
	}


	public void setDestinyAccount(Account destinyAccount) {
		this.destinyAccount = destinyAccount;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
    @Override
    public String toString() {
        return "Transaction [id=" + id + ", originAccount=" + originAccount.getAccountHolder().getName() + ", destinyAccount="
        		+ destinyAccount.getAccountHolder().getName() + "amout=" + amount;
    }


}
