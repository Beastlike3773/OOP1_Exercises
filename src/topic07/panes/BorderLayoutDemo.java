package panes;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * The Borderlayout Demo App
 * 
 * @author lua1
 */

public class BorderLayoutDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		final BorderPane pane = new BorderPane();
		
	    // Top region
		final TextFlow textFlow = new TextFlow();
		textFlow.setStyle("-fx-border-color: black;");
		textFlow.setTextAlignment(TextAlignment.CENTER);
		textFlow.setPadding(new Insets(10));
		textFlow.getChildren().add(new Text("Top"));
		pane.setTop(textFlow);
		
		// Left region
		final TextFlow textFlowLeft = new TextFlow();
		textFlowLeft.setStyle("-fx-border-color: black;");
		textFlowLeft.setTextAlignment(TextAlignment.LEFT);
		textFlowLeft.setPadding(new Insets(10));
		textFlowLeft.getChildren().add(new Text("L\ne\nf\nt"));
		pane.setLeft(textFlowLeft);
		
		// Center region
		final TextFlow textFlowCenter = new TextFlow();
		textFlowCenter .setStyle("-fx-border-color: black;");
		textFlowCenter .setTextAlignment(TextAlignment.CENTER);
		textFlowCenter .setPadding(new Insets(10));
		textFlowCenter .getChildren().add(new Text("CENTER"));
		pane.setCenter (textFlowCenter );
			
		// Right region
		final TextFlow textFlowRight = new TextFlow();
		textFlowRight.setStyle("-fx-border-color: black;");
		textFlowRight.setTextAlignment(TextAlignment.RIGHT);
		textFlowRight.setPadding(new Insets(10));
		textFlowRight.getChildren().add(new Text("R\ni\ng\nh\nt"));
		pane.setRight(textFlowRight);

		// Bottom region
		final TextFlow textFlowBottom = new TextFlow();
		textFlowBottom.setStyle("-fx-border-color: black;");
		textFlowBottom.setTextAlignment(TextAlignment.CENTER);
		textFlowBottom.setPadding(new Insets(10));
		textFlowBottom.getChildren().add(new Text("Bottom"));
		pane.setBottom(textFlowBottom);
		
		// Link Stage, Scene and StackPane
		primaryStage.setScene(new Scene(pane, 400, 300));

		// set properties title and resizeable
		primaryStage.setTitle("BorderLayout Demo");
		primaryStage.setResizable(true);

		// Position and show
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
