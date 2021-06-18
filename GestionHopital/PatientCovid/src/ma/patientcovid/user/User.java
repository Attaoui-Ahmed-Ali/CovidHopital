package ma.patientcovid.user;

public class User {
	int id; // clé primaire
	String login;
	String pwd;
	String perm;

	public User(int id, String login, String pwd, String perm) {
		this.id = id;
		this.login = login;
		this.pwd = pwd;
		this.perm = perm;
	}
	
	public User(String login, String pwd, String perm) {
		this.login = login;
		this.pwd = pwd;
		this.perm = perm;
	}
	
	public User(String login, String pwd) {
		this.login = login;
		this.pwd = pwd;
	}
	
	public User(int id) {
		this.id = id;
	}

	public User() {
		this.id = -1;
		this.login = null;
		this.pwd = null;
		this.perm = null;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPerm() {
		return this.perm;
	}

	public void setPerm(String perm) {
		this.perm = perm;
	}
	
	public String toString() {
		return(id + ",'" +login + "','" + pwd + "','" + perm + "'");
	}
	
	public String toStringNoid() {
		return("'" +login + "','" + pwd + "','" + perm + "'");
	}

}
