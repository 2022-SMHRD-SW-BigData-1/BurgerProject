package View;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

import CTRL.DAO;
import CTRL.ingredientCTRL;

public class BurgerStore {
	static DAO dao = new DAO();
	static Scanner sc = new Scanner(System.in);
	static int i = 1;
	private static ArrayList<ingredientCTRL> CTRL;

	public static void main(String[] args) {
		startLogo();
		User();
		start();
		selectLevel();
		loading();
		play();

	}

	// User 회원가입, 로그인, 탈퇴, 종료 등 시작 메소드
	public static void User() {
		while (true) {
			System.out.print("\t\t\t\t[1]회원가입 [2]로그인 [3]탈퇴 [4]종료 >> ");
			int enu = sc.nextInt();

			if (enu == 1) {
				// 회원가입 기능 연결
				System.out.println("\t\t\t\t==========회원등록==========");
				System.out.print("\t\t\t\tID : ");
				String id = sc.next();
				System.out.print("\t\t\t\tPW : ");
				String pw = sc.next();
				System.out.print("\t\t\t\t닉네임(띄어쓰기 금지) : ");
				String nick = sc.next();

				int cnt = dao.join(id, pw, nick);
				if (cnt > 0) {
					System.out.println("\t\t\t\t회원등록 성공!");
				} else {
					System.out.println("\t\t\t\t등록 실패..");
				}
				System.out.println("\t\t\t\t=========================");

			} else if (enu == 2) {
				// 로그인 기능 연결
				System.out.println("\t\t\t\t==========로그인==========");
				System.out.print("\t\t\t\tID : ");
				String id = sc.next();
				System.out.print("\t\t\t\tPW : ");
				String pw = sc.next();
				int cnt = dao.login(id, pw);
				if (cnt == 1) {
					escapeN(32);
					System.out.println("\t\t\t\t로그인 성공!\n");

					break;
				} else if (cnt == 0) {
					System.out.println("\t\t\t\t비밀번호가 틀렸습니다.");
				} else if (cnt == 2) {
					System.out.println("\t\t\t\tID가 틀렸습니다..");
				} else if (cnt == -1) {
					System.out.println("\t\t\t\t계정이 없습니다.");
				}

				System.out.println("\t\t\t\t=========================");

			} else if (enu == 3) {
				// 탈퇴 기능 연결
				System.out.println("\t\t\t\t==========회원조회==========");
				System.out.print("\t\t\t\tID : ");
				String id = sc.next();
				dao.delete(id);
				System.out.println("\t\t\t\t" + id + " 유저가 탈퇴되었습니다.");
				System.out.println("\t\t\t\t=========================");
			} else if (enu == 4) {
				break;
			}
		}
	}

	public static void start() {
		System.out.println("\t\t\tAI가 세상을 지배한지 벌써 20년이나 지났다.. 인류 절반이 타노스 당했고 AI의 인간통제와\r\n"
				+ "\t\t\t문명말살로 인해 인간의 컴퓨터는 도스창을 사용할 수 밖에 없는 세상이 왔다.\r\n"
				+ "\t\t\t수 많은 인간의 음식들이 사라졌고 유일하게 남은 요식업 기업이 바로 BURGER KING...\r\n"
				+ "\t\t\t생존한 인간들은 외식을 할때면 BURGER KING의 버거만 먹어야 하는데...\r\n"
				+ "\t\t\t항상 똑같은 메뉴에 질린 인간들은 분노하여 BURGER KING에 올때면 자기들 마음대로 레시피를 부르곤 한다.\r\n"
				+ "\t\t\t(여기가 무슨 써브웨인줄 아나..)\r\n"
				+ "\t\t\t그러다 갑자기 뼈저리게 가난한 우리의 주인공 \"너님\"은 우연히 비어있는 BURGER KING 점포를 발견하고\r\n"
				+ "\t\t\t번뜩이는 아이디어를 떠올리며 들어가게 되는데.................\n\n");

	}

	public static void selectLevel() {

		System.out.print("\t\t\t\t난이도를 선택하세요! >> ");
		System.out.print("[1]Easy  [2]Normal  [3]Hard   ");
		int nu = sc.nextInt();
		switch (nu) {
		case 1: {
			System.out.println("\t\t\t\tEasy 난이도를 선택하셨습니다. 곧 게임을 시작하겠습니다.");

			break;
		}
		case 2: {
			System.out.println("\t\t\t\tNormal 난이도를 선택하셨습니다. 곧 게임을 시작하겠습니다.");

			break;
		}
		case 3: {
			System.out.println("\t\t\t\tHard 난이도를 선택하셨습니다. 곧 게임을 시작하겠습니다.");

			break;
		}
		default:
			break;
		}

	}

