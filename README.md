# Challenge requirements: Trip Planning System

One of the biggest problems that people traveling to other countries go through is confusion about the times between boarding and disembarking. This happens because, as we move around the planet, the time zone changes. For example, imagine that we are leaving Brasilia on 01/22 and our flight leaves at 1:00 pm for Tokyo, Japan. Considering that we are on a direct flight, lasting 24 hours, we will arrive in Tokyo at 1:00 am on 01/24. You might think: "But hey, if we left Brazil on 01/22, on a 24-hour flight, how did we arrive two days later in Japan?" So it is! This is due to the time zone!

To help travelers, an airline hired its team to develop a system so that its customers can calculate the time zones of their travels between countries.

So, before we start describing the system requirements, we want to say that after completing this challenge, you will be proficient in dealing with dates, times, and time zones using Java. Let's go! ✈️

The airline that hired its team to develop the project wants the system to receive input from the user indicating, in the following order:
**1st:** What is the city of origin of your trip;
**2nd:** the city of destination;
**3rd:** The date and time of departure of your flight; and
**4th:** The distance between cities in kilometers.

After the user enters this information, the system should present a summary of the trip, indicating the date, time, and the name of the departure city, and also the date, time, and the name of the destination city. To make life easier for travelers, the system must present a sentence making it clear, so as not to confuse, that the disembarkation will be at a given time in the destination city, which is equivalent to a specific time in the city of origin — thus the person's family members traveler will know what time they can try to call to find out if everything went well during the flight, for example.

With these requirements from the airline, the project manager surveyed the classes, methods, and attributes that the system must have and sent the demand for it to be developed by you. Then the system must have the following classes, methods, and attributes:

## Classes

- Time: this class is responsible for doing all the manipulation of dates, times, and system time zones.
    - Attributes:
        - `boarding`: is private, of the `LocalDateTime` class type, and is responsible for storing the traveler's boarding date and time.
        - `origin`: it is private, of type String, and is responsible for storing the name of the city of origin of the trip.
        - `destination`: is private, of type String, and is responsible for storing the name of the destination city of the trip.
        - `duration`: is private, of the integer type, and is responsible for storing the duration of the trip in hours, in this case, it is the duration of the flight specifically.
        - `format`: it is private, of type String, and is responsible for representing the format that the date and time must have when entered by the user (eg: "dd/MM/yyyy HH:mm:ss").
	
    - Methods:
        - Constructor: the constructor method of this `Time` class must receive four arguments: String `boarding`, String `origin`, String `destination`, `int` `duration`, which must be used to initialize the respective attributes. Note that the `boarding` attribute is of type `LocalDateTime`, and the argument received is of type String, so you must use the methods of the `LocalDateTime` class to do this manipulation.
        - `returnTheLandingTimeConsideringTheDestinationLocation`: this method is public and returns a String value representing date and time in dd/MM/yyyy HH:mm:ss format. It is responsible for discovering the local date and time of the traveler's destination city upon disembarkation (taking into account the duration of the flight). For example, considering that boarding in the city of origin was on 22/01/22, the flight left at 1:00 pm for the destination city, which has a difference of 12 hours in the time zone, that is, in the destination city of boarding of the traveling person was on 23/01/22 at 01:00. Assuming that the flight lasts 24 hours, then this method should return the String "24/01/22 01:00:00", which represents the date and time that the landing will be made, taking into account the city time of destination.
        - `returnTheLandingTimeConsidereingTheOriginLocation`: this method is public and also returns a String value representing date and time in the format dd/MM/yyyy HH:mm:ss. Similar to the previous one, this method must calculate what will be the date and local time in the city of origin when the person will disembark in the city of destination. Considering the same previous example, in which the boarding in the city of origin was on 22/01/22, the flight left at 13:00 for the destination city, which has a difference of 24 hours in the time zone. Assuming that the flight lasts 24 hours, then this method should return the String "23/01/22 13:00:00", which represents the date and time that the landing will take into account the time in the city of origin. This information is relevant so that the traveler can advise family members at what time they can try to contact the traveler.

        ⚠️🔴**TIP: use the `LocalDateTime`, `ZoneId`, `ZonedDateTime`, and `DateTimeFormatter` classes from the `java.time` package to manipulate date and time, time zones, and date and time formats, respectively. The static method `getAvailableZoneIds` of the `ZoneId` class returns an object of type `Set`, which contains all the time zones supported by the `java.util` package. You can convert this `Set` object into an array of Strings using the `toArray` method of the `ZoneId` class. Ex:** 🔴⚠️
        ```java
        String[]  timeZones = new String[ZoneId.getAvailableZoneIds().size()];
        ZoneId.getAvailableZoneIds().toArray(timezones);
        ```
    
