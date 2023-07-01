package com.rangel;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    /**
     * The Main method is the entry point of the application.
     * @param args an array of string, used to pass values during the initialization.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
		int op;
		
		System.out.println("---------------------------- Welcome to the Trip Planning System ----------------------------");

        do {
			System.out.println("	1) Plan a new trip");
			System.out.println("	2) Shut down System");
			System.out.println();
			System.out.print("Enter the desired option: ");
			op = scanner.nextInt();
			scanner.nextLine();
			
			if(op == 1) {
				System.out.print("Enter the name of the city of origin: ");
				String origin = scanner.nextLine();
				System.out.print("Enter the name of the city of destination: ");
				String destination = scanner.nextLine();
				System.out.print("Enter the date and time of the departure (format: dd/mm/aaaa hh:mm:ss): ");
				String departure = scanner.nextLine();
				System.out.print("Enter with the distance in km between the city of origin and the destination: ");
				Double distanceKm = scanner.nextDouble();
				
				Trip trip = new Trip(departure, origin, destination, distanceKm);
		
				System.out.println("\n\n---------------------------- Trip Summary ----------------------------");
				System.out.println(trip.returnTriṕInformation());
				System.out.println("--------------------------------------------------------------------------\n\n");
				
			} else if(op == 2) {
				System.out.println("Shutting down the system...");
				break;
			} else {
				System.out.println("Invalid option, try again!");
			}
			
		} while(true);
		
		System.out.println("System shut down!");
		scanner.close();
    }
}
