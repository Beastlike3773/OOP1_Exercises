package panes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * The Flow Pane Demo App
 * 
 * @author lua1
 */

public class FlowPaneDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		final FlowPane pane = new FlowPane(10, 10);
		pane.setPadding(new Insets(10));
		
		for (int i = 1;i < 11; i++) {
			final ImageView image = new ImageView(new Image(
					"file:res/flowers/flower_" + i + ".jpg"));
			image.setPreserveRatio(true);
			image.setFitWidth(150);
			pane.getChildren().add(image);
		}

		// Link Stage, Scene and StackPane
		primaryStage.setScene(new Scene(pane, 500, 550));

		// set properties title and resizeable
		primaryStage.setTitle("FlowPane Demo");
		primaryStage.setResizable(true);

		// Position and show
		primaryStage.centerOnScreen();
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
