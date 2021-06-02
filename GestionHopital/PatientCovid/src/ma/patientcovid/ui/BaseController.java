package ma.patientcovid.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class BaseController {

	@FXML
	Button btnConfirmation;

	@FXML
	Button btnClear;

	@FXML
	TextField usernameLoginField;

	@FXML
	PasswordField passwordLoginField;

	@FXML
	private void loginUser() {
		String username = usernameLoginField.getText();
		String password = passwordLoginField.getText();
	}

	@FXML
	private void clearLoginUser() {
		usernameLoginField.clear();
		passwordLoginField.clear();
	}
	
	@FXML
	MenuItem addUser;
	
	@FXML
	MenuItem editUser;
	
	@FXML
	MenuItem listUser;
	
	@FXML
	MenuItem deleteUser;
	
	@FXML
	MenuItem statUser;
	
	@FXML
	MenuItem addHopital;
	
	@FXML
	MenuItem editHopital;
	
	@FXML
	MenuItem listHopital;
	
	@FXML
	MenuItem deleteHopital;
	
	@FXML
	MenuItem statHopital;
	
	@FXML
	MenuItem addPatient;
	
	@FXML
	MenuItem editPatient;
	
	@FXML
	MenuItem listPatient;
	
	@FXML
	MenuItem deletePatient;
	
	@FXML
	MenuItem statPatient;
	
	@FXML
	MenuItem addTraitement;
	
	@FXML
	MenuItem editTraitement;
	
	@FXML
	MenuItem listTraitement;
	
	@FXML
	MenuItem deleteTraitement;
	
	@FXML
	MenuItem statTraitement;
	
	@FXML
	MenuItem addSejour;
	
	@FXML
	MenuItem editSejour;
	
	@FXML
	MenuItem listSejour;
	
	@FXML
	MenuItem deleteSejour;
	
	@FXML
	MenuItem statSejour;

}
