package ex01_setter;

public class User {
	
	private int userNo;
	private String id;
	private String eamil;
	
	public int getUserNo() {
		return userNo;
	}
	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", id=" + id + ", eamil=" + eamil + "]";
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

}
