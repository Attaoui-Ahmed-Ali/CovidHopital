package ma.patientcovid.user;

public abstract class User {
	int id_User;
	String login;
	String passwd;
	
	public abstract int getId();
	
	public abstract void setId(int id);
	
	public abstract String getLogin();
	
	public abstract void setLogin(String login);
	
	public abstract String getPwd();
	
	public abstract void setPwd(String login);
	
}

