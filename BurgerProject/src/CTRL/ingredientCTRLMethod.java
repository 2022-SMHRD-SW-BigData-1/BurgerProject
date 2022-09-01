package CTRL;

import java.util.ArrayList;
import java.util.Scanner;

public class ingredientCTRLMethod {

	private ArrayList<ingredientCTRL> CTRL;
	Scanner sc = new Scanner(System.in);

	public ingredientCTRLMethod() {
		CTRL = new ArrayList<ingredientCTRL>();
	}

	public void BuyIngredient() {
		System.out.println("[1]육류 [2]채소류 [3]기타류 [4]이전");
		System.out.print("<선택> : ");
		int num1 = sc.nextInt();

		if (num1 == 1) {
			System.out.println("[1]고기패티 [2]새우패티 [3]치킨패티 [4]베이컨 [5]이전");
			System.out.print("<선택> : ");
			int num2 = sc.nextInt();

			switch(num2) {
			case 1 : 
				System.out.println("고기패티를 구매하였습니다.");
			case 2 : 
				System.out.println("새우패티를 구매하였습니다.");
			case 3 : 
				System.out.println("치킨패티를 구매하였습니다.");
			case 4 : 
				System.out.println("베이컨를 구매하였습니다.");
			case 5 : 
				System.out.println("이전으로 돌아가겠습니다.");
			}

		}

		if (num1 == 2) {
			System.out.println("[1]토마토 [2]피클 [3]양상추 [4]이전");
			System.out.print("<선택> : ");
			int num2 = sc.nextInt();

			for (int i = 1; i <= 3; i++) {
				if (num2 == i) {
					System.out.println("재료구매완료");
				}
			}
		}

		if (num1 == 3) {
			System.out.println("[1]빵 [2]머스타드&케찹 [3]치즈 [4]이전");
			System.out.print("<선택> : ");
			int num2 = sc.nextInt();

			for (int i = 1; i <= 3; i++) {
				if (num2 == i) {
					System.out.println("재료구매완료");
				}
			}
		}
	}

}
