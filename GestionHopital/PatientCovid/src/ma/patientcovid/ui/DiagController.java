package ma.patientcovid.ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.patient.Diagnostic;
import ma.patientcovid.patient.Maladie;
import ma.patientcovid.patient.Patient;
import ma.patientcovid.patient.Symptome;

public class DiagController implements Initializable{
	
	@FXML
	TableView<Symptome> SymptTable1;
	
	@FXML
	TableColumn Id1;
	
	@FXML
	TableColumn Desc1;
	
	@FXML
	TableView<Symptome> SymptTable2;
	
	@FXML
	TableColumn Id2;
	
	@FXML
	TableColumn Desc2;
	
	@FXML
	Button move;
	
	@FXML
	Button remove;
	
	@FXML
	ChoiceBox patientId;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		SymptTable1.getItems().clear();
		Set<Symptome> data = DAOFactory.getSymptomeDAO().all();
		Id1.setCellValueFactory(new PropertyValueFactory("id"));
		Desc1.setCellValueFactory(new PropertyValueFactory("desc"));
		Id2.setCellValueFactory(new PropertyValueFactory("id"));
		Desc2.setCellValueFactory(new PropertyValueFactory("desc"));
		SymptTable1.getItems().addAll(data);
		SymptTable1.sort();
		Set<Patient> set = DAOFactory.getPatientDAO().all();
		List<String> list = new ArrayList<String>();
		for (Patient p : set) {
			list.add(String.valueOf(p.getId()));
		}
		ObservableList obList = FXCollections.observableList(list);
		patientId.setItems(obList);
	}
	
	@FXML
	public void moving() {
		Symptome s = SymptTable1.getSelectionModel().getSelectedItem();
		SymptTable2.getItems().add(s);
		SymptTable1.getItems().remove(s);
	}
	
	@FXML
	public void removing() {
		Symptome s = SymptTable2.getSelectionModel().getSelectedItem();
		SymptTable1.getItems().add(s);
		SymptTable2.getItems().remove(s);
	}
	
	@FXML
	RadioButton mort;
	
	@FXML
	RadioButton gueri;
	
	@FXML
	RadioButton malade;
	
	@FXML
	RadioButton sain;
	
	@FXML
	DatePicker dateCont;
	
	@FXML
	DatePicker dateDiag;
	
	@FXML
	DatePicker dateClot;
	
	@FXML
	Button confirm;
	
	@FXML
	Button clear;
	
	@FXML
	TextField idDiag;
	
	@FXML
	private void clearAjout(){
		Symptome[] t = new Symptome[1];
		SymptTable1.getItems().addAll(SymptTable2.getItems().toArray(t));
		SymptTable2.getItems().clear();
	}
	
	@FXML
	private void clearModif(){
		for (Symptome s : SymptTable2.getSelectionModel().getSelectedItems()) {
			SymptTable1.getItems().add(s);
			SymptTable2.getItems().remove(s);
		}
		idDiag.clear();
	}
	
	@FXML
	private void confirmAjout() {
		LocalDate DD = dateDiag.getValue();
		LocalDate DCon = dateCont.getValue(); 
		LocalDate DClot = dateClot.getValue();
		int etat = 0;
		if (gueri.isSelected() || sain.isSelected()) {
			etat = 1;
		}
		else if (mort.isSelected() || malade.isSelected()){
			etat = 0;
		}
		int idP = Integer.parseInt((String)patientId.getValue());
		Diagnostic d = new Diagnostic(DCon,DD,DClot,etat,idP);
		System.out.println(d);
		DAOFactory.getDiagnosticDAO().create(d);
		int idD = DAOFactory.getDiagnosticDAO().find(d).getId();
		System.out.println(idD);
		for (Symptome s : SymptTable2.getItems()) {
			Maladie m = new Maladie(s.getId(),idD);
			DAOFactory.getMaladieDAO().create(m);
		}
	}
	
	@FXML
	private void confirmModif() {
		LocalDate DD = dateDiag.getValue();
		LocalDate DCon = dateCont.getValue(); 
		LocalDate DClot = dateClot.getValue();
		String idText = idDiag.getText();
		int id = Integer.parseInt(idText);
		int etat = 0;
		if (gueri.isSelected() || sain.isSelected()) {
			etat = 1;
		}
		else if (mort.isSelected() || malade.isSelected()){
			etat = 0;
		}
		int idP = Integer.parseInt((String)patientId.getValue());
		Diagnostic d = new Diagnostic(id,DCon,DD,DClot,etat,idP);
		DAOFactory.getDiagnosticDAO().update(d,d);
		for (Symptome s : SymptTable2.getItems()) {
			Maladie m = new Maladie(s.getId(),id);
			DAOFactory.getMaladieDAO().create(m);
		}
	}
}
