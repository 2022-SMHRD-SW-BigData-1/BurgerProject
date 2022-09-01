package CTRL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Model.MemberVO;

public class DAO {
	Scanner sc = new Scanner(System.in);
	// Controller : View와 Model을 연결하기 위한 연결고리
	// DAO (Data Access Object) :
	// 데이터베이스에 접근하여 해당 로직을 수행할 수 있도록 하는 기능들
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {

		}
	}

	// 동적로딩 및 데이터베이스 연결 메소드
	// DB 접속
	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String id = "campus_h_0830_6";
			String pw = "smhrd6";

			conn = DriverManager.getConnection(url, id, pw);

			if (conn != null) {
//					System.out.println("접속 성공");
			} else {
				System.out.println("접속 실패");
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// [1]회원가입
	public int join(String id, String pw, String nick, int age) {
		int cnt = 0;
		try {
			getCon();
			String sql = "insert into memberInfo values(?,?,?,?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick);
			psmt.setInt(4, age);

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {

		} finally {
			close();
		}
		return cnt;
	}

	// [2]로그인
	// ID,PW 입력
	// ID, PW = DB 일치 로그인
	public int login(String id, String pw) {

		try {
			getCon();
			String sql = "select pw from memberInfo where id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();

			if (rs.next()) {// contentEquals는 타입과 내용이 전부 일치해야 됨
				if (rs.getString(1).contentEquals(pw)) {
					return 1; // 로그인 성공
				} else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1; // 아이디가 없어요.

		} catch (SQLException e) {

		} finally {
			close();
		}
		return -2;

	}

	// [3]조회
	public ArrayList<MemberVO> select() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			getCon();
			String sql = "select * from memberInfo";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String nick = rs.getString(3);
				int age = rs.getInt(4);
				MemberVO vo = new MemberVO(id, pw, nick, age);
				list.add(vo);
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getId() + " / " + list.get(i).getPw() + " / " + list.get(i).getNick()
						+ " / " + list.get(i).getAge());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// [4]탈퇴
	public int delete(String id) {
		int cnt = 0;
		try {
			getCon();
			String sql = "delete from memberInfo where id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			cnt = psmt.executeUpdate();
		} catch (SQLException e) {

		} finally {
			close();
		}
		return cnt;
	}
}
