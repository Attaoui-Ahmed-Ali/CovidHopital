package ma.patientcovid.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import ma.patientcovid.DAO.DAOFactory;
import ma.patientcovid.patient.Traitement;

public class TraitementController implements Initializable{
	
	@FXML
	ChoiceBox choiceMedoc;
	
	@FXML
	ChoiceBox choicePos;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Set<String> medocSet = DAOFactory.getMedicamentDAO().allid();
		List<String> list = new ArrayList<String>();
		for (String  m : medocSet) {
			list.add(m);
		}
		ObservableList obList = FXCollections.observableList(list);
		choiceMedoc.setItems(obList);
		
		Set<String> set = DAOFactory.getPosologieDAO().allid();
		List<String> list2 = new ArrayList<String>();
		for (String p : set) {
			list2.add(p);
		}
		ObservableList obList2 = FXCollections.observableList(list2);
		choicePos.setItems(obList2);
	}
	
	@FXML
	private void confirmAdd() {
		int idP = Integer.parseInt((String)choicePos.getValue());
		int idM = Integer.parseInt((String)choiceMedoc.getValue());
		Traitement t = new Traitement(idM,idP);
		DAOFactory.getTraitementDAO().create(t);
	}
	
	@FXML
	private void confirmDelete() {
		int idP = Integer.parseInt((String)choicePos.getValue());
		int idM = Integer.parseInt((String)choiceMedoc.getValue());
		Traitement t = new Traitement(idM,idP);
		DAOFactory.getTraitementDAO().delete(t);
	}
	
}
