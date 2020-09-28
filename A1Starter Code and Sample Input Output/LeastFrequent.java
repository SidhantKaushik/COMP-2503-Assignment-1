import java.util.Comparator;

public class LeastFrequent implements Comparator<Avenger>{
	public int compare(Avenger o1, Avenger o2){
		if (o1.getFreq()>o2.getFreq()) {
			return -1;
		}
		if (o1.getFreq() == (o2.getFreq())) {
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