- Trip: this class is responsible for concentrating the manipulation between flight and schedule. It uses methods of the `Tempo` class and of the `Flight` class to send the information to the `main` method that is in the class `Main`.
    - Attributes:
        - `boarding`: this attribute is a private String type, and is responsible for storing the date and time of boarding of the person using the system.
        - `origin`: it is private, of type String, and is responsible for storing the entry of the user with the name of the city of origin of the trip.
        - `destination`: is private, of type String, and is responsible for storing the name of the destination city of the trip that is entered by the user.
        - `distanceKm`: this attribute is private, of type `double`, and is responsible for storing the entry of the user, indicating the distance in kilometers between the city of origin and destination.
        - `flight`: is the private part of the `Flight` type, and is responsible for calling the methods of the `Flight` class.
	
    - Methods:
        - Constructor: This method receives four attributes: `String boarding`, `String origin`, `String destination`, `double distanceKm`, which are used to initialize their attributes respectively.
        - `returnTheLandingTimeConsideringTheDestinationLocation`: this method is public and has a String type return. It is responsible for instantiating a `Time` type object and using the `returnTheLandingTimeConsideringTheDestinationLocation` method of the `Time` class to receive the String that represents the date and local time of the destination city during the disembarkation of the traveler.
        - `returnFlightDuration`: this method is public and has an integer return type. It is responsible for using the `flight` attribute passing the `distanceKm` attribute to the `retornarFlightTime` method of the `Flight` class, which returns an integer value representing the duration of the flight in hours.
        - `returnTripInformation`: it is public and returns a String value that is the summary of the trip, as determined by the airline.

- Flight: this class is responsible for handling methods related to flight.
    - Attributes:
        - `flightTime`: this attribute is private and of integer type, used to store the flight time in hours.
	
    - Methods:
        - `returnFlightTime`: this method is public and returns an integer value that represents the duration of the flight in hours. It receives an attribute of type `double`, which represents the distance in kilometers between the city of origin and the city of destination. For this calculation, consider that a commercial plane at cruising speed travels 700 kilometers per hour. For example, if the distance between the city of origin and destination is 8,000 kilometers, considering that the average speed of the plane is 700 kilometers per hour, the flight would last 11.4 hours, and this method should return the value 11 (rounding occurs because the return is of integer type).
        - `returnFlightInformation`: this method is public and has a String type return that represents the summary of information about the flight. It takes four arguments: `String boarding`, `String origin`, `String disembarkation`, and `String destination`, and uses them to form a String with the flight summary.

To help you with this challenge, let's implement the `Main` class with the `main` method to initialize our system.
```java
package com.rangel;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
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
```
We start our `main` method with the declaration of our `scanner` of the `Scanner` class so that the user can insert entries in our system. We also declare a variable to store the option chosen from the menu by the user. After that, we put together a nice little menu to appear in a nice way in the Java console.

We put our code inside an infinite loop so we can keep interacting with the system until we get enough. After the user enters the desired option, we use conditional blocks to implement what each option will generate. In the first conditional block, which represents option 1, we ask the user to enter the name of the city of origin, then the city of destination, the date and time of departure, and the distance in kilometers between the city of origin and destination. After that, we instantiate an object of the `Trip` class type, passing the information to its constructor, and calling the `returnTripInformation` method, which returns a String representing the summary of the trip.

Pretty cool huh? Now you have the first class of this challenge, you can start implementing the others! #LETSGO

## Exemple

Let's see what our console output would look like after an interaction with our trip planning system. Here we are considering that the city of origin is Recife, that the city of destination is Tokyo, that our flight will board on 22/01/2022 at 18:30:00, and that the distance between Recife and Tokyo is 16,885 km (I searched for this information on Google). With this information, the output in our console would be:
```
---------------------------- Welcome to the Trip Planning System  ----------------------------
	1) Plan a new trip
	2) Shut down System

Enter the desired option: 1
Enter the name of the city of origin: Recife
Enter the name of the city of destination: Tokyo
Enter the date and time of the departure (format: dd/mm/aaaa hh:mm:ss): 22/01/2022 18:30:00
Enter with the distance in km between the city of origin and the destination: 16.885


---------------------------- Trip Summary ----------------------------
Departure: 22/01/2022 18:30:00
Origin: Recife

Arrival: 24/01/2022 06:30:00
Destination: Tokyo

Attention: disembarkation in Tokyo will be: 24/01/2022 06:30:00 Tokyo time and 23/01/2022 18:30:00 Recife time
--------------------------------------------------------------------------


	1) Plan a new trip
	2) Shut down System

Enter the desired option: 
```
Note that considering that the plane travels 700 kilometers per hour and the distance between Recife and Tokyo is 16,885 kilometers, the duration rounded to a whole flight is 24 hours. See also that, with this system, travelers will have more accurate information, which will help a lot in their trip planning, and also for them to inform their families, who may be less worried.

Do you see how a system developed by you can reduce the headaches and worries of several people and families? Get to work! Buckle up and #LETSGO 💺


---
