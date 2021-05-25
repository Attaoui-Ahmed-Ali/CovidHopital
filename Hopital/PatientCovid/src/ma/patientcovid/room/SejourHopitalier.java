package ma.patientcovid.room;

import java.util.Date;

public class SejourHopitalier {
	int id_Sejour;
	Date debutSejour;
	Date finSejour;
	
	public SejourHopitalier(int id, Date debut, Date fin) {
		this.id_Sejour = id;
		this.debutSejour = debut;
		this.finSejour = fin;
	}
	
	public SejourHopitalier() {
		this.id_Sejour = -1;
		this.debutSejour = null;
		this.finSejour = null;
	}
	
	public int getId() {
		return this.id_Sejour;
	}
	
	public void setId(int id) {
		this.id_Sejour = id;
	}
	
	public Date getDebut() {
		return this.debutSejour;
	}
	
	public void setDebut(Date debut) {
		this.debutSejour = debut;
	}
	
	public Date getFin() {
		return this.finSejour;
	}
	
	public void setFin(Date fin) {
		this.finSejour = fin;
	}
}
