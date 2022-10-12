import java.util.Scanner;

public class BankApp {
	
	Account[] acc = new Account[100];  //��ü �迭  //�������, ���� ���� - �⺻�� null
	Scanner sc = new Scanner(System.in);        //�������, ���� ����
	
	void info() {
		System.out.println("--------------------------------------");
		System.out.println("1.���� ���� 2.���� ��� 3.���� 4.��� 5.����");
		System.out.println("--------------------------------------");
		System.out.print("���� : ");
	}
	
	//���� ���� ���
	void createAccount() {
		System.out.println("----------");
		System.out.println("���� ���� �޴�");
		System.out.println("----------");

		
	    System.out.println("���� ��ȣ : ");
	    String ano = sc.next();
	    
	    if(findAccount(ano)!= null) {
	    	System.out.println("�̹� ���°� ���� �մϴ�.");
	    	return;
	    }
	    
	    System.out.println("�����ָ� : ");
	    String owner = sc.next();
	    
	    System.out.println("�ʱ� �Ա� �ݾ� : ");
	    int balance = sc.nextInt();
	    
	    System.out.println("���ڷ� �Է� : ");
	    double rate = sc.nextDouble();
	    	    
	    Account account = new Account(ano,owner,balance,rate);
	    //
	    account.rateCal();
	    
	    for(int i=0; i<acc.length; i++) {//���� ���� �κ�    //���� ������ ��ġ�� �ȵǴϱ� �ݺ��� ���
	    	if(acc[i] == null) {
	    		acc[i] = account;
	    		System.out.println("���°� ���� �Ǿ����ϴ�.");
	    		break;
	    	}	    	
	    }	    	
	}
	
	//���� ��� ���� ���
	
	void accountList() {
		System.out.println("-------------");
		System.out.println("���� ��� ���� �޴�");
		System.out.println("-------------");
		//
		System.out.println("���¹�ȣ   ������        �Աݾ�    ������   ��� ���� �ݾ�");
		
		for(int i=0; i<acc.length; i++) {
			if(acc[i] == null) {
				break;
			}
			//
     System.out.println(acc[i].getAno()+"   "+acc[i].getOwner()+"  "+acc[i].getBalance()+"��  "+acc[i].getRate()+"% "+acc[i].getAmount()+"�� ");
			
		}

	}
	
	//���� ��� 
	
	void deposit() {
		
		System.out.println("-------------");
		System.out.println("���� ��� �޴�");
		System.out.println("-------------");
		
		System.out.println("���¹�ȣ : ");
		String ano = sc.next();
		
		System.out.println("���ݾ� : ");
		int balance = sc.nextInt();
		
		
		Account account = findAccount(ano);
		
		if(account == null) {
			System.out.println("���¹�ȣ�� �������� �ʽ��ϴ�.");
			return;
		}
	
		account.setBalance(account.getBalance() + balance);
		System.out.println("���� ó���� ���������� �Ǿ����ϴ�.");
		
	}
	
	//��� ���
	void withdraw() {
		
		System.out.println("-------------");
		System.out.println("��� ��� �޴�");
		System.out.println("-------------");
		
		System.out.println("���¹�ȣ : ");
		String ano = sc.next();
		
		System.out.println("��ݾ� : ");
		int balance = sc.nextInt();
		
		Account account = findAccount(ano);
		
		if(account == null) {
			System.out.println("���¹�ȣ�� �������� �ʽ��ϴ�.");
			return;
		}
		
		if(account.getBalance() < balance) {		
		System.out.println("�ܾ��� ���� �մϴ�.");
		return;
		}
		account.setBalance(account.getBalance() - balance);
		System.out.println("����� ���������� �Ǿ����ϴ�");
	}
	
	
	
		
	//���� Ȯ�� ���
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
