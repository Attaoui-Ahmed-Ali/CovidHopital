package ma.patientcovid.ui;

import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.room.Hopital;
import ma.patientcovid.user.User;

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
		hopitalTable.getItems().clear();
		Set<Hopital> data = DAOFactory.getHopitalDAO().all();
		hopitalId.setCellValueFactory(new PropertyValueFactory("id"));
		hopitalNom.setCellValueFactory(new PropertyValueFactory("nom"));
		hopitalVille.setCellValueFactory(new PropertyValueFactory("nomv"));
		hopitalTable.getItems().addAll(data);
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
		Hopital hop = new Hopital(nom, ville);
		DAOFactory.getHopitalDAO().create(hop);
	}

	@FXML
	private void clearAddHopital() {
		hopitalNomField.clear();
		hopitalVilleField.clear();
	}

	@FXML
	TextField hopitalIdField;

	@FXML
	private void editHopital() {
		String idtext = hopitalIdField.getText();
		int id = Integer.parseInt(idtext);
		String nom = hopitalNomField.getText();
		String ville = hopitalVilleField.getText();
		Hopital hop = new Hopital(id, nom, ville);
		DAOFactory.getHopitalDAO().update(hop, hop);

	}

	@FXML
	private void clearEditHopital() {
		hopitalIdField.clear();
		hopitalNomField.clear();
		hopitalVilleField.clear();
	}

	@FXML
	private void deleteHopital() {
		String idtext = hopitalIdField.getText();
		int id = Integer.parseInt(idtext);
		Hopital hop = new Hopital(id);
		DAOFactory.getHopitalDAO().delete(hop);
	}
}
