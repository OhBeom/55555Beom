import java.util.Scanner;

public class BankApp {
	
	Account[] acc = new Account[100];  //객체 배열  //멤버변수, 참조 변수 - 기본값 null
	Scanner sc = new Scanner(System.in);        //멤버변수, 참조 변수
	
	void info() {
		System.out.println("--------------------------------------");
		System.out.println("1.계좌 생성 2.계좌 목록 3.예금 4.출금 5.종료");
		System.out.println("--------------------------------------");
		System.out.print("선택 : ");
	}
	
	//계좌 생성 기능
	void createAccount() {
		System.out.println("----------");
		System.out.println("계좌 생성 메뉴");
		System.out.println("----------");

		
	    System.out.println("계좌 번호 : ");
	    String ano = sc.next();
	    
	    if(findAccount(ano)!= null) {
	    	System.out.println("이미 계좌가 존재 합니다.");
	    	return;
	    }
	    
	    System.out.println("계좌주명 : ");
	    String owner = sc.next();
	    
	    System.out.println("초기 입금 금액 : ");
	    int balance = sc.nextInt();
	    
	    System.out.println("이자률 입력 : ");
	    double rate = sc.nextDouble();
	    	    
	    Account account = new Account(ano,owner,balance,rate);
	    //
	    account.rateCal();
	    
	    for(int i=0; i<acc.length; i++) {//계좌 생성 부분    //계좌 생성이 겹치면 안되니깐 반복문 사용
	    	if(acc[i] == null) {
	    		acc[i] = account;
	    		System.out.println("계좌가 생성 되었습니다.");
	    		break;
	    	}	    	
	    }	    	
	}
	
	//계좌 목록 보기 기능
	
	void accountList() {
		System.out.println("-------------");
		System.out.println("계좌 목록 보기 메뉴");
		System.out.println("-------------");
		//
		System.out.println("계좌번호   계좌주        입금액    이자율   출금 가능 금액");
		
		for(int i=0; i<acc.length; i++) {
			if(acc[i] == null) {
				break;
			}
			//
     System.out.println(acc[i].getAno()+"   "+acc[i].getOwner()+"  "+acc[i].getBalance()+"원  "+acc[i].getRate()+"% "+acc[i].getAmount()+"원 ");
			
		}

	}
	
	//예금 기능 
	
	void deposit() {
		
		System.out.println("-------------");
		System.out.println("예금 기능 메뉴");
		System.out.println("-------------");
		
		System.out.println("계좌번호 : ");
		String ano = sc.next();
		
		System.out.println("예금액 : ");
		int balance = sc.nextInt();
		
		
		Account account = findAccount(ano);
		
		if(account == null) {
			System.out.println("계좌번호가 존재하지 않습니다.");
			return;
		}
	
		account.setBalance(account.getBalance() + balance);
		System.out.println("예금 처리가 정삭적으로 되었습니다.");
		
	}
	
	//출금 기능
	void withdraw() {
		
		System.out.println("-------------");
		System.out.println("출금 기능 메뉴");
		System.out.println("-------------");
		
		System.out.println("계좌번호 : ");
		String ano = sc.next();
		
		System.out.println("출금액 : ");
		int balance = sc.nextInt();
		
		Account account = findAccount(ano);
		
		if(account == null) {
			System.out.println("계좌번호가 존재하지 않습니다.");
			return;
		}
		
		if(account.getBalance() < balance) {		
		System.out.println("잔액이 부족 합니다.");
		return;
		}
		account.setBalance(account.getBalance() - balance);
		System.out.println("출금이 정상적으로 되었습니다");
	}
	
	
	
		
	//계좌 확인 기능
	Account findAccount(String ano) {

		Account account = null;
		
		for(int i=0; i<acc.length; i++) {
			if(acc[i] != null) {				
			if(acc[i].ano.equals(ano)) {
				account = acc[i];
				break;
			}			
		}
	}
		return account;
		
	}
	
		
}
