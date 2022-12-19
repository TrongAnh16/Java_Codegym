package view;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import services.ParkingSpot;
import services.ParkingTicketService;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        ParkingTicketService service = new ParkingTicketService();
        ParkingTicketView parkingTicketView = new ParkingTicketView();
        ParkingSpot parkingSpot = new ParkingSpot();
        while (true){
            Scanner sc = new Scanner(System.in);
            String opt;
            try {
                AsciiTable menu = new AsciiTable();
                menu.addRule();
                menu.addRow("----------MENU----------").getCells().get(0).getContext().setTextAlignment(TextAlignment.CENTER);

                menu.addRule();
                menu.addRow("Nhập 1: Để nhập thông tin xe");
                menu.addRule();
                menu.addRow("Nhập 2: Để trả xe");
                menu.addRule();
                menu.addRow("Nhập 3: Để kiểm tra thông tin gửi xe");
                menu.addRule();
                menu.addRow("Nhập 4: Liệt kê các chỗ đã để xe");
                menu.addRule();
                menu.addRow("Nhập 5: Hiển thị tất cả thông tin xe trong bãi");
                menu.addRule();
                menu.addRow("Nhập 0: Để thoát");
                menu.addRule();
                System.out.println(menu.render(50));
                System.out.print("Chọn chức năng: ");
                opt = sc.nextLine();

                switch (opt){
                    case "1":
                        //Nhập thông tin gửi xe
                        parkingTicketView.addParkingTicketView();
                        break;
                    case "2":
                        //Trả xe
                        service.parkingHistory();
                        break;
                    case "3":
                        //Kiểm tra thông tin gửi xe
                        parkingTicketView.searchInfoPackingTicketView();
                        break;
                    case "4":
                        //Liệt kê các chỗ đã để xe
                        parkingSpot.checkParkingSpotNum();
                        ArrayList<String> dataWrite = new ArrayList<>();
                        int spotNum = ParkingTicketService.checkIfSpotAvailable(parkingSpot);
                        if (spotNum == -1) break;
                        break;
                    case "5":
                        //Hiển thị tất cả thông tin xe đang gửi
                        service.getAllInfoParkingTicket();
                        parkingTicketView.showListParkingTicket(service.getAllInfoParkingTicket());
                        break;
                    case "0":
                        //Thoát
                        return;
                }
            }catch ( Exception e) {
                System.out.println("Vui long nhap lai");
                e.printStackTrace();
            }
        }
    }
}
