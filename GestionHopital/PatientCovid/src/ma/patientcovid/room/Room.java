package ma.patientcovid.room;

public class Room {
	int id_Room;
	String type;
	String etat; // f: free b: booked o: occupied
	int id_Sejour;
	int id_Hopital;

	public Room(int id, String type, String etat, int idSej, int idHop) {
		this.id_Room = id;
		this.type = type;
		this.etat = etat;
		this.id_Hopital = idHop;
		this.id_Sejour = idSej;
	}

	public Room() {
		this.id_Room = -1;
		this.type = null;
		this.etat = null;
		this.id_Hopital = -1;
		this.id_Sejour = -1;
	}

	public int getId() {
		return this.id_Room;
	}

	public void setId(int id) {
		this.id_Room = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getIdSej() {
		return this.id_Sejour;
	}

	public void setIdSej(int id) {
		this.id_Sejour = id;
	}

	public int getIdHop() {
		return this.id_Hopital;
	}

	public void setIdHop(int id) {
		this.id_Hopital = id;
	}
}
