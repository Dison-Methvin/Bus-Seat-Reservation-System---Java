package service;

import model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerService {
    public void registerCustomer(Scanner scanner, List<Customer> customerList) {
        try {
            System.out.println("********** Customer Registration **********\n");
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

            System.out.println("\n********** Customer Details **********");
            System.out.println("Name: " + customer.getName());
            System.out.println("Mobile Number: " + customer.getMobileNumber());
            System.out.println("Email ID: " + customer.getEmail());
            System.out.println("City: " + customer.getCity());
            System.out.println("Age: " + customer.getAge());
        } catch (Exception e) {
            System.out.println("An error occurred during customer registration: " + e.getMessage());
        }
    }

    private int getIntInput(Scanner scanner, String prompt) {
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // consume invalid input
                }
            } catch (Exception e) {
                System.out.println("An error occurred while reading input: " + e.getMessage());
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
            try {
                System.out.print(prompt);
                input = scanner.nextLine();
                if (input.contains("@")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid email address containing '@'.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred while reading input: " + e.getMessage());
            }
        }
        return input;
    }
}