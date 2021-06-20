package ma.patientcovid.ui;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.room.Hopital;
import ma.patientcovid.room.Room;
import ma.patientcovid.room.SejourHopitalier;

public class miniCardController {

	@FXML
	Text idRoom;
	
	@FXML
	Text idHop;
	
	@FXML
	Text ville;
	
	@FXML
	Pane state;
	
	@FXML
	Button res;
	
	@FXML
	Button ann;
	
	public void setRoom(Hopital h, Room r) {
		idRoom.setText(String.valueOf(r.getId()));
		idHop.setText(String.valueOf(h.getId()));
		ville.setText(h.getnomv());
		LocalDate now = LocalDate.now();
		SejourHopitalier s = DAOFactory.getSejourHopitalierDAO().findId(r.getIdSej());
		if ((r.getEtat().equals("b")) && (r.getIdSej()!=-1) && (r.getIdSej()!=0) && (s.getDebut().isAfter(now))) {
			state.setStyle("-fx-background-color: #FFFF00");
			res.setDisable(true);
			ann.setDisable(true);
		}
		else if((r.getEtat().equals("o")) && (r.getIdSej()!=-1) && (r.getIdSej()!=0) && ((s.getDebut().equals(now)) || ((s.getDebut().isBefore(now)) && (s.getFin().isAfter(now))))) {
			state.setStyle("-fx-background-color: #FF0000");
			res.setDisable(true);
			ann.setDisable(true);
		}
		else if(r.getEtat().equals("f")) {
			state.setStyle("-fx-background-color: #00FF00");
			ann.setDisable(true);
		}
		else {
			state.setStyle("-fx-background-color: #00FF00");
			r.setEtat("f");
			DAOFactory.getRoomDAO().updateid(r, r);
			ann.setDisable(true);
		}
	}
	
	public void modifRoom(Hopital h, Room r) {
		idRoom.setText(String.valueOf(r.getId()));
		idHop.setText(String.valueOf(h.getId()));
		ville.setText(h.getnomv());
		LocalDate now = LocalDate.now();
		SejourHopitalier s = DAOFactory.getSejourHopitalierDAO().findId(r.getIdSej());
		if ((r.getEtat().equals("b")) && (r.getIdSej()!=-1) && (r.getIdSej()!=0) && (s.getDebut().isAfter(now))) {
			state.setStyle("-fx-background-color: #FFFF00");
		}
		else if((r.getEtat().equals("o")) && (r.getIdSej()!=-1) && (r.getIdSej()!=0) && ((s.getDebut().equals(now)) || ((s.getDebut().isBefore(now)) && (s.getFin().isAfter(now))))) {
			state.setStyle("-fx-background-color: #FF0000");
		}
		else if(r.getEtat().equals("f")) {
			state.setStyle("-fx-background-color: #00FF00");
		}
		else {
			state.setStyle("-fx-background-color: #00FF00");
			r.setEtat("f");
			DAOFactory.getRoomDAO().updateid(r, r);
		}
	}
	
	@FXML
	public void reserv() {
		int id = Integer.parseInt(idRoom.getText());
		Room r = new Room(id);
		SejourController.avRoom = DAOFactory.getRoomDAO().find(r);
		SejourController.av=1;
		System.out.println(SejourController.av);
	}
	
	@FXML
	public void annuler() {
		int id = Integer.parseInt(idRoom.getText());
		Room r = new Room(id);
		SejourController.avRoom = DAOFactory.getRoomDAO().find(r);
		SejourController.av=0;
		System.out.println(SejourController.av);
	}
}
