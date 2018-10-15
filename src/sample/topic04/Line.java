package sample.topic04;

import javafx.geometry.Point2D;

public class Line {

    double m, y, x, b;

    public Line(double x1, double y1, double x2, double y2) {
        this.y = y1;
        this.x = x1;
        if ((x2 - x1) != 0) {
            this.m = (y2 - y1) / (x2 - x1);
        } else {
            this.m = Double.MAX_VALUE;
        }

        this.b = this.y - (this.m * this.x);
    }

    public Line(double x, double y, double m) {
        this.y = y;
        this.x = x;
        this.m = m;

        this.b = this.y - (this.m * this.x);
    }

    public Line(double b, double m) {
        this.x = 1;
        this.y = m * this.x + b;
        this.m = m;
        this.b = b;
    }


    public Line(double a) {
        this.x = a;
        this.y = 0;
        this.m = Double.MAX_VALUE;

        this.b = Double.MAX_VALUE;
    }

    public boolean isVertical() {
        return this.m == Double.MAX_VALUE;
    }

    public boolean isHorizontal() {
        return this.m == 0;
    }

    public boolean equals(Line other) {
        return this.m == other.m && this.b == other.b;
    }

    public boolean isParallel(Line other) {
        return this.m == other.m;
    }

    public boolean intersects(Line other) {
        return !isParallel(other);
    }
}
