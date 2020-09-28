import java.util.Comparator;

public class LeastFrequent implements Comparator<Avenger>{

		/**
		 * compares two avengers by ascending frequency,
		 * if it is a tie, sorts them in ascending last name length
		 * if it is still a tie, sorts them in ascending alphabetical order of last name
		 * @param two avengers to compare
		 * @return returns a negative integer if the first argument is less than,
		 * 			0 if they are equal, and
		 * 			positive if the first argument is greater than
		 */
	public int compare(Avenger o1, Avenger o2){
		if (o1.getFreq()>o2.getFreq()) {
			return 1;
		}
		if (o1.getFreq() == (o2.getFreq())) {
			if (o1.getName().length()>(o2.getName().length())) {
				return 1;
			}
			if (o1.getName().length() == (o2.getName().length())){
				if (o1.getName().compareTo(o2.getName()) > 0) {
					return 1;
				}
				else {
					return -1;
				}
			}
			else {
				return -1;
			}
		}
		else {
			return -1;
		}
	}
}
