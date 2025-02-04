package service;

import model.Bus;
import model.Customer;
import model.Reservation;

import java.util.List;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class ReservationService {
    public void seatReservation(Scanner scanner, List<Customer> customerList, List<Bus> busList) {
        try {
            System.out.println("********** Seat Reservation **********\n");

            System.out.println("Available Buses:");
            for (int i = 0; i < busList.size(); i++) {
                Bus bus = busList.get(i);
                System.out.println((i + 1) + ") Bus Number: " + bus.getBusNumber() +
                        ", Starting Point: " + bus.getStartingPoint() +
                        ", Ending Point: " + bus.getEndingPoint());
            }

            System.out.print("\nSelect a bus (Enter the corresponding number): ");
            int busIndex = scanner.nextInt() - 1;
            scanner.nextLine();

            if (busIndex < 0 || busIndex >= busList.size()) {
                System.out.println("Invalid bus selection.");
                return;
            }

            Bus selectedBus = busList.get(busIndex);

            System.out.println("\nAvailable Seats for Bus " + selectedBus.getBusNumber() + ":");
            for (int i = 1; i <= selectedBus.getTotalSeatCapacity(); i++) {
                System.out.print(i + " ");
                if (i % 10 == 0) {
                    System.out.println();
                }
            }

            System.out.print("\nSelect a seat number for reservation: ");
            int seatNumber = scanner.nextInt();
            scanner.nextLine();

            if (seatNumber < 1 || seatNumber > selectedBus.getTotalSeatCapacity()) {
                System.out.println("Invalid seat number.");
                return;
            }

            boolean isSeatAvailable = true;
            for (Reservation reservation : selectedBus.getReservations()) {
                if (reservation.getSeatNumber() == seatNumber) {
                    isSeatAvailable = false;
                    break;
                }
            }

            if (!isSeatAvailable) {
                System.out.println("Seat " + seatNumber + " is already reserved.");
                return;
            }

            System.out.print("Enter Customer Name: ");
            String name = scanner.nextLine();
            int mobileNumber = getMobileNumberInput(scanner, "Enter Mobile Number (10 digits): ");
            
            // Check for duplicate mobile number
            for (Customer customer : customerList) {
                if (customer.getMobileNumber() == mobileNumber) {
                    System.out.println("This mobile number already exists. Please enter a different mobile number.");
                    return;
                }
            }

            String email = getEmailInput(scanner, "Enter Email ID: ");
            
            // Check for duplicate email
            for (Customer customer : customerList) {
                if (customer.getEmail().equalsIgnoreCase(email)) {
                    System.out.println("This email already exists. Please enter a different email.");
                    return;
                }
            }

            System.out.print("Enter City: ");
            String city = scanner.nextLine();
            int age = getIntInput(scanner, "Enter Age: ");

            Customer customer = new Customer(name, mobileNumber, email, city, age);
            customerList.add(customer);

            Reservation reservation = new Reservation(customer, seatNumber);
            selectedBus.addReservation(reservation);

            System.out.println("Seat " + seatNumber + " reserved successfully for " + customer.getName());
        } catch (Exception e) {
            System.out.println("An error occurred during seat reservation: " + e.getMessage());
        }
    }

    public void seatCancellation(Scanner scanner, List<Customer> customerList, List<Bus> busList) {
        try {
            System.out.println("********** Seat Cancellation **********\n");

            System.out.print("Enter Customer Name: ");
            String name = scanner.nextLine();

            Customer customer = null;
            for (Customer c : customerList) {
                if (c.getName().equalsIgnoreCase(name)) {
                    customer = c;
                    break;
                }
            }

            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }

            System.out.println("Reservations for " + customer.getName() + ":");
            for (Bus bus : busList) {
                for (Reservation reservation : bus.getReservations()) {
                    if (reservation.getCustomer().equals(customer)) {
                        System.out.println("Bus Number: " + bus.getBusNumber() +
                                ", Seat Number: " + reservation.getSeatNumber());
                    }
                }
            }

            System.out.print("\nEnter Bus Number: ");
            int busNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Seat Number: ");
            int seatNumber = scanner.nextInt();
            scanner.nextLine();

            Bus bus = null;
            for (Bus b : busList) {
                if (b.getBusNumber() == busNumber) {
                    bus = b;
                    break;
                }
            }

            if (bus == null) {
                System.out.println("Bus not found.");
                return;
            }

            boolean isSeatReserved = false;
            for (Reservation reservation : bus.getReservations()) {
                if (reservation.getCustomer().equals(customer) && reservation.getSeatNumber() == seatNumber) {
                    bus.getReservations().remove(reservation);
                    isSeatReserved = true;
                    break;
                }
            }

            if (!isSeatReserved) {
                System.out.println("Seat " + seatNumber + " is not reserved for " + customer.getName() + ".");
            } else {
                System.out.println("Seat " + seatNumber + " canceled successfully for " + customer.getName() + ".");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during seat cancellation: " + e.getMessage());
        }
    }

    public void seatRequestQueue(Scanner scanner, List<Customer> customerList, List<Bus> busList) {
        try {
            System.out.println("********** Seat Request Queue **********\n");

            System.out.print("Enter Bus Number: ");
            int busNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Seat Number: ");
            int seatNumber = scanner.nextInt();
            scanner.nextLine();

            Bus bus = null;
            for (Bus b : busList) {
                if (b.getBusNumber() == busNumber) {
                    bus = b;
                    break;
                }
            }

            if (bus == null) {
                System.out.println("Bus not found.");
                return;
            }

            boolean isSeatReserved = false;
            for (Reservation reservation : bus.getReservations()) {
                if (reservation.getSeatNumber() == seatNumber) {
                    isSeatReserved = true;
                    break;
                }
            }

            if (!isSeatReserved) {
                System.out.println("Seat " + seatNumber + " is not reserved.");
                return;
            }

            Queue<Customer> seatRequestQueue = new LinkedList<>();

            System.out.print("Enter Customer Name: ");
            String name = scanner.nextLine();

            Customer customer = null;
            for (Customer c : customerList) {
                if (c.getName().equalsIgnoreCase(name)) {
                    customer = c;
                    break;
                }
            }

            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }

            seatRequestQueue.add(customer);

            System.out.println("\n********** Seat Request Queue for Seat " + seatNumber + " **********");
            for (Customer c : seatRequestQueue) {
                System.out.println("Customer: " + c.getName());
            }
        } catch (Exception e) {
            System.out.println("An error occurred during seat request queue: " + e.getMessage());
        }
    }

    private int getIntInput(Scanner scanner, String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // consume invalid input
            }
        }
        return input;
    }

    private int getMobileNumberInput(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.matches("\\d{10}")) {
                break;
            } else {
                System.out.println("Invalid input. Mobile number must be 10 digits.");
            }
        }
        return Integer.parseInt(input);
    }

    private String getEmailInput(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.contains("@")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid email address containing '@'.");
            }
        }
        return input;
    }
}