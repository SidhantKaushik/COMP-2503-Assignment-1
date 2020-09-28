import java.util.Comparator;

public class LeastFrequent implements Comparator<Avenger>{
	/*
	 * Compare method takes two Avenger's and compares them
	 * @param Avenger: Takes in the two avenger's in order to compare them.
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
