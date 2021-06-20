package ma.patientcovid.room;

import java.time.LocalDate;

public class SejourHopitalier {
	int id_Sejour; // clé primaire
	LocalDate debutSejour;
	LocalDate finSejour;
	int id_Diagnostic;

	public SejourHopitalier(int id, LocalDate debut, LocalDate fin, int idDiag) {
		this.id_Sejour = id;
		this.debutSejour = debut;
		this.finSejour = fin;
		this.id_Diagnostic = idDiag;
	}
	
	public SejourHopitalier(int id) {
		this.id_Sejour = id;
	}
	
	public SejourHopitalier(LocalDate debut, LocalDate fin, int idDiag) {
		this.debutSejour = debut;
		this.finSejour = fin;
		this.id_Diagnostic = idDiag;
	}

	public SejourHopitalier() {
		this.id_Sejour = -1;
		this.debutSejour = null;
		this.finSejour = null;
		this.id_Diagnostic = -1;
	}

	public int getId() {
		return this.id_Sejour;
	}

	public void setId(int id) {
		this.id_Sejour = id;
	}

	public LocalDate getDebut() {
		return this.debutSejour;
	}

	public void setDebut(LocalDate debut) {
		this.debutSejour = debut;
	}

	public LocalDate getFin() {
		return this.finSejour;
	}

	public void setFin(LocalDate fin) {
		this.finSejour = fin;
	}

	public int getIdDiag() {
		return this.id_Diagnostic;
	}

	public void setIdDiag(int id) {
		this.id_Diagnostic = id;
	}
	
	public String toString() {
		return (id_Sejour+",'"+debutSejour+"','"+finSejour+"',"+id_Diagnostic);
	}
}
