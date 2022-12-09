import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassExample {
    public static final String CLASS_REGEX = "^[CAP][0-9]{4}[GHIKLM]$";

    public ClassExample() {
    }

    public static boolean validate(String string) {
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
