package ma.patientcovid.ui;

import java.time.LocalDate;
import java.util.Set;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.patient.Diagnostic;
import ma.patientcovid.patient.Maladie;

public class DiagSuppAffController {
	@FXML
	TextField idDiag;
	
	@FXML
	Button confirm;
	
	@FXML
	Button clear;
	
	@FXML
	TableView<Diagnostic> diagTable;
	
	@FXML
	TableColumn<Diagnostic,Integer> id;
	
	@FXML
	TableColumn<Diagnostic,LocalDate> DateCon;
	
	@FXML
	TableColumn<Diagnostic,LocalDate> DateD;
	
	@FXML
	TableColumn<Diagnostic,LocalDate> DateClot;
	
	@FXML
	TableColumn<Diagnostic,Integer> etat;
	
	@FXML
	TableColumn<Diagnostic,Integer> idP;
	
	@FXML
	private void confrimSupp() {
		String idText = idDiag.getText();
		int idD = Integer.parseInt(idText);
		Maladie m = new Maladie(idD);
		DAOFactory.getMaladieDAO().delete(m);
		Diagnostic diag = new Diagnostic(idD);
		DAOFactory.getDiagnosticDAO().delete(diag);
	}
	
	@FXML
	private void clearSupp() {
		idDiag.clear();
	}
	
	@FXML
	private void loadDate() {
		diagTable.getItems().clear();
		Set<Diagnostic> data = DAOFactory.getDiagnosticDAO().all();
		id.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
		DateCon.setCellValueFactory(
				cellData -> new SimpleObjectProperty<LocalDate>(cellData.getValue().getCont()));
		DateD.setCellValueFactory(
				cellData -> new SimpleObjectProperty<LocalDate>(cellData.getValue().getDiag()));
		DateClot.setCellValueFactory(
				cellData -> new SimpleObjectProperty<LocalDate>(cellData.getValue().getClot()));
		etat.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getstateF()).asObject());
		idP.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getidPatat()).asObject());
		diagTable.getItems().addAll(data);
	}
}
