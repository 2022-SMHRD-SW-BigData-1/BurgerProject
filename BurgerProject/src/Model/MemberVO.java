package Model;

public class MemberVO {
	// DTO - 로직은 가지고 있지 않으나 순수하게 데이터 객체. 메소드로는 Getter/Setter
	private String id;
	private String pw;
	private String nick;
	private int age;

	// 생성자
	public MemberVO(String id, String pw, String nick, int age) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.age = age;
	}
	// VO는 매개변수 자체를 나타내기 위해서 만든거다

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


}
