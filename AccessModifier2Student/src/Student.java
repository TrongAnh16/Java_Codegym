import java.util.Objects;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public Student() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " classes: " + this.classes;
    }


}