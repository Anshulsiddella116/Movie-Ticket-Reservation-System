import java.util.Scanner;
import java.util.NoSuchElementException;

public class Movie_Ticket_Reservation_System {
    static Scanner scanner = new Scanner(System.in);
    static String[] movies = {"Inception", "Interstellar", "Avatar"};
    static String[] showTimes = {"10:00 AM", "2:00 PM", "6:00 PM"};
    static boolean[][] bookedSeats = new boolean[3][20];
    static final int TICKET_PRICE = 150;

    public static void main(String[] args) {
        try {
            while (true) {
                try {
                    System.out.println("\n--- Movie Ticket Reservation System ---");
                    System.out.println("1. View Movies");
                    System.out.println("2. View Seats");
                    System.out.println("3. Book Ticket");
                    System.out.println("4. Cancel Ticket");
                    System.out.println("5. Exit");
                    int choice = readNumber("Enter your choice: ");

                    switch (choice) {
                        case 1:
                            displayMovies();
                            break;
                        case 2:
                            int movie = selectMovie();
                            displaySeats(movie);
                            break;
                        case 3:
                            bookTicket();
                            break;
                        case 4:
                            cancelTicket();
                            break;
                        case 5:
                            System.out.println("Thank you!");
                            return;
                        default:
                            throw new IllegalArgumentException("Please choose a number from 1 to 5.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Input ended. Program closed.");
        } finally {
            scanner.close();
        }
    }

    static int readNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    static void displayMovies() {
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i]
                    + " | " + showTimes[i] + " | Rs. " + TICKET_PRICE);
        }
    }

    static int selectMovie() {
        displayMovies();
        int movie = readNumber("Enter movie number: ");
        if (movie < 1 || movie > movies.length) {
            throw new IllegalArgumentException("Invalid movie number.");
        }
        return movie - 1;
    }

    static void displaySeats(int movie) {
        System.out.println("\nSeats for " + movies[movie]);
        System.out.println("X = Booked; numbers = Available");
        for (int i = 0; i < bookedSeats[movie].length; i++) {
            if (bookedSeats[movie][i]) {
                System.out.printf("%4s", "X");
            } else {
                System.out.printf("%4d", i + 1);
            }
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }

    static void bookTicket() {
        int movie = selectMovie();
        displaySeats(movie);

        int available = 0;
        for (boolean booked : bookedSeats[movie]) {
            if (!booked) {
                available++;
            }
        }
        if (available == 0) {
            System.out.println("This show is fully booked.");
            return;
        }

        int count = readNumber("How many seats do you want to book? ");
        if (count < 1 || count > available) {
            throw new IllegalArgumentException(
                    "Please choose between 1 and " + available + " seats.");
        }

        int[] selectedSeats = new int[count];
        boolean[] selected = new boolean[bookedSeats[movie].length];

        for (int i = 0; i < count; i++) {
            int seat = readNumber("Enter seat number " + (i + 1) + ": ");
            if (seat < 1 || seat > bookedSeats[movie].length) {
                System.out.println("Invalid seat number.");
                i--;
            } else if (bookedSeats[movie][seat - 1]) {
                System.out.println("This seat is already booked.");
                i--;
            } else if (selected[seat - 1]) {
                System.out.println("You have already selected this seat.");
                i--;
            } else {
                selectedSeats[i] = seat;
                selected[seat - 1] = true;
            }
        }

        for (int seat : selectedSeats) {
            bookedSeats[movie][seat - 1] = true;
        }

        System.out.println("\nTickets booked successfully!");
        System.out.println("Movie: " + movies[movie]);
        System.out.println("Show time: " + showTimes[movie]);
        System.out.print("Seats: ");
        for (int seat : selectedSeats) {
            System.out.print(seat + " ");
        }
        System.out.println("\nTotal price: Rs. " + (count * TICKET_PRICE));
    }

    static void cancelTicket() {
        int movie = selectMovie();
        int seat = readNumber("Enter seat number to cancel: ");
        if (seat < 1 || seat > bookedSeats[movie].length) {
            throw new IllegalArgumentException("Invalid seat number.");
        }
        if (!bookedSeats[movie][seat - 1]) {
            System.out.println("No booking exists for this seat.");
            return;
        }
        bookedSeats[movie][seat - 1] = false;
        System.out.println("Ticket cancelled successfully.");
    }
}
