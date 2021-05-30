package ma.patiencovid.patient;

public class Maladie {
	int id_Symptome;
	int id_Diagnostic;
	// Les deux id sont clé primaire

	public Maladie() {
		this.id_Symptome = -1;
		this.id_Diagnostic = -1;
	}

	public Maladie(int idSymp, int idDiag) {
		this.id_Symptome = idSymp;
		this.id_Symptome = idDiag;
	}

	public int getIdSymp() {
		return this.id_Symptome;
	}

	public void setIdSymp(int id) {
		this.id_Symptome = id;
	}

	public int getIdDiag() {
		return this.id_Diagnostic;
	}

	public void setIdDiag(int id) {
		this.id_Diagnostic = id;
	}

}
