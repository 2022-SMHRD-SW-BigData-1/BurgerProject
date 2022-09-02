package CTRL;

import java.util.ArrayList;
import java.util.Scanner;

public class ingredientCTRLMethod {

	private ArrayList<ingredientCTRL> CTRL;
	Scanner sc = new Scanner(System.in);

	public ingredientCTRLMethod() {
		CTRL = new ArrayList<ingredientCTRL>();
	}

	int Cntmeatpatty = 0;
	int Cntshrimppatty = 0;
	int Cntchickenpatty = 0;
	int Cntbacon = 0;

	int Cnttomato = 0;
	int Cntpickle = 0;
	int Cntcabbage = 0;

	int Cntbread = 0;
	int Cntmustard = 0;
	int Cntketchup = 0;
	int Cntcheese = 0;

	// [1] 재료구매

	public void BuyIngredient() {
		while (true) {
			ingredientCTRL igCTRL = new ingredientCTRL();
			System.out.println("[1]육류 [2]채소류 [3]기타류 [4]처음화면으로 이동");
			System.out.print("<선택> : ");
			int num1 = sc.nextInt();

			if (num1 == 1) {
				System.out.println("[1]고기패티 [2]새우패티 [3]치킨패티 [4]베이컨 [5]이전");
				System.out.print("<선택> : ");
				int num2 = sc.nextInt();

				switch (num2) {
				case 1:
					System.out.println("고기패티를 구매하였습니다.");
					System.out.println();
					Cntmeatpatty++;
					break;
				case 2:
					System.out.println("새우패티를 구매하였습니다.");
					System.out.println();
					Cntshrimppatty++;
					break;
				case 3:
					System.out.println("치킨패티를 구매하였습니다.");
					System.out.println();
					Cntchickenpatty++;
					break;
				case 4:
					System.out.println("베이컨를 구매하였습니다.");
					System.out.println();
					Cntbacon++;
					break;
				case 5:
					System.out.println("이전으로 돌아가겠습니다.");
					System.out.println();
					continue;
				}

			}

			if (num1 == 2) {
				System.out.println("[1]토마토 [2]피클 [3]양상추 [4]이전");
				System.out.print("<선택> : ");
				int num3 = sc.nextInt();

				switch (num3) {
				case 1:
					System.out.println("토마토를 구매하였습니다.");
					System.out.println();
					Cnttomato++;
					break;
				case 2:
					System.out.println("피클을 구매하였습니다.");
					System.out.println();
					Cntpickle++;
					break;
				case 3:
					System.out.println("양상추를 구매하였습니다.");
					System.out.println();
					Cntcabbage++;
					break;
				case 4:
					System.out.println("이전으로 돌아가겠습니다.");
					System.out.println();
					continue;
				}
			}

			if (num1 == 3) {
				System.out.println("[1]빵 [2]머스타드 [3]케찹 [4]치즈 [5]이전");
				System.out.print("<선택> : ");
				int num4 = sc.nextInt();

				switch (num4) {
				case 1:
					System.out.println("빵을 구매하였습니다.");
					System.out.println();
					Cntbread++;
					break;
				case 2:
					System.out.println("머스타드을 구매하였습니다.");
					System.out.println();
					Cntmustard++;
					break;
				case 3:
					System.out.println("케찹을 구매하였습니다.");
					System.out.println();
					Cntketchup++;
					break;
				case 4:
					System.out.println("치즈를 구매하였습니다.");
					System.out.println();
					Cntcheese++;
					break;
				case 5:
					System.out.println("이전으로 돌아가겠습니다.");
					System.out.println();
					continue;
				}

			}
			CTRL.add(igCTRL);

			if (num1 == 4) {
				System.out.println("처음화면으로 이동합니다.");
				System.out.println();
				break;
			}
			
		}
		
	}

	// [4] 재료 재고파악

	public void CheckIngredient() {
		System.out.println("[1]고기패티 : " + Cntmeatpatty + "개, [2]새우패티 : " + Cntshrimppatty + "개, [3]치킨패티 : "
				+ Cntchickenpatty + "개, [4]베이컨 : " + Cntbacon + "개");
		System.out.println("[1]토마토 : " + Cnttomato + "개, [2]피클 : " + Cntpickle + "개, [3]양상추 : " + Cntcabbage + "개");
		System.out.println("[1]빵 : " + Cntbread + "개, [2]머스타드 : " + Cntmustard + "개, [3]케찹 : " + Cntketchup
				+ "개, [4]치즈 : " + Cntcheese + "개");
	}

	

}
