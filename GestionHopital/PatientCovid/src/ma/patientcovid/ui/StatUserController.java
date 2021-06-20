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

public class StatUserController implements Initializable{
	@FXML
	PieChart permPieChart;
	
	@FXML
	BarChart<String,Integer> permBarChart;
	
	@FXML
	CategoryAxis X;
	
	@FXML
	NumberAxis Y;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int nbA = DAOFactory.getUserDAO().countPerm("Administrateur");
		int nbS = DAOFactory.getUserDAO().countPerm("Soignant");
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
				new PieChart.Data("Administrateur", nbA),
				new PieChart.Data("Soignant", nbS));
		
		permPieChart.setData(data);
		
		XYChart.Series<String,Integer> set = new XYChart.Series<>();
		set.getData().add(new XYChart.Data<String,Integer>("Administrateur", nbA));
		set.getData().add(new XYChart.Data<String,Integer>("Soignant", nbS));
		permBarChart.getData().addAll(set);
		
	}

}
