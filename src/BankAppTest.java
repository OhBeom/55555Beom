import java.util.Scanner;

public class BankAppTest {

	public static void main(String[] args) {
		
		BankApp ba = new BankApp();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=============================");
		System.out.println("=      은행 업무 관련 시스템           =");
		System.out.println("=============================");
	
		while(true) { //반복이 언제 끝날지 모르니 와일 선택
			
		
		ba.info();
		int choice = sc.nextInt();
		
		if(choice == 1) {
			ba.createAccount();
		}else if(choice == 2 ) {
			ba.accountList();
		}else if(choice == 3) {
			ba.deposit();
		}else if(choice == 4) {
			ba.withdraw();
		}else if(choice == 5) {
			break;
		}
		
 }
		System.out.println("업무를 종료 합니다.");
		
	}

}
