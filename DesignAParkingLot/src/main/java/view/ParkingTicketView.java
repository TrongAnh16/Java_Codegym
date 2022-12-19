package view;

import common.FileUtils;
import de.vandermeer.asciitable.AsciiTable;
import model.ParkingTicket;
import model.Payment;
import services.ParkingSpot;
import services.ParkingTicketService;
import services.ScanTicket;
import services.TotalTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingTicketView {
    public RandomInfo randominfo = new RandomInfo();
    ParkingTicketService parkingTicketService;
    Scanner sc;
    public ParkingTicketView(){
         parkingTicketService = new ParkingTicketService();
         sc = new Scanner(System.in);
    }

    public void addParkingTicketView() {
        while (true) {
            try {
                ParkingSpot parkingSpot = new ParkingSpot();
                TotalTime totalTime = new TotalTime();
                Payment payment = new Payment();
                long ticketNumber = System.currentTimeMillis()/100;
                String numberPlate = randominfo.NumberPlate();
                String carColor = randominfo.CarColor();
                String carType = randominfo.CarType();
                String inTime = randominfo.Time();
                String inDate = randominfo.Date();
                String outTime = randominfo.ExitTime();
                String outDate = randominfo.ExitDate();
                int time[] = totalTime.CalculateTime(inDate, outDate, inTime, outTime);
                double amount = payment.TotalAmount(time[0], time[1]);
                ArrayList<String> dataWrite = new ArrayList<>();
                int spotNum = parkingTicketService.checkIfSpotAvailable(parkingSpot);
                if (spotNum == -1) break;
                String data = ticketNumber + "," + numberPlate + "," + carColor + "," + carType + "," + inTime + "," + inDate + "," + outTime + "," + outDate + "," + spotNum + "," + (time[0] + time[1]) + "," + 0;
                System.out.println("Nhập thông tin thành công!");
                AsciiTable table = new AsciiTable();
                table.addRule();
                table.addRow("Số phiếu", "Số xe", "Màu sắc", "Hãng xe", "Giờ vào", "Ngày vào", "Giờ ra", "Ngày ra", "Vị trí đỗ xe", "Tổng thời gian gửi", "Thành tiền");
                table.addRule();
                table.addRow(ticketNumber, numberPlate, carColor, carType, inTime, inDate, " - ", " - ", spotNum, (time[0] + " h " + time[1] + " min"), "-");
                table.addRule();
                System.out.println(table.render(150));
                dataWrite.add(data);
                FileUtils.writeData(parkingTicketService.PATH, dataWrite, true);
                System.out.println("Nhấn Y để tiếp tục nhập. Nhấn bất kỳ để thoát!");
                char opt = sc.next().charAt(0);
                switch (opt) {
                    case 'Y':
                        break;
                    default:
                        return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Nhập sai. Vui lòng nhập lại!");
            }
        }
    }

    public void showListParkingTicket(List<ParkingTicket> listTicketData) {

        Payment payment = new Payment();
        TotalTime totalTime = new TotalTime();
        AsciiTable tableAll = new AsciiTable();
        tableAll.addRule();
        tableAll.addRow("Số phiếu", "Số xe", "Màu sắc", "Hãng xe", "Giờ vào", "Ngày vào", "Giờ hiện tại", "Ngày hiện tại", "Vị trí đỗ xe","Tổng thời gian gửi", "Thành tiền");
        tableAll.addRule();
        for (ParkingTicket parkingTicket : listTicketData) {
            String outDate = randominfo.ExitDate();
            String outTime = randominfo.ExitTime();
            int [] time = totalTime.CalculateTime(parkingTicket.getInDate(), parkingTicket.getOutDate(),parkingTicket.getInTime(), parkingTicket.getOutTime());
            float amount = payment.TotalAmount(time[0], time[1]);
            tableAll.addRow(parkingTicket.getTicketNumber(),
                    parkingTicket.getNumberPlate(),
                    parkingTicket.getCarColor(),
                    parkingTicket.getCarType(),
                    parkingTicket.getInTime(),
                    parkingTicket.getInDate(),
                    parkingTicket.getOutTime(),
                    parkingTicket.getOutDate(),
                    parkingTicket.getNumberSpot(),
                    (time[0]+ "H "+ time[1]+"min"),
                    parkingTicket.getPayment()
            );
            tableAll.addRule();
        }
        System.out.println(tableAll.render(150));
        sc.nextLine();
    }

    public void searchInfoPackingTicketView() {
        ParkingSpot parkingSpot = new ParkingSpot();
        ScanTicket scanTicket = new ScanTicket();
        TotalTime totalTime = new TotalTime();
        boolean checkSpot = parkingSpot.emptySpot();
        if (checkSpot) {
            System.out.println("Chưa có xe nào trong bãi đậu xe");
        } else {
            List<ParkingTicket> listTicketData = parkingTicketService.getAllInfoParkingTicket();
            System.out.print("Nhập số xe bạn muốn tìm kiếm: ");
            Scanner sc = new Scanner(System.in);
            String number = sc.nextLine();

            for (ParkingTicket tk : listTicketData) {
                String carnumber = tk.getNumberPlate();
                int item = scanTicket.checknumber(number, carnumber);
                if (item == 0) {
                    continue;
                }
                if (item == 1) {
                   List<ParkingTicket> parkingTickets = new ArrayList<>();
                    parkingTickets.add(tk);
                    showListParkingTicket(parkingTickets);
                    break;
                }
            }
        }
    }
}