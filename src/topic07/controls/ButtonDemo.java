package topic07.controls;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * The Button Demo App
 * 
 * @author lua1
 */

public class ButtonDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10));
		
			
		final Button button = new Button("Click me");
		pane.getChildren().add(button);

		final HBox box1 = new HBox();
		box1.setAlignment(Pos.CENTER_LEFT);
		box1.setPadding(new Insets(10));
		pane.getChildren().add(box1);

		final CheckBox cb1 = new CheckBox("Apple ");
		final ImageView image1 = new ImageView(new Image("file:res/apple.png"));
		image1.setFitHeight(30f);
		image1.setFitWidth(30f);
		cb1.setGraphic(image1);
		box1.getChildren().add(cb1);
		
		final CheckBox cb2 = new CheckBox("Pear  ");
		final ImageView image2 = new ImageView(new Image("file:res/pear.png"));
		image2.setFitHeight(30f);
		image2.setFitWidth(20f);
		cb2.setGraphic(image2);
        box1.getChildren().add(cb2);

		final CheckBox cb3 = new CheckBox("Banana");
		final ImageView image3 = new ImageView(new Image("file:res/banana.png"));
		image3.setFitHeight(30f);
		image3.setFitWidth(30f);
		cb3.setGraphic(image3);
		box1.getChildren().add(cb3);

		
		final VBox box2 = new VBox();
		box2.setAlignment(Pos.CENTER_LEFT);
		box2.setPadding(new Insets(10));
		pane.getChildren().add(box2);

		final Label label = new Label("Choose a Color");
		label.setPrefHeight(30);
		box2.getChildren().add(label);
		
		final ToggleGroup tg = new ToggleGroup();
		final RadioButton rb1 = new RadioButton("Red");
		rb1.setPadding(new Insets(5));
		rb1.setTextFill(Color.RED);
	    rb1.setToggleGroup(tg);
		box2.getChildren().add(rb1);
		
		final RadioButton rb2 = new RadioButton("Blue");
		rb2.setPadding(new Insets(5));
		rb2.setTextFill(Color.BLUE);
		rb2.setToggleGroup(tg);
		box2.getChildren().add(rb2);
		
		final RadioButton rb3 = new RadioButton("Green");
		rb3.setPadding(new Insets(5));
		rb3.setTextFill(Color.GREEN);
        rb3.setToggleGroup(tg);
		box2.getChildren().add(rb3);
				
		// Link Stage, Scene and StackPane
		primaryStage.setScene(new Scene(pane, 300, 200));

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
