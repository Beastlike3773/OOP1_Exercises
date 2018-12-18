package javafx3d.celestialbodys.planets;

import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

public class Mars implements IPlanet {
    private Double rotate;
    private Sphere body;
    private PhongMaterial material;
    private Double radius;

    private static IPlanet instance;
    protected Mars(){
        rotate = 0d;
        radius = 3390d;

        // Create sphere
        body = new Sphere(radius);
        body.setRotationAxis(Rotate.Y_AXIS);
        material = new PhongMaterial();
        body.setMaterial(material);
        body.setRadius(radius);
        material.setDiffuseMap(new Image("file:./src/javafx3d/resources/mars.jpg"));
    }

    public static IPlanet getInstance(){
        if(instance == null){
            instance = new Mars();
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
