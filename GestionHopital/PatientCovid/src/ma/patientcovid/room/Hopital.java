package ma.patientcovid.room;

public class Hopital {
	int id; // clé primaire
	String nom;
	String nomv;

	public Hopital(int id, String nom, String nomv) {
		this.id = id;
		this.nom = nom;
		this.nomv = nomv;
	}
	
	public Hopital(String nom, String nomv) {
		this.nom = nom;
		this.nomv = nomv;
	}
	
	public Hopital(int id) {
		this.id = id;
	}

	public Hopital() {
		this.id = -1;
		this.nom = null;
		this.nomv = null;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getnomv() {
		return this.nomv;
	}

	public void setnomv(String nomv) {
		this.nomv = nomv;
	}
	
	public String toString() {
		return(id +",'"+nom+"','"+nomv+"'");
	}
	
	public String toStringNoid() {
		return("'"+nom+"','"+nomv+"'");
	}
}
