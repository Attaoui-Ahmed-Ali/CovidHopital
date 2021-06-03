package ma.patientcovid.patient;

public class Medicament {
	int id_Medoc; // clé primaire
	String descriptionMedoc;

	public Medicament(int id, String desc) {
		this.id_Medoc = id;
		this.descriptionMedoc = desc;
	}

	public Medicament() {
		this.id_Medoc = -1;
		this.descriptionMedoc = null;
	}

	public int getId() {
		return this.id_Medoc;
	}

	public void setId(int id) {
		this.id_Medoc = id;
	}

	public String getDesc() {
		return this.descriptionMedoc;
	}

	public void setDesc(String desc) {
		this.descriptionMedoc = desc;
	}
}
