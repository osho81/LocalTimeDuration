package timetesting.skier;

import java.time.LocalTime;

public class Skier {
	private int skierNumber;
	private String firstName;
	private String lastName;
	private LocalTime indivStartTime; // Use this instead
	
	// COnstructor
	public Skier(int skierNumber, String firstName, String lastName) {
		super();
		this.skierNumber = skierNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Skier [skierNumber=" + skierNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", indivStartTime=" + indivStartTime + "]";
	}

	public void setIndivStartTime(LocalTime givenStartTime) {
		this.indivStartTime = givenStartTime;	
	}

	public LocalTime getIndivStartTime() {
		return indivStartTime;
	}
	
	
}
