package CTRL;
import java.util.Scanner;



public class ingredientCTRL {

	public static void main(String[] args) {
		
		// Controller
		
		Scanner sc = new Scanner(System.in);
		ingredientCTRLMethod Method = new ingredientCTRLMethod();
		
		while (true) {
			PrintMenu();
			System.out.print("<선택> : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				Method.BuyIngredient();
				break;
//			case 2:
//				manager.deposit();
//				break;
//			case 3:
//				manager.withdraw();
//				break;
//			case 4:
//				manager.inquire();
//				break;
//			case 5:
//				manager.disp();
//				break;
			default:
				System.out.println("잘못입력하셨습니다. 재입력해주세요.");
				break;
			}
		}

	}
	
	public static void  PrintMenu() {
		System.out.println();
		System.out.println("======================= Menu ========================");
		System.out.println("[1]재료구매 [2]주방 및 제작 [3]햄버거 판매 [4]재료 재고파악 [5]포기");
	}

}
