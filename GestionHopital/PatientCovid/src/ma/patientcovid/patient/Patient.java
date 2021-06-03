package ma.patientcovid.patient;

import java.time.LocalDate;

public class Patient {
	int id_Patient; // clé primaire
	String CIN;
	LocalDate DateNaissance;
	String Nom;
	String Prenom;
	String Tel;
	String Adresse;
	String sexe; // prend F ou M

	public Patient(int id, String CIN, LocalDate DN, String nom, String prenom, String tel, String adresse, String sexe) {
		this.id_Patient = id;
		this.CIN = CIN;
		this.DateNaissance = DN;
		this.Nom = nom;
		this.Prenom = prenom;
		this.Tel = tel;
		this.Adresse = adresse;
		this.sexe = sexe;
	}

	public Patient() {
		this.id_Patient = -1;
		this.CIN = null;
		this.DateNaissance = null;
		this.Nom = null;
		this.Prenom = null;
		this.Tel = null;
		this.Adresse = null;
		this.sexe = null;
	}

	public int getId() {
		return this.id_Patient;
	}

	public void setId(int id) {
		this.id_Patient = id;
	}

	public String getCIN() {
		return this.CIN;
	}

	public void setCIN(String CIN) {
		this.CIN = CIN;
	}

	public LocalDate getDN() {
		return this.DateNaissance;
	}

	public void setDN(LocalDate DN) {
		this.DateNaissance = DN;
	}

	public String getNom() {
		return this.Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}

	public String getPrenom() {
		return this.Prenom;
	}

	public void setPrenom(String prenom) {
		this.Prenom = prenom;
	}

	public String getTel() {
		return this.Tel;
	}

	public void setTel(String tel) {
		this.Tel = tel;
	}

	public String getAdresse() {
		return this.Adresse;
	}

	public void setAdresse(String adresse) {
		this.Adresse = adresse;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

}
