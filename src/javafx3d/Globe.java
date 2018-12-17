package javafx3d;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Globe extends Application {

    private static Sphere globe;
    private static Double rotate;

    private static Group root;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        root = new Group();
        scene = new Scene(root, 500, 500);
        Text t = new Text();
        t.setLayoutY(10);
        t.setLayoutX(10);

        createGlobe();

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                globe.setRotate(rotate += 0.2);
                if(rotate == 360) {
                    rotate = 0d;
                }
            }
        }.start();

        root.getChildren().addAll(globe,t);
        stage.setScene(scene);
        stage.show();
    }

    public static void createGlobe(){
        // Create globe
        globe = new Sphere(200);
        globe.setLayoutX(scene.getWidth()/2);
        globe.setLayoutY(scene.getHeight()/2);
        globe.setRotationAxis(Rotate.Y_AXIS);
        rotate = 0d;

        PhongMaterial material = new PhongMaterial();
        material.setSpecularColor(Color.DARKGREY);
        material.setDiffuseMap(new Image("file:./src/javafx3d/resources/earth_d.jpg"));
        //material.setSpecularMap(new Image("file:./src/javafx3d/resources/earth_n.jpg"));

        globe.setMaterial(material);
    }

    public static void main(String[] args){
        launch(args);
    }
}
