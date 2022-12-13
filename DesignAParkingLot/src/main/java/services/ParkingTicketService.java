package services;

import common.FileUtils;
import common.JavaUtils;
import de.vandermeer.asciitable.AsciiTable;
import model.ParkingTicket;
import model.Payment;
import view.ParkingSpot;
import view.RandomInfo;
import view.ScanTicket;
import view.TotalTime;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ParkingTicketService {
    private final String PATH = "./data/tickets.txt";
    private final String PATH2 = "./data/parkingHistory.txt";
    //    private static FileUtils fileUtils = FileUtils.getInstance();
//    public List<ParkingTicket> listTicketData;
    public RandomInfo randominfo = new RandomInfo();

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


    //them thong tin xe vao bai dau xe
    public void addParkingTicket() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap so phieu: ");
                int ticketNumber = sc.nextInt();
                System.out.println("Nhap so xe: ");
                String numberPlate = sc.next();
                System.out.println("Nhap mau xe: ");
                String carColor = sc.next();
                System.out.println("Nhap hang xe: ");
                String carType = sc.next();
                String inTime = randominfo.Time();
                String inDate = randominfo.Date();
//                Timestamp inTime = new Timestamp(System.currentTimeMillis());
                ArrayList<String> dataWrite = new ArrayList<String>();
                String data = ticketNumber + "," + numberPlate + "," + carColor + "," + carType + "," + inTime + "," + inDate + "," + 01 + "," + 02 + "," + 03 + "," + 04 + "," + 05;
                System.out.println("Nhap thong tin thanh cong!");
                AsciiTable table = new AsciiTable();
                table.addRule();
                table.addRow("So phieu", "So xe", "Mau xe", "Hang xe", "Gio vao", "Ngay vao", "Gio ra", "Ngay ra", "Vi tri do", "Thanh tien", "Trang thai");
                table.addRule();
                table.addRow(ticketNumber, numberPlate, carColor, carType, inTime, inDate, "- ", " -", 03, 04, 05);
                table.addRule();
                System.out.println(table.render(150));
                dataWrite.add(data);
                FileUtils.writeData(PATH, dataWrite, true);
                System.out.println("Nhan Y de tiep tuc nhap, nhan N de thoat!");
                char opt = sc.next().charAt(0);
                switch (opt) {
                    case 'Y':
                        break;
                    default:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Nhap sai vui long nhap lai!");
            }
        }
    }

    // Lay tat ca thong tin gui xe
    public List<ParkingTicket> getAllInfoParkingTicket() {
        List<String> ticketData = FileUtils.readData(PATH);
        if (ticketData.get(0).equals("")) return new ArrayList<>();
        List<ParkingTicket> listTicketData = new ArrayList<>();
        for (String item : ticketData) {
            String[] line = item.split(",");
            int ticketNumber = Integer.parseInt(line[0]);
            String numberPlate = line[1];
            String carColor = line[2];
            String carType = line[3];
            String inTime = line[4];
            String inDate = line[5];
            String outTime = line[6];
            String outDate = line[7];
            double payment = Double.parseDouble(line[8]);
            int status = Integer.parseInt(line[9]);
            int numberSpot = Integer.parseInt(line[10]);
            ParkingTicket ticket = new ParkingTicket(ticketNumber, numberPlate, carColor, carType, inTime, inDate, outTime, outDate, payment, status, numberSpot);
            listTicketData.add(ticket);
        }
        return listTicketData;
    }

    //Hien thi tat ca thong tin gui xe
    public void showAllInfoParkingTicket() {
        List<ParkingTicket> listTicketData = getAllInfoParkingTicket();
        AsciiTable tableAll = new AsciiTable();
        tableAll.addRule();
        tableAll.addRow("So phieu", "So xe", "Mau xe", "Hang xe", "Gio vao", "Ngay vao", "Gio ra", "Ngay ra", "Vi tri do xe", "Thanh tien", "Trang thai");
        tableAll.addRule();
        for (ParkingTicket parkingTicket : listTicketData) {
            tableAll.addRow(parkingTicket.getTicketNumber(),
                    parkingTicket.getNumberPlate(),
                    parkingTicket.getCarColor(),
                    parkingTicket.getCarType(),
                    parkingTicket.getInTime(),
                    parkingTicket.getInDate(),
                    parkingTicket.getOutTime(),
                    parkingTicket.getOutDate(),
                    parkingTicket.getNumberSpot(),
                    parkingTicket.getPayment(),
                    parkingTicket.getStatus()
            );
            tableAll.addRule();
        }
        System.out.println(tableAll.render(150));
    }

    public void searchInfoPackingTicket() {
        ParkingSpot parkingSpot = new ParkingSpot();
        ScanTicket scanTicket = new ScanTicket();
        TotalTime totalTime = new TotalTime();
        Payment payment = new Payment();
        boolean checkSpot = parkingSpot.emptySpot();
        if (checkSpot) {
            System.out.println("Chua co xe nao trong bai dau xe");
        } else {
            List<ParkingTicket> listTicketData = getAllInfoParkingTicket();
            System.out.print("Nhap so xe ban muon tim: ");
            Scanner sc = new Scanner(System.in);
            String number = sc.nextLine();

            for (ParkingTicket tk : listTicketData) {
                String carnumber = tk.getNumberPlate();
                int item = scanTicket.checknumber(number, carnumber);
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
                    AsciiTable tbSearch = new AsciiTable();
                    tbSearch.addRule();
                    tbSearch.addRow("So phieu", "So xe", "Mau xe", "Hang xe", "Gio vao", "Ngay vao", "Gio ra", "Ngay ra", "Vi tri do xe", "Thanh tien", "Trang thai");
                    tbSearch.addRule();
                    tbSearch.addRow(listTicketData.get(spot).getTicketNumber(),
                            listTicketData.get(spot).getNumberPlate(),
                            listTicketData.get(spot).getCarColor(),
                            listTicketData.get(spot).getCarType(),
                            inTime, inDate, outTime, outDate, listTicketData.get(spot).getNumberSpot(),
//                                    time[0] + " h " + time[1] + " min ",
                            amount + " VND",
                            listTicketData.get(spot).getStatus());
                    tbSearch.addRule();
                    System.out.println(tbSearch.render(150));
                }
            }
        }
    }

    public void parkingHistory() {
        ParkingSpot parkingSpot = new ParkingSpot();
        ScanTicket scanTicket = new ScanTicket();
        TotalTime totalTime = new TotalTime();
        Payment payment = new Payment();
        boolean checkSpot = parkingSpot.emptySpot();
        if (checkSpot) {
            System.out.println("Chua co xe nao trong bai dau xe");
        } else {
            List<ParkingTicket> listTicketData = getAllInfoParkingTicket();
            System.out.print("Nhap so xe ban muon thanh toan: ");
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
                    AsciiTable tbSearch = new AsciiTable();
                    tbSearch.addRule();
                    tbSearch.addRow("So phieu", "So xe", "Mau xe", "Hang xe", "Gio vao", "Ngay vao", "Gio ra", "Ngay ra", "Vi tri do xe", "Thanh tien", "Trang thai");
                    tbSearch.addRule();
                    tbSearch.addRow(listTicketData.get(spot).getTicketNumber(),
                            listTicketData.get(spot).getNumberPlate(),
                            listTicketData.get(spot).getCarColor(),
                            listTicketData.get(spot).getCarType(),
                            inTime, inDate, outTime, outDate, listTicketData.get(spot).getNumberSpot(),
//                                    time[0] + " h " + time[1] + " min ",
                            amount + " VND",
                            listTicketData.get(spot).getStatus());
                    tbSearch.addRule();
                    System.out.println(tbSearch.render(150));
                    System.out.println("Ban co muon thanh toan hoa don khong?");
                    System.out.println("Nhap 1 de thanh toan. Nhap bat ky de bo qua");
                    int select = sc.nextInt();
                    switch (select) {
                        case 1:
                            ArrayList<String> dataWrite1 = new ArrayList<String>();
                            List<String> parkingTickets = FileUtils.readData(PATH);
                            for (int i=0;i<parkingTickets.size();i++){
                                String[] items = parkingTickets.get(i).split(",");
                                if (items[1].equals(numberPay)) parkingTickets.remove(i);
                            }
                            String data1 = listTicketData.get(spot).getTicketNumber() + "," +
                            listTicketData.get(spot).getNumberPlate() + "," +
                                    listTicketData.get(spot).getCarColor() + "," +
                                    listTicketData.get(spot).getCarType() + "," +
                                    inTime + "," + inDate + "," + outTime + "," + outDate + "," + listTicketData.get(spot).getNumberSpot() + "," +
                                    amount + " VND" + "," +
                                    listTicketData.get(spot).getStatus();
                            dataWrite1.remove(data1);
                            FileUtils.writeData(PATH,parkingTickets,false);
                            dataWrite1.add(data1);
                            FileUtils.writeData(PATH2, dataWrite1,true);
                            break;
                        case 0:
                            return;
                    }
                }
            }
        }
    }
}

