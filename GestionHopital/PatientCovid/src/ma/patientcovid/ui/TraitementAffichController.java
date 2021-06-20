package ma.patientcovid.ui;

import java.util.Set;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.patient.Maladie;
import ma.patientcovid.patient.Traitement;

public class TraitementAffichController {
	@FXML
	TableView<Traitement> maladieTable;
	
	@FXML
	TableColumn<Traitement,Integer> medocId;
	
	@FXML
	TableColumn<Traitement,Integer> posId;
	
	@FXML
	Button medocLoad;
	
	@FXML
	private void loadData() {
		maladieTable.getItems().clear();
		Set<Traitement> data = DAOFactory.getTraitementDAO().all();
		medocId.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getIdMed()).asObject());
		posId.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getIdPos()).asObject());
		maladieTable.getItems().addAll(data);
		maladieTable.sort();
	}
}
