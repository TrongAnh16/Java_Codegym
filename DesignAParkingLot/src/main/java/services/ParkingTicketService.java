package services;

import common.FileUtils;
import de.vandermeer.asciitable.AsciiTable;
import model.ParkingTicket;
import model.Payment;
import view.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingTicketService {
    public String PATH = "./data/tickets.txt";
    private final String PATH2 = "./data/parkingHistory.txt";
    public RandomInfo randominfo = new RandomInfo();
    ParkingTicketView parkingTicketView;

    //Thêm thông tin xe vào bãi đậu xe
    public void addParkingTicket() {
        List<ParkingTicket> parkingTickets = new ArrayList<>();
        parkingTicketView.addParkingTicketView();
    }

    // Lấy tất cả thông tin gửi xe
    public List<ParkingTicket> getAllInfoParkingTicket() {
        List<String> ticketData = FileUtils.readData(PATH);
        if (ticketData.isEmpty()) return new ArrayList<>();
        TotalTime totalTime = new TotalTime();
        Payment payment = new Payment();
        if (ticketData.get(0).equals("")) return new ArrayList<>();
        List<ParkingTicket> listTicketData = new ArrayList<>();
        for (String item : ticketData) {
            String[] line = item.split(",");
            String numberPlate = line[1];
            String carColor = line[2];
            String carType = line[3];
            String inTime = line[4];
            String inDate = line[5];
            String outTime = randominfo.ExitTime();
            String outDate = randominfo.ExitDate();
            int numberSpot = Integer.parseInt(line[8]);
            int time[] = totalTime.CalculateTime(inDate, outDate, inTime, outTime);
            double amount = payment.TotalAmount(time[0], time[1]);
            ParkingTicket ticket = new ParkingTicket(numberPlate, carColor, carType, inTime, inDate, outTime, outDate, numberSpot, amount);
            ticket.setTicketNumber(Long.parseLong(line[0]));
            listTicketData.add(ticket);
        }
        return listTicketData;
    }

    //Hiển thị tất cả thông tin gửi xe
    public void showAllInfoParkingTicket() {
        List<ParkingTicket> listTicketData = getAllInfoParkingTicket();
        parkingTicketView.showListParkingTicket(listTicketData);
    }

    public void searchInfoPackingTicket() {
        parkingTicketView.searchInfoPackingTicketView();
    }

    //Trả xe
    public void parkingHistory() {
        parkingTicketView = new ParkingTicketView();
        ParkingSpot parkingSpot = new ParkingSpot();
        ScanTicket scanTicket = new ScanTicket();
        TotalTime totalTime = new TotalTime();
        Payment payment = new Payment();
        boolean checkSpot = parkingSpot.emptySpot();
        if (checkSpot) {
            System.out.println("Chưa có xe nào trong bãi đậu xe.");
        } else {
            List<ParkingTicket> listTicketData = getAllInfoParkingTicket();
            System.out.print("Nhập số xe bạn muốn thanh toán: ");
            Scanner sc = new Scanner(System.in);
            String numberPay = sc.nextLine();

            for (ParkingTicket tk : listTicketData) {
                String carnumber = tk.getNumberPlate();
                int item = scanTicket.checknumber(numberPay, carnumber);
                if (item == 0) {
                    continue;
                } else if (item == 1) {
                    int spot = listTicketData.indexOf(tk);
                    String outDate = randominfo.ExitDate();
                    String outTime = randominfo.ExitTime();
                    String inTime = listTicketData.get(spot).getInTime();
                    String inDate = listTicketData.get(spot).getInDate();
                    int time[] = totalTime.CalculateTime(inDate, outDate, inTime, outTime);
                    float amount = payment.TotalAmount(time[0], time[1]);
                    List<ParkingTicket> parkingTicketList = new ArrayList<>();
                    parkingTicketList.add(tk);
                    parkingTicketView.showListParkingTicket(parkingTicketList);
                    System.out.println("Bạn có muốn thanh toán hóa đơn không?");
                    System.out.println("Nhập 1 để thanh toán. Nhập bất kỳ để thoát. ");
                    String select = sc.nextLine();
                    switch (select) {
                        case "1":
                            ArrayList<String> dataWrite1 = new ArrayList<>();
                            List<String> parkingTickets = FileUtils.readData(PATH);
                            for (int i = 0; i < parkingTickets.size(); i++) {
                                String[] items = parkingTickets.get(i).split(",");
                                if (items[1].equals(numberPay)) parkingTickets.remove(i);
                            }
                            String data1 = listTicketData.get(spot).getTicketNumber() + "," +
                                    listTicketData.get(spot).getNumberPlate() + "," +
                                    listTicketData.get(spot).getCarColor() + "," +
                                    listTicketData.get(spot).getCarType() + "," +
                                    inTime + "," + inDate + "," + outTime + "," + outDate + "," + listTicketData.get(spot).getNumberSpot() + "," +
                                    amount + " VND";
                            dataWrite1.remove(data1);
                            FileUtils.writeData(PATH, parkingTickets, false);
                            dataWrite1.add(data1);
                            FileUtils.writeData(PATH2, dataWrite1, true);
                            System.out.println("Bạn đã thanh toán thành công!");
                            break;
                        case "0":
                            return;
                    }
                }
            }
        }
    }

    public static int checkIfSpotAvailable(ParkingSpot parkingspot) {
        int spotnum = parkingspot.SpotNum();
        if (spotnum == -1) {
            System.out.println("Rất tiếc, bãi đậu xe đã hết chỗ trống");
        }
        return spotnum;
    }
}

