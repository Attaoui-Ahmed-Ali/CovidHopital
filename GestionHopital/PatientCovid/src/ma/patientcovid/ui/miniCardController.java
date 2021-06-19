package ma.patientcovid.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import ma.patientcovid.room.Hopital;
import ma.patientcovid.room.Room;

public class miniCardController {

	@FXML
	Text idRoom;
	
	@FXML
	Text idHop;
	
	@FXML
	Text ville;
	
	@FXML
	Pane state;
	
	public void setRoom(Hopital h, Room r) {
		idRoom.setText(String.valueOf(r.getId()));
		idHop.setText(String.valueOf(h.getId()));
		ville.setText(h.getnomv());
		if (r.getEtat().equals("b")) {
			state.setStyle("-fx-background-color: #FFFF00");
		}
		else if(r.getEtat().equals("f")) {
			state.setStyle("-fx-background-color: #00FF00");
		}
		else if(r.getEtat().equals("o")) {
			state.setStyle("-fx-background-color: #FF0000");
		}
	}
}
