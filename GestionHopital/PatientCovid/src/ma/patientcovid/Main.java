package ma.patientcovid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ma.patientcovid.ui.BaseController;

public class Main extends Application{

	private static BaseController base;
	static BorderPane mainLayout1 = null;
	static Pane mainLayout2 = null;
	static Stage primary ;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader rootfx = new FXMLLoader(getClass().getResource("ui/LoginPage.fxml"));
		Parent root = rootfx.load();
		base = rootfx.getController();
		primary = primaryStage;
		primaryStage.setTitle("PatientCovid - Attaoui Ahmed Ali");
		primaryStage.setScene(new Scene(root));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static BaseController getControllerdashboard() {
		return base;
	}

}
