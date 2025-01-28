package Assignments;// Calculate the avarage temperature, and give how many days are above the avarage temperature
// 1. Take an input from the user (eg. 5)
// 2. Prompt the user to enter all the 5 numbers (temperature values)
// 3. Calculate the avarage temperature
// 4. Given the avarage temperature, how many of the numbers in the line 2 are above the avarage temperature?

import java.util.Scanner;

public class TempAssignment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of days: ");
        int numberOfDays = input.nextInt();

        double[] temperatures = new double[numberOfDays];

        // Loop for collecting the temperatures on each day
        for (int i = 0; i < numberOfDays; i++) {
            System.out.println("Enter the temperature for day " + (i + 1) + ": ");
            temperatures[i] = input.nextDouble();
        }

        // Calculating average temperature
        double sum = 0;
        for (int i = 0; i < numberOfDays; i++) {
            sum += temperatures[i];
        }

        double average = sum / numberOfDays;
        System.out.println("Average temperature is: " + average);

        // Calculating how many days were above average
        int daysAboveAverage = 0;
        for (int i = 0; i < numberOfDays; i++) {
            if (temperatures[i] > average) {
                daysAboveAverage++;
            }
        }

        System.out.println("Number of days above average: " + daysAboveAverage);
    }
}

