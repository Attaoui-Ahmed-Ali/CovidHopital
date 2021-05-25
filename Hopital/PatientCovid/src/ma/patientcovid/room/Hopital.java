package ma.patientcovid.room;

public class Hopital {
	int id_Hopital;
	String nomHopital;
	String ville;
	
	public Hopital (int id, String nom, String ville) {
		this.id_Hopital = id;
		this.nomHopital = nom;
		this.ville = ville;
	}
	
	public Hopital () {
		this.id_Hopital = -1;
		this.nomHopital = null;
		this.ville = null;
	}
	
	public int getId() {
		return this.id_Hopital;
	}
	
	public void setId(int id) {
		this.id_Hopital = id;
	}
	
	public String getNom() {
		return this.nomHopital;
	}
	
	public void setNom(String nom) {
		this.nomHopital = nom;
	}
	
	public String getVille() {
		return this.ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
}
