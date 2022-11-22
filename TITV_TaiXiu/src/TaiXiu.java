import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TaiXiu {
    public static void main(String[] args) {
        double taiKhoanNguoiChoi = 5000000.99;
        Scanner sc = new Scanner(System.in);

        Locale lc = new Locale("en", "US");
        NumberFormat numf = NumberFormat.getCurrencyInstance(lc);

        int luaChon = 0;
        do {
            System.out.println("--------------Moi ban lua chon--------------");
            System.out.println("Chon (1) de tiep tuc choi");
            System.out.println("Chon phim bat ky de thoat");
            luaChon = sc.nextInt();
            if (luaChon == 1){
                System.out.println("***Bat dau choi: ");
                System.out.println("*****Tai khoan cua ban: "+taiKhoanNguoiChoi+", ban muon cuoc bao nhieu?");
                double datCuoc = 0;
                do {
                    System.out.println("*****Dat cuoc (0<so tien cuoc <="+taiKhoanNguoiChoi+":");
                    datCuoc = sc.nextDouble();
                }while (datCuoc <= 0 || datCuoc>taiKhoanNguoiChoi);

                int luaChonTaiXiu = 0;
                do {
                    System.out.println("*****Chon 1 <-> Tai hoac 2 <-> Xiu");
                    luaChonTaiXiu = sc.nextInt();
                }while (luaChonTaiXiu != 1 && luaChonTaiXiu != 2);

                Random xucXac1 = new Random();
                Random xucXac2 = new Random();
                Random xucXac3 = new Random();

                int giaTri1 = xucXac1.nextInt(5) + 1;
                int giaTri2 = xucXac2.nextInt(5) + 1;
                int giaTri3 = xucXac3.nextInt(5) + 1;
                int tong = giaTri1 + giaTri2 + giaTri3;
            }
        }while (luaChon != 1);
    }
}
