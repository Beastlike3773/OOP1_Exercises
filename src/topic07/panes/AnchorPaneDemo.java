package panes;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * The Anchor Pane Demo App
 * 
 * @author lua1
 */

public class AnchorPaneDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		final AnchorPane root = new AnchorPane();
		
		Button saveB = new Button("Save");
		AnchorPane.setBottomAnchor(saveB, 10.0);
		AnchorPane.setRightAnchor(saveB, 10.0);
		
		Button cancelB = new Button("Cancel");
		AnchorPane.setBottomAnchor(cancelB, 10.0);
		AnchorPane.setRightAnchor(cancelB, 100.0);
		
		final ImageView help = new ImageView(new Image("file:res/help.png"));
		help.setPreserveRatio(true);
		help.setFitHeight(100);
		AnchorPane.setTopAnchor(help, 10.0);
		AnchorPane.setRightAnchor(help, 10.0);
		
		
		root.getChildren().addAll(cancelB, saveB, help );
		
		// Link Stage, Scene and Pane
		primaryStage.setScene(new Scene(root, 500, 550));

		// set properties title and resizeable
		primaryStage.setTitle("AnchorPane Demo");
		primaryStage.setResizable(true);

		// Position and show
		primaryStage.centerOnScreen();
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
