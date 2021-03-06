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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.patient.Diagnostic;
import ma.patientcovid.patient.Maladie;
import ma.patientcovid.patient.Medicament;
import ma.patientcovid.patient.Posologie;
import ma.patientcovid.patient.Symptome;
import ma.patientcovid.patient.Traitement;

public class PosologieAjoutModifController implements Initializable{
	
	@FXML
	ChoiceBox diagId;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Set<Diagnostic> set = DAOFactory.getDiagnosticDAO().all();
		List<String> list = new ArrayList<String>();
		for (Diagnostic d : set) {
			list.add(String.valueOf(d.getId()));
		}
		ObservableList obList = FXCollections.observableList(list);
		diagId.setItems(obList);
	}
	
	@FXML
	DatePicker DD;
	
	@FXML
	DatePicker DF;
	
	@FXML
	TextField NbPrise;
	
	@FXML
	TextField idPos;
	
	@FXML
	private void confirmAjout() {
		LocalDate DateDeb = DD.getValue();
		LocalDate DateFin = DF.getValue();
		String nbPText = NbPrise.getText();
 		int nbP = Integer.parseInt(nbPText);
 		int idD = Integer.parseInt((String)diagId.getValue());
 		Posologie p = new Posologie(DateDeb,DateFin,nbP,idD);
 		DAOFactory.getPosologieDAO().create(p);
	}
	
	@FXML
	private void confirmModif() {
		LocalDate DateDeb = DD.getValue();
		LocalDate DateFin = DF.getValue();
		String nbPText = NbPrise.getText();
 		int nbP = Integer.parseInt(nbPText);
 		int idD = Integer.parseInt((String)diagId.getValue());
 		String idPosText = idPos.getText();
 		int id = Integer.parseInt(idPosText);
 		Posologie p = new Posologie(id,DateDeb,DateFin,nbP,idD);
 		DAOFactory.getPosologieDAO().update(p,p);
	}
	
	@FXML
	private void clearModif(){
		idPos.clear();
		NbPrise.clear();
	}
	
	@FXML
	private void clearAjout(){
		NbPrise.clear();
	}
}
