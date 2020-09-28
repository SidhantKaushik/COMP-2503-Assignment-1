import java.util.Comparator;

/**
 * Comparator to sort avengersArrayList into the most four mentioned
 * 
 * @author Sidhant Kaushik, Erika Robles
 * @version Fall 2020
 */

public class MostFrequent implements Comparator<Avenger> {

		/**
		 * compares two avengers by descending frequency
		 * if it is a tie, sorts them in ascending alphabetical order
		 * @param two avengers to compare
		 * @return returns a negative integer if the first argument is less than,
		 * 			0 if they are equal, and
		 * 			positive if the first argument is greater than
		 */
	
	@Override
	public int compare(Avenger o1, Avenger o2) {
		if (o1.getFreq()>o2.getFreq()) {
			return -1;
		}
		if (o1.getFreq() == o2.getFreq()) {
			if (o1.getAlias().compareTo(o2.getAlias())>0) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else {
			return 1;
		}
	}

}
