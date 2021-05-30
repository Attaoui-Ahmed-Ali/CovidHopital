package ma.patiencovid.patient;

public class Traitement {
	int id_Medoc;
	int id_Posologie;
	// les deux id sont clé primaire

	public Traitement() {
		this.id_Medoc = -1;
		this.id_Posologie = -1;
	}

	public Traitement(int idMed, int idPos) {
		this.id_Medoc = idMed;
		this.id_Posologie = idPos;
	}

	public int getIdMed() {
		return this.id_Medoc;
	}

	public void setIdMed(int id) {
		this.id_Medoc = id;
	}

	public int getIdPos() {
		return this.id_Posologie;
	}

	public void setIdPos(int id) {
		this.id_Posologie = id;
	}
}
