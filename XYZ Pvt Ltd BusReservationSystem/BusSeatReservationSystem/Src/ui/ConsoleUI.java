package ui;

import model.Bus;
import model.Customer;
import service.BusService;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;
    private List<Customer> customerList;
    private List<Bus> busList;
    private BusService busService;
    private CustomerService customerService;
    private ReservationService reservationService;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        customerList = new ArrayList<>();
        busList = new ArrayList<>();
        busService = new BusService();
        customerService = new CustomerService();
        reservationService = new ReservationService();
    }

    public void displayMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("***************************************************************************");
            System.out.println("                                 Main Dashboard                            ");
            System.out.println("***************************************************************************");
            System.out.println(" ");
            System.out.println("          1) Customer Registration");
            System.out.println("          2) Bus Registration");
            System.out.println("          3) Bus Search Functionality");
            System.out.println("          4) Seat Reservation");
            System.out.println("          5) Seat Cancellation");
            System.out.println("          6) Seat Request Queue");
            System.out.println("          7) Display of Reservations");
            System.out.println("          0) Exit");
            System.out.println(" ");
            System.out.println("***************************************************************************");
            System.out.println("What do you need to do? Enter the corresponding number:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println("Customer Registration");
                    customerService.registerCustomer(scanner, customerList);
                    break;
                case 2:
                    System.out.println("Bus Registration");
                    busService.registerBus(scanner, busList);
                    break;
                case 3:
                    System.out.println("Bus Search Functionality");
                    busService.searchBus(scanner, busList);
                    break;
                case 4:
                    System.out.println("Seat Reservation");
                    reservationService.seatReservation(scanner, customerList, busList);
                    break;
                case 5:
                    System.out.println("Seat Cancellation");
                    reservationService.seatCancellation(scanner, customerList, busList);
                    break;
                case 6:
                    System.out.println("Seat Request Queue");
                    reservationService.seatRequestQueue(scanner, customerList, busList);
                    break;
                case 7:
                    System.out.println("Display of Reservations");
                    busService.displayReservations(busList);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        scanner.close();
    }
}