	public static void startCountdown(int count) {

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (i <= count) {
					System.out.println("\t\t\t\t[SYSTEM] 카운트다운 : " + (count + 1 - i));
					i++;
				} else {
					System.out.println("\t\t\t\t[SYSTEM] 시작!");
					timer.cancel();
				}

			}

		};
		timer.schedule(task, 1000, 1000);

	}

	public static void startLogo() {
		System.out.println(
				"                                                                                                    \r\n"
						+ "                                                                                                    \r\n"
						+ "                                          WWWWWWWWWWWWWWWW                                          \r\n"
						+ "                                  WWNXXKK00OOOkkkkkkkOOOO00KKXXNWW                                  \r\n"
						+ "                              WNXK0OkxxxxxxxxxxxxxxxxxxxxxxxxxxkO0KXNW                              \r\n"
						+ "                           WNKOkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxk0KNW                           \r\n"
						+ "                         WX0kxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxk0XW                         \r\n"
						+ "                       WXOxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxk0XW                       \r\n"
						+ "                      WKkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxkKW                      \r\n"
						+ "                     WKkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxkKW                     \r\n"
						+ "                     NOxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxON                     \r\n"
						+ "                     WX000000000000000000000000000000000000000000000000000000KW                     \r\n"
						+ "                     WXOOkO0XWWXO0XWX0OXNXOOOO0XWW WNX0OkO0XWN0OOOO0XN0OOOOKNW                      \r\n"
						+ "                     Ko;;::;cOKd;;xXx;;d0o;;;;;cxXNKdc;;;;;o0k:;;;;:xx:;;;;:oKW                     \r\n"
						+ "                     0l,:do;;d0o,;dKd;,lkl,;od:,cxko;;cddookKx;,:lokKx;,cdc,;xN                     \r\n"
						+ "                     0l,;c:;;x0o,;dKd;,lkl,;::;:xkoc,:xxc:coOd;,;;:dKx;,;c;;lKW                     \r\n"
						+ "                     0l,:xd:,cxo,,lkl;,okl,;c:,:xOkl,;ldl:,;dd;,:ldkKx;,:c;;oKW                     \r\n"
						+ "                     Kl,;::;;o0kc;;;;;ck0o;;xkc,:xXOo;;;:;;o0x;,;;;cxd;,oko;;oX                     \r\n"
						+ "                     W0xddxk0NWN0xdxxOKNXkxkXN0xx0XNX0kxxxkKNXOkkkxk00xdOXKkk0N                     \r\n"
						+ "                     WOoccd0WWXxlclkXW0occoONW0dccloONWW0occo0W WN0xolccclox0N                      \r\n"
						+ "                     Kl,,,;dX0l;,,,cOKo,,,,c0Xd;,,,,:xNNd;,,,oXW0o:,,,,,,,,,c0W                     \r\n"
						+ "                     0l,,,,coc,,,;:xXKl,,,,cOXo,,,,,,:xKo,,,,lK0l,,,;cdxxdllxX                      \r\n"
						+ "                    W0l,,,,,,,,,:o0WWKl,,,,cOXo,,,,,,,:lc,,,,l0d;,,;o00kxddx0N                      \r\n"
						+ "                     0l,,,,,,,,,:xXW Kl,,,,cOXo,,,,,;;,,,,,,,lOo;,,;x0o,,,,,:xN                     \r\n"
						+ "                     0l,,,,:c;,,,;o0NKl,,,,cOXo,,,,,lxl;,,,,,l0x;,,,ckkdl;,,,lKW                    \r\n"
						+ "                     Kl,,,,oOo;,,,,:k0l,,,,cOXo,,,,,oK0l;,,,,oKKd;,,;:llc;,,;dN                     \r\n"
						+ "                     Xo;,,;xNXxc;,,;xKd;,,;lKNx;,,,;dNW0l;,,;dNWXkl:;,,,,,;cxX                      \r\n"
						+ "                     WXkxxOXW WKkxxOXWXOxdkKWWXOxxxkXW WXkxxkXW  WN0kxxdxkOXW                       \r\n"
						+ "                     WXKK0KKKKKKKKKKKKKK00KKKKKK0KKKKKKKKKKKKKKKKKKKKKK000KKKX                      \r\n"
						+ "                     NOxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxO                      \r\n"
						+ "                     WNOkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxkOX                      \r\n"
						+ "                       WX0OkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxkO0XN                       \r\n"
						+ "                         WWNXK0OOkkkxxxxxxxxxxxxxxxxxxxxxxxxxxxxkkkOO0KXNWWX                        \r\n"
						+ "                               WWWNNXXXXKKKKKKKKKKKKKKKKKKKKXXXXNNWWWWN                             \r\n"
						+ "                                                                                                    \r\n"
						+ "                                                                                                    \r\n"
						+ "                                                                                                    ");
	}

	public static void escapeN(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println();
		}
	}

	public static void play() {

		long start = System.currentTimeMillis();
		long time = 3 * 60 * 1000;
		escapeN(50);
		while ((System.currentTimeMillis() - start) < time) {
			PrintMenu();
			System.out.print("\t\t\t<선택> : ");
			int choice = sc.nextInt();

			if (choice == 1) {
				BuyIngredient();
			} else if (choice == 2) {

			} else if (choice == 3) {

			} else if (choice == 4) {
				CheckIngredient();
			} else if (choice == 5) {
				escapeN(50);
				System.out.println("\t\t\t게임을 포기하셨습니다.");
			} else {
				System.out.println("\t\t\t잘못 입력 하셨습니다. 재 입력 해주세요.");
			}

		}
	}

	public static void PrintMenu() {
		escapeN(10);
		System.out.println("\t\t\t======================= Menu ========================");
		System.out.println("\t\t\t[1]재료구매 [2]주방 및 제작 [3]햄버거 판매 [4]재료 재고파악 [5]포기");
	}

	public static void loading() {
		try {
			System.out.print("\t\t문여는 중");
			Thread.sleep(500);
			System.out.print("-----");
			Thread.sleep(300);
			System.out.print("-----");
			Thread.sleep(100);
			System.out.print("테이블 닦는중");
			Thread.sleep(300);
			System.out.print("-----");
			Thread.sleep(200);
			System.out.print("-----");
			Thread.sleep(200);
			System.out.print("불판 달구는중");
			Thread.sleep(200);
			System.out.print("-----");
			Thread.sleep(200);
			System.out.print("-----");
			Thread.sleep(200);
			System.out.print("냉장고 정리중");
			Thread.sleep(200);
			System.out.print("-----");
			Thread.sleep(200);
			System.out.println("장사 준비 완료!!");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ingredientCTRLMethod() {
		CTRL = new ArrayList<ingredientCTRL>();
	}

	static int Cntmeatpatty = 0;
	static int Cntshrimppatty = 0;
	static int Cntchickenpatty = 0;
	static int Cntbacon = 0;

	static int Cnttomato = 0;
	static int Cntpickle = 0;
	static int Cntcabbage = 0;

	static int Cntbread = 0;
	static int Cntmustard = 0;
	static int Cntketchup = 0;
	static int Cntcheese = 0;

	// [1] 재료구매

	public static void BuyIngredient() {
		while (true) {
			ingredientCTRL igCTRL = new ingredientCTRL();

			System.out.println("\t\t\t[1]육류 [2]채소류 [3]기타류 [4]처음화면으로 이동");
			System.out.print("\t\t\t<선택> : ");
			int num1 = sc.nextInt();

			if (num1 == 1) {

				System.out.println("\t\t\t[1]고기패티 [2]새우패티 [3]치킨패티 [4]베이컨 [5]이전");
				System.out.print("\t\t\t<선택> : ");
				int num2 = sc.nextInt();

				switch (num2) {
				case 1:
					escapeN(50);
					System.out.println("\t\t\t고기패티를 구매하였습니다.");
					System.out.println();
					Cntmeatpatty++;
					break;
				case 2:
					escapeN(50);
					System.out.println("\t\t\t새우패티를 구매하였습니다.");
					System.out.println();
					Cntshrimppatty++;
					break;
				case 3:
					escapeN(50);
					System.out.println("\t\t\t치킨패티를 구매하였습니다.");
					System.out.println();
					Cntchickenpatty++;
					break;
				case 4:
					escapeN(50);
					System.out.println("\t\t\t베이컨를 구매하였습니다.");
					System.out.println();
					Cntbacon++;
					break;
				case 5:
					escapeN(50);
					System.out.println("\t\t\t이전으로 돌아가겠습니다.");
					System.out.println();
					continue;
				}

			}

			if (num1 == 2) {

				System.out.println("\t\t\t[1]토마토 [2]피클 [3]양상추 [4]이전");
				System.out.print("\t\t\t<선택> : ");
				int num3 = sc.nextInt();

				switch (num3) {
				case 1:
					escapeN(50);
					System.out.println("\t\t\t토마토를 구매하였습니다.");
					System.out.println();
					Cnttomato++;
					break;
				case 2:
					escapeN(50);
					System.out.println("\t\t\t피클을 구매하였습니다.");
					System.out.println();
					Cntpickle++;
					break;
				case 3:
					escapeN(50);
					System.out.println("\t\t\t양상추를 구매하였습니다.");
					System.out.println();
					Cntcabbage++;
					break;
				case 4:
					escapeN(50);
					System.out.println("\t\t\t이전으로 돌아가겠습니다.");
					System.out.println();
					continue;
				}
			}

			if (num1 == 3) {

				System.out.println("\t\t\t[1]빵 [2]머스타드 [3]케찹 [4]치즈 [5]이전");
				System.out.print("\t\t\t<선택> : ");
				int num4 = sc.nextInt();

				switch (num4) {
				case 1:
					escapeN(50);
					System.out.println("\t\t\t빵을 구매하였습니다.");
					System.out.println();
					Cntbread++;
					break;
				case 2:
					escapeN(50);
					System.out.println("\t\t\t머스타드을 구매하였습니다.");
					System.out.println();
					Cntmustard++;
					break;
				case 3:
					escapeN(50);
					System.out.println("\t\t\t케찹을 구매하였습니다.");
					System.out.println();
					Cntketchup++;
					break;
				case 4:
					escapeN(50);
					System.out.println("\t\t\t치즈를 구매하였습니다.");
					System.out.println();
					Cntcheese++;
					break;
				case 5:
					escapeN(50);
					System.out.println("\t\t\t이전으로 돌아가겠습니다.");
					System.out.println();
					continue;
				}

			}

			if (num1 == 4) {
				escapeN(50);
				System.out.println("\t\t\t처음화면으로 이동합니다.");
				System.out.println();
				break;
			}

		}

	}

	// [2] 햄버거 제작

	int i1 = 0;
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
						arr[i1] = "고기패티";
						i1++;
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
						arr[i1] = "새우패티";
						i1++;
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
						arr[i1] = "치킨패티";
						i1++;
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
						arr[i1] = "베이컨";
						i1++;
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
						arr[i1] = "토마토";
						i1++;
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
						arr[i1] = "피클";
						i1++;
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
						arr[i1] = "양상추";
						i1++;
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
						arr[i1] = "빵";
						i1++;
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
						arr[i1] = "머스타드";
						i1++;
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
						arr[i1] = "케찹";
						i1++;
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
						arr[i1] = "치즈";
						i1++;
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

	// [4] 재료 재고파악

	public static void CheckIngredient() {
		System.out.println("\t\t\t<육류> --[1]고기패티 : " + Cntmeatpatty + "개, [2]새우패티 : " + Cntshrimppatty + "개, [3]치킨패티 : "
				+ Cntchickenpatty + "개, [4]베이컨 : " + Cntbacon + "개");
		System.out.println(
				"\t\t\t<야채류>--[1]토마토 : " + Cnttomato + "개, [2]피클 : " + Cntpickle + "개, [3]양상추 : " + Cntcabbage + "개");
		System.out.println("\t\t\t<기타류>--[1]빵 : " + Cntbread + "개, [2]머스타드 : " + Cntmustard + "개, [3]케찹 : " + Cntketchup
				+ "개, [4]치즈 : " + Cntcheese + "개");
	}

	public static void coungGui() {
		JFrame jframe = new JFrame();
		JLabel jLabel = new JLabel();
		jframe.setLayout(new FlowLayout());
		jframe.setBounds(170, 0, 170, 100);

		jframe.add(jLabel);
		jframe.setVisible(true);

		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {
			int i = 3;

			public void run() {
				jLabel.setText(/*객체스트링*/ " : " + i);
				i--;

				if (i < 0) {
					timer.cancel();
					jLabel.setText("이집 별로네...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					jframe.setVisible(false);
				}
			}
		}, 0, 1000);
	}

}
