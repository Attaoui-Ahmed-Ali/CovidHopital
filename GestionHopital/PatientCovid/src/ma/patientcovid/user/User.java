package ma.patientcovid.user;

public class User {
	int id_User;
	String login;
	String passwd;
	
	public User(int id, String login, String pwd) {
		this.id_User = id;
		this.login = login;
		this.passwd = pwd;
	}
	
	public User() {
		this.id_User = -1;	
		this.login = null;
		this.passwd = null;
	}
	
	public  int getId() {
		return this.id_User;
	}
	
	public void setId(int id) {
		this.id_User = id;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPwd() {
		return this.passwd;
	}
	
	public void setPwd(String pwd) {
		this.passwd = pwd;
	}
	
}

