
public class Avenger implements Comparable <Avenger> {

	private String heroName;
	private String heroAlias;
	private int frequency;
	
	@Override
	public int compareTo(Avenger other) {
		return this.heroAlias.compareTo(other.heroAlias);
	}

    public boolean equals (Avenger other) {
        return this.heroAlias.equals(other.heroAlias);
    }
    @Override
    public String toString() {
    	String format = heroAlias + " aka " + heroName
    			+ " mentioned " + frequency + " time(s)";
    	return format;
    }
}
