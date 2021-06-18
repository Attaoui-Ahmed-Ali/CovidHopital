package ma.patientcovid.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ma.patientcovid.Main;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.user.User;
import ma.patientcovid.ui.UserController;

public class BaseController {

	static Stage primary;
	static BorderPane primaryLayout;
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
	Menu userMenu;
	

	@FXML
	private void loginUser() throws Exception{
		String username = usernameLoginField.getText();
		String password = passwordLoginField.getText();
		User user = DAOFactory.getUserDAO().find(new User(username,password));
		System.out.println(user.getPerm());
		
		if (user.getPerm().equals("Administrateur")){
			System.out.println(user);
			try {
				primary = (Stage) btnConfirmation.getScene().getWindow();
				primary.close();
				FXMLLoader rootfx = new FXMLLoader(getClass().getResource("AdminBase.fxml"));
				primaryLayout = rootfx.load();
				primary.setScene(new Scene(primaryLayout));
				primary.setTitle("Admin");
				primary.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (user.getPerm().equals("Soignant")) {
			try {
				primary = (Stage) btnConfirmation.getScene().getWindow();
				primary.close();
				FXMLLoader rootfx = new FXMLLoader(getClass().getResource("AdminBase.fxml"));
				primaryLayout = rootfx.load();
				primary.setScene(new Scene(primaryLayout));
				primary.setTitle("Soignant");
				primary.show();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
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
	private void showAddUser() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutUsers.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
			ObservableList<String> permission = FXCollections.observableArrayList("Administrateur","Soignant");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem editUser;
	
	@FXML
	private void showEditUser() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifUsers.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem listUser;
	
	@FXML
	private void showListUser() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichUsers.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem deleteUser;
	
	@FXML
	private void showdeleteUser() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SuppUsers.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem statUser;
	
	@FXML
	private void showStatUser() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StatUsers.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem addHopital;
	
	@FXML
	private void showAddHopital() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutHopital.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem editHopital;
	
	@FXML
	private void showEditHopital() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifHopital.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem listHopital;
	
	@FXML
	private void showListHopital() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichHopital.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem deleteHopital;
	
	@FXML
	private void showDeleteHopital() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SuppHopital.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem statHopital;
	
	@FXML
	private void showStatHopital() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StatHopital.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem addPatient;
	
	@FXML
	private void showAddPatient() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutPatient.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem editPatient;
	
	@FXML
	private void showEditPatient() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifPatient.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem listPatient;
	
	@FXML
	private void showListPatient() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichPatient.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem deletePatient;
	
	@FXML
	private void showDeletePatient() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SuppPatient.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem statPatient;
	
	@FXML
	private void showStatPatient() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StatPatient.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem addTraitement;
	
	@FXML
	private void showAddTraitement() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutTraitement.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem editTraitement;
	
	@FXML
	private void showEditTraitement() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifTraitement.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem listTraitement;
	
	@FXML
	private void showListTraitement() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichTraitement.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem deleteTraitement;
	
	@FXML
	private void showDeleteTraitement() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SuppTraitement.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem statTraitement;
	
	@FXML
	private void showStatTraitement() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StatTraitement.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem addSejour;
	
	@FXML
	private void showAddSejour() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutSejour.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem editSejour;
	
	@FXML
	private void showEditSejour() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifSejour.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem listSejour;
	
	@FXML
	private void showListSejour() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichSejour.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem deleteSejour;
	
	@FXML
	private void showDeleteSejour() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SuppSejour.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	MenuItem statSejour;
	
	@FXML
	private void showStatSejour() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StatSejour.fxml"));
			Pane newPane = loader.load();
			primaryLayout.setCenter(newPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
