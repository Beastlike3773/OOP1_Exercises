package topic08.circledrawer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CircleDrawer extends Application {
    private class NumberField extends TextField{
        public NumberField(String s){
            super(s);
        }

        @Override
        public void replaceText(int start, int end, String text){
            if(text.matches("[0-9]") || text.equals("")){
                super.replaceText(start, end, text);
            }
        }

        @Override
        public void replaceSelection(String text){
            if(text.matches("[0-9]") || text.equals("")){
                super.replaceSelection(text);
            }
        }
    }

    private static Canvas canvas;
    private static Text tMessage;
    private static ComboBox<String> cbColor;
    private static int radius;
    private boolean drag;

    @Override
    public void start(Stage stage) throws Exception {
        final Group root = new Group();
        final Circle circle = Circle.getInstance();
        drag = false;

        cbColor = new ComboBox<>();
        cbColor.setLayoutX(20);
        cbColor.setLayoutY(190);
        cbColor.setPrefSize(70,20);
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Random",
                        "Purple",
                        "Green",
                        "Yellow",
                        "Red",
                        "Blue",
                        "Pink"
                );
        cbColor.setItems(options);
        cbColor.setOnAction(event -> {
            if(cbColor.getValue() != "Random"){
                circle.setColor(Color.valueOf(cbColor.getValue()));
            }
        });
        cbColor.setValue(options.get(1));
        circle.setColor(Color.valueOf(cbColor.getValue()));

        // Stage
        canvas = new Canvas();
        canvas.setLayoutX(100);
        canvas.setLayoutY(0);
        canvas.setWidth(400);
        canvas.setHeight(480);
        canvas.setOnMouseClicked(event -> {
            if(drag) return;
            circle.setRadius(radius);
            circle.setX((int)event.getX());
            circle.setY((int)event.getY());

            draw(circle);
        });
        canvas.setOnMousePressed(event -> {
            if(!drag) return;
            if(cbColor.getValue() == "Random"){
                circle.setColor(Color.color(Math.random(), Math.random(), Math.random()));
            }
            circle.setX((int)event.getX());
            circle.setY((int)event.getY());
        });
        canvas.setOnMouseDragged(event -> {
            if(!drag) return;
            int x = Math.abs(circle.getX() - (int)event.getX());
            int y = Math.abs(circle.getY() - (int)event.getY());
            circle.setRadius((int)Math.sqrt(x*x + y*y));

            draw(circle);
        });


        Line vLine = new Line(100, 5, 100,475);
        vLine.setStroke(Color.LIGHTGRAY);
        Line hLine = new Line(5, 480, 495,480);
        hLine.setStroke(Color.LIGHTGRAY);

        Label xL = new Label("X:");
        xL.setLayoutX(10);
        xL.setLayoutY(100);
        Label yL = new Label("Y:");
        yL.setLayoutX(10);
        yL.setLayoutY(130);
        Label rL = new Label("R:");
        rL.setLayoutX(10);
        rL.setLayoutY(160);
        NumberField xTF = new NumberField("0");
        xTF.setLayoutX(25);
        xTF.setLayoutY(100);
        xTF.setPrefWidth(40);
        NumberField yTF = new NumberField("0");
        yTF.setLayoutX(25);
        yTF.setLayoutY(130);
        yTF.setPrefWidth(40);
        NumberField rTF = new NumberField("0");
        rTF.setOnKeyReleased(event -> {
            radius = Integer.parseInt(rTF.getText());
        });
        rTF.setLayoutX(25);
        rTF.setLayoutY(160);
        rTF.setPrefWidth(40);

        Button drawB = new Button("Draw");
        drawB.setOnAction(event -> {
            try {
                circle.setRadius(radius);
                circle.setX(Integer.parseInt(xTF.getText()));
            }catch(NumberFormatException e){
                tMessage.setText("Error when reading text fields!");
            }

           draw(circle);
        });
        drawB.setLayoutX(20);
        drawB.setLayoutY(230);
        drawB.setPrefSize(70, 20);

        CheckBox chbDrag = new CheckBox("Drag");
        chbDrag.setLayoutX(20);
        chbDrag.setLayoutY(270);
        chbDrag.setOnAction(event -> {
           drag = chbDrag.isSelected();
        });

        tMessage = new Text();
        tMessage.setLayoutX(10);
        tMessage.setLayoutY(495);

        root.getChildren().addAll(xL, yL, rL, xTF, yTF, rTF, cbColor, drawB, tMessage, chbDrag,vLine, hLine, canvas);

        Scene scene = new Scene(root, 500,500);
        scene.setFill(Color.WHITESMOKE);
        stage.setScene(scene);
        stage.show();
    }

    public static void draw(Circle circle){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        gc.setFill(circle.getColor());
        gc.fillOval(circle.getX() - circle.getRadius(), circle.getY()- circle.getRadius(), circle.getRadius()*2, circle.getRadius()*2);
        tMessage.setText("Circle drawn: X: " + circle.getX() + ", Y: " + circle.getY() + ", Radius: " + circle.getRadius() + ", Color: " + cbColor.getValue());
    }

    public static void main(String[] args){
        launch(args);
    }
}