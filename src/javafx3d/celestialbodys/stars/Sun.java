package javafx3d.celestialbodys.stars;

import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx3d.celestialbodys.planets.Earth;
import javafx3d.celestialbodys.planets.IPlanet;

public class Sun implements IStar {
    private Double rotate;
    private Sphere body;
    private PhongMaterial material;
    private Double radius;

    private static IStar instance;

    protected Sun(){
        rotate = 0d;
        radius = 695508d;

        // Create sphere
        body = new Sphere(radius);
        body.setRotationAxis(Rotate.Y_AXIS);
        material = new PhongMaterial();
        body.setMaterial(material);
        body.setRadius(radius);
        material.setDiffuseMap(new Image("file:./src/javafx3d/resources/sun.jpg"));
    }

    public static IStar getInstance(){
        if(instance == null){
            instance = new Sun();
        }

        return instance;
    }

    @Override
    public Sphere getBody(int scale){
        body.setRadius(radius/scale);
        return body;
    }

    @Override
    public void rotateBy(double v) {
        body.setRotate(rotate += 0.2);
        if(rotate == 360d){
            rotate = 0d;
        }
    }
}
