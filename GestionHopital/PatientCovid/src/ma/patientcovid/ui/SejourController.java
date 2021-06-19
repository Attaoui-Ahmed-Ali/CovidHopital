package ma.patientcovid.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.patient.Diagnostic;
import ma.patientcovid.room.Hopital;
import ma.patientcovid.room.Room;

public class SejourController implements Initializable{
	@FXML
	DatePicker DB;
	
	@FXML
	DatePicker DF;
	
	@FXML
	ChoiceBox choiceIdDia;
	
	@FXML
	ChoiceBox choiceVille;
	
	@FXML
	ChoiceBox choiceIdHop;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Set<String> villeSet = DAOFactory.getHopitalDAO().allVille();
		List<String> list = new ArrayList<String>();
		for (String  s : villeSet) {
			list.add(s);
		}
		ObservableList obList = FXCollections.observableList(list);
		choiceVille.setItems(obList);
		
		Set<Diagnostic> set = DAOFactory.getDiagnosticDAO().all();
		List<String> list2 = new ArrayList<String>();
		for (Diagnostic d : set) {
			list2.add(String.valueOf(d.getId()));
		}
		ObservableList obList2 = FXCollections.observableList(list2);
		choiceIdDia.setItems(obList2);
	}
	
	@FXML
	private void loadHop() {
		String nomV = (String)choiceVille.getValue();
		Set<Integer> set_hop = DAOFactory.getHopitalDAO().findVille(nomV);
		List<String> list3 = new ArrayList<String>();
		for (Integer id : set_hop) {
			list3.add(String.valueOf(id));
		}
		ObservableList obList3 = FXCollections.observableList(list3);
		choiceIdHop.setItems(obList3);
	}
	
	@FXML
	VBox vbscroll;
	
	@FXML
	private void loadRooms() {
		int idH = Integer.parseInt((String)choiceIdHop.getValue());
		String nomv = (String)choiceVille.getValue();
		vbscroll.getChildren().clear();
		Hopital h = new Hopital(idH,nomv);
		Set<Room> rooms = DAOFactory.getRoomDAO().findHop((String)choiceIdHop.getValue());
		System.out.println(rooms);
		for (Room r : rooms) {
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("CardRoom.fxml"));
				HBox mini = loader.load();
				((miniCardController) loader.getController()).setRoom(h, r);
				HBox.setMargin(mini, new Insets(0, 0, 5, 0));

				vbscroll.setAlignment(Pos.CENTER);
				vbscroll.getChildren().add(mini);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
