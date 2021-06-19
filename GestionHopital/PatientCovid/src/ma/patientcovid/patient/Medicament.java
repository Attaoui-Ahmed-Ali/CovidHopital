package ma.patientcovid.patient;

public class Medicament {
	int id; // clé primaire
	String desc;

	public Medicament(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public Medicament(int id) {
		this.id = id;
	}
	
	public Medicament(String desc) {
		this.desc = desc;
	}

	public Medicament() {
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
