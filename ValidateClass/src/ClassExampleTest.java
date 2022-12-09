public class ClassExampleTest {
    private static ClassExample classExample;
    public static final String[] validClass = new String[] {
            "123abc_", "C0318G", "______", "M0318G","abcdefgh"
    };

    public static final String[] invalidClass = new String[] {
            ".@", "12345", "1234_", "abcde"
    };

    public static void main(String[] args) {
        classExample = new ClassExample();
        for (String className : validClass) {
            boolean isvalid = classExample.validate(className);
            System.out.println("Class is "+ className+" isvalid: "+isvalid);
        }
    }
}
