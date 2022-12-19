package services;

public class ScanTicket {
    public int checknumber(String inputnumber, String storenumber) {
            if (inputnumber.equals(storenumber)) {
            return 1;
        }
        return 0;
    }
}
