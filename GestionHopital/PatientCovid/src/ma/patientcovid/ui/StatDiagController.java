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

public class StatDiagController implements Initializable{
	@FXML
	PieChart etatPieChart;
	
	@FXML
	BarChart<String,Integer> etatBarChart;
	
	@FXML
	CategoryAxis X;
	
	@FXML
	NumberAxis Y;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int nbC = DAOFactory.getDiagnosticDAO().countEtat(0);
		int nbS = DAOFactory.getDiagnosticDAO().countEtat(1);
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
				new PieChart.Data("Contaminé ou mort", nbC),
				new PieChart.Data("Sain", nbS));
		
		etatPieChart.setData(data);
		
		XYChart.Series<String,Integer> set = new XYChart.Series<>();
		set.getData().add(new XYChart.Data<String,Integer>("Contaminé ou mort",nbC));
		set.getData().add(new XYChart.Data<String,Integer>("Sain",nbS));
		etatBarChart.getData().addAll(set);
		
	}

}
