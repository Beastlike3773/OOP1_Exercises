package javafx3d;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx3d.celestialbodys.planets.Earth;
import javafx3d.celestialbodys.planets.IPlanet;
import javafx3d.celestialbodys.planets.Mars;
import javafx3d.celestialbodys.stars.IStar;
import javafx3d.celestialbodys.stars.Sun;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem extends Application {

    static List<IPlanet> planets;
    static List<IStar> stars;
    static List<Sphere> spheres;

    private static Group root;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        root = new Group();
        scene = new Scene(root, 1800, 900);

        planets = new ArrayList<>();
        stars = new ArrayList<>();
        spheres = new ArrayList<>();

        createStars();
        createPlanets();
        addSpheresToStage();

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(IStar s : stars){
                    s.rotateBy(0.2);
                }
                for(IPlanet p : planets){
                    p.rotateBy(0.2);
                }
            }
        }.start();


        // Background
        Image stars = new Image("file:./src/javafx3d/resources/stars_milkeyway.jpg");
        ImageView ivStars = new ImageView(stars);
        root.getChildren().add(ivStars);
        root.getChildren().addAll(spheres);
        stage.setScene(scene);
        stage.show();
    }

    public static void createStars(){
        stars.add(Sun.getInstance());
    }
    public static void createPlanets(){
        planets.add(Mars.getInstance());
        planets.add(Earth.getInstance());
    }

    public static void addSpheresToStage(){
        for(IStar s : stars){
            spheres.add(s.getBody(10000));
        }
        for(IPlanet p : planets){
            spheres.add(p.getBody(200));
        }

        Double space = 200d;
        Double pos = 800d;

        for(Sphere s : spheres) {
            s.setLayoutY(scene.getHeight()/2);
            s.setLayoutX(pos);
            pos += space;
        }
    }


    public static void main(String[] args){
        launch(args);
    }
}
