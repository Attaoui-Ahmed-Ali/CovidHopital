package ma.patientcovid.patient;

public class Symptome {
	int id; // clé primaire
	String desc;

	public Symptome(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public Symptome(String desc) {
		this.desc = desc;
	}

	public Symptome(int id) {
		this.id = id;
	}
	
	public Symptome() {
		this.id = -1;
		this.desc = null;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String toString() {
		return(id+",'"+desc+"'");
	}
	
	public String toStringNoid() {
		return("'"+desc+"'");
	}
}
