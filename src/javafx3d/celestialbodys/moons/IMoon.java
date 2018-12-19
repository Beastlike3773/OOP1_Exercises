package javafx3d.celestialbodys.moons;

import javafx3d.celestialbodys.ICelestialBody;

public interface IMoon extends ICelestialBody {
    Double getDistanceToPlanet();
    String getPlanet();
}
