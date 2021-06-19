package ma.patientcovid.patient;

public class Maladie {
	int idS;
	int idD;
	// Les deux id sont clé primaire

	public Maladie() {
		this.idS = -1;
		this.idD = -1;
	}

	public Maladie(int idSymp, int idDiag) {
		this.idS = idSymp;
		this.idD = idDiag;
	}
	
	public Maladie(int idDiag) {
		this.idD = idDiag;
	}

	public int getIdSymp() {
		return this.idS;
	}

	public void setIdSymp(int id) {
		this.idS = id;
	}

	public int getIdDiag() {
		return this.idD;
	}

	public void setIdDiag(int id) {
		this.idD = id;
	}
	
	public String toString() {
		return(idS+","+idD);
	}
}
