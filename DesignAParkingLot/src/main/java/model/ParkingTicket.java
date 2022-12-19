package model;

import java.sql.Timestamp;
import java.util.Date;

public class ParkingTicket {
    private long ticketNumber;
    private String numberPlate;
    private String carColor;
    private String carType;
    private String inTime;
    private String inDate;
    private String outTime;
    private String outDate;
    private double payment;
    private int numberSpot;

    public ParkingTicket() {
    }

    public ParkingTicket(String numberPlate, String carColor, String carType, String inTime, String inDate, String outTime, String outDate,int numberSpot, double payment) {
        this.ticketNumber = System.currentTimeMillis()/1000;
        this.numberPlate = numberPlate;
        this.carColor = carColor;
        this.carType = carType;
        this.inTime = inTime;
        this.inDate = inDate;
        this.outTime = outTime;
        this.outDate = outDate;
        this.payment = payment;
        this.numberSpot = numberSpot;
    }

    public long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }


    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getNumberSpot() {
        return numberSpot;
    }

    public void setNumberSpot(int numberSpot) {
        this.numberSpot = numberSpot;
    }
}
