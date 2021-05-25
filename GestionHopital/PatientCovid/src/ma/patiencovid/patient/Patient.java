package ma.patiencovid.patient;

import java.util.Date;

public class Patient {
	int id_Patient;
	String CIN;
	Date DateNaissance;
	String Nom;
	String Prenom;
	String Tel;
	String Adresse;
	char sexe; //prend F ou M
	
	public Patient(int id, String CIN, Date DN, String nom, String prenom, String tel, String adresse,char sexe) {
		this.id_Patient = id;
		this.CIN = CIN;
		this.DateNaissance = DN;
		this.Nom = nom;
		this.Prenom = prenom;
		this.Tel = tel;
		this.Adresse = adresse;
		if (sexe == 'F' || sexe == 'M')
			this.sexe = sexe;
		else
			System.out.println("Veuillez inserer soit M pour Masculin ou F pour Feminin");
	}
	
	public Patient() {
		this.id_Patient = -1;
		this.CIN = null;
		this.DateNaissance = null;
		this.Nom = null;
		this.Prenom = null;
		this.Tel = null;
		this.Adresse = null;
		this.sexe = '0';
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
	
	public Date getDN() {
		return this.DateNaissance;
	}
	
	public void setDN(Date DN) {
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
	
	public char getSexe() {
		return this.sexe;
	}
	
	public void setSexe(char sexe) {
		if (sexe == 'F' || sexe == 'M')
			this.sexe = sexe;
		else
			System.out.println("Veuillez inserer soit M pour Masculin ou F pour Feminin");
	}
	
	
}