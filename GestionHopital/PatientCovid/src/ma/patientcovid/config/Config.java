package ma.patientcovid.config;

public class Config {

	public String BDD;
	public String IP;
	public String PRT;
	public String BDDNAME;
	public String USR;
	public String PSWD;
	public String SERVERIP;
	public String SERVERPORT;

	public Config() {
		this.BDD = "mysql";
		this.IP = "127.0.0.1";
		this.PRT = "9432";
		this.BDDNAME = "SchoolManagementSystem";
		this.USR = "root";
		this.PSWD = "";
	}

	private static Config instance;

	public static Config getInstance() {
		if (instance == null) {
			instance = fromDefaults();
		}
		return instance;
	}
	private static Config fromDefaults() {
		Config config = new Config();
		return config;
	}

}
