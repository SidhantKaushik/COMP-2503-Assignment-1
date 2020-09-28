import java.util.ArrayList;
import java.util.Collections;
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

			if (!existsInRoster(currWord)) {
				  
				  Avenger a = createAvenger(currWord); // creates a new avenger object

				  if (a!= null) {
					   if (listContains(a)) {
						   increaseFreq(a);
					   } else {
						   a.setFreq();
						   avengersArrayList.add(a);
					   }
				  }	 
			}
		}
		
		input.close();
	}

	private boolean existsInRoster (String input){
	    for(int i = 0; i < avengerRoster.length; i++){
	        for(int j = 0; j < 2; j++){
	            if(avengerRoster[i][j] == input) {
	            	return true;
	            }
	        }
	    }
	    return false;
	}
	
	private boolean listContains(Avenger a) {
		
		for (Avenger currAvenger : avengersArrayList) {
			if (currAvenger.getAlias().equals(a.getAlias()) || 
					currAvenger.getName().equals(a.getName())) {
				return true;
		}
	}
		
		return false;
	}
	
	private void increaseFreq(Avenger a) {
		
		for (Avenger currAvenger : avengersArrayList) {
			if (currAvenger.getAlias().equals(a.getAlias()) || 
					currAvenger.getName().equals(a.getName())) {
				currAvenger.increaseFreq();
			}
		}
	}

	private Avenger createAvenger(String input) {
		
		Avenger a = null; 
		
		for (int r = 0; r < avengerRoster.length; r++) {
			
			for (int c = 0; c < 2; c++) {

				if (input.equals(avengerRoster[r][c])) {
					if (c == 1) { //if the input is an name
						a = new Avenger(input, avengerRoster[r][0]);
					} else if (c == 0) { //if the input is a last name
						a = new Avenger(avengerRoster[r][1], input);
					}
				}		
			}
			//a
		}
		return a;
	}

	private String ordered() {
		String avengerList = "";
		for(int i = 0; i<avengersArrayList.size();i++) {
			avengerList = avengerList + avengersArrayList.get(i).toString() + "\n";
		}
		return avengerList;
	}
	
	private String alphabeticalOrder() {
		String avengerList = "";
		
		Collections.sort(avengersArrayList);
		
		for(int i = 0; i<avengersArrayList.size();i++) {
			avengerList = avengerList + avengersArrayList.get(i).toString() + "\n";
		}
		return avengerList;
	}
	
	private String mostPopular() {
		String avengerList = "";
		
		Collections.sort(avengersArrayList, new MostFrequent());
		for(int i = 0; i<avengersArrayList.size();i++) {
			avengerList = avengerList + avengersArrayList.get(i).toString() + "\n";
		}
		return avengerList;
	}
	private String leastPopular() {
		String avengerList = "";
		Collections.sort(avengersArrayList, new LeastFrequent());
		for(int i = 0; i<avengersArrayList.size();i++) {
			avengerList = avengerList + avengersArrayList.get(i).toString() + "\n";
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
		System.out.println(mostPopular());

		System.out.println("Top " + topN + " least popular avengers:");
		// Todo: Print the least popular avengers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output		
		System.out.println(leastPopular());

		System.out.println("All mentioned avengers in alphabetical order:");
		// Todo: Print the list of avengers in alphabetical order
		//System.out.println();
		System.out.println(alphabeticalOrder());
	}
}
