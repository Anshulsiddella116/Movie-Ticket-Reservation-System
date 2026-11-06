# Movie Ticket Reservation System

A simple console application written in Java for viewing movies, checking seats, booking tickets, and cancelling bookings. This beginner project uses basic Java concepts and requires no external libraries.

## Features

- View movies, show times, and ticket prices.
- View 20 seats per movie: numbers indicate available seats, and `X` indicates booked seats.
- Book one or multiple seats for a movie in one transaction.
- Prevent booking an occupied seat or selecting the same seat twice.
- Display selected seats and the total ticket price.
- Cancel one booked seat at a time.
- Handle invalid input and close the scanner when the program exits.

## Available Movies

| Movie | Show time | Ticket price |
| --- | --- | --- |
| Inception | 10:00 AM | Rs. 150 |
| Interstellar | 2:00 PM | Rs. 150 |
| Avatar | 6:00 PM | Rs. 150 |

## Requirements

- Java Development Kit (JDK) 8 or later
- A terminal or a Java IDE

## How to Run

Download the source file or clone this repository, then open a terminal in the folder containing `Movie_Ticket_Reservation_System.java`.

Compile the program:

```bash
javac Movie_Ticket_Reservation_System.java
```

Run the program:

```bash
java Movie_Ticket_Reservation_System
```

## Menu

```text
--- Movie Ticket Reservation System ---
1. View Movies
2. View Seats
3. Book Ticket
4. Cancel Ticket
5. Exit
```

Enter the number of the operation you want to perform. After each operation, the program returns to the main menu.

## Booking Multiple Seats

1. Choose option `3` (Book Ticket).
2. Enter the movie number.
3. Enter how many seats you want to book.
4. Enter each seat number when prompted.
5. View the booking confirmation and total price.

For example, booking seats `7`, `8`, and `9` for Inception produces:

```text
Tickets booked successfully!
Movie: Inception
Show time: 10:00 AM
Seats: 7 8 9
Total price: Rs. 450
```

Seats are booked only after all requested seats have been selected successfully. If a seat number is invalid, occupied, or already selected, the program asks for another seat.

## Cancelling a Ticket

Choose option `4`, enter the movie number, and enter the booked seat number. That seat becomes available again. To cancel multiple seats, repeat this operation for each seat.

## Exception Handling

- `NumberFormatException`: handles nonnumeric input and numbers outside the Java `int` range, then asks for input again.
- `IllegalArgumentException`: handles invalid menu choices, movie numbers, booking quantities, and cancellation seat numbers, then returns to the menu.
- `NoSuchElementException`: closes the program gracefully when input ends.
- `finally`: closes the scanner when the program finishes.

## Java Concepts Used

- Arrays and two-dimensional arrays
- Methods, loops, and conditional statements
- Switch statements
- Console input using `Scanner`
- Exception handling using `try`, `catch`, `throw`, and `finally`

## Limitations

- Bookings are stored in memory and reset when the program closes.
- Each movie has one fixed show time and 20 seats.
- The program does not process payments or store customer details.

## Files

```text
Movie_Ticket_Reservation_System.java
README.md
```
