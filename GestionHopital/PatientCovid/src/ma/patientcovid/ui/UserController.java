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
		String username = userNameField.getText();
		String password = userPasswordField.getText();
		String permission = userPermissionChoice.getValue().toString();
	}
	
	@FXML
	private void clearAddUser() {
		userNameField.clear();
		userPasswordField.clear();
	}
	
	@FXML
	TextField userIdField;
	
	@FXML
	private void editUser() {
		String idtext = userIdField.getText();
		int id = Integer.parseInt(idtext);
		String username = userNameField.getText();
		String password = userPasswordField.getText();
		String permission = userPermissionChoice.getValue().toString();
	}
	
	@FXML
	private void clearEditUser() {
		userIdField.clear();
		userNameField.clear();
		userPasswordField.clear();
	}
	
	@FXML
	private void deleteUser() {
		String idtext = userIdField.getText();
		int id = Integer.parseInt(idtext);
	}
	
}
