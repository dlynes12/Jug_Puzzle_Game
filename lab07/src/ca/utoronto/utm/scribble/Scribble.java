package ca.utoronto.utm.scribble;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Scribble extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		Scene scene = new Scene(new ScribblePanel());
		stage.setScene(scene);
		stage.setTitle("Scribble");
		stage.show();
	}
}
