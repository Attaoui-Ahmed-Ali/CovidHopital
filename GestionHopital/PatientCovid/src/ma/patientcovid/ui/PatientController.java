package ma.patientcovid.ui;

import java.time.LocalDate;
import java.util.Set;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.patient.Patient;

public class PatientController {

	@FXML
	TableView<Patient> patientTable;
	
	@FXML
	TableColumn<Patient,Integer> patientId;
	
	@FXML
	TableColumn<Patient,String> patientCIN;
	
	@FXML
	TableColumn<Patient,String> patientNom;
	
	@FXML
	TableColumn<Patient,String> patientPrenom;
	
	@FXML
	TableColumn<Patient,String> patientSexe;
	
	@FXML
	TableColumn<Patient,LocalDate> patientDN;
	
	@FXML
	TableColumn<Patient,String> patientTel;
	
	@FXML
	TableColumn<Patient,String> patientAdress;
	
	@FXML
	Button patientLoad;
	
	@FXML
	private void loadPatientData() {
		patientTable.getItems().clear();
		Set<Patient> data = DAOFactory.getPatientDAO().all();
		patientId.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
		patientCIN.setCellValueFactory(
				cellData -> new SimpleObjectProperty<String>(cellData.getValue().getCIN()));
		patientNom.setCellValueFactory(
				cellData -> new SimpleObjectProperty<String>(cellData.getValue().getNom()));
		patientPrenom.setCellValueFactory(
				cellData -> new SimpleObjectProperty<String>(cellData.getValue().getPrenom()));
		patientSexe.setCellValueFactory(
				cellData -> new SimpleObjectProperty<String>(cellData.getValue().getSexe()));
		patientDN.setCellValueFactory(
				cellData -> new SimpleObjectProperty<LocalDate>(cellData.getValue().getDN()));
		patientTel.setCellValueFactory(
				cellData -> new SimpleObjectProperty<String>(cellData.getValue().getTel()));
		patientAdress.setCellValueFactory(
				cellData -> new SimpleObjectProperty<String>(cellData.getValue().getAdresse()));
		patientTable.getItems().addAll(data);
	}

	@FXML
	TextField patientIdField;
	
	@FXML
	TextField patientCINField;
	
	@FXML
	TextField patientNomField;
	
	@FXML
	TextField patientPrenomField;
	
	@FXML
	RadioButton Homme;
	
	@FXML
	RadioButton Femme;
	
	@FXML
	DatePicker patientDNPicker;
	
	@FXML
	TextField patientTelField;
	
	@FXML
	TextField patientAdressField;
	
	@FXML
	Button btnConfirmation;
	
	@FXML
	Button btnClear;
	
	@FXML
	private void addPatient() {
		String CIN = patientCINField.getText();
		String nom = patientNomField.getText();
		String prenom = patientPrenomField.getText();
		String tel = patientTelField.getText();
		String adresse = patientAdressField.getText();
		LocalDate DN = patientDNPicker.getValue();
		String sexe = new String();
		if (Homme.isSelected()) {
			sexe="H";
		}
		else if(Femme.isSelected()) {
			sexe="F";
		}
		Patient pat = new Patient(CIN,DN,nom,prenom,tel,adresse,sexe);
		DAOFactory.getPatientDAO().create(pat);
	}
	
	@FXML
	private void clearAddPatient() {
		patientCINField.clear();
		patientNomField.clear();
		patientPrenomField.clear();
		patientTelField.clear();
		patientAdressField.clear();
	}
	
	@FXML
	private void editPatient() {
		String idtext = patientIdField.getText();
		int id = Integer.parseInt(idtext);
		String CIN = patientCINField.getText();
		String nom = patientNomField.getText();
		String prenom = patientPrenomField.getText();
		String tel = patientTelField.getText();
		String adresse = patientAdressField.getText();
		LocalDate DN = patientDNPicker.getValue();
		String sexe = new String();
		if (Homme.isSelected()) {
			sexe="H";
		}
		else if(Femme.isSelected()) {
			sexe="F";
		}
		Patient pat = new Patient(id,CIN,DN,nom,prenom,tel,adresse,sexe);
		DAOFactory.getPatientDAO().update(pat,pat);
	}
	
	@FXML
	private void clearEditPatient() {
		patientIdField.clear();
		patientCINField.clear();
		patientNomField.clear();
		patientPrenomField.clear();
		patientTelField.clear();
		patientAdressField.clear();
	}
	
	@FXML
	private void deletePatient() {
		String idtext = patientIdField.getText();
		int id = Integer.parseInt(idtext);
		Patient pat = new Patient(id);
		DAOFactory.getPatientDAO().delete(pat);
	}
}
