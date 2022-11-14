public class Circle {
    private double radius = 1;
    private String color = "red";

    public Circle() {

    }

    public Circle(double r) {

    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

}
