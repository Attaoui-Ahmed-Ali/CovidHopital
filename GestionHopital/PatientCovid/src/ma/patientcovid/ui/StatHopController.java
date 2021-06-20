package ma.patientcovid.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

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

public class StatHopController implements Initializable {
	@FXML
	PieChart villePieChart;
	
	@FXML
	BarChart<String,Integer> villeBarChart;
	
	@FXML
	CategoryAxis X;
	
	@FXML
	NumberAxis Y;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Set<String> t1 = DAOFactory.getHopitalDAO().allVille();
		ArrayList<Integer> t2 = new ArrayList<Integer>();
		ArrayList<String> t3 = new ArrayList<String>();
		for (String v : t1) {
			t2.add(DAOFactory.getHopitalDAO().countVille(v));
			t3.add(v);
		}
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
		XYChart.Series<String,Integer> set = new XYChart.Series<>();
		int size = t2.size();
		for (int i =0;i<size;i++) {
			data.add(new PieChart.Data(t3.get(i), t2.get(i)));
			set.getData().add(new XYChart.Data<String,Integer>(t3.get(i),t2.get(i)));
		}
		
		villePieChart.setData(data);
		villeBarChart.getData().addAll(set);
		
	}
}
