package topic07.controls;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 * The HTML Demo App
 * 
 * @author lua1
 */

public class HTMLDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		VBox pane = new VBox();
		pane.setAlignment(Pos.TOP_LEFT);
		pane.setPadding(new Insets(10));

		final HTMLEditor html = new HTMLEditor();
		
		pane.getChildren().add(html);

		final Button button = new Button("Print Content");
		pane.getChildren().add(button);
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println(html.getHtmlText());
			}
		});
		

		// Link Stage, Scene and StackPane
		primaryStage.setScene(new Scene(pane, 600, 300));

		// set properties title and resizeable
		primaryStage.setTitle("HTML Demo");
		primaryStage.setResizable(true);

		// Position and show
		primaryStage.centerOnScreen();
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
