package shape;

import colorable.Colorable;

public class Circle extends Shape implements Colorable {
    double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "A circle with radius = "
                + getRadius()
                + ", area: "
                + getArea()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public String howToColor() {
        return "Color all circle";
    }
}