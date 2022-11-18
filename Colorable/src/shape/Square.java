package shape;

import colorable.Colorable;

public class Square extends Shape implements Colorable {
    private double side = 0;

    public Square() {
    }

    public Square(double side) {

        this.side = side;
    }

    public Square(double side, String color, boolean filled) {

        super(color, filled);
        this.side = side;
    }


    public double getSide() {
        return this.side;
    }

    public void setSide(double side){
        this.side = side;
    }

    public double getArea() {
        return this.side*this.side;
    }

    @Override
    public String toString() {
        return "A square with side = "
                + getSide()
                + ", area: "
                + getArea()
                + ", which a subclass of "
                + super.toString();
    }

    @Override
    public String howToColor() {
        return "Color all four sides";
    }
}
