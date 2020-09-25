import java.util.ArrayList;
import java.util.Scanner;

/** 
 * COMP 2503 Winter 2020 Assignment 1 
 * 
 * This program must read a input stream and keeps track of the 
 * frequency at which an avenger is mentioned either by name or alias.
 *
 * @author Maryam Elahi
 * @date Fall 2020
*/

public class A1 {

	public String[][] avengerRoster = { { "captainamerica", "rogers" }, { "ironman", "stark" },
			{ "blackwidow", "romanoff" }, { "hulk", "banner" }, { "blackpanther", "tchalla" }, { "thor", "odinson" },
			{ "hawkeye", "barton" }, { "warmachine", "rhodes" }, { "spiderman", "parker" },
			{ "wintersoldier", "barnes" } };
	
	private int topN = 4;
	private int totalwordcount = 0;
	private ArrayList<Avenger> avengersArrayList = new ArrayList<>();

	public static void main(String[] args) {
		A1 a1 = new A1();
		a1.run();
	}

	public void run() {
		readInput();
		printResults();
		
	}

	/**
	 * read the input stream and keep track  
	 * how many times avengers are mentioned by alias or last name.
	 */
	private void readInput() {

		Scanner input = new Scanner(System.in);
		/*
		In a loop, while the scanner object has not reached end of stream,
		 	- read a word.
		 	- clean up the word
		    - if the word is not empty, add the word count. 
		    - Check if the word is either an avenger alias or last name then
				- Create a new avenger object with the corresponding alias and last name.
				- if this avenger has already been mentioned, increase the frequency count for the object already in the list.
				- if this avenger has not been mentioned before, add the newly created avenger to the list, remember to set the frequency.
		*/ 
		while (input.hasNext()) {
			String currWord = input.next().trim().toLowerCase().replaceAll("[^a-z]", "");
			if (!currWord.isEmpty()) {
				totalwordcount++;
			}
		
			 Avenger a = createAvenger(currWord);
			 
			 if (a != null) { 
				 if (!listContains(a)) { 
					 a.setFreq(1);
					 avengersArrayList.add(a); 
				 } else { 
					 a.increaseFreq(); 
				 } 
			 }
			 if(input.next().equals("break")) {
				 break;
			 }
		}
		
	}

	private boolean listContains(Avenger a) {
		return avengersArrayList.contains(a);
	}

	private Avenger createAvenger(String input) {
		
		Avenger a = null;
		
		for (int r = 0; r < avengerRoster.length; r++) {
			for (int c = 0; c < 2; c++) {
				
				if (input.equals(avengerRoster[r][c])) { //if input is part of the roster, make a new Avenger
					if (c == 0) { //if the input is an alias
						a = new Avenger(input, avengerRoster[r][c] );
					} else if (c == 1) { //if the input is a last name
						a = new Avenger(avengerRoster[r][c], input);
					}
				}
			}
		}
		
		return a; 
	}

	private String ordered() {
		String avengerList = null;
		for(int i = 0; i<avengersArrayList.size();i++) {
			avengerList = avengerList + i +": " + avengersArrayList.get(i).toString() + " ";
		}
		return avengerList;
	}
	/**
	 * print the results
	 */
	private void printResults() {
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " + avengersArrayList.size());
		System.out.println();

		System.out.println("All avengers in the order they appeared in the input stream:");
		// Todo: Print the list of avengers in the order they appeared in the input
		// Make sure you follow the formatting example in the sample output
		System.out.println(ordered());
		
		System.out.println("Top " + topN + " most popular avengers:");
		// Todo: Print the most popular avengers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output
		System.out.println();

		System.out.println("Top " + topN + " least popular avengers:");
		// Todo: Print the least popular avengers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output		
		System.out.println();

		System.out.println("All mentioned avengers in alphabetical order:");
		// Todo: Print the list of avengers in alphabetical order
		System.out.println();
	}
}
