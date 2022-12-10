package common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtils {
    public static Timestamp convertStringToTimeStamp(String timeStamp) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(timeStamp);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            return timestamp;
        } catch (Exception e) {
            return null;
        }
    }
}
