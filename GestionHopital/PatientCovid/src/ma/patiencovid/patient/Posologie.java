package ma.patiencovid.patient;

import java.util.Date;

public class Posologie {
	int id_Posologie;
	Date date_debut;
	Date date_fin;
	int nb_prise_jour;
	
	public Posologie(int id, Date deb, Date fin, int prise) {
		this.id_Posologie = id;
		this.date_debut = deb;
		this.date_fin = fin;
		this.nb_prise_jour = prise;
	}
	
	public Posologie() {
		this.id_Posologie = -1;
		this.date_debut = null;
		this.date_fin = null;
		this.nb_prise_jour = -1;
	}
	
	public int getId() {
		return this.id_Posologie;
	}
	
	public void setId(int id) {
		this.id_Posologie = id;
	}
	
	public Date getDebut() {
		return this.date_debut;
	}
	
	public void setDebut(Date debut) {
		this.date_debut = debut;
	}
	
	public Date getFin() {
		return this.date_fin;
	}
	
	public void setFin(Date fin) {
		this.date_fin = fin;
	}
	
	public int getPrise() {
		return(this.nb_prise_jour);
	}
	
	public void setPrise(int prise) {
		this.nb_prise_jour = prise;
	}
}