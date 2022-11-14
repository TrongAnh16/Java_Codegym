public class Main {
    public static void main(String[] args) {
        fan fan1 = new fan(3, true, "yellow", 10);
        fan fan2 = new fan(2, false, "blue", 5);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
