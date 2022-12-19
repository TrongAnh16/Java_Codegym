package view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomInfo {
    Random random = new Random();

    String[] dist = {"75", "43", "29", "37", "74", "51", "96", "92"};
    String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "K"};
    String[] color = {"Red", "Yellow", "Green", "White", "Brown", "Violet", "Pink", "Blue"};
    String[] type = {"Mercedes", "Vinfast", "Porche", "Lamborghini", "Ferrari", "Toyota","Huyndai","Kia"};

    public String NumberPlate() {
        int di = random.nextInt(dist.length);
        int al = random.nextInt(alpha.length);

        return dist[di] +"-"+ alpha[al] +"-"+ random.nextInt((999 - 100)+1) + 10;
    }

    public String CarColor() {
        int res = random.nextInt(color.length);
        return color[res];
    }

    public String CarType() {
        int typ = random.nextInt(type.length);
        return type[typ];
    }

    public String Time() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String inTime = localTime.format(dateTimeFormatter);
        return inTime;
    }

    public String ExitTime() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String outTime = localTime.format(dateTimeFormatter);
        return outTime;
    }

    public String Date() {
        LocalDate inDate = LocalDate.now();
        return inDate.toString();
    }

    public String ExitDate() {
        LocalDate outDate = LocalDate.now();
        return  outDate.toString();
    }

    public long CardNumber() {
        return ((random.nextLong()% 100000000000000L) + 5200000000000000L);
    }
}
