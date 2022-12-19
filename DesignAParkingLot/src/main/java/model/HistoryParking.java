package model;

import java.sql.Timestamp;
import java.util.Date;

public class HistoryParking {
    private int ticketNumber;
    private String numberPlate;
    private String carColor;
    private String carType;
    private Timestamp inTime;
    private Timestamp outTime;
    private double payment;
    private int numberSpot;



    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public HistoryParking() {
    }

    public HistoryParking(int ticketNumber, String numberPlate, String carColor, String carType, Timestamp inTime, Timestamp outTime, int numberSpot, double payment) {
        this.ticketNumber = ticketNumber;
        this.numberPlate = numberPlate;
        this.carColor = carColor;
        this.carType = carType;
        this.inTime = inTime;
        this.outTime = outTime;
        this.payment = payment;
        this.numberSpot = numberSpot;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
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
