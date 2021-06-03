package ma.patientcovid.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ma.patientcovid.Main;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.user.User;

public class BaseController {

	Main main = new Main();
	@FXML
	Button btnConfirmation;

	@FXML
	Button btnClear;

	@FXML
	TextField usernameLoginField;

	@FXML
	PasswordField passwordLoginField;

	@FXML
	private void loginUser() throws Exception{
		String username = usernameLoginField.getText();
		String password = passwordLoginField.getText();
		User user = DAOFactory.getUserDAO().find(new User(username,password));
		if (user.getPerm() == "Administrateur"){
			main.showAdminscene();
			Stage stage = (Stage) btnConfirmation.getScene().getWindow();
			stage.close();
			Stage newStage = new Stage();
			FXMLLoader rootfx = new FXMLLoader(getClass().getResource("AdminBase.fxml"));
			Parent root = rootfx.load();
			newStage.setScene(new Scene(root));
			newStage.setTitle("Admin");
			newStage.show();
		}
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
