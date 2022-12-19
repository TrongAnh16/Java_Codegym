package services;

import model.ParkingTicket;
import services.ParkingTicketService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingSpot {
    private ParkingTicketService parkingTicketService;
    private List<ParkingTicket> tickets;

    public ParkingSpot() {
        parkingTicketService = new ParkingTicketService();
        tickets = parkingTicketService.getAllInfoParkingTicket();
    }

    public final int MAX_PARKING_SPOT = 10;
    private int[] spots = new int[MAX_PARKING_SPOT];

    public int SpotNum() {
        for (int i = 0; i < tickets.size(); i++) {
            spots[tickets.get(i).getNumberSpot() - 1] = tickets.get(i).getNumberSpot();
        }
        int count = 0;
        while (spots[count] != 0) {
            count++;
            if (count == MAX_PARKING_SPOT) return -1;
        }
        return count + 1;
    }

    public void checkParkingSpotNum(){
        tickets = parkingTicketService.getAllInfoParkingTicket();
        List<Integer> parkingSpotNum = new ArrayList<>();
        System.out.println("Bãi xe có "+ MAX_PARKING_SPOT +" chỗ để xe.");
        System.out.print("Các vị trí đã có xe đang đỗ : ");
        for(int i = 0; i < tickets.size(); i++){
            parkingSpotNum.add(tickets.get(i).getNumberSpot());
            }
        Collections.sort(parkingSpotNum);
        for (Integer element : parkingSpotNum) {
            System.out.print(element+"  ");
        }
        System.out.println();
    }

    public boolean emptySpot() {
        return tickets.isEmpty();
    }
}
