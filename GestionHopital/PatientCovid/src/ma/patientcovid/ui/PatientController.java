package ma.patientcovid.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
		
	}
	
	@FXML
	private void clearAddPatient() {
		
	}
	
	@FXML
	TextField patiendIdField;
	
	@FXML
	private void editPatient() {
		
	}
	
	@FXML
	private void clearEditPatient() {
		
	}
	
	@FXML
	private void deletePatient() {
		
	}
}
