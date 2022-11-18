package Main;

import shape.Circle;
import shape.Rectangle;
import shape.Square;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(12, 20);
        System.out.println(rectangle);
        Rectangle rectangleResized =  rectangle.resize(50 );
        System.out.println(rectangleResized);

        Circle circle = new Circle(50);
        System.out.println(circle);
        Circle circleResized = circle.resize(50);
        System.out.println(circleResized);

        Square square = new Square(10);
        System.out.println(square);
        Square squareResized = square.resize(50);
        System.out.println(squareResized);
    }
}
