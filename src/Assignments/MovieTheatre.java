package Assignments;//Simulate a movie theater that helps users to book and reserve seats.
//1. Reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
//2. Cancel seats
//3. Retrieve initial seating charting

public class MovieTheatre {
    private boolean[][] seats;

    public MovieTheatre() {
        // initializing a 10x10 seating arrangement
        seats = new boolean[10][10];
    }

    public boolean reserveSeat(int row, int col) {
        // First check to see if the seat is taken
        if (seats[row][col]) {
            System.out.println("This seat has already been reserved.");
            suggestNearestSeat(row, col);

            return false;
        }

        // If the seat turns out to be available, it gets marked as True
        seats[row][col] = true;
        System.out.println("Seat has successfully been reserved.");
        return true;
    }

    // Cancel a seat
    public void cancelSeat(int row, int col) {
        seats[row][col] = false;
        System.out.println("Reservation has been cancelled.");
    }

    // Initial seating chart
    public void displaySeats() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < seats.length; i++) {
            System.out.print((char)('A' + i) + " ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }

    // Additional method for suggesting the nearest seat that can be reserved.
    private void suggestNearestSeat(int row, int col) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats.length; j++) {
                if (!seats[i][j]) {
                    System.out.println("Suggested available seat: Row " +
                            (char)('A' + i) + ", Seat " + (j + 1));
                    return;
                }
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        MovieTheatre theater = new MovieTheatre();

        // Display initial seating
        System.out.println("Initial seating chart:");
        theater.displaySeats();

        // Try reserving some seats
        theater.reserveSeat(0, 0);
        theater.reserveSeat(2, 3);

        System.out.println("Reservation chart:");

        // Show updated seating
        System.out.println("After reservations:");
        theater.displaySeats();

        // Try reserving an already taken seat
        theater.reserveSeat(0, 0);
    }
}