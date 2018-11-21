package topic07.controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The Menu Demo App
 * 
 * @author lua1
 */

public class MenuDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		VBox pane = new VBox();
		pane.setAlignment(Pos.TOP_LEFT);
		pane.setPadding(new Insets(10));
		
		EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("You chose the menu item <<"+
			       ((MenuItem) event.getSource()).getText()+ ">>!!");			
			}};

		final MenuBar menuBar = new MenuBar();
		menuBar.setUseSystemMenuBar(true);
		final Menu fileM = new Menu("File");
		// New item
		final ImageView imageN = new ImageView(new Image("file:res/New.png"));
		imageN.setFitHeight(30f);
		imageN.setFitWidth(30f);
		final MenuItem newI = new MenuItem("New", imageN);
		newI.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
		newI.setOnAction(handler);
		// Open item
		final ImageView imageO = new ImageView(new Image("file:res/Open.png"));
		imageO.setFitHeight(30f);
		imageO.setFitWidth(30f);
		final MenuItem openI = new MenuItem("Open", imageO);
		openI.setAccelerator(KeyCombination.keyCombination("Shortcut+O"));
		openI.setOnAction(handler);
		// Close item
		final MenuItem closeI = new MenuItem("Close");
		closeI.setOnAction(handler);
		// Add to Menu "File"
		fileM.getItems().addAll(newI, openI, new SeparatorMenuItem(), closeI);
		
		// Options Menu
		final Menu optionsM = new Menu("Options");
		final MenuItem op1 = new MenuItem("Option1");
		op1.setOnAction(handler);
		final MenuItem op2 = new MenuItem("Option2");
		op2.setOnAction(handler);
		final MenuItem op3 = new MenuItem("Option3");
		op3.setOnAction(handler);
		optionsM.getItems().addAll(op1, op2, op3);

		// Help Menu
		final Menu helpM = new Menu("Help");
		final MenuItem about = new MenuItem("About");
		about.setOnAction(handler);
		helpM.getItems().addAll(about);
		
		menuBar.getMenus().addAll(fileM, optionsM, helpM);
		pane.getChildren().addAll(menuBar);
	

		// Link Stage, Scene and StackPane
		primaryStage.setScene(new Scene(pane, 400, 300));

		// set properties title and resizeable
		primaryStage.setTitle("Menu Demo");
		primaryStage.setResizable(true);

		// Position and show
		primaryStage.centerOnScreen();
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
