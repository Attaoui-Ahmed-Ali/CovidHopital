package ma.patientcovid.patient;

import java.time.LocalDate;

public class Patient {
	int id; // clé primaire
	String CIN;
	LocalDate DN;
	String Nom;
	String Prenom;
	String Tel;
	String Adresse;
	String sexe; // prend F ou M

	public Patient(int id, String CIN, LocalDate DN, String nom, String prenom, String tel, String adresse, String sexe) {
		this.id = id;
		this.CIN = CIN;
		this.DN = DN;
		this.Nom = nom;
		this.Prenom = prenom;
		this.Tel = tel;
		this.Adresse = adresse;
		this.sexe = sexe;
	}
	
	public Patient(String CIN, LocalDate DN, String nom, String prenom, String tel, String adresse, String sexe) {
		this.CIN = CIN;
		this.DN = DN;
		this.Nom = nom;
		this.Prenom = prenom;
		this.Tel = tel;
		this.Adresse = adresse;
		this.sexe = sexe;
	}
	
	public Patient(int id) {
		this.id = id;
	}

	public Patient() {
		this.id = -1;
		this.CIN = null;
		this.DN = null;
		this.Nom = null;
		this.Prenom = null;
		this.Tel = null;
		this.Adresse = null;
		this.sexe = null;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCIN() {
		return this.CIN;
	}

	public void setCIN(String CIN) {
		this.CIN = CIN;
	}

	public LocalDate getDN() {
		return this.DN;
	}

	public void setDN(LocalDate DN) {
		this.DN = DN;
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
	
	public String toString() {
		return(id+"'"+CIN+"','"+DN+"','"+Nom+"','"+Prenom+"','"+Tel+"','"+Adresse+"','"+sexe+"'");
	}
	
	public String toStringNoid() {
		return("'"+CIN+"','"+DN+"','"+Nom+"','"+Prenom+"','"+Tel+"','"+Adresse+"','"+sexe+"'");
	}

}
