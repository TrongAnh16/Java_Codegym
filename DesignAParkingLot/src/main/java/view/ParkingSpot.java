package view;

import model.ParkingTicket;
import services.ParkingTicketService;

import java.util.List;

public class ParkingSpot {
    private ParkingTicketService parkingTicketService;
    private List<ParkingTicket> tickets;
    public  ParkingSpot(){
        parkingTicketService = new ParkingTicketService();
        tickets = parkingTicketService.getAllInfoParkingTicket();
    }
//    public final int MAX_PARKING_SPOT = 20;
//    private int[] spots = new  int[MAX_PARKING_SPOT];
//    public int SpotNum() {
//        for (int i=0;i<tickets.size();i++) {
//            spots[tickets.get(i).getNumberSpot()-1] = tickets.get(i).getNumberSpot();
//        }
//        int count= 0;
//        while (spots[count]!=0){
//            count++;
//            if (count==MAX_PARKING_SPOT) return -1;
//        }
//        return count+1;
//    }

    public boolean emptySpot() {
       return tickets.isEmpty();
    }
}
