package view;

import services.ParkingTicketService;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        ParkingTicketService service = new ParkingTicketService();
        while (true){
            Scanner sc = new Scanner(System.in);
            int opt;
            try {
                System.out.println("----------MENU----------");
                System.out.println("Nhap 1: De nhap thong tin gui xe");
                System.out.println("Nhap 2: De tra xe");
                System.out.println("Nhap 3: De kiem tra thong tin gui xe");
                System.out.println("Nhap 4: Liet ke cac cho de xe con trong");
                System.out.println("Nhap 5: Hien thi tat ca thong tin xe da gui");
                System.out.println("Nhap 0: De thoat");
                opt = sc.nextInt();

                switch (opt){
                    case 1:
                        //nhap thong tin gui xe"
                        service.addParkingTicket();
                        break;
                    case 2:
                        //tra xe
                        break;
                    case 3:
                        //kiem tra thong tin gui xe
                        break;
                    case 4:
                        //Liet ke cac cho de xe con trong
                        break;
                    case 5:
                        //Hien thi tat ca thong tin xe da gui

                        service.getAllInfoParkingTicket();
                        service.showAllInfoParkingTicket();
                        break;
                    case 0:
                        //thoat
                        return;
                }
            }catch ( Exception e) {
                System.out.println("Vui long nhap lai");
            }
        }
    }
}
