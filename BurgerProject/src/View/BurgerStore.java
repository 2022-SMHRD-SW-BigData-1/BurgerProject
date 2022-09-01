package View;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import CTRL.DAO;

public class BurgerStore {
	static DAO dao = new DAO();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		startLogo();
		User();
		start();
		selectLevel();

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
				System.out.print("\t\t\t\t닉네임 : ");
				String nick = sc.next();

				int cnt = dao.join(id, pw, nick, 10000);
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
		System.out.println("\t\t\t    환영합니다! 당신은 BurgerKing의 담당 쉐프입니다.\r\n"
				+ "\t\t\t    우리 식당의 규칙은 간단해요! FastFood인 만큼 빠르고! 맛있게! 손님들을 대접한다!\r\n"
				+ "\t\t\t    정말 쉽죠? 더이상의 설명은 생략한다. 진정한 쉐프생활은 맞아가면서 배우는법!!\n\n");
	}

	public static void selectLevel() {

		System.out.print("\t\t\t\t난이도를 선택하세요! >> ");
		System.out.print("[1]Easy  [2]Normal  [3]Hard   ");
		int nu = sc.nextInt();
		switch (nu) {
		case 1: {
			System.out.println("\t\t\t\tEasy 난이도를 선택하셨습니다. 3초 후 게임을 시작하겠습니다.");
			startCountdown(1);
			break;
		}
		case 2: {
			System.out.println("\t\t\t\tNormal 난이도를 선택하셨습니다. 3초 후 게임을 시작하겠습니다.");
			startCountdown(1);
			break;
		}
		case 3: {
			System.out.println("\t\t\t\tHard 난이도를 선택하셨습니다. 3초 후 게임을 시작하겠습니다.");
			startCountdown(1);
			break;
		}
		default:
			break;
		}

	}

	public static void startCountdown(int count) {

		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			int i = 3;
			
			@Override
			public void run() {
				if (i >= count) {
					System.out.println("\t\t\t\t[SYSTEM] 카운트다운 : " + i);
					i--;
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

}
