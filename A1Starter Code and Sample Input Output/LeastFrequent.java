import java.util.Comparator;

public class LeastFrequent implements Comparator<Avenger>{
	public int compare(Avenger o1, Avenger o2){
		if (o1.getFreq()>o2.getFreq()) {
			return -1;
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
			return 1;
		}
	}
}