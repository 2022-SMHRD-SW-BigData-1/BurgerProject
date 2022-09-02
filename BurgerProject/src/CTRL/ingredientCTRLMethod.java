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

	int score = 10000;

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
					score -= 50;
					break;
				case 2:
					System.out.println("새우패티를 구매하였습니다.");
					System.out.println();
					Cntshrimppatty++;
					score -= 50;
					break;
				case 3:
					System.out.println("치킨패티를 구매하였습니다.");
					System.out.println();
					Cntchickenpatty++;
					score -= 50;
					break;
				case 4:
					System.out.println("베이컨를 구매하였습니다.");
					System.out.println();
					score -= 50;
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
					score -= 50;
					Cnttomato++;
					break;
				case 2:
					System.out.println("피클을 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntpickle++;
					break;
				case 3:
					System.out.println("양상추를 구매하였습니다.");
					System.out.println();
					score -= 50;
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
					score -= 50;
					Cntbread++;
					break;
				case 2:
					System.out.println("머스타드을 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntmustard++;
					break;
				case 3:
					System.out.println("케찹을 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntketchup++;
					break;
				case 4:
					System.out.println("치즈를 구매하였습니다.");
					System.out.println();
					score -= 50;
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

	// [2]주방 및 제작

	int i = 0;
	String[] arr = new String[3]; // 배열의 크기는 나중에 손님이 들고온 레시피로 배열의 크기 조정

	public void MakeHamburger() {

		while (true) {

			System.out.println("햄버거에 들어갈 재료를 골라주세요.");
			System.out.println("[1]육류 [2]채소류 [3]기타류 [4]햄버거완성 [5]처음화면으로 이동");
			System.out.print("<선택> : ");
			int num1 = sc.nextInt();

			if (num1 == 1) {
				System.out.println("[1]고기패티 [2]새우패티 [3]치킨패티 [4]베이컨 [5]이전");
				System.out.print("<선택> : ");
				int num2 = sc.nextInt();

				switch (num2) {
				case 1:
					if (Cntmeatpatty <= 0) {
						System.out.println("고기패티의 재고가 부족합니다.");
						System.out.println();
					} else {
						System.out.println("고기패티를 추가했습니다.");
						System.out.println();
						arr[i] = "고기패티";
						i++;
						Cntmeatpatty--;
					}
					break;
				case 2:
					if (Cntshrimppatty <= 0) {
						System.out.println("새우패티의 재고가 부족합니다.");
						System.out.println();
					} else {
						System.out.println("새우패티를 추가했습니다.");
						System.out.println();
						arr[i] = "새우패티";
						i++;
						Cntshrimppatty--;
					}
					break;
				case 3:
					if (Cntchickenpatty <= 0) {
						System.out.println("치킨패티의 재고가 부족합니다.");
						System.out.println();
					} else {
						System.out.println("치킨패티를 추가했습니다.");
						System.out.println();
						arr[i] = "치킨패티";
						i++;
						Cntchickenpatty--;
					}
					break;
				case 4:
					if (Cntbacon <= 0) {
						System.out.println("베이컨의 재고가 부족합니다.");
						System.out.println();
					} else {
						System.out.println("베이컨를 추가했습니다.");
						System.out.println();
						arr[i] = "베이컨";
						i++;
						Cntbacon--;
					}
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
					if (Cnttomato <= 0) {
						System.out.println("토마토의 재고가 부족합니다.");
						System.out.println();
					} else {
						System.out.println("토마토를 추가했습니다.");
						System.out.println();
						arr[i] = "토마토";
						i++;
						Cnttomato--;
					}
					break;
				case 2:
					if (Cntpickle <= 0) {
						System.out.println("피클의 재고가 부족합니다.");
						System.out.println();
					} else {
						System.out.println("피클을 추가했습니다.");
						System.out.println();
						arr[i] = "피클";
						i++;
						Cntpickle--;
					}
					break;
				case 3:
					if (Cntcabbage <= 0) {
						System.out.println("양상추의 재고가 부족합니다.");
						System.out.println();
					} else {
						System.out.println("양상추를 추가했습니다.");
						System.out.println();
						arr[i] = "양상추";
						i++;
						Cntcabbage--;
					}
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
					if (Cntbread <= 0) {
						System.out.println("빵의 재고가 부족합니다.");
						System.out.println();
					} else {
						System.out.println("뺭을 추가했습니다.");
						System.out.println();
						arr[i] = "빵";
						i++;
						Cntbread--;
					}
					break;
				case 2:
					if (Cntmustard <= 0) {
						System.out.println("머스타드의 재고가 부족합니다.");
						System.out.println();
					} else {
						System.out.println("머스타드를 추가했습니다.");
						System.out.println();
						arr[i] = "머스타드";
						i++;
						Cntmustard--;
					}
					break;
				case 3:
					if (Cntketchup <= 0) {
						System.out.println("케찹이 부족합니다.");
						System.out.println();
					} else {
						System.out.println("케찹을 추가했습니다.");
						System.out.println();
						arr[i] = "케찹";
						i++;
						Cntketchup--;
					}
					break;
				case 4:
					if (Cntcheese <= 0) {
						System.out.println("치즈의 재고가 부족합니다.");
						System.out.println();
					} else {
						System.out.println("치즈를 추가했습니다.");
						System.out.println();
						arr[i] = "치즈";
						i++;
						Cntcheese--;
					}
					break;
				case 5:
					System.out.println("이전으로 돌아가겠습니다.");
					System.out.println();
					continue;
				}

			}

			if (num1 == 4) {
				System.out.println("햄버거가 완성되었습니다.");
				System.out.println();
				break;
			}

			if (num1 == 5) {
				System.out.println("처음화면으로 이동합니다.");
				System.out.println();
				break;
			}

		}
	}

	// [3]햄버거 판매

	public void SellHamburger() {

//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++) {
//				if (arr[i] == arr1[j]) {
//					System.out.println("햄버거 판매에 성공하였습니다.");
//					Score += 1000;
//					System.out.println("현재까지의 점수는 " + Score + "점 입니다.");
//				} else if (arr[i] != arr1[j]) {
//					System.out.println("햄버거 판매에 실패하였습니다.");
//					Score -= 1000;
//					System.out.println("현재까지의 점수는 " + Score + "점 입니다.");
//
//				}
//			}
//		}
//
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
