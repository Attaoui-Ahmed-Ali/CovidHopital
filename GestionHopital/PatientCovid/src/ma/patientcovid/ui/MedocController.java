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
import ma.patientcovid.patient.Medicament;

public class MedocController {
	@FXML
	TableView medocTable;
	
	@FXML
	TableColumn medocId;
	
	@FXML
	TableColumn medocDesc;
	
	@FXML
	Button medocLoad;
	
	@FXML
	private void loadData() {
		medocTable.getItems().clear();
		Set<Medicament> data = DAOFactory.getMedicamentDAO().all();
		medocId.setCellValueFactory(new PropertyValueFactory("id"));
		medocDesc.setCellValueFactory(new PropertyValueFactory("desc"));
		medocTable.getItems().addAll(data);
		medocTable.sort();
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
	private void confirmAjoutmedoc() {
		String medocdesc = desc.getText();
		Medicament S = new Medicament(medocdesc);
		DAOFactory.getMedicamentDAO().create(S);
	}
	
	@FXML
	private void clearAjoutmedoc() {
		desc.clear();
	}
	
	@FXML
	private void confirmModifmedoc() {
		String textmedocId = id.getText();
		int medocId = Integer.parseInt(textmedocId); 
		String medocdesc = desc.getText();
		Medicament S = new Medicament(medocId,medocdesc);
		DAOFactory.getMedicamentDAO().update(S,S);
	}
	
	@FXML
	private void clearModifmedoc() {
		id.clear();
		desc.clear();
	}
	
	@FXML
	private void confirmSuppmedoc() {
		String textmedocId = id.getText();
		int medocId = Integer.parseInt(textmedocId); 
		Medicament S = new Medicament(medocId);
		DAOFactory.getMedicamentDAO().delete(S);
	}
	
	@FXML
	private void clearSuppmedoc() {
		id.clear();
	}
}
