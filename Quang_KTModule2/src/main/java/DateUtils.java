import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class DateUtils {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public static Date convertStringToDate(String strDate) {
        try {
            return formatter.parse(strDate);
        } catch (ParseException parseException) {
        }
        return null;
    }

    public static String convertDateToString(Date date) {
        return formatter.format(date);
    }

}
