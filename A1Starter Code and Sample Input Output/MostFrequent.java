import java.util.Comparator;

public class MostFrequent implements Comparator<Avenger> {

	@Override
	public int compare(Avenger o1, Avenger o2) {
		
		int result = o1.getFreq() - o2.getFreq();
		
		if (result == 0) {
			result = o1.getAlias().compareTo(o2.getAlias());
		}
		
		return result;
	}

}
