package ma.patientcovid.ui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.patient.Diagnostic;
import ma.patientcovid.room.Hopital;
import ma.patientcovid.room.Room;
import ma.patientcovid.room.SejourHopitalier;

public class SejourController implements Initializable{
	static int av;
	static Room avRoom = new Room();
	
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
		av = 0;
	}
	
	@FXML
	private void loadRoomsModif() {
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
				((miniCardController) loader.getController()).modifRoom(h, r);
				HBox.setMargin(mini, new Insets(0, 0, 5, 0));

				vbscroll.setAlignment(Pos.CENTER);
				vbscroll.getChildren().add(mini);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		av = 0;
	}
	
	@FXML
	private void confirmAjout() {
		System.out.println(av);
		System.out.println(avRoom);
		if (av==1) {
			LocalDate DateDeb = DB.getValue();
			LocalDate DateFin = DF.getValue();
			int idDiag = Integer.parseInt((String)choiceIdDia.getValue());
			SejourHopitalier s = new SejourHopitalier(DateDeb,DateFin,idDiag);
			DAOFactory.getSejourHopitalierDAO().create(s);
			int idS = DAOFactory.getSejourHopitalierDAO().find(s).getId();
			avRoom.setIdSej(idS);
			LocalDate now = LocalDate.now();
			if ((DateDeb.equals(now)) || ((DateDeb.isBefore(now)) && (DateFin.isAfter(now)))) {
				avRoom.setEtat("o");
			}
			else if (DateDeb.isAfter(now)){
				avRoom.setEtat("b");
			}
			else {
				avRoom.setEtat("f");
			}
			DAOFactory.getRoomDAO().updateid(avRoom, avRoom);
		}
	}
	
	@FXML
	TextField idSejText;
	
	@FXML
	private void confirmModif() {
		System.out.println(av);
		System.out.println(avRoom);
		if (av==1) {
			LocalDate DateDeb = DB.getValue();
			LocalDate DateFin = DF.getValue();
			int idS = Integer.parseInt(idSejText.getText());
			int idDiag = Integer.parseInt((String)choiceIdDia.getValue());
			SejourHopitalier s = new SejourHopitalier(idS,DateDeb,DateFin,idDiag);
			DAOFactory.getSejourHopitalierDAO().update(s,s);
			avRoom.setIdSej(idS);
			LocalDate now = LocalDate.now();
			if ((DateDeb.equals(now)) || ((DateDeb.isBefore(now)) && (DateFin.isAfter(now)))) {
				avRoom.setEtat("o");
			}
			else if (DateDeb.isAfter(now)){
				avRoom.setEtat("b");
			}
			else {
				avRoom.setEtat("f");
			}
			DAOFactory.getRoomDAO().updateid(avRoom, avRoom);
		}
		else if(av == 0) {
			DAOFactory.getSejourHopitalierDAO().deleteSejId(avRoom.getIdSej());
			avRoom.setEtat("f");
			avRoom.setIdSej(-1);
			DAOFactory.getRoomDAO().updateid(avRoom, avRoom);
		}
	}
	
	public static void setAv(int a) {
		av = a;
	}
}
