package service;

import model.Bus;
import model.Reservation;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class BusService {
    public void registerBus(Scanner scanner, List<Bus> busList) {
        try {
            System.out.println("********** Bus Registration **********\n");
            
            int busNumber;
            while (true) {
                busNumber = getIntInput(scanner, "Enter Bus Number: ");
                boolean isDuplicate = false;
                for (Bus bus : busList) {
                    if (bus.getBusNumber() == busNumber) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (isDuplicate) {
                    System.out.println("This bus number already exists. Please enter a different bus number.");
                } else {
                    break;
                }
            }

            int totalSeatCapacity = getIntInput(scanner, "Enter Total Seat Capacity: ");
            System.out.print("Enter Starting Point: ");
            String startingPoint = scanner.nextLine();
            System.out.print("Enter Ending Point: ");
            String endingPoint = scanner.nextLine();
            System.out.print("Enter Starting Time: ");
            String startingTime = scanner.nextLine();
            double fare = getDoubleInput(scanner, "Enter Fare: ");
            System.out.print("Enter Driver Name: ");
            String driverName = scanner.nextLine();

            Bus bus = new Bus(busNumber, totalSeatCapacity, startingPoint, endingPoint, startingTime, fare, driverName);
            busList.add(bus);

            System.out.println("\n********** Bus Details **********");
            System.out.println("Bus Number: " + bus.getBusNumber());
            System.out.println("Total Seat Capacity: " + bus.getTotalSeatCapacity());
            System.out.println("Starting Point: " + bus.getStartingPoint());
            System.out.println("Ending Point: " + bus.getEndingPoint());
            System.out.println("Starting Time: " + bus.getStartingTime());
            System.out.println("Fare: " + bus.getFare());
            System.out.println("Driver Name: " + bus.getDriverName());
        } catch (Exception e) {
            System.out.println("An error occurred during bus registration: " + e.getMessage());
        }
    }

    public void searchBus(Scanner scanner, List<Bus> busList) {
        try {
            System.out.println("********** Bus Search **********\n");
            System.out.print("Enter Starting Point: ");
            String startingPoint = scanner.nextLine();
            System.out.print("Enter Ending Point: ");
            String endingPoint = scanner.nextLine();

            List<Bus> availableBuses = new ArrayList<>();
            for (Bus bus : busList) {
                if (bus.getStartingPoint().equalsIgnoreCase(startingPoint) &&
                    bus.getEndingPoint().equalsIgnoreCase(endingPoint)) {
                    availableBuses.add(bus);
                }
            }

            System.out.println("\n********** Available Buses **********");
            if (availableBuses.isEmpty()) {
                System.out.println("No buses available for the specified route.");
            } else {
                for (Bus bus : availableBuses) {
                    System.out.println("Bus Number: " + bus.getBusNumber());
                    System.out.println("Total Seat Capacity: " + bus.getTotalSeatCapacity());
                    System.out.println("Starting Time: " + bus.getStartingTime());
                    System.out.println("Fare: " + bus.getFare());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred during bus search: " + e.getMessage());
        }
    }

    public void displayReservations(List<Bus> busList) {
        try {
            System.out.println("********** Display of Reservations **********\n");

            for (Bus bus : busList) {
                System.out.println("Bus Number: " + bus.getBusNumber());
                System.out.println("Starting Point: " + bus.getStartingPoint());
                System.out.println("Ending Point: " + bus.getEndingPoint());
                System.out.println("Starting Time: " + bus.getStartingTime());
                System.out.println("Fare: " + bus.getFare());

                List<Reservation> reservations = bus.getReservations();
                if (reservations.isEmpty()) {
                    System.out.println("No reservations for this bus.");
                } else {
                    System.out.println("Reservations:");
                    for (Reservation reservation : reservations) {
                        System.out.println("    Seat Number: " + reservation.getSeatNumber() +
                                ", Customer Name: " + reservation.getCustomer().getName());
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("An error occurred while displaying reservations: " + e.getMessage());
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

    private double getDoubleInput(Scanner scanner, String prompt) {
        double input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a decimal number.");
                scanner.next(); // consume invalid input
            }
        }
        return input;
    }
}