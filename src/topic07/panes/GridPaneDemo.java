package panes;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * The Grid Pane Demo App
 * 
 * @author lua1
 */

public class GridPaneDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		final GridPane grid = new GridPane();
		// Add gaps between cells
	    grid.setHgap(10);
	    grid.setVgap(10);
		// Add padding to the grid
	    grid.setPadding(new Insets(10, 10, 10, 10));

		// display grid lines
		//grid.setGridLinesVisible(true);
		
		// Span the first line
		final Label label1 = new Label("---Top---");
		label1.setPadding(new Insets(5));
		GridPane.setConstraints(label1, 0, 0, GridPane.REMAINING, 1, HPos.CENTER, VPos.CENTER);
		
		final Label label2 = new Label("A");
		label2.setPadding(new Insets(5));
		GridPane.setConstraints(label2, 0, 1);
		
		final Label label3 = new Label("B");
		label3.setPadding(new Insets(5));
		GridPane.setConstraints(label3, 1, 1);

		final Label label4 = new Label("C");
		label4.setPadding(new Insets(5));
		GridPane.setConstraints(label4, 2, 1);
		
		final Label label5 = new Label("D");
		label5.setPadding(new Insets(5));
		GridPane.setConstraints(label5, 3, 1);

		// ...
		
		final Label label7 = new Label("Three");
		label7.setPadding(new Insets(5));
    	GridPane.setConstraints(label7, 1, 2, 3, 1, HPos.RIGHT, VPos.BOTTOM);
		
	    // add all nodes to grid
		grid.getChildren().addAll(label1, label2, label3, label4, label5, label7);
		
		// Link Stage, Scene and StackPane
		primaryStage.setScene(new Scene(grid, 500, 550));

		// set properties title and resizeable
		primaryStage.setTitle("GridPane Demo");
		primaryStage.setResizable(true);

		// Position and show
		primaryStage.centerOnScreen();
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
