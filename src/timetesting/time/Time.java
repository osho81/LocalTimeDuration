package timetesting.time;

import java.time.Duration;
import java.time.LocalTime;

//Class for methods (not oop)
public class Time {

	// Return any skier's lapsed time at any point
	public static void currentSkiTime(LocalTime chosenSkier) {
		// (Possible to return Duration etc, i.e. must not be void)

		// Get current time locally, i.e. in this case what the clock is in Sweden
		LocalTime currentTime = LocalTime.now();

		// Print out just to check
		System.out.println("Current time: " + currentTime);
		System.out.println("Skier start time: " + chosenSkier); // Chosen skier's start time

		// Measure range of time that has passed from start till current time/now
		Duration duration = Duration.between(chosenSkier, currentTime);
		System.out.println("Lapsed time: " + duration);

		// Retrieve difference in hours, minutes, seconds, OR nano seconds
		long durationInHour = duration.toHours();
		long durationInMin = duration.toMinutes();
		long durationInSec = duration.toSeconds();
		long durationInNs = duration.toNanos();
		System.out.println(durationInHour + " hours or " + durationInMin + " minutes or " + durationInSec
				+ " seconds or " + durationInNs + " nano seconds.");

		// Return as hh:mm:ss:ns
		long durationH = duration.toHours();
		long durationM = duration.toMinutesPart();
		long durationS = duration.toSecondsPart();
		long durationNs = duration.toNanosPart();
		System.out.println(durationH + ":" + durationM + ":" + durationS + ":" + durationNs + ":");
	}
	
	// Compare skier's lapsed time at certain points (can return diff instead)
	public static void compareTime(LocalTime chosenSkier1, LocalTime chosenSkier2, LocalTime reachTime1, LocalTime reachTime2) {
		
		// Simply checking the difference between their starting times: 
		Duration startDiff = Duration.between(chosenSkier1, chosenSkier2);
		System.out.println("Diff in start time: " + startDiff);
		
		// If want to return difference of ski time at certain spot: 
		Duration duration1 = Duration.between(chosenSkier1, reachTime1);
		Duration duration2 = Duration.between(chosenSkier2, reachTime2);
		
		long duration1InSec = duration1.toSeconds();
		long duration2InSec = duration2.toSeconds();
		
		// SKi time difference will be same as start time difference 
		// Since if they reach same 
		long skiTimeDiff = duration1InSec - duration2InSec;
		System.out.println("Diff in seconds: " + skiTimeDiff);
		
	}

}
