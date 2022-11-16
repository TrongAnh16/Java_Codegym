public class MoveablePointTest {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint(8,2,3,4);
        System.out.println("Before move: "+moveablePoint);
        System.out.println("After move: "+moveablePoint.move());
    }
}
