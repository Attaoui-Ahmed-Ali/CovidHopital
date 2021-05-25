package ma.patiencovid.patient;

import java.util.Date;

public class Diagnostic {
	int id_Diagnostic;
	Date date_contamination;
	Date date_Diagnostic;
	Date date_cloture;
	boolean etat_final; //true si patient survie et gu�ri sinon false
	
	public Diagnostic(int id, Date cont, Date diag, Date clot, boolean etatf) {
		this.id_Diagnostic = id;
		this.date_contamination = cont;
		this.date_Diagnostic = diag;
		this.date_cloture = clot;
		this.etat_final = etatf;
	}
	
	public Diagnostic() {
		this.id_Diagnostic = -1;
		this.date_contamination = null;
		this.date_Diagnostic = null;
		this.date_cloture = null;
		this.etat_final = true ;
	}
	
	public int getId() {
		return this.id_Diagnostic;
	}
	
	public void setId(int id) {
		this.id_Diagnostic = id;
	}
	
	public Date getCont() {
		return this.date_contamination;
	}
	
	public void setCont(Date cont) {
		this.date_contamination = cont;
	}
	
	public Date getDiag() {
		return this.date_Diagnostic;
	}
	
	public void setDiag(Date diag) {
		this.date_Diagnostic = diag;
	}
	
	public Date getClot() {
		return this.date_cloture;
	}
	
	public void setClot(Date clot) {
		this.date_cloture = clot ;
	}
	
	public boolean getEtatF() {
		return this.etat_final;
	}
	
	public void setEtatF(boolean etat) {
		this.etat_final = etat;
	}
	
	
}