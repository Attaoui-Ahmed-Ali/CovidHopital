package ma.patientcovid.ui;

import java.util.Set;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.patient.Maladie;

public class MaladieController {

	@FXML
	TableView<Maladie> maladieTable;
	
	@FXML
	TableColumn<Maladie,Integer> symptId;
	
	@FXML
	TableColumn<Maladie,Integer> diagId;
	
	@FXML
	Button medocLoad;
	
	@FXML
	private void loadData() {
		maladieTable.getItems().clear();
		Set<Maladie> data = DAOFactory.getMaladieDAO().all();
		symptId.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getIdSymp()).asObject());
		diagId.setCellValueFactory(
				cellData -> new SimpleIntegerProperty(cellData.getValue().getIdDiag()).asObject());
		maladieTable.getItems().addAll(data);
		maladieTable.sort();
	}
}
