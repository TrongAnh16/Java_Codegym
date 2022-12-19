package model;

import java.util.Date;
import java.util.Objects;

public class ThiSinh {
    private int maThiSinh;
    private String tenThiSinh;
    private Tinh queQuan;
    private Date ngaySinh;
    private boolean gioiTinh;
    private float diemMon1, diemMon2, diemMon3;

    public ThiSinh() {
    }


    public ThiSinh(int maThiSinh, String tenThiSinh, Tinh queQuan,
                   Date ngaySinh, boolean gioiTinh, float diemMon1,
                   float diemMon2, float diemMon3) {
        this.maThiSinh = maThiSinh;
        this.tenThiSinh = tenThiSinh;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diemMon1 = diemMon1;
        this.diemMon2 = diemMon2;
        this.diemMon3 = diemMon3;
    }

    public int getMaThiSinh() {
        return maThiSinh;
    }

    public void setMaThiSinh(int maThiSinh) {
        this.maThiSinh = maThiSinh;
    }

    public String getTenThiSinh() {
        return tenThiSinh;
    }

    public void setTenThiSinh(String tenThiSinh) {
        this.tenThiSinh = tenThiSinh;
    }

    public Tinh getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(Tinh queQuan) {
        this.queQuan = queQuan;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public float getDiemMon1() {
        return diemMon1;
    }

    public void setDiemMon1(float diemMon1) {
        this.diemMon1 = diemMon1;
    }

    public float getDiemMon2() {
        return diemMon2;
    }

    public void setDiemMon2(float diemMon2) {
        this.diemMon2 = diemMon2;
    }

    public float getDiemMon3() {
        return diemMon3;
    }

    public void setDiemMon3(float diemMon3) {
        this.diemMon3 = diemMon3;
    }

    @Override
    public String toString() {
        return "ThiSinh{" +
                "maThiSinh=" + maThiSinh +
                ", tenThiSinh='" + tenThiSinh + '\'' +
                ", queQuan=" + queQuan +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh=" + gioiTinh +
                ", diemMon1=" + diemMon1 +
                ", diemMon2=" + diemMon2 +
                ", diemMon3=" + diemMon3 +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ThiSinh thiSinh = (ThiSinh) obj;
        return maThiSinh == thiSinh.maThiSinh && gioiTinh
                == thiSinh.gioiTinh
                && Float.compare(thiSinh.diemMon1, diemMon1) == 0
                && Float.compare(thiSinh.diemMon2, diemMon2) == 0
                && Float.compare(thiSinh.diemMon3, diemMon3) == 0
                && tenThiSinh.equals(thiSinh.tenThiSinh)
                && queQuan.equals(thiSinh.queQuan)
                && ngaySinh.equals(thiSinh.ngaySinh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maThiSinh, tenThiSinh, queQuan, ngaySinh,
                gioiTinh, diemMon1, diemMon2, diemMon3);
    }
}
