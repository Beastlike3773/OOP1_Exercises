package javafx3d.celestialbodys.moons;

public abstract class Moon implements IMoon {
    protected String planet;

    @Override
    public String getPlanet(){
        return planet;
    }
}
