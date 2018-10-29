package topic05.picalculation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Main extends Application {

    static List<Circle> circles;
    static Group root;
    static Circle circleMain;

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new Group();
        circles = new ArrayList<>();

        Rectangle rect = new Rectangle();
        rect.setLayoutY(10);
        rect.setFill(Color.WHITE);
        rect.setLayoutX(10);
        rect.setWidth(1000);
        rect.setHeight(1000);
        rect.setStrokeWidth(2);
        rect.setStroke(Color.BLACK);
        rect.setStrokeType(StrokeType.OUTSIDE);
        rect.setVisible(true);

        circleMain = new Circle();
        circleMain.setFill(Color.WHITE);
        circleMain.setCenterY(510);
        circleMain.setCenterX(510);
        circleMain.setRadius(500);
        circleMain.setStrokeWidth(2);
        circleMain.setStroke(Color.BLACK);
        circleMain.setStrokeType(StrokeType.OUTSIDE);
        circleMain.setVisible(true);


        new AnimationTimer() {

            @Override
            public void handle(long now) {
                Points();

                long blue = 0;
                long green = 0;

                for (Circle circle : circles) {
                    if (circle.getFill() == Color.GREEN) {
                        blue++;
                        green++;
                    } else {
                        blue++;
                    }
                }

                double pi = 4 * ((double) green / (double) blue);

                System.out.println(pi);
            }
        }.start();

        root.getChildren().addAll(rect, circleMain);
        primaryStage.setScene(new Scene(root, 1100, 1100));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

    public static void Points(){
        for(int i = 0; i<10000;i++){
            Circle circle = new Circle();
            Random random = new Random();
            circle.setCenterY(random.nextInt(1000) + 10);
            circle.setCenterX(random.nextInt(1000) + 10);
            circle.setRadius(1);
            circle.setVisible(true);

            int mainX = (int)circleMain.getCenterX();
            int mainY = (int)circleMain.getCenterY();
            int X = (int)circle.getCenterX();
            int Y = (int)circle.getCenterY();

            if(Math.sqrt(Math.pow(mainX - X, 2) + Math.pow(mainY - Y, 2)) < 500){
                circle.setFill(Color.GREEN);
            }else{
                circle.setFill(Color.BLUE);
            }

            circles.add(circle);

            root.getChildren().add(circle);
        }
    }
}
