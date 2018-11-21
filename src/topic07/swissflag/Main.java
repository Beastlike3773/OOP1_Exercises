package topic07.swissflag;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    boolean isVisible = false;

    @Override
    public void start(Stage stage){
        //final Group root = new Group();

        final StackPane container = new StackPane();
        container.setAlignment(Pos.CENTER);
        container.setVisible(false);

        // Flag
        final Rectangle redSquare = new Rectangle(0, 0, 200, 200);
        redSquare.setFill(Color.RED);
        final Rectangle whiteVertical = new Rectangle(0, 0, 200 * 0.667, 6 * (200 * 0.667) / 20);
        whiteVertical.setFill(Color.WHITE);
        final Rectangle whiteHorizontal = new Rectangle(0, 0, 6 * (200 * 0.667) / 20, 200 * 0.667);
        whiteHorizontal.setFill(Color.WHITE);
        container.getChildren().addAll(redSquare, whiteVertical, whiteHorizontal);

        // Button Hide/Show
        Button showHide = new Button("Show");
        showHide.setPrefSize(50, 20);
        showHide.setOnAction(event -> {
            if(isVisible){
                container.setVisible(false);
                isVisible = false;
                showHide.setText("Show");
            }else{
                container.setVisible(true);
                isVisible = true;
                showHide.setText("Hide");
            }
        });

        // Radio buttons
        final ToggleGroup tg = new ToggleGroup();
        final RadioButton swissBtn = new RadioButton();
        swissBtn.setText("Swiss");
        swissBtn.setToggleGroup(tg);

        final RadioButton spainBtn = new RadioButton();
        spainBtn.setText("Spain");
        spainBtn.setToggleGroup(tg);

        final RadioButton brazilBtn = new RadioButton();
        brazilBtn.setText("Brazil");
        brazilBtn.setToggleGroup(tg);

        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)tg.getSelectedToggle();

                switch (rb.getText()) {
                    case "Swiss":
                        container.getChildren().removeAll();
                        container.getChildren().addAll(redSquare, whiteVertical, whiteHorizontal);
                        break;
                    case "Spain":
                        container.getChildren().removeAll();
                        //container.getChildren().addAll(firstStripe, secondStripe, thirdStripe);
                        break;
                    case "Brazil":
                        container.getChildren().removeAll();
                        //container.getChildren().addAll(japanBackground, circle);
                        break;
                }
            }
        });

        // HBox
        final HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(swissBtn,spainBtn,brazilBtn);

        final VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(hBox, container, showHide);
        //root.getChildren().add(vBox);
        final Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
