package ma.patiencovid.patient;

public class Symptome {
	int id_Symptome; // clé primaire
	String descriptionSymptome;

	public Symptome(int id, String desc) {
		this.id_Symptome = id;
		this.descriptionSymptome = desc;
	}

	public Symptome() {
		this.id_Symptome = -1;
		this.descriptionSymptome = null;
	}

	public int getId() {
		return this.id_Symptome;
	}

	public void setId(int id) {
		this.id_Symptome = id;
	}

	public String getDesc() {
		return this.descriptionSymptome;
	}

	public void setDesc(String desc) {
		this.descriptionSymptome = desc;
	}
}
