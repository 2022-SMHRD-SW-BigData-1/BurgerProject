package View;

import java.util.Scanner;

import CTRL.DAO;
import Model.MemberVO;

public class BurgerStore {
	static DAO dao = new DAO();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		User();
		start();

	}
	// User 회원가입, 로그인, 탈퇴, 종료 등 시작 메소드
	public static void User() {
		while (true) {
			System.out.print("[1]회원가입 [2]로그인 [3]탈퇴 [4]종료 >> ");
			int menu = sc.nextInt();

			if (menu == 1) {
				// 회원가입 기능 연결
				System.out.println("==========회원등록==========");
				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("PW : ");
				String pw = sc.next();
				System.out.print("닉네임 : ");
				String nick = sc.next();
				
				int cnt = dao.join(id, pw, nick, 10000);
				if (cnt > 0) {
					System.out.println("회원등록 성공!");
				} else {
					System.out.println("등록 실패..");
				}
				System.out.println("=========================");

			} else if (menu == 2) {
				// 로그인 기능 연결
				System.out.println("==========로그인==========");
				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("PW : ");
				String pw = sc.next();
				int cnt = dao.login(id, pw);
				if (cnt == 1) {
					System.out.println("로그인 성공!");
					break;
				} else if (cnt == 0) {
					System.out.println("비밀번호가 틀렸습니다.");
				} else if (cnt == 2) {
					System.out.println("ID가 틀렸습니다..");
				} else if(cnt == -1){
					System.out.println("계정이 없습니다.");
				}

				System.out.println("=========================");
			
			} else if (menu == 3) {
				// 탈퇴 기능 연결
				System.out.println("==========회원조회==========");
				System.out.print("ID : ");
				String id = sc.next();
				dao.delete(id);
				System.out.println(id + " 유저가 탈퇴되었습니다.");
				System.out.println("=========================");
			} else if (menu == 4) {
				break;
			}
		}
	}
	public static void start() {
		System.out.println("축하드립니다! 당신은 BurgerKing의 담당 쉐프입니다.\r\n"
				+ "우리 식당의 규칙은 간단해요! FastFood인 만큼 빠르고! 맛있게! 손님들을 대접한다!\r\n"
				+ "정말 쉽죠? 더이상의 설명은 생략한다. 진정한 쉐프생활은 맞아가면서 배우는법!!");
	}
	
	public static void selectLevel() {
		System.out.print("난이도를 선택하세요! >> ");
		System.out.println("[1]Easy  [2]Normal  [3]Hard");
		int num = sc.nextInt();
		if (num == 1) {
			System.out.println("Easy 난이도를 선택하셨습니다. 3초 후 게임을 시작하겠습니다.");
		}
	}

}
