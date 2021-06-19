package ma.patientcovid.ui;

import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.patient.Symptome;

public class SymptController {
	@FXML
	TableView symptTable;
	
	@FXML
	TableColumn symptId;
	
	@FXML
	TableColumn symptDesc;
	
	@FXML
	Button symptLoad;
	
	@FXML
	private void loadData() {
		symptTable.getItems().clear();
		Set<Symptome> data = DAOFactory.getSymptomeDAO().all();
		symptId.setCellValueFactory(new PropertyValueFactory("id"));
		symptDesc.setCellValueFactory(new PropertyValueFactory("desc"));
		symptTable.getItems().addAll(data);
		symptTable.sort();
	}
	
	@FXML
	TextField id;
	
	@FXML
	TextArea desc;
	
	@FXML
	Button clear;
	
	@FXML
	Button confirm;
	
	@FXML
	private void confirmAjoutSympt() {
		String symptdesc = desc.getText();
		Symptome S = new Symptome(symptdesc);
		DAOFactory.getSymptomeDAO().create(S);
	}
	
	@FXML
	private void clearAjoutSympt() {
		desc.clear();
	}
	
	@FXML
	private void confirmModifSympt() {
		String textSymptId = id.getText();
		int symptId = Integer.parseInt(textSymptId); 
		String symptdesc = desc.getText();
		Symptome S = new Symptome(symptId,symptdesc);
		DAOFactory.getSymptomeDAO().update(S,S);
	}
	
	@FXML
	private void clearModifSympt() {
		id.clear();
		desc.clear();
	}
	
	@FXML
	private void confirmSuppSympt() {
		String textSymptId = id.getText();
		int symptId = Integer.parseInt(textSymptId); 
		Symptome S = new Symptome(symptId);
		DAOFactory.getSymptomeDAO().delete(S);
	}
	
	@FXML
	private void clearSuppSympt() {
		id.clear();
	}
}
