package model;

public class Reservation {
    private Customer customer;
    private int seatNumber;

    public Reservation(Customer customer, int seatNumber) {
        this.customer = customer;
        this.seatNumber = seatNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}