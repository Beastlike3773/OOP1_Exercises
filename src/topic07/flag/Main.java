package topic07.flag;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    boolean isVisible = true;

    @Override
    public void start(Stage stage){
        //final Group root = new Group();

        final StackPane container = new StackPane();
        container.setAlignment(Pos.CENTER);
        container.setVisible(true);

        // Switzerland Flag
        final Rectangle swiss1 = new Rectangle(0, 0, 200, 200);
        swiss1.setFill(Color.RED);
        final Rectangle swiss2 = new Rectangle(0, 0, 200 * 0.667, 6 * (200 * 0.667) / 20);
        swiss2.setFill(Color.WHITE);
        final Rectangle swiss3 = new Rectangle(0, 0, 6 * (200 * 0.667) / 20, 200 * 0.667);
        swiss3.setFill(Color.WHITE);

        // Spain Flag
        final Rectangle spain1 = new Rectangle(0, 0, 300, 70);
        spain1.setFill(Color.RED);
        final Rectangle spain2 = new Rectangle(0, 0, 300, 70);
        spain2.setFill(Color.YELLOW);
        final Rectangle spain3 = new Rectangle(0, 0, 300, 70);
        spain3.setFill(Color.RED);
        VBox spainFlag = new VBox();
        spainFlag.setAlignment(Pos.CENTER);
        spainFlag.getChildren().addAll(spain1, spain2, spain3);

        // Brazil Flag
        final Rectangle brazil1 = new Rectangle(0, 0, 300, 210);
        brazil1.setFill(Color.GREEN);
        final Polygon brazil2 = new Polygon(
                -100, 75,
                0, 0,
                100, 75,
                0, 150);
        brazil2.setFill(Color.YELLOW);
        final Circle brazil3 = new Circle();
        brazil3.setRadius(45);
        brazil3.setFill(Color.BLUE);
        //final Rectangle spain2 = new Rectangle(0, 0, 300, 70);
        //spain2.setFill(Color.YELLOW);
        //final Rectangle spain3 = new Rectangle(0, 0, 300, 70);
        //spain3.setFill(Color.RED);

        // Button Hide/Show
        Button showHide = new Button("Hide");
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
        final RadioButton switzerlandBtn = new RadioButton();
        switzerlandBtn.setText("Switzerland");
        switzerlandBtn.setToggleGroup(tg);

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
                    case "Switzerland":
                        container.getChildren().clear();
                        container.getChildren().addAll(swiss1, swiss2, swiss3);
                        break;
                    case "Spain":
                        container.getChildren().clear();
                        container.getChildren().add(spainFlag);
                        break;
                    case "Brazil":
                        container.getChildren().clear();
                        container.getChildren().addAll(brazil1, brazil2, brazil3);
                        break;
                }
            }
        });

        // HBox
        final HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(switzerlandBtn,spainBtn,brazilBtn);

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
