package ma.patientcovid.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UserController {

	@FXML
	TableView userTable;
	
	@FXML
	TableColumn userId;
	
	@FXML
	TableColumn userName;
	
	@FXML
	TableColumn userPassword;
	
	@FXML
	TableColumn userPermission;
	
	@FXML
	Button userLoad;
	
	@FXML
	private void loadUserData() {
		
	}
	
	@FXML
	TextField userNameField;
	
	@FXML
	PasswordField userPasswordField;
	
	@FXML
	ChoiceBox userPermissionChoice;
	
	@FXML
	Button btnConfirmation;
	
	@FXML
	Button btnClear;
	
	@FXML
	private void addUser() {
		
	}
	
	@FXML
	private void clearAddUser() {
		
	}
	
	@FXML
	TextField userIdField;
	
	@FXML
	private void editUser() {
		
	}
	
	@FXML
	private void clearEditUser() {
		
	}
	
	@FXML
	private void deleteUser() {
		
	}
	
}
