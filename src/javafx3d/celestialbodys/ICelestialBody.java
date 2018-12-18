package javafx3d.celestialbodys;

import javafx.scene.shape.Sphere;

public interface ICelestialBody {
    Sphere getBody(int scale);
    void rotateBy(double v);
}
