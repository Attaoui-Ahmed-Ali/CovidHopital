package ma.patientcovid.patient;

import java.time.LocalDate;

public class Diagnostic {
	int iDateDiagiagnostique; // clé primaire
	LocalDate DateCon;
	LocalDate DateDiag;
	LocalDate DateClot;
	int state; // true si patient survie et guéri sinon false
	int idPat;

	public Diagnostic(int id, LocalDate cont, LocalDate diag, LocalDate clot, int statef, int idPatat) {
		this.iDateDiagiagnostique = id;
		this.DateCon = cont;
		this.DateDiag = diag;
		this.DateClot = clot;
		this.state = statef;
		this.idPat = idPatat;
	}
	
	public Diagnostic(int id) {
		this.iDateDiagiagnostique = id;
	}
	
	public Diagnostic(LocalDate cont, LocalDate diag, LocalDate clot, int statef, int idPatat) {
		this.DateCon = cont;
		this.DateDiag = diag;
		this.DateClot = clot;
		this.state = statef;
		this.idPat = idPatat;
	}

	public Diagnostic() {
		this.iDateDiagiagnostique = -1;
		this.DateCon = null;
		this.DateDiag = null;
		this.DateClot = null;
		this.state = 1;
		this.idPat = -1;
	}

	public int getId() {
		return this.iDateDiagiagnostique;
	}

	public void setId(int id) {
		this.iDateDiagiagnostique = id;
	}

	public LocalDate getCont() {
		return this.DateCon;
	}

	public void setCont(LocalDate cont) {
		this.DateCon = cont;
	}

	public LocalDate getDiag() {
		return this.DateDiag;
	}

	public void setDiag(LocalDate diag) {
		this.DateDiag = diag;
	}

	public LocalDate getClot() {
		return this.DateClot;
	}

	public void setClot(LocalDate clot) {
		this.DateClot = clot;
	}

	public int getstateF() {
		return this.state;
	}

	public void setstateF(int state) {
		this.state = state;
	}

	public int getidPatat() {
		return this.idPat;
	}

	public void setidPatat(int id) {
		this.idPat = id;
	}
	
	public String toString() {
		return(iDateDiagiagnostique+",'"+DateCon+"','"+DateDiag+"','"+DateClot+"',"+state+","+idPat);
	}
	
	public String toStringNoid() {
		return("'"+DateCon+"','"+DateDiag+"','"+DateClot+"',"+state+","+idPat);
	}

}
