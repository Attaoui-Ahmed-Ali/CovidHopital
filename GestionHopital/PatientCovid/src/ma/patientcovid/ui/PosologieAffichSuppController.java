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
import ma.patientcovid.patient.Posologie;
import ma.patientcovid.patient.Traitement;

public class PosologieAffichSuppController {
	@FXML
	TableView<Posologie> posTable;
	
	@FXML
	TableColumn<Posologie,Integer> idPos;
	
	@FXML
	TableColumn<Posologie,LocalDate> DateDeb;
	
	@FXML
	TableColumn<Posologie,LocalDate> DateFin;
	
	@FXML
	TableColumn<Posologie,Integer> nbPrise;
	
	@FXML
	TableColumn<Posologie,Integer> idD;
	
	@FXML
	private void loadDate() {
		posTable.getItems().clear();
		Set<Posologie> data = DAOFactory.getPosologieDAO().all();
		idPos.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
		DateDeb.setCellValueFactory(
				cellData -> new SimpleObjectProperty<LocalDate>(cellData.getValue().getDebut()));
		DateFin.setCellValueFactory(
				cellData -> new SimpleObjectProperty<LocalDate>(cellData.getValue().getFin()));
		nbPrise.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getPrise()).asObject());
		idD.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getIdDiag()).asObject());
		posTable.getItems().addAll(data);
	}
	
	@FXML
	TextField idP;
	
	@FXML
	private void confirmSupp() {
		String idText = idP.getText();
		int id = Integer.parseInt(idText);
		Posologie p = new Posologie(id);
		Traitement t = new Traitement(p.getId());
		DAOFactory.getTraitementDAO().delete(t);
		DAOFactory.getPosologieDAO().delete(p);
	}
	
	@FXML
	private void clearSupp() {
		idP.clear();
	}
	
}
