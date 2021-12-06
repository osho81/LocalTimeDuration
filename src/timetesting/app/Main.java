package timetesting.app;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import timetesting.skier.Skier;
import timetesting.time.Time;

public class Main {

	public static void main(String[] args) {

		// Create first starting time (when race starts)
		// This can be called by e.g. a menu choice:
		LocalTime raceStart = LocalTime.now();
		// Or manually chosen:
//		LocalTime raceStart = LocalTime.of(10,0,0,0); 

		// Create an array of skiers - i.e. a specific ski race
		Skier[] skiRace = new Skier[5];

		// Create an object in each object array index, and assign values
		for (int i = 0; i < skiRace.length; i++) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Skier first name");
			String fName = scan.nextLine();
			System.out.println("Skier last name");
			String lName = scan.nextLine();
			skiRace[i] = new Skier(i, fName, lName); // Assign num & names

			// Also assign a starting time for each skier
			// Increase skier's individual starting time and assign to the skier (i)
			LocalTime givenStartTime = raceStart.plus(15 * i, ChronoUnit.SECONDS); // Ex: 15 sec * skie nr
			skiRace[i].setIndivStartTime(givenStartTime);
		}

		// Print out (added toSTring() in Skier and Time)
		for (int i = 0; i < skiRace.length; i++) {
			System.out.println(skiRace[i]);
		}

		// LAPSED TIME
		// Choose a certain skier's startTime
		Scanner scan = new Scanner(System.in);
		System.out.println("Which skier number to check?");
		int chosenNr = scan.nextInt(); // Retrieve chosen skier LocalTime
		LocalTime chosenSkier = skiRace[chosenNr].getIndivStartTime();
		
		// Pass it in as arg to Time class operations
		Time.currentSkiTime(chosenSkier);

		// COMPARE TWO SKIERS AT CERTAIN REACH/SPOT
		// Choose a certain skier's startTime
		System.out.println("Enter nr of first skier to compare:");
		int chosenNr1 = scan.nextInt(); 
		System.out.println("Enter nr of second skier to compare:");
		int chosenNr2 = scan.nextInt(); 
		
		// Retrieve both chosen skiers' LocalTime
		LocalTime chosenSkier1 = skiRace[chosenNr1].getIndivStartTime();
		LocalTime chosenSkier2 = skiRace[chosenNr2].getIndivStartTime();
		
		// Enter times for reaching the spot
		System.out.println("Enter hh, mm, ss, ns for first skier:");
		LocalTime reachTime1 = LocalTime.of(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()); 
		System.out.println("Enter hh, mm, ss, ns for second skier:");
		LocalTime reachTime2 = LocalTime.of(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()); 
		
		// Pass it in as arg to Time class operations
		Time.compareTime(chosenSkier1, chosenSkier2, reachTime1, reachTime2);
		
	}

}
