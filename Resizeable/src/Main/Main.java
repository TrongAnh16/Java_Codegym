package Main;

import shape.Circle;
import shape.Rectangle;
import shape.Square;

public class Main {
    public static void main(String[] args) {
        System.out.println("Rectangle before resized: ");
        Rectangle rectangle = new Rectangle(12, 20);
        System.out.println(rectangle);
        System.out.println("Rectangle after resized: ");
        Rectangle rectangleResized =  rectangle.resize(50 );
        System.out.println(rectangleResized);

        System.out.println("Circle before resized: ");
        Circle circle = new Circle(50);
        System.out.println(circle);
        System.out.println("Circle after resized: ");
        Circle circleResized = circle.resize(50);
        System.out.println(circleResized);

        System.out.println("Square before resized: ");
        Square square = new Square(10);
        System.out.println(square);
        System.out.println("Square after resized: ");
        Square squareResized = square.resize(50);
        System.out.println(squareResized);
    }
}
