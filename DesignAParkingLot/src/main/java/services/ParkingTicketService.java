package services;

import common.FileUtils;
import common.JavaUtils;
import model.ParkingTicket;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ParkingTicketService {
    private final String PATH = "./data/tickets.txt";
//    private static FileUtils fileUtils = FileUtils.getInstance();
    public List<ParkingTicket> listTicketData;

//    public void addNewTicket(ParkingTicket ticket) {
//        List<ParkingTicket> tickets = getAllTickets();
//        tickets.add(ticket);
//        List<String> rawData = convertParkingTicketsToRawData(tickets);
//        fileUtils.writeData(PATH, rawData);
//    }

//    private List<String> convertParkingTicketsToRawData(List<ParkingTicket> tickets) {
//        List<String> rawData = new ArrayList<>();
//        for (ParkingTicket ticket : tickets) {
//            rawData.add(ticket.toData());
//        }
//        return rawData;
//    }
    public void addParkingTicket(){
        while(true){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap so phieu: ");
                int ticketNumber = sc.nextInt();
                System.out.println("Nhap so xe: ");
                String numberPlate = sc.next();
                System.out.println("Nhap mau xe: ");
                String carColor= sc.next();
                System.out.println("Nhap hang xe: ");
                String carType= sc.next();
                Timestamp inTime = new Timestamp(System.currentTimeMillis());
                ArrayList<String> dataWrite = new ArrayList<String>();
                String data = ticketNumber + "," + numberPlate + "," + carColor + "," + carType + "," + inTime + ",,0,1,90";
                dataWrite.add(data);
                FileUtils.writeData(PATH, dataWrite);
                System.out.println("Nhap thong tin thanh cong!");
                System.out.println("Nhan Y de tiep tuc nhap, nhan N de thoat!");
                char opt = sc.next().charAt(0);
                switch (opt){
                    case 'Y':
                        break;
                    default:
                            return;
                }

            }catch (Exception e)
            {
                System.out.println("Nhap sai vui long nhap lai!");
            }
        }
    }

    // Lay tat ca thong tin gui xe
    public List<ParkingTicket> getAllInfoParkingTicket() {
        List<String> ticketData = FileUtils.readData(PATH);
        listTicketData = new ArrayList<>();
        for (String item : ticketData) {
            String[] line = item.split(",");
            int ticketNumber = Integer.parseInt(line[0]);
            String numberPlate = line[1];
            String carColor= line[2];
            String carType= line[3];
            Timestamp inTime= JavaUtils.convertStringToTimeStamp(line[4]);
            Timestamp outTime= JavaUtils.convertStringToTimeStamp(line[5]);
            double payment= Double.parseDouble(line[6]);
            int status= Integer.parseInt(line[7]);
            int numberSpot= Integer.parseInt(line[8]);
            ParkingTicket ticket = new ParkingTicket(ticketNumber, numberPlate, carColor, carType,inTime,outTime,payment,status,numberSpot);
            listTicketData.add(ticket);
        }
        return listTicketData;
    }


    //Hien thi tat ca thong gui xe
    public void showAllInfoParkingTicket()
    {
        for (ParkingTicket ticket : listTicketData) {
            System.out.println("So phieu: " + ticket.getTicketNumber());
            System.out.println("So xe: " + ticket.getNumberPlate());
            System.out.println("Mau xe: " + ticket.getCarColor());
            System.out.println("Hang xe: " + ticket.getCarType());
            System.out.println("Gio vao: " + ticket.getInTime());
            System.out.println("Gio ra: " + ticket.getOutTime());
            System.out.println("Thanh tien: " + ticket.getPayment());
            System.out.println("Trang thai: " + ticket.getStatus());
            System.out.println("Vi tri do xe: " + ticket.getNumberSpot());
            System.out.println("--------------------------------------");
        }
    }



}
