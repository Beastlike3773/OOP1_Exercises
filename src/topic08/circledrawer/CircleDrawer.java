package topic08.circledrawer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class CircleDrawer extends Application {

    private Circle circle;
    private static Canvas canvas;
    private static int radius;

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Circle circle = Circle.getInstance();

        // Stage
        canvas = new Canvas();
        canvas.setLayoutX(100);
        canvas.setLayoutY(0);
        canvas.setWidth(400);
        canvas.setHeight(480);
        canvas.setOnMouseClicked(event -> {
            circle.setRadius(radius);
            circle.setX((int)event.getX());
            circle.setY((int)event.getY());
            circle.setColor(Color.PURPLE);

            draw(circle);
        });

        canvas.setOnMousePressed(event -> {
            circle.setX((int)event.getX());
            circle.setY((int)event.getY());
            circle.setColor(Color.PURPLE);
        });
        canvas.setOnMouseReleased(event -> {
            int x = Math.abs(circle.getX() - (int)event.getX());
            int y = Math.abs(circle.getY() - (int)event.getY());
            circle.setRadius((int)Math.sqrt(x*x + y*y));

            draw(circle);
        });

        Line vLine = new Line(100, 5, 100,475);
        //vLine.setFill(Color.LIGHTGRAY);
        Line hLine = new Line(5, 480, 495,480);
        //hLine.setFill(Color.LIGHTGRAY);

        Label xL = new Label("X:");
        xL.setLayoutX(10);
        xL.setLayoutY(100);
        Label yL = new Label("Y:");
        yL.setLayoutX(10);
        yL.setLayoutY(130);
        Label rL = new Label("R:");
        rL.setLayoutX(10);
        rL.setLayoutY(160);
        TextField xTF = new TextField("0");
        xTF.setLayoutX(25);
        xTF.setLayoutY(100);
        xTF.setPrefWidth(40);
        TextField yTF = new TextField("0");
        yTF.setLayoutX(25);
        yTF.setLayoutY(130);
        yTF.setPrefWidth(40);
        TextField rTF = new TextField("0");
        rTF.setOnKeyTyped(event -> {
            radius = Integer.parseInt(rTF.getText());
        });
        rTF.setLayoutX(25);
        rTF.setLayoutY(160);
        rTF.setPrefWidth(40);

        Button drawB = new Button("Draw");
        drawB.setOnAction(event -> {
            circle.setRadius(radius);
            circle.setX(Integer.parseInt(xTF.getText()));
            circle.setY(Integer.parseInt(yTF.getText()));
            circle.setColor(Color.PURPLE);

           draw(circle);
        });
        drawB.setLayoutX(20);
        drawB.setLayoutY(190);

        root.getChildren().addAll(xL, yL, rL, xTF, yTF, rTF, drawB,
                vLine, hLine, canvas);

        Scene scene = new Scene(root, 500,500);
        scene.setFill(Color.LIGHTGREY);
        stage.setScene(scene);
        stage.show();
    }

    public static void draw(Circle circle){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,500,500);
        gc.setFill(circle.getColor());
        gc.fillOval(circle.getX() - circle.getRadius()/2, circle.getY() - circle.getRadius()/2, circle.getRadius(), circle.getRadius());
    }

    public static void main(String[] args){
        launch(args);
    }
}
