package javafx3d;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx3d.celestialbodys.moons.EarthMoon;
import javafx3d.celestialbodys.moons.IMoon;
import javafx3d.celestialbodys.planets.*;
import javafx3d.celestialbodys.stars.IStar;
import javafx3d.celestialbodys.stars.Sun;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem extends Application {

    private static List<IPlanet> planets;
    private static List<IStar> stars;
    private static List<IMoon> moons;
    private static List<Sphere> spheres;
    private static List<Sphere> moonSpheres;
    private static Sphere clickedSphere;

    // Animations
    private static Double transX;
    private static Double transS;
    private static boolean inZoom;

    private static AnchorPane root;
    private static Pane pane;
    private static Scene scene;
    private static Button returnB;

    @Override
    public void start(Stage stage) throws Exception {
        root = new AnchorPane();
        scene = new Scene(root, 1800, 900);

        planets = new ArrayList<>();
        stars = new ArrayList<>();
        moons = new ArrayList<>();
        spheres = new ArrayList<>();
        moonSpheres = new ArrayList<>();

        createStars();
        createPlanets();
        createMoons();
        addSpheresToStage();

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                for(IStar s : stars){
                    s.rotate();
                }
                for(IPlanet p : planets){
                    p.rotate();
                }
                for(IMoon m : moons){
                    m.rotate();

                }
            }
        }.start();

        // Create buttons
        createButtons();

        // Background
        Image stars = new Image("file:./src/javafx3d/resources/stars_milkeyway.jpg");
        ImageView ivStars = new ImageView(stars);
        root.getChildren().add(ivStars);
        root.getChildren().addAll(spheres);
        root.getChildren().addAll(moonSpheres);
        root.getChildren().add(returnB);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void createButtons(){
        returnB = new Button("Back");
        AnchorPane.setBottomAnchor(returnB, 20d);
        AnchorPane.setRightAnchor(returnB, 20d);
        returnB.setDisable(true);
        returnB.setVisible(false);
        returnB.getStyleClass().add("returnButton");
        returnB.setOnAction(event -> {
            TranslateTransition planetTrans = new TranslateTransition(Duration.seconds(2), clickedSphere);
            planetTrans.setByX(-transX);
            ScaleTransition planetScale = new ScaleTransition(Duration.seconds(2), clickedSphere);
            planetScale.setByX(-transS);
            planetScale.setByY(-transS);
            planetScale.setByZ(-transS);
            planetTrans.play();
            planetScale.play();
            returnB.setDisable(true);
            returnB.setVisible(false);

            planetTrans.setOnFinished(e -> {
                inZoom = false;
            });
            for(Sphere s : spheres){
                s.setVisible(true);
            }
            clickedSphere = null;

        });
    }

    public static void createStars(){
        stars.clear();
        stars.add(Sun.getInstance());
    }
    public static void createPlanets(){
        planets.clear();
        planets.add(Mercury.getInstance());
        planets.add(Venus.getInstance());
        planets.add(Earth.getInstance());
        planets.add(Mars.getInstance());
    }

    public static void createMoons(){
        moons.add(EarthMoon.getInstance());
    }

    public static void addSpheresToStage() {
        spheres.clear();
        for (IStar s : stars) {
            spheres.add(s.getBody(2000));
        }
        for (IPlanet p : planets) {
            spheres.add(p.getBody(100));
        }
        for(IMoon m : moons){
            moonSpheres.add(m.getBody(100));
        }
        Double pos = 200d;

        spheres.get(0).setLayoutY(scene.getHeight() / 2);
        spheres.get(0).setLayoutX(pos);

        EventHandler<MouseEvent> sphereClicked = mouseEvent -> {
            if(!inZoom) {
                clickedSphere = (Sphere) mouseEvent.getSource();

                for (Sphere s : spheres) {
                    if (!s.equals(clickedSphere)) {
                        s.setVisible(false);
                    }
                }


                transX = -(clickedSphere.getLayoutX() - (scene.getWidth() / 2));
                transS = 4d;
                TranslateTransition planetTrans = new TranslateTransition(Duration.seconds(2), clickedSphere);
                planetTrans.setByX(transX);
                ScaleTransition planetScale = new ScaleTransition(Duration.seconds(2), clickedSphere);
                planetScale.setByX(transS);
                planetScale.setByY(transS);
                planetScale.setByZ(transS);
                planetTrans.play();
                planetScale.play();
                inZoom = true;

                planetTrans.setOnFinished(e -> {
                    returnB.setDisable(false);
                    returnB.setVisible(true);
                });
            }
        };

            for (int i = 0; i < spheres.size(); i++) {
                spheres.get(i).setLayoutY(scene.getHeight() / 2);
                if (i != 0) {
                    spheres.get(i).setLayoutX(spheres.get(0).getLayoutX() + stars.get(0).getRadius() / 2000 + (planets.get(i - 1).getDistanceToSun() * 5));
                } else {
                    spheres.get(i).setLayoutX(300);
                }
                spheres.get(i).addEventHandler(MouseEvent.MOUSE_CLICKED, sphereClicked);
            }

            for(int i = 0; i < moons.size(); i++){
                switch(moons.get(i).getPlanet()){
                    case "Earth":
                        for(int k = 1; k < spheres.size(); k++){
                            if(planets.get(k-1) instanceof Earth){
                                moonSpheres.get(i).setLayoutX(spheres.get(k).getLayoutX());
                                moonSpheres.get(i).setLayoutY(scene.getHeight()/2);
                            }
                        }
                        break;
                }
            }

    }


    public static void main(String[] args){
        launch(args);
    }
}
