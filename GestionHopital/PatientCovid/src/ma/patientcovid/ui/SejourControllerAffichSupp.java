package ma.patientcovid.ui;

import java.time.LocalDate;
import java.util.Set;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.room.Room;
import ma.patientcovid.room.SejourHopitalier;

public class SejourControllerAffichSupp {
	
	@FXML
	TextField idText;
	
	@FXML
	private void ConfirmSupp() {
		int id = Integer.parseInt(idText.getText());
		Room r = DAOFactory.getRoomDAO().findSej(id);
		r.setIdSej(-1);
		r.setEtat("f");
		DAOFactory.getRoomDAO().updateid(r, r);
		DAOFactory.getSejourHopitalierDAO().deleteSejId(id);
	}
	
	@FXML
	TableView<SejourHopitalier> sejTable;
	
	@FXML
	TableColumn<SejourHopitalier,Integer> idsej;
	
	@FXML
	TableColumn<SejourHopitalier,LocalDate> DateDeb;
	
	@FXML
	TableColumn<SejourHopitalier,LocalDate> DateFin;
	
	@FXML
	TableColumn<SejourHopitalier,Integer> idDiag;
	
	@FXML
	private void loadDate() {
		sejTable.getItems().clear();
		Set<SejourHopitalier> data = DAOFactory.getSejourHopitalierDAO().all();
		idsej.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
		DateDeb.setCellValueFactory(
				cellData -> new SimpleObjectProperty<LocalDate>(cellData.getValue().getDebut()));
		DateFin.setCellValueFactory(
				cellData -> new SimpleObjectProperty<LocalDate>(cellData.getValue().getFin()));
		idDiag.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getIdDiag()).asObject());
		sejTable.getItems().addAll(data);
	}
}
