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

public class StatRoomController implements Initializable{
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
		int nbB = DAOFactory.getRoomDAO().countEtat("b");
		int nbO = DAOFactory.getRoomDAO().countEtat("o");
		int nbF = DAOFactory.getRoomDAO().countEtat("f");
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList(
				new PieChart.Data("Réservée", nbB),
				new PieChart.Data("Occupée", nbO),
				new PieChart.Data("Libre", nbF));
		
		etatPieChart.setData(data);
		
		XYChart.Series<String,Integer> set = new XYChart.Series<>();
		set.getData().add(new XYChart.Data<String,Integer>("Réservée", nbB));
		set.getData().add(new XYChart.Data<String,Integer>("Occupée", nbO));
		set.getData().add(new XYChart.Data<String,Integer>("Libre", nbF));
		etatBarChart.getData().addAll(set);
		
	}
}
