package topic07.controls;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * The Label Demo App
 * 
 * @author lua1
 */

public class LabelDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		final TilePane pane = new TilePane();

		final Label label1 = new Label("I'm a Label");
		pane.getChildren().add(label1);
		
		final Label label2 = new Label("I'm a\nLabel too!");
		label2.setFont(Font.font("Dialog", FontWeight.BOLD, 16));
		pane.getChildren().add(label2);
		
		final ImageView image = new ImageView(new Image("file:res/lock-2.png"));
		image.setFitHeight(30f);
		image.setFitWidth(30f);
		final Label label3 = new Label("Don't change me", image);
		label3.setContentDisplay(ContentDisplay.RIGHT);
	    pane.getChildren().add(label3);
    
		// Link Stage, Scene and StackPane
		primaryStage.setScene(new Scene(pane, 400, 50));

		// set properties title and resizeable
		primaryStage.setTitle("Label Demo");
		primaryStage.setResizable(true);

		// Position and show
		primaryStage.centerOnScreen();
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
