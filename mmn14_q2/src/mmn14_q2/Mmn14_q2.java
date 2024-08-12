package mmn14_q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mmn14_q2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("mmn14_q2.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("mmn14_q2");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {

		launch(args);
	}
}
