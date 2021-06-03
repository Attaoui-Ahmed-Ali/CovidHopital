package ma.patientcovid.patient;

import java.time.LocalDate;

public class Diagnostic {
	int id_Diagnostic; // clé primaire
	LocalDate date_contamination;
	LocalDate date_Diagnostic;
	LocalDate date_cloture;
	boolean etat_final; // true si patient survie et guéri sinon false
	int id_Patient;

	public Diagnostic(int id, LocalDate cont, LocalDate diag, LocalDate clot, boolean etatf, int idPat) {
		this.id_Diagnostic = id;
		this.date_contamination = cont;
		this.date_Diagnostic = diag;
		this.date_cloture = clot;
		this.etat_final = etatf;
		this.id_Patient = idPat;
	}

	public Diagnostic() {
		this.id_Diagnostic = -1;
		this.date_contamination = null;
		this.date_Diagnostic = null;
		this.date_cloture = null;
		this.etat_final = true;
		this.id_Patient = -1;
	}

	public int getId() {
		return this.id_Diagnostic;
	}

	public void setId(int id) {
		this.id_Diagnostic = id;
	}

	public LocalDate getCont() {
		return this.date_contamination;
	}

	public void setCont(LocalDate cont) {
		this.date_contamination = cont;
	}

	public LocalDate getDiag() {
		return this.date_Diagnostic;
	}

	public void setDiag(LocalDate diag) {
		this.date_Diagnostic = diag;
	}

	public LocalDate getClot() {
		return this.date_cloture;
	}

	public void setClot(LocalDate clot) {
		this.date_cloture = clot;
	}

	public boolean getEtatF() {
		return this.etat_final;
	}

	public void setEtatF(boolean etat) {
		this.etat_final = etat;
	}

	public int getIdPat() {
		return this.id_Patient;
	}

	public void setIdPat(int id) {
		this.id_Patient = id;
	}

}
