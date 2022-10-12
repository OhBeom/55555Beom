
public class Account {
	String ano;
	String owner;
	int balance;
	double rate;
	//↓출금 가능액에 관한 것
	int amount;
	
	public Account(String ano, String owner, int balance, double rate) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
		this.rate = rate;
	}

	String getAno() {
		return ano;	

    }
	
	void setAno(String ano) {
		this.ano = ano;
	}
	
	
	
	
	String getOwner() {
		return owner;	

    }
	
	void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	
	
	int getBalance() {
		return balance;	

    }
	
	void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	
	double getRate() {
		return rate;
		
	}
	
	void setRate(double rate) {
		this.rate = rate;
	}
	
	
	
	
	
	int getAmount() {
		return amount;
	}
	
	void setAmount(int amount) {
		this.amount = amount;
	}
	
	//
	void rateCal() {
		this.amount = balance + (int)(balance * getRate()/100);
		
	}
	
}