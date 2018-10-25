package topic05;

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
    public void start(Stage primaryStage) throws Exception{
            int input;
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();

            List<Integer> output = new ArrayList<>();

            for(int i = 2; i < input; i++) {
                while(input % i == 0) {
                    output.add(i);
                    input = input/i;
                }
            }

            for (Integer anOutput : output) {
                System.out.println(anOutput);
            }

    }

    public static void main(String[] args){
        launch(args);
    }

    public static void Points(){
        for(int i = 0; i<100;i++){
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
