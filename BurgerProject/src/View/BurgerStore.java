package View;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

import CTRL.DAO;
import CTRL.arrayCTRL;
import CTRL.customerCTRL;
import CTRL.customerCharCTRL;

public class BurgerStore {
	static DAO dao = new DAO();
	static Scanner sc = new Scanner(System.in);
	static int i = 1;
	static arrayCTRL ac = new arrayCTRL();

	static String cusName = "";
	static String cusDia = "";
	static String cusIng = "";
	static String cusChar = "";
	static int Cntmeatpatty = 0;
	static int Cntshrimppatty = 0;
	static int Cntchickenpatty = 0;
	static int Cntbacon = 0;

	static String id;
	static int Cnttomato = 0;
	static int Cntpickle = 0;
	static int Cntcabbage = 0;

	static int Cntbread = 0;
	static int Cntmustard = 0;
	static int Cntketchup = 0;
	static int Cntcheese = 0;
	static int cntAppear = 0;
	static int cntEasy = 2;
	static int cntNormal = 3;
	static int cntHard = 4;
	static int score = 10000;
	static int check = 0;
	static int check2 = 0;
	static int endcheck = 1;
	static int level = 0;
	static String[] easy;
	static String[] normal;
	static String[] hard;
	static ArrayList<String> ans = new ArrayList<>();
	
	static JFrame jframe = new JFrame();
	static JLabel jLabel = new JLabel();
	static Timer timer = new Timer();

