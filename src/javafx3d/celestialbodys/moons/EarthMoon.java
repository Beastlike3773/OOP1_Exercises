package javafx3d.celestialbodys.moons;

import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx3d.celestialbodys.planets.IPlanet;
import javafx3d.celestialbodys.planets.Mars;

public class EarthMoon extends Moon {
    private Double rotate;
    private Double distanceToPlanet;
    private Sphere body;
    private PhongMaterial material;
    private Double radius;

    private static IMoon instance;

    protected EarthMoon(){
        rotate = 0d;
        radius = 1737d;
        distanceToPlanet = 0.3844d;
        planet = "Earth";

        // Create sphere
        body = new Sphere(radius);
        body.setRotationAxis(Rotate.Y_AXIS);
        material = new PhongMaterial();
        body.setMaterial(material);
        body.setRadius(radius);
        material.setDiffuseMap(new Image("file:./src/javafx3d/resources/earth_moon.jpg"));
    }

    public static IMoon getInstance(){
        if(instance == null){
            instance = new EarthMoon();
        }

        return instance;
    }

    @Override
    public Double getDistanceToPlanet() {
        return distanceToPlanet;
    }


    @Override
    public Sphere getBody(int scale){
        body.setRadius(radius/scale);
        return body;
    }
    @Override
    public void rotate() {
        body.setRotate(rotate += 0.2);
        if(rotate == 360d){
            rotate = 0d;
        }
    }
}
