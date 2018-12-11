package topic08.circledrawer;

import javafx.scene.paint.Color;

public class Circle {

    private int radius;
    private int x;
    private int y;
    private Color color;

    private static Circle instance = null;


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static Circle getInstance(){
        if(instance == null){
            instance = new Circle();
        }

        return instance;
    }

    private Circle(){
        radius = 0;
        x = 0;
        y = 0;
        color = Color.BLACK;
    }
}
