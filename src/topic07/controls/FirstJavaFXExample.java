package topic07.controls;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The first Java FX example
 * 
 * @author lua1
 */

public class FirstJavaFXExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		final StackPane stackPane = new StackPane();

		// Create a label and add to the pane
		final Label label = new Label("This is my first JavaFX example !!!");
		stackPane.getChildren().add(label);

		// Link Stage, Scene and StackPane
		primaryStage.setScene(new Scene(stackPane, 250, 75));

		// set properties title and resizeable
		primaryStage.setTitle("FirstJavaFXExample");
		primaryStage.setResizable(true);

		// Position and show
		primaryStage.centerOnScreen();
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
