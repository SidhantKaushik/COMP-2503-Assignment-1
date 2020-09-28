import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** 
 * COMP 2503 Winter 2020 Assignment 1 
 * 
 * This program must read a input stream and keeps track of the 
 * frequency at which an avenger is mentioned either by name or alias.
 *
 * @author Maryam Elahi, Sidhant Kaushik, Erika Robles
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
	
		while (input.hasNext()) {
			String next = input.next();
			if (next.contains("'")) {
				String[] currWord1 = next.split("'");
				next = currWord1[0].toString();
			}
			String currWord = next.toLowerCase().replaceAll("[^a-z]", "").trim();
			
			if (!currWord.isBlank()) {
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

		/**
		 * Helper method
		 * checks if the given String input exists in the avengerRoster array
		 * @param takes in the input, which is either a name, alias or invalid input
		 * @return true, if the input is in the avengerRoster, false otherwise
		 */
	
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
	
		/**
		 * Helper method
		 * checks if the given Avenger input already exists in the avengerArrayList
		 * @param takes in the Avenger to look in the list for
		 * @return true, if the input is in the avengerArrayList, false otherwise
		 */
	
	private boolean listContains(Avenger a) {
		
		for (Avenger currAvenger : avengersArrayList) {
			if (currAvenger.getAlias().equals(a.getAlias()) || 
					currAvenger.getName().equals(a.getName())) {
				return true;
		}
	}
		
		return false;
	}
	
		/**
		 * Helper method
		 * looks for the given Avenger in avengersArrayList, 
		 * then it takes that Avenger and increases its frequency by 1
		 * @param takes in the Avenger to look in the list for
		 */
	
	private void increaseFreq(Avenger a) {
		
		for (Avenger currAvenger : avengersArrayList) {
			if (currAvenger.getAlias().equals(a.getAlias()) || 
					currAvenger.getName().equals(a.getName())) {
				currAvenger.increaseFreq();
			}
		}
	}
	
		/**
		 * Helper method
		 * takes a users input, 
		 * if its a name, it finds the corresponding alias and vise versa
		 * then creates a new object with the corret name and alias 
		 * @param takes in the input, which is either a name, alias or invalid input
		 * @return returns the new Avenger object
		 */

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
		
		}
		return a;
	}
	
		/**
		 * sorts the avengerArrayList in the order they are appeared on the input stream
		 * @return a string of each avenger mentioned in the correct order
		 */

	private String ordered() {
		String avengerList = "";
		for(int i = 0; i<avengersArrayList.size();i++) {
			avengerList = avengerList + avengersArrayList.get(i).toString() + "\n";
		}
		return avengerList;
	}
	
		/**
		 * sorts the avengerArrayList in alphabetical order of their alias
		 * @return a string of each avenger mentioned in the correct order
		 */
	
	private String alphabeticalOrder() {
		String avengerList = "";
		
		Collections.sort(avengersArrayList);
		
		for(int i = 0; i<avengersArrayList.size();i++) {
			avengerList = avengerList + avengersArrayList.get(i).toString() + "\n";
		}
		return avengerList;
	}
	
		/**
		 * sorts the avengerArrayList from highest frequency to the least
		 * if there is a tie, it sorts them into alphabetical order of their alias
		 * displays the first four avengers after sorted
		 * @return a string of each avenger mentioned in the correct order
		 */
	
	private String mostPopular() {
		MostFrequent a = new MostFrequent();
		Collections.sort(avengersArrayList, a);
		return collectionSort();
	}
	
		/**
		 * sorts the avengerArrayList from lowest to highest frequency
		 * if there is a tie, it sorts them in ascending order of last name length
		 * if there is still a tie, it sorts them in ascending alphabetical order of their last name
		 * displays the first four after sorted
		 * @return a string of each avenger mentioned in the correct order
		 */
	
	private String leastPopular() {
		Collections.sort(avengersArrayList, new LeastFrequent());
		return collectionSort();
	}
	
		/**
		 * takes a sorted list and displays either the first four,
		 * if the list contains less than four avengers, it displays the whole list
		 * @return a string of each avenger mentioned in the correct order
		 */
	private String collectionSort() {
		String avengerList = "";
		if (avengersArrayList.size()>4) {
			for(int i = 0; i<4;i++) {
				avengerList = avengerList + avengersArrayList.get(i).toString() + "\n";
			}
			}
		else {
				for(int i = 0; i<avengersArrayList.size();i++) {
					avengerList = avengerList + avengersArrayList.get(i).toString() + "\n";
				}
			}
		return avengerList;
	}
	
		/**
		 * prints the results
		 *
		 */
	private void printResults() {
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " + avengersArrayList.size());
		System.out.println();

		System.out.println("All avengers in the order they appeared in the input stream:");
		System.out.println(ordered());
		
		System.out.println("Top " + topN + " most popular avengers:");
		System.out.println(mostPopular());

		System.out.println("Top " + topN + " least popular avengers:");
		System.out.println(leastPopular());

		System.out.println("All mentioned avengers in alphabetical order:");
		System.out.println(alphabeticalOrder());
	}
}
