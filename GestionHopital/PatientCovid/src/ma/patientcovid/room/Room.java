package ma.patientcovid.room;

public class Room {
	int id_Room;
	String type;
	char etat; // f: free b: booked o: occupied
	
	public Room(int id, String type, char etat) {
		this.id_Room = id;
		this.type = type;
		if (etat == 'f' || etat == 'o' || etat == 'b')
			this.etat = etat;
	}
	
	public Room() {
		this.id_Room = -1;
		this.type = null;
		this.etat = 'f';
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
	
	public char getEtat() {
		return this.etat;
	}
	
	public void setEtat(char etat) {
		if (etat == 'f' || etat == 'o' || etat == 'b')
			this.etat = etat;
	}
}