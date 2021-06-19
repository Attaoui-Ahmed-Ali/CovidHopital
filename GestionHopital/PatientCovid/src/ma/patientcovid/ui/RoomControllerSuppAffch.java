package ma.patientcovid.ui;

import java.util.Set;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.room.Room;

public class RoomControllerSuppAffch {
	@FXML
	TableView<Room> roomTable;
	
	@FXML
	TableColumn<Room,Integer> idRoom;
	
	@FXML
	TableColumn<Room,String> typeR;
	
	@FXML
	TableColumn<Room,String> etatR;
	
	@FXML
	TableColumn<Room,Integer> idSej;
	
	@FXML
	TableColumn<Room,Integer> idhop;
	
	@FXML
	private void loadDate() {
		roomTable.getItems().clear();
		Set<Room> data = DAOFactory.getRoomDAO().all();
		idRoom.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
		typeR.setCellValueFactory(
				cellData -> new SimpleObjectProperty<String>(cellData.getValue().getType()));
		etatR.setCellValueFactory(
				cellData -> new SimpleObjectProperty<String>(cellData.getValue().getEtat()));
		idSej.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getIdSej()).asObject());
		idhop.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getIdHop()).asObject());
		roomTable.getItems().addAll(data);
	}
	
	@FXML
	TextField idR;
	
	@FXML
	private void confirmSupp() {
		String idText = idR.getText();
		int id = Integer.parseInt(idText);
		Room r = new Room(id);
		DAOFactory.getRoomDAO().delete(r);
	}
	
	@FXML
	private void clearSupp() {
		idR.clear();
	}
}
