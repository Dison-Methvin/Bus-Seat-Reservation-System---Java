package model;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    private int busNumber;
    private int totalSeatCapacity;
    private String startingPoint;
    private String endingPoint;
    private String startingTime;
    private double fare;
    private String driverName;
    private List<Reservation> reservations;

    public Bus(int busNumber, int totalSeatCapacity,
     String startingPoint, String endingPoint, String startingTime,
      double fare, String driverName) {
        this.busNumber = busNumber;
        this.totalSeatCapacity = totalSeatCapacity;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.startingTime = startingTime;
        this.fare = fare;
        this.driverName = driverName;
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public int getTotalSeatCapacity() {
        return totalSeatCapacity;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public double getFare() {
        return fare;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public void setTotalSeatCapacity(int totalSeatCapacity) {
        this.totalSeatCapacity = totalSeatCapacity;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        this.endingPoint = endingPoint;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
}