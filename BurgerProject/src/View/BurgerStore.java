package View;

import java.util.Scanner;

import CTRL.DAO;

public class BurgerStore {
	static DAO dao = new DAO();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		User();

	}

	public static void User() {
		while (true) {
			System.out.print("[1]회원가입 [2]로그인 [3]조회 [4]탈퇴 [5]종료 >> ");
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
				System.out.println("나이 : ");
				int age = sc.nextInt();
				int cnt = dao.join(id, pw, nick, age);
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
				} else if (cnt == 0) {
					System.out.println("비밀번호가 틀렸습니다.");
				} else if (cnt == 2) {
					System.out.println("ID가 틀렸습니다..");
				} else {
					System.out.println("계정이 없습니다.");
				}

				System.out.println("=========================");

			} else if (menu == 3) {
				// 조회 기능 연결
				System.out.println("==========회원조회==========");
//				System.out.print("ID : ");
//				String id = sc.next();
				dao.select();
				System.out.println("=========================");
			} else if (menu == 4) {
				// 탈퇴 기능 연결
				System.out.println("==========회원조회==========");
				System.out.print("ID : ");
				String id = sc.next();
				dao.delete(id);
				System.out.println(id + " 유저가 탈퇴되었습니다.");
				System.out.println("=========================");
			} else if (menu == 5) {
				break;
			}
		}
	}

}
