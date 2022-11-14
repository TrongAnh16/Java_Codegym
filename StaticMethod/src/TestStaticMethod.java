public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change(); //calling change method

        //creating objects
        Student s1 = new Student(1, "Anh");
        Student s2 = new Student(2, "An");
        Student s3 = new Student(3, "Minh");

        //calling display method
        s1.display();
        s2.display();
        s3.display();
    }
}
