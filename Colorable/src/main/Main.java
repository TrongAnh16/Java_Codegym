package main;

import colorable.Colorable;
import shape.Circle;
import shape.Rectangle;
import shape.Shape;
import shape.Square;

public class Main {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[3];
        shapes[0] = new Square(3.5);
        shapes[1] = new Circle(5);
        shapes[2] = new Rectangle(5,10);
        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println(shape.howToColor());
        }

    }
}
