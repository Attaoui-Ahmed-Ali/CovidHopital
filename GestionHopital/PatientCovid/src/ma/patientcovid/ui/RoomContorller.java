package ma.patientcovid.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.room.Hopital;
import ma.patientcovid.room.Room;

public class RoomContorller implements Initializable{
	
	@FXML
	ChoiceBox choixHop;
	
	@FXML
	ChoiceBox choixEtat;
	
	@FXML
	ChoiceBox choixType;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Set<Hopital> set = DAOFactory.getHopitalDAO().all();
		List<String> list = new ArrayList<String>();
		for (Hopital p : set) {
			list.add(String.valueOf(p.getId()));
		}
		ObservableList obList = FXCollections.observableList(list);
		choixHop.setItems(obList);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("f");
		list2.add("b");
		list2.add("o");
		ObservableList obList2 = FXCollections.observableList(list2);
		choixEtat.setItems(obList2);
		
		List<String> list3 = new ArrayList<String>();
		list3.add("individuelle");
		list3.add("double");
		ObservableList obList3 = FXCollections.observableList(list3);
		choixType.setItems(obList3);
	}
	
	@FXML
	TextField idRoomF;
	
	
	@FXML
	private void confirmAjout() {
		int hopid = Integer.parseInt((String)choixHop.getValue());
		String type = (String)choixType.getValue();
		String etat = (String)choixEtat.getValue();
		Room r = new Room(type,etat,hopid);
		DAOFactory.getRoomDAO().create(r);
	}
	
	@FXML
	private void confirmModif() {
		int hopid = Integer.parseInt((String)choixHop.getValue());
		int id = Integer.parseInt(idRoomF.getText());
		String type = (String)choixType.getValue();
		String etat = (String)choixEtat.getValue();
		Room r = new Room(id,type,etat,hopid);
		DAOFactory.getRoomDAO().update(r,r);
	}
}
