package ma.patientcovid.patient;

import java.time.LocalDate;

public class Posologie {
	int id_Posologie; // clé primaire
	LocalDate date_debut;
	LocalDate date_fin;
	int nb_prise_jour;
	int id_Diagnostic;

	public Posologie(int id, LocalDate deb, LocalDate fin, int prise, int idDiag) {
		this.id_Posologie = id;
		this.date_debut = deb;
		this.date_fin = fin;
		this.nb_prise_jour = prise;
		this.id_Diagnostic = idDiag;
	}
	
	public Posologie(LocalDate deb, LocalDate fin, int prise, int idDiag) {
		this.date_debut = deb;
		this.date_fin = fin;
		this.nb_prise_jour = prise;
		this.id_Diagnostic = idDiag;
	}
	
	public Posologie(int id) {
		this.id_Posologie = id;
	}

	public Posologie() {
		this.id_Posologie = -1;
		this.date_debut = null;
		this.date_fin = null;
		this.nb_prise_jour = -1;
		this.id_Diagnostic = -1;
	}

	public int getId() {
		return this.id_Posologie;
	}

	public void setId(int id) {
		this.id_Posologie = id;
	}

	public LocalDate getDebut() {
		return this.date_debut;
	}

	public void setDebut(LocalDate debut) {
		this.date_debut = debut;
	}

	public LocalDate getFin() {
		return this.date_fin;
	}

	public void setFin(LocalDate fin) {
		this.date_fin = fin;
	}

	public int getPrise() {
		return (this.nb_prise_jour);
	}

	public void setPrise(int prise) {
		this.nb_prise_jour = prise;
	}

	public int getIdDiag() {
		return this.id_Diagnostic;
	}

	public void setIdDiag(int id) {
		this.id_Diagnostic = id;
	}
	
	public String toString() {
		return(id_Posologie+",'"+date_debut+"','"+date_fin+"',"+nb_prise_jour+","+id_Diagnostic);
	}
	
	public String toStringNoid() {
		return("'"+date_debut+"','"+date_fin+"',"+nb_prise_jour+","+id_Diagnostic);
	}
}
