package ma.patientcovid.ui;

import java.time.LocalDate;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.patient.Patient;
import ma.patientcovid.room.Hopital;

public class PatientController {

	@FXML
	TableView patientTable;
	
	@FXML
	TableColumn patientId;
	
	@FXML
	TableColumn patientCIN;
	
	@FXML
	TableColumn patientNom;
	
	@FXML
	TableColumn patientPrenom;
	
	@FXML
	TableColumn patientSexe;
	
	@FXML
	TableColumn patientDN;
	
	@FXML
	TableColumn patientTel;
	
	@FXML
	TableColumn patientAdress;
	
	@FXML
	Button patientLoad;
	
	@FXML
	private void loadPatientData() {
		patientTable.getItems().clear();
		Set<Patient> data = DAOFactory.getPatientDAO().all();
		patientId.setCellValueFactory(new PropertyValueFactory("id"));
		patientCIN.setCellValueFactory(new PropertyValueFactory("nom"));
		patientNom.setCellValueFactory(new PropertyValueFactory("nomv"));
		patientPrenom.setCellValueFactory(new PropertyValueFactory("id"));
		patientSexe.setCellValueFactory(new PropertyValueFactory("nom"));
		patientDN.setCellValueFactory(new PropertyValueFactory("nomv"));
		patientTel.setCellValueFactory(new PropertyValueFactory("nom"));
		patientAdress.setCellValueFactory(new PropertyValueFactory("nomv"));
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
	ChoiceBox patientSexeChoice;
	
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
		String sexe = patientSexeChoice.getValue().toString();
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
	TextField patiendIdField;
	
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
		String sexe = patientSexeChoice.getValue().toString();
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
