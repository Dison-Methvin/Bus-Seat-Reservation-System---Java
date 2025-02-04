# BusSeatReservationSystem
=====================
# A system by Dison Methvin
# Version 3.0
# Date: 13/01/2025
=====================

Note!
> This project is made for assignment purposes. I made this for the DSA assignment as a student doing HND in Computing in the field of Software Engineering field at Esoft Metro Campus.

Overview
The `BusSeatReservationSystem` is a Java-based application designed to manage bus seat reservations. It allows the customers to register seats and buses, search for buses, reserve and cancel seats, manage seat request queues, and display reservations. The application follows Object-Oriented Programming (OOP) principles and is structured into different packages for better modularity and maintainability.

Project Structure
The project is organized into the following directories and files:

Model Classes
[Bus.java](BusSeatReservationSystem/Src/model/Bus.java)**: Represents a bus with attributes like bus number, total seat capacity, starting point, ending point, starting time, fare, and a list of reservations.
[Customer.java](BusSeatReservationSystem/Src/model/Customer.java)**: Represents a customer with attributes like name, mobile number, email, city, and age.
[Reservation.java](BusSeatReservationSystem/Src/model/Reservation.java)**: Represents a reservation with attributes like customer and seat number.

 Service Classes
[BusService.java](BusSeatReservationSystem/Src/service/BusService.java)**: Contains methods for bus registration, bus search, and displaying reservations.
[CustomerService.java](BusSeatReservationSystem/Src/service/CustomerService.java)**: Contains methods for customer registration.
[ReservationService.java](BusSeatReservationSystem/Src/service/ReservationService.java)**: Contains methods for seat reservation, seat cancellation, and managing seat request queues.

 UI Classes
[ConsoleUI.java](BusSeatReservationSystem/Src/ui/ConsoleUI.java)**: Manages the user interface and handles user input for various operations.
[Menu.java](BusSeatReservationSystem/Src/ui/Menu.java)**: Displays the main menu for the application.

 Utility Classes
[App.java](BusSeatReservationSystem/Src/util/App.java)**: Contains the `main` method to run the application.

How to Run
1. Clone the Repository
    
    git clone https://github.com/DionMethvin/BusReservationSystem.git
    cd BusReservationSystem


2. Compile the Code
  
    javac -d bin Src/model/*.java Src/service/*.java Src/ui/*.java Src/util/*.java


3. Run the Application
    java -cp bin util.App
    ``

Features
Customer Registration: Register new customers with details like name, mobile number, email, city, and age.
Bus Registration: Register new buses with details like bus number, total seat capacity, starting point, ending point, starting time, and fare.
Bus Search: Search for buses based on starting and ending points.
Seat Reservation: Reserve seats for customers on a selected bus.
Seat Cancellation: Cancel reserved seats for customers.
Seat Request Queue: Manage a queue for seat requests.
Display Reservations: Display all reservations for each bus.

 Contact
For any questions or suggestions, please contact [disonmethvin.education@gmail.com](mailto:disonmethvin.education@gmail.com).