package ma.patientcovid.ui;

import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.user.User;

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
		Set<User> data = DAOFactory.getUserDAO().all();
		userId.setCellValueFactory(new PropertyValueFactory("id"));
		userName.setCellValueFactory(new PropertyValueFactory("login"));
		userPassword.setCellValueFactory(new PropertyValueFactory("pwd"));
		userPermission.setCellValueFactory(new PropertyValueFactory("perm"));
		userTable.getItems().addAll(data);
	}
	
	@FXML
	TextField userNameField;
	
	@FXML
	PasswordField userPasswordField;
	
	@FXML
	RadioButton Administrateur;
	
	@FXML
	RadioButton Soignant;
	
	@FXML
	Button btnConfirmation;
	
	@FXML
	Button btnClear;
	
	@FXML
	private void addUser() {
		String username = userNameField.getText();
		String password = userPasswordField.getText();
		String permission = new String();
		if (Soignant.isSelected()){
			permission = "Soignant";
		}
		else if (Administrateur.isSelected()) {
			permission = "Administrateur";
		}
		User user = new User(username,password,permission);
		DAOFactory.getUserDAO().create(user);
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
		String permission = new String();
		if (Soignant.isSelected()){
			permission = "Soignant";
		}
		else if (Administrateur.isSelected()) {
			permission = "Administrateur";
		}
		User user = new User(id,username,password,permission);
		DAOFactory.getUserDAO().update(user, user);
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
		User user = new User(id);
		DAOFactory.getUserDAO().delete(user);
	}
	
}
