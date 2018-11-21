package topic07.controls;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * The Circle Example with StackPane
 * 
 * @author lua1
 */
public class CircleExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		final StackPane root = new StackPane();
		final Scene scene = new Scene(root, 300, 250);
		
		final Circle c1 = 
			      new Circle(50.0f, 50.0f, 120.0f, Color.DARKSEAGREEN);
			           			        
		final Circle c2 = 
			      new Circle(50.0f, 50.0f, 80.0f, Color.SEAGREEN);
			           			        

	    final Circle c3 = 
			      new Circle(50.0f, 50.0f, 40.0f, Color.FORESTGREEN);
			           			        
	    root.getChildren().addAll(c1,c2,c3);
		
		primaryStage.setTitle("JavaFX Circle example");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
