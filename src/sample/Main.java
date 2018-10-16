package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();

        // labels
        Label fileNameLabel = new Label("Enter file name:");
        Label fileContentLabel = new Label("File content:");
        fileNameLabel.setLayoutY(10);
        fileContentLabel.setLayoutY(100);
        root.getChildren().add(fileNameLabel);
        root.getChildren().add(fileContentLabel);

        // text input field
        TextField fileNameTextField = new TextField();
        fileNameTextField.setLayoutY(30);
        fileNameTextField.setPrefWidth(400);
        root.getChildren().add(fileNameTextField);

        // content area
        TextArea fileContentTextArea = new TextArea();
        fileContentTextArea.setLayoutY(120);
        fileContentTextArea.setPrefWidth(400);
        fileContentTextArea.setPrefHeight(300);
        root.getChildren().add(fileContentTextArea);

        // buttons
        Button loadButton = new Button("Load");
        Button saveButton = new Button("Save");
        Button clearButton = new Button("Clear");
        loadButton.setLayoutY(440);
        loadButton.setLayoutX(100);
        loadButton.setPrefWidth(30);
        saveButton.setLayoutY(440);
        saveButton.setLayoutX(150);
        saveButton.setPrefWidth(30);
        clearButton.setLayoutY(440);
        clearButton.setLayoutX(200);
        clearButton.setPrefWidth(30);
        root.getChildren().add(loadButton);
        root.getChildren().add(saveButton);
        root.getChildren().add(clearButton);

        primaryStage.setTitle("Text Editor");
        primaryStage.setScene(new Scene(root, 400, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
