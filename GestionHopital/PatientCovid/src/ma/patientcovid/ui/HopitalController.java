package ma.patientcovid.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HopitalController {

	@FXML
	TableView hopitalTable;
	
	@FXML
	TableColumn hopitalId;
	
	@FXML
	TableColumn hopitalNom;
	
	@FXML
	TableColumn hopitalVille;
	
	@FXML
	Button hoptialLoad;
	
	@FXML
	private void loadHopitalData() {
		
	}
	
	@FXML
	TextField hopitalNomField;
	
	@FXML
	TextField hopitalVilleField;
	
	@FXML
	Button btnConfirmation;
	
	@FXML
	Button btnClear;
	
	@FXML
	private void addHopital() {
		String nom = hopitalNomField.getText();
		String ville = hopitalVilleField.getText();
	}
	
	@FXML
	private void clearAddHopital() {
		
	}
	
	@FXML
	TextField hopitalIdField;
	
	@FXML
	private void editHopital() {
		String idtext = hopitalIdField.getText();
		int id = Integer.parseInt(idtext);
		String nom = hopitalNomField.getText();
		String ville = hopitalVilleField.getText();
		
	}
	
	@FXML
	private void clearEditHopital() {
		
	}
	
	@FXML
	private void deleteHopital() {
		String idtext = hopitalIdField.getText();
		int id = Integer.parseInt(idtext);
	}
}