	public static void main(String[] args) {
		while (true) {
			endcheck = 1;
			startLogo();
			User();
			start();
			selectLevel();
			loading();
			play();
			System.out.println("\t\t\t게임이 끝났습니다. 정산결과 당신의 점수는 " + score + "점 입니다.");
			ranking();
			System.out.print("\t\t\t게임을 계속 하시겠습니까? Y/N");
			String choice = sc.next();
			if (choice.equals("y") || choice.equals("Y")) {
				continue;
			} else {
				try {
					System.out.println("\t\t\t게임을 종료합니다.");
					System.out.print("\t\t\t3..");
					Thread.sleep(1000);
					System.out.print("2..");
					Thread.sleep(1000);
					System.out.print("1..");
					Thread.sleep(500);
					System.exit(0);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}

	}

	// User 회원가입, 로그인, 탈퇴, 종료 등 시작 메소드
	public static void User() {
		while (true) {
			System.out.print("\t\t\t\t[1]회원가입 [2]로그인 [3]탈퇴 [4]랭킹확인 [5]종료 >> ");
			int enu = sc.nextInt();

			if (enu == 1) {
				// 회원가입 기능 연결
				System.out.println("\t\t\t\t==========회원등록==========");
				System.out.print("\t\t\t\tID : ");
				id = sc.next();
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
				id = sc.next();
				System.out.print("\t\t\t\tPW : ");
				String pw = sc.next();
				int cnt = dao.login(id, pw);
				if (cnt == 1) {
					escapeN(30);
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
				rankView();
			} else if (enu == 5) {
				try {
					System.out.println("\t\t\t게임을 종료합니다.");
					System.out.print("\t\t\t3..");

					Thread.sleep(1000);

					System.out.print("2..");
					Thread.sleep(1000);
					System.out.print("1..");
					Thread.sleep(500);
					System.exit(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("\t\t\t\t잘못 입력하셨습니다.");
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
		int num = sc.nextInt();
		switch (num) {
		case 1: {
			level = 1;
			System.out.println("\t\t\t\tEasy 난이도를 선택하셨습니다. 곧 게임을 시작하겠습니다.");

			break;
		}
		case 2: {
			level = 2;
			System.out.println("\t\t\t\tNormal 난이도를 선택하셨습니다. 곧 게임을 시작하겠습니다.");

			break;
		}
		case 3: {
			level = 3;
			System.out.println("\t\t\t\tHard 난이도를 선택하셨습니다. 곧 게임을 시작하겠습니다.");

			break;
		}
		default:
			break;
		}

	}

	public static void cusAppearCnt() {

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {

				cusAppear(level);
				++cntAppear;
				if (cntAppear == cntEasy) {
					timer.cancel();
				} else if (cntAppear == cntNormal) {
					timer.cancel();
				} else if (cntAppear == cntHard) {
					timer.cancel();
				}
			}
		};
		timer.schedule(task, 1000, 10000);

	}

	public static void startLogo() {
		try {
			System.out.print(
					"                                                                                                    \n");
			Thread.sleep(60);
			System.out.print(
					"                                                                                                    \n");
			Thread.sleep(60);
			System.out.print(
					"                                          WWWWWWWWWWWWWWWW                                          \n");
			Thread.sleep(60);
			System.out.print(
					"                                  WWNXXKK00OOOkkkkkkkOOOO00KKXXNWW                                  \n");
			Thread.sleep(60);
			System.out.print(
					"                              WNXK0OkxxxxxxxxxxxxxxxxxxxxxxxxxxkO0KXNW                              \n");
			Thread.sleep(60);
			System.out.print(
					"                           WNKOkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxk0KNW                           \n");
			Thread.sleep(60);
			System.out.print(
					"                         WX0kxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxk0XW                         \n");
			Thread.sleep(60);
			System.out.print(
					"                       WXOxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxk0XW                       \n");
			Thread.sleep(60);
			System.out.print(
					"                      WKkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxkKW                      \n");
			Thread.sleep(60);
			System.out.print(
					"                     WKkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxkKW                     \n");
			Thread.sleep(60);
			System.out.print(
					"                     NOxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxON                     \n");
			Thread.sleep(60);
			System.out.print(
					"                     WX000000000000000000000000000000000000000000000000000000KW                     \n");
			Thread.sleep(60);
			System.out.print(
					"                     WXOOkO0XWWXO0XWX0OXNXOOOO0XWW WNX0OkO0XWN0OOOO0XN0OOOOKNW                      \n");
			Thread.sleep(60);
			System.out.print(
					"                     Ko;;::;cOKd;;xXx;;d0o;;;;;cxXNKdc;;;;;o0k:;;;;:xx:;;;;:oKW                     \n");
			Thread.sleep(60);
			System.out.print(
					"                     0l,:do;;d0o,;dKd;,lkl,;od:,cxko;;cddookKx;,:lokKx;,cdc,;xN                     \n");
			Thread.sleep(60);
			System.out.print(
					"                     0l,;c:;;x0o,;dKd;,lkl,;::;:xkoc,:xxc:coOd;,;;:dKx;,;c;;lKW                     \n");
			Thread.sleep(60);
			System.out.print(
					"                     0l,:xd:,cxo,,lkl;,okl,;c:,:xOkl,;ldl:,;dd;,:ldkKx;,:c;;oKW                     \n");
			Thread.sleep(60);
			System.out.print(
					"                     Kl,;::;;o0kc;;;;;ck0o;;xkc,:xXOo;;;:;;o0x;,;;;cxd;,oko;;oX                     \n");
			Thread.sleep(60);
			System.out.print(
					"                     W0xddxk0NWN0xdxxOKNXkxkXN0xx0XNX0kxxxkKNXOkkkxk00xdOXKkk0N                     \n");
			Thread.sleep(60);
			System.out.print(
					"                     WOoccd0WWXxlclkXW0occoONW0dccloONWW0occo0W WN0xolccclox0N                      \n");
			Thread.sleep(60);
			System.out.print(
					"                     Kl,,,;dX0l;,,,cOKo,,,,c0Xd;,,,,:xNNd;,,,oXW0o:,,,,,,,,,c0W                     \n");
			Thread.sleep(60);
			System.out.print(
					"                     0l,,,,coc,,,;:xXKl,,,,cOXo,,,,,,:xKo,,,,lK0l,,,;cdxxdllxX                      \n");
			Thread.sleep(60);
			System.out.print(
					"                     0l,,,,,,,,,:o0WWKl,,,,cOXo,,,,,,,:lc,,,,l0d;,,;o00kxddx0N                      \n");
			Thread.sleep(60);
			System.out.print(
					"                     0l,,,,,,,,,:xXW Kl,,,,cOXo,,,,,;;,,,,,,,lOo;,,;x0o,,,,,:xN                     \n");
			Thread.sleep(60);
			System.out.print(
					"                     0l,,,,:c;,,,;o0NKl,,,,cOXo,,,,,lxl;,,,,,l0x;,,,ckkdl;,,,lKW                    \n");
			Thread.sleep(60);
			System.out.print(
					"                     Kl,,,,oOo;,,,,:k0l,,,,cOXo,,,,,oK0l;,,,,oKKd;,,;:llc;,,;dN                     \n");
			Thread.sleep(60);
			System.out.print(
					"                     Xo;,,;xNXxc;,,;xKd;,,;lKNx;,,,;dNW0l;,,;dNWXkl:;,,,,,;cxX                      \n");
			Thread.sleep(60);
			System.out.print(
					"                     WXkxxOXW WKkxxOXWXOxdkKWWXOxxxkXW WXkxxkXW  WN0kxxdxkOXW                       \n");
			Thread.sleep(60);
			System.out.print(
					"                     WXKK0KKKKKKKKKKKKKK00KKKKKK0KKKKKKKKKKKKKKKKKKKKKK000KKKX                      \n");
			Thread.sleep(60);
			System.out.print(
					"                     NOxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxO                      \n");
			Thread.sleep(60);
			System.out.print(
					"                     WNOkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxkOX                      \n");
			Thread.sleep(60);
			System.out.print(
					"                       WX0OkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxkO0XN                       \n");
			Thread.sleep(60);
			System.out.print(
					"                         WWNXK0OOkkkxxxxxxxxxxxxxxxxxxxxxxxxxxxxkkkOO0KXNWWX                        \n");
			Thread.sleep(60);
			System.out.print(
					"                               WWWNNXXXXKKKKKKKKKKKKKKKKKKKKXXXXNNWWWWN                             \n");
			Thread.sleep(60);
			System.out.print(
					"                                                                                                    \n");
			Thread.sleep(60);
			System.out.print(
					"                                                                                                    \n");
			Thread.sleep(60);
			System.out.println(
					"                                                                                                      ");
			System.out.println("\t\t    ____  __  ______  ________________  __ __ _____   ________\r\n"
					+ "\t\t   / __ )/ / / / __ \\/ ____/ ____/ __ \\/ //_//  _/ | / / ____/\r\n"
					+ "\t\t  / __  / / / / /_/ / / __/ __/ / /_/ / ,<   / //  |/ / / __  \r\n"
					+ "\t\t / /_/ / /_/ / _, _/ /_/ / /___/ _, _/ /| |_/ // /|  / /_/ /  \r\n"
					+ "\t\t/_____/\\____/_/ |_|\\____/_____/_/ |_/_/ |_/___/_/ |_/\\____/\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void escapeN(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println();
		}
	}

	public static void play() {
		long start = System.currentTimeMillis();
		int minute = 60;
		long time = minute * 1000;

		escapeN(30);
		startTimeGui(minute);
		while ((System.currentTimeMillis() - start) < time) {
			if (check == 0) {
				cusAppear(level);
				check = 1;
			} else {

				System.out.println("\t\t\t======================= Menu ========================");
				System.out.println("\t\t\t[1]재료구매 [2]주방 및 제작 [3]버거 판매 [4]재료 재고파악");
				System.out.print("\t\t\t<선택> : ");
				escapeN(2);
				int choice = sc.nextInt();

				if (choice == 1) {
					BuyIngredient();
				} else if (choice == 2) {
					MakeHamburger();
				} else if (choice == 3) {
					if (ans.size() == 0) {
						System.out.println("\t\t\t버거가 준비되지 않았습니다!");
					} else
						SellHamburger();
				} else if (choice == 4) {
					CheckIngredient();
				} else {
					System.out.println("\t\t\t잘못 입력 하셨습니다. 재 입력 해주세요.");
					escapeN(2);
				}
			}
		}
	}

	public static void loading() {
		try {
			escapeN(3);
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
			Thread.sleep(500);
			System.out.print("-----");
			Thread.sleep(500);
			System.out.print("-----");
			Thread.sleep(200);
			System.out.print("냉장고 정리중");
			Thread.sleep(300);
			System.out.print("-----");
			Thread.sleep(200);
			System.out.println("장사 준비 완료!!");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void BuyIngredient() {

		while (endcheck == 1) {

			escapeN(2);
			cusAppear(level);
			System.out.println("\t\t\t[1]육류 [2]채소류 [3]기타류 [4]처음화면으로 이동");
			System.out.print("\t\t\t<선택> : ");
			int num1 = sc.nextInt();
			escapeN(5);

			if (num1 == 1) {

				escapeN(2);
				cusAppear(level);
				System.out.println("\t\t\t[1]고기패티(50원)-" + Cntmeatpatty + "개 [2]새우패티(50원)-" + Cntshrimppatty
						+ "개 [3]치킨패티(50원)-" + Cntchickenpatty + "개 [4]베이컨(50원)-" + Cntbacon + "개 [5]이전");
				System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
				System.out.print("\t\t\t<선택> : ");
				int num2 = sc.nextInt();
				escapeN(5);
				switch (num2) {
				case 1:

					escapeN(2);

					System.out.println("\t\t\t고기패티를 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntmeatpatty++;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					escapeN(2);
					break;
				case 2:

					escapeN(2);

					System.out.println("\t\t\t새우패티를 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntshrimppatty++;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					escapeN(2);
					break;
				case 3:

					escapeN(2);

					System.out.println("\t\t\t치킨패티를 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntchickenpatty++;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					escapeN(2);
					break;
				case 4:

					escapeN(2);

					System.out.println("\t\t\t베이컨를 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntbacon++;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					escapeN(2);
					break;
				case 5:

					escapeN(2);

					System.out.println("\t\t\t이전으로 돌아가겠습니다.");
					System.out.println();
					escapeN(2);
					continue;
				}

			}

			if (num1 == 2) {

				escapeN(2);
				cusAppear(level);
				System.out.println("\t\t\t[1]토마토(50원)-" + Cnttomato + "개 [2]피클(50원)-" + Cntpickle + "개 [3]양상추(50원)-"
						+ Cntcabbage + "개 [4]이전");
				System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
				System.out.print("\t\t\t<선택> : ");
				int num3 = sc.nextInt();
				escapeN(5);
				switch (num3) {
				case 1:

					escapeN(2);

					System.out.println("\t\t\t토마토를 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cnttomato++;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					escapeN(2);
					break;
				case 2:

					escapeN(2);

					System.out.println("\t\t\t피클을 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntpickle++;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					escapeN(2);
					break;
				case 3:

					escapeN(2);

					System.out.println("\t\t\t양상추를 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntcabbage++;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					escapeN(2);
					break;
				case 4:

					escapeN(2);

					System.out.println("\t\t\t이전으로 돌아가겠습니다.");
					System.out.println();
					escapeN(2);
					continue;
				}
			}

			if (num1 == 3) {

				escapeN(2);
				cusAppear(level);
				System.out.println("\t\t\t[1]빵(50원)-" + Cntbread + "개 [2]머스타드(50원)-" + Cntmustard + "개 [3]케찹(50원)-"
						+ Cntketchup + "개 [4]치즈(50원)-" + Cntcheese + "개 [5]이전");
				System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
				System.out.print("\t\t\t<선택> : ");

				int num4 = sc.nextInt();
				escapeN(5);
				switch (num4) {
				case 1:

					escapeN(2);
					System.out.println("\t\t\t빵을 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntbread++;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					escapeN(2);
					break;
				case 2:

					escapeN(2);
					System.out.println("\t\t\t머스타드을 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntmustard++;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					escapeN(2);
					break;
				case 3:

					escapeN(2);
					System.out.println("\t\t\t케찹을 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntketchup++;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					escapeN(2);
					break;
				case 4:

					escapeN(2);
					System.out.println("\t\t\t치즈를 구매하였습니다.");
					System.out.println();
					score -= 50;
					Cntcheese++;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					escapeN(2);
					break;
				case 5:

					escapeN(2);
					System.out.println("\t\t\t이전으로 돌아가겠습니다.");
					System.out.println();
					escapeN(2);
					continue;
				}

			}

			if (num1 == 4) {

				escapeN(2);
				System.out.println("\t\t\t처음화면으로 이동합니다.");
				System.out.println();
				escapeN(2);
				break;
			}

		}

	}

	public static void MakeHamburger() {

		while (endcheck == 1) {

			escapeN(2);
			cusAppear(level);
			System.out.println("\t\t\t버거에 들어갈 재료를 골라주세요.");
			System.out.println("\t\t\t[1]육류 [2]채소류 [3]기타류 [4]버거 완성 [5]재료 버리기 [6]처음화면으로 이동");
			System.out.print("\t\t\t<선택> : ");

			int num1 = sc.nextInt();
			escapeN(5);
			if (num1 == 1) {

				escapeN(2);
				cusAppear(level);
				System.out.println("\t\t\t[1]고기패티(" + Cntmeatpatty + ") [2]새우패티(" + Cntshrimppatty + ") [3]치킨패티("
						+ Cntchickenpatty + ") [4]베이컨(" + Cntbacon + ") [5]이전");
				System.out.print("\t\t\t<선택> : ");

				int num2 = sc.nextInt();
				escapeN(5);
				switch (num2) {
				case 1:

					if (Cntmeatpatty <= 0) {
						escapeN(2);
						System.out.println("\t\t\t고기패티의 재고가 부족합니다.");
						System.out.println();
						escapeN(2);
					} else {
						escapeN(2);
						System.out.println("\t\t\t고기패티를 추가했습니다.");
						System.out.println();
						escapeN(2);
						ans.add("고기패티");
						Cntmeatpatty--;
					}
					break;
				case 2:

					if (Cntshrimppatty <= 0) {
						escapeN(2);
						System.out.println("\t\t\t새우패티의 재고가 부족합니다.");
						System.out.println();
						escapeN(2);
					} else {
						escapeN(2);
						System.out.println("\t\t\t새우패티를 추가했습니다.");
						System.out.println();
						escapeN(2);
						ans.add("새우패티");
						Cntshrimppatty--;
					}
					break;
				case 3:

					if (Cntchickenpatty <= 0) {
						escapeN(2);
						System.out.println("\t\t\t치킨패티의 재고가 부족합니다.");
						System.out.println();
						escapeN(2);
					} else {
						escapeN(2);
						System.out.println("\t\t\t치킨패티를 추가했습니다.");
						System.out.println();
						escapeN(2);
						ans.add("치킨패티");

						Cntchickenpatty--;
					}
					break;
				case 4:

					if (Cntbacon <= 0) {
						escapeN(2);
						System.out.println("\t\t\t베이컨의 재고가 부족합니다.");
						System.out.println();
						escapeN(2);
					} else {
						escapeN(2);
						System.out.println("\t\t\t베이컨를 추가했습니다.");
						System.out.println();
						escapeN(2);
						ans.add("베이컨");

						Cntbacon--;
					}
					break;
				case 5:

					escapeN(2);
					System.out.println("\t\t\t이전으로 돌아가겠습니다.");
					System.out.println();
					escapeN(2);
					continue;
				}

			}

			if (num1 == 2) {

				escapeN(2);
				cusAppear(level);
				System.out.println(
						"\t\t\t[1]토마토(" + Cnttomato + ") [2]피클(" + Cntpickle + ") [3]양상추(" + Cntcabbage + ") [4]이전");
				System.out.print("\t\t\t<선택> : ");

				int num3 = sc.nextInt();
				escapeN(5);
				switch (num3) {
				case 1:

					if (Cnttomato <= 0) {
						escapeN(2);
						System.out.println("\t\t\t토마토의 재고가 부족합니다.");
						System.out.println();
						escapeN(2);
					} else {
						escapeN(2);
						System.out.println("\t\t\t토마토를 추가했습니다.");
						System.out.println();
						ans.add("토마토");
						Cnttomato--;
						escapeN(2);
					}
					break;
				case 2:

					if (Cntpickle <= 0) {
						escapeN(2);
						System.out.println("\t\t\t피클의 재고가 부족합니다.");
						System.out.println();
						escapeN(2);
					} else {
						escapeN(2);
						System.out.println("\t\t\t피클을 추가했습니다.");
						System.out.println();
						escapeN(2);
						ans.add("피클");
						Cntpickle--;
					}
					break;
				case 3:

					if (Cntcabbage <= 0) {
						escapeN(2);
						System.out.println("\t\t\t양상추의 재고가 부족합니다.");
						System.out.println();
						escapeN(2);
					} else {
						escapeN(2);
						System.out.println("\t\t\t양상추를 추가했습니다.");
						System.out.println();
						escapeN(2);
						ans.add("양상추");

						Cntcabbage--;
					}
					break;
				case 4:

					escapeN(2);
					System.out.println("\t\t\t이전으로 돌아가겠습니다.");
					System.out.println();
					escapeN(2);
					continue;
				}
			}

			if (num1 == 3) {

				escapeN(2);
				cusAppear(level);
				System.out.println("\t\t\t[1]빵(" + Cntbread + ") [2]머스타드(" + Cntmustard + ") [3]케찹(" + Cntketchup
						+ ") [4]치즈(" + Cntcheese + ") [5]이전");
				System.out.print("\t\t\t<선택> : ");

				int num4 = sc.nextInt();
				escapeN(5);
				switch (num4) {
				case 1:

					if (Cntbread <= 0) {
						escapeN(2);
						System.out.println("\t\t\t빵의 재고가 부족합니다.");
						System.out.println();
						escapeN(2);
					} else {
						escapeN(2);
						System.out.println("\t\t\t빵을 추가했습니다.");
						System.out.println();
						ans.add("빵");
						Cntbread--;
						escapeN(2);
					}
					break;
				case 2:

					if (Cntmustard <= 0) {
						escapeN(2);
						System.out.println("\t\t\t머스타드의 재고가 부족합니다.");
						System.out.println();
						escapeN(2);
					} else {
						escapeN(2);
						System.out.println("\t\t\t머스타드를 추가했습니다.");
						System.out.println();
						escapeN(2);
						ans.add("머스타드");

						Cntmustard--;
					}
					break;
				case 3:

					if (Cntketchup <= 0) {
						escapeN(2);
						System.out.println("\t\t\t케찹이 부족합니다.");
						System.out.println();
						escapeN(2);
					} else {
						escapeN(2);
						System.out.println("\t\t\t케찹을 추가했습니다.");
						System.out.println();
						escapeN(2);
						ans.add("케찹");

						Cntketchup--;
					}
					break;
				case 4:

					if (Cntcheese <= 0) {
						escapeN(2);
						System.out.println("\t\t\t치즈의 재고가 부족합니다.");
						System.out.println();
						escapeN(2);
					} else {
						escapeN(2);
						System.out.println("\t\t\t치즈를 추가했습니다.");
						System.out.println();
						escapeN(2);
						ans.add("치즈");

						Cntcheese--;
					}
					break;
				case 5:
					escapeN(2);
					System.out.println("\t\t\t이전으로 돌아가겠습니다.");
					System.out.println();
					escapeN(2);
					continue;
				}

			}
			if (num1 == 4) {
				escapeN(2);
				System.out.println("\t\t\t버거를 완성하였습니다.");
				System.out.print("\t\t\t[");
				for (int i = 0; i < ans.size(); i++) {
					System.out.print(ans.get(i) + " ");
				}
				System.out.println("]");
				escapeN(2);

				break;
			}
			if (num1 == 5) {

				escapeN(2);
				if (ans.size() == 0) {
					System.out.println("\t\t\t버릴 재료가 없습니다.");
				} else {
					System.out.println("\t\t\t마지막에 넣은 재료를 버렸습니다.");
					ans.remove(ans.size() - 1);
				}

				escapeN(2);
			}
			if (num1 == 6) {

				escapeN(2);
				System.out.println("\t\t\t처음화면으로 이동합니다.");
				System.out.println();
				escapeN(2);
				break;
			}

		}
	}

	public static void SellHamburger() {

		int cntlength = 0;
		if (level == 1) {
			for (int j = 0; j < easy.length; j++) {
				if (ans.get(j) != easy[j]) {
					escapeN(2);
					System.out.println("\t\t\t버거 판매에 실패하였습니다.");
					score -= 250;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					timer.cancel();
					jframe.setVisible(false);
					check = 0;

					break;
				} else {
					++cntlength;
				}
			}
			if (ans.size() == 3) {
				if (cntlength == easy.length) {
					escapeN(2);
					System.out.println("\t\t\t버거 판매에 성공하였습니다.");
					score += 300;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					timer.cancel();
					jframe.setVisible(false);
					check = 0;

				}
			}
			if (ans.size() == 4) {
				if (cntlength == easy.length) {
					escapeN(2);
					System.out.println("\t\t\t버거 판매에 성공하였습니다.");
					score += 400;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					timer.cancel();
					jframe.setVisible(false);
					check = 0;

				}
			}
			if (ans.size() == 5) {
				if (cntlength == easy.length) {
					escapeN(2);
					System.out.println("\t\t\t버거 판매에 성공하였습니다.");
					score += 500;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					timer.cancel();
					jframe.setVisible(false);
					check = 0;

				}
			}
		} else if (level == 2) {
			for (int j = 0; j < normal.length; j++) {
				if (ans.get(j) != normal[j]) {
					escapeN(2);
					System.out.println("\t\t\t버거 판매에 실패하였습니다.");
					score -= 250;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					timer.cancel();
					jframe.setVisible(false);
					check = 0;
					escapeN(2);
					break;
				} else {
					++cntlength;
				}
			}
			if (ans.size() == 5) {
				if (cntlength == normal.length) {
					escapeN(2);
					System.out.println("\t\t\t버거 판매에 성공하였습니다.");
					score += 750;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					timer.cancel();
					jframe.setVisible(false);
					check = 0;
					escapeN(2);
				}
			}
			if (ans.size() == 6) {
				if (cntlength == normal.length) {
					escapeN(2);
					System.out.println("\t\t\t버거 판매에 성공하였습니다.");
					score += 900;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					timer.cancel();
					jframe.setVisible(false);
					check = 0;
					escapeN(2);
				}
			}
			if (ans.size() == 7) {
				if (cntlength == normal.length) {
					escapeN(2);
					System.out.println("\t\t\t버거 판매에 성공하였습니다.");
					score += 1050;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					timer.cancel();
					jframe.setVisible(false);
					check = 0;
					escapeN(2);
				}
			}
		} else if (level == 3) {
			for (int j = 0; j < hard.length; j++) {
				if (ans.get(j) != hard[j]) {
					escapeN(2);
					System.out.println("\t\t\t버거 판매에 실패하였습니다.");
					score -= 250;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					timer.cancel();
					jframe.setVisible(false);
					check = 0;
					escapeN(2);
					break;
				} else {
					++cntlength;
				}
			}
			if (ans.size() == 7) {
				if (cntlength == hard.length) {
					escapeN(2);
					System.out.println("\t\t\t버거 판매에 성공하였습니다.");
					score += 1400;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					timer.cancel();
					jframe.setVisible(false);
					check = 0;
					escapeN(2);
				}
			}
			if (ans.size() == 8) {
				if (cntlength == hard.length) {
					escapeN(2);
					System.out.println("\t\t\t버거 판매에 성공하였습니다.");
					score += 1600;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					timer.cancel();
					jframe.setVisible(false);
					check = 0;
					escapeN(2);
				}
			}
			if (ans.size() == 9) {
				if (cntlength == hard.length) {
					escapeN(2);
					System.out.println("\t\t\t버거 판매에 성공하였습니다.");
					score += 1800;
					System.out.println("\t\t\t현재 자산은 " + score + "원 입니다.");
					timer.cancel();
					jframe.setVisible(false);
					check = 0;
					escapeN(2);
				}
			}
		}
		ans.clear();

	}

	public static void CheckIngredient() {
		escapeN(2);
		System.out.println("\t\t\t<육류> --[1]고기패티 : " + Cntmeatpatty + "개, [2]새우패티 : " + Cntshrimppatty + "개, [3]치킨패티 : "
				+ Cntchickenpatty + "개, [4]베이컨 : " + Cntbacon + "개");
		System.out.println(
				"\t\t\t<야채류>--[1]토마토 : " + Cnttomato + "개, [2]피클 : " + Cntpickle + "개, [3]양상추 : " + Cntcabbage + "개");
		System.out.println("\t\t\t<기타류>--[1]빵 : " + Cntbread + "개, [2]머스타드 : " + Cntmustard + "개, [3]케찹 : " + Cntketchup
				+ "개, [4]치즈 : " + Cntcheese + "개");
		escapeN(2);
	}

	public static void countGui() {
		
		jframe.setLayout(new FlowLayout());
		jframe.setBounds(170, 0, 170, 100);

		jframe.add(jLabel);
		jframe.setVisible(true);


		timer.scheduleAtFixedRate(new TimerTask() {
			int i = 3;

			public void run() {
				jLabel.setText(/* 객체스트링 */ " : " + i);
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

	public static void cusAppear(int lev) {

		customerCTRL cus = new customerCTRL();
		customerCharCTRL ccv = new customerCharCTRL();
		if (check == 0 || check2 == 0) {
			cusName = cus.customer();
			cusDia = cus.dialogue();
			cusChar = ccv.customerchar();
			if (lev == 1) {
				easy = ac.Easy();
				cusIng = Arrays.toString(easy);
			} else if (lev == 2) {
				normal = ac.Normal();
				cusIng = Arrays.toString(normal);
			} else if (lev == 3) {
				hard = ac.Hard();
				cusIng = Arrays.toString(hard);
			}
			if (easy.length == 3) {

				cusTime(15);
			} else if (easy.length == 4) {

				cusTime(17);
			} else if (easy.length == 5 || normal.length == 5) {

				cusTime(19);
			} else if (normal.length == 6) {

				cusTime(22);
			} else if (normal.length == 7 || hard.length == 7) {

				cusTime(24);
			} else if (hard.length == 8) {

				cusTime(26);
			} else if (hard.length == 9) {

				cusTime(28);
			}

		}
		
		System.out.println("\t\t\t" + cusChar);
		System.out.println("\t\t\t" + cusName);
		System.out.println("\t\t\t" + cusDia);
		System.out.println("\t\t\t" + cusIng);
		escapeN(1);
		

	}

	public static void cusTime(int time) {
		
		jframe.setLayout(new FlowLayout());
		jframe.setBounds(1200, 100, 170, 100);

		jframe.add(jLabel);
		jframe.setVisible(true);
		Font font = new Font("맑은 고딕", Font.PLAIN, 50);
		jLabel.setFont(font);

		timer.scheduleAtFixedRate(new TimerTask() {
			int i = time;
			public void run() {
				check2 = 1;
				jLabel.setText(cusName + " : " + i);
				i--;

				if (i == 0) {
					timer.cancel();
					jLabel.setText("\t\t\t" + cusName + "손님이 떠났습니다.");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					check2 = 0;
					System.out.println("\t\t\t" + cusName + "손님이 떠났습니다.");
					jframe.setVisible(false);
					cusAppear(level);
					

				}
			}
		}, 0, 1000);
	}

	public static void startTimeGui(int count) {
		JFrame jframe = new JFrame();
		JLabel jLabel = new JLabel();
		jframe.setLayout(new FlowLayout());
		jframe.setBounds(1200, 0, 170, 100);

		jframe.add(jLabel);
		jframe.setVisible(true);
		Font font = new Font("맑은 고딕", Font.PLAIN, 20);
		jLabel.setFont(font);
		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {
			int i = count;

			public void run() {
				jLabel.setText("게임시간 : " + (i / 60) + ":" + (i % 60));
				i--;

				if (i < 0) {
					timer.cancel();
					jLabel.setText("게임종료!!!");
					endcheck = 0;
				}
			}
		}, 0, 1000);
	}

	public static void ranking() {

		System.out.println("\t\t\t랭킹에 등록하겠습니다...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int r = dao.ranking(id, score);
		if (r == 1) {
			System.out.println("\t\t\t랭킹등록에 성공하였습니다!");
		} else {
			System.out.println("\t\t\t랭킹등록에 실패하였습니다..");
		}
	}

	public static void rankView() {
		System.out.println("\n\t\t\t\t랭킹\t닉네임\t점수");
		for (int i = 0; i < dao.rankView().size(); i++) {
			System.out.println("\t\t\t\t" + (i + 1) + "\t" + dao.rankView().get(i).getNickname() + "\t"
					+ dao.rankView().get(i).getScore());
		}
		System.out.println();

	}
}
