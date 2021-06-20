package ma.patientcovid.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import ma.patientcovid.DAO.DAOFactory;

public class PatientStatController implements Initializable{

	@FXML
	PieChart sexePieChart;
	
	@FXML
	BarChart<String,Integer> sexeBarChart;
	
	@FXML
	CategoryAxis X;
	
	@FXML
	NumberAxis Y;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int nbH = DAOFactory.getPatientDAO().countSexe("H");
		int nbF = DAOFactory.getPatientDAO().countSexe("F");
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
				new PieChart.Data("Homme", nbH),
				new PieChart.Data("Femme", nbF));
		
		sexePieChart.setData(data);
		
		XYChart.Series<String,Integer> set = new XYChart.Series<>();
		set.getData().add(new XYChart.Data<String,Integer>("Homme",nbH));
		set.getData().add(new XYChart.Data<String,Integer>("Femme",nbF));
		sexeBarChart.getData().addAll(set);
		
	}

}
