package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.topic04.File;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main extends Application {

    public static File file;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();

        root.getChildren().add(getTextEditorVBox());

        primaryStage.setTitle("Text Editor");
        primaryStage.setScene(new Scene(root, 400, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);}

    public static VBox getTextEditorVBox(){
        file = new File();

        // labels
        Label fileNameLabel = new Label("Enter file name:");
        Label fileContentLabel = new Label("File content:");

        // error text
        Text errorText = new Text("Error");
        errorText.setFill(Color.RED);
        errorText.prefWidth(400);
        errorText.setTextAlignment(TextAlignment.LEFT);
        errorText.setText(file.getErrorText());

        // text input field
        TextField fileNameTextField = new TextField();
        fileNameTextField.setPrefWidth(400);

        // content area
        TextArea fileContentTextArea = new TextArea();
        fileContentTextArea.setPrefWidth(400);
        fileContentTextArea.setPrefHeight(300);

        // buttons
        Button loadButton = new Button("Load");
        Button saveButton = new Button("Save");
        Button clearButton = new Button("Clear");
        loadButton.setPrefWidth(50);
        saveButton.setPrefWidth(50);
        clearButton.setPrefWidth(50);

        loadButton.setOnAction(event -> {
            file.loadFile(fileNameTextField.getText());
            fileNameTextField.setText(file.getFileName());
            fileContentTextArea.setText(file.getFileContent());
            errorText.setText(file.getErrorText());
        });
        
        saveButton.setOnAction(event ->{
            file.saveFile(fileNameTextField.getText());
            errorText.setText(file.getErrorText());
        });

        clearButton.setOnAction(event -> {
            file.clearFile();
            fileNameTextField.setText(file.getFileName());
            fileContentTextArea.setText(file.getFileContent());
            errorText.setText(file.getErrorText());
        });

        // HBox
        HBox hBox = new HBox();
        hBox.getChildren().addAll(loadButton, saveButton, clearButton);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);

        // VBox
        VBox vBox = new VBox();
        vBox.getChildren().addAll(fileNameLabel, fileNameTextField, errorText, fileContentLabel, fileContentTextArea, hBox);
        vBox.setSpacing(10);

        return vBox;
    }
}
