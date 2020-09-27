
public class Avenger implements Comparable <Avenger> {

	private String heroName;
	private String heroAlias;
	private int frequency;

    public Avenger(String givenName, String givenAlias) {
        heroName = givenName;
        heroAlias = givenAlias;
    }

    public void setFreq() {
		frequency = 1;
	}

    public void increaseFreq() {
        frequency++;
    }
    
    public int getFreq() {
    	return frequency;
    }
    
    public String getName() {
    	return heroName;
    }
    
    public String getAlias() {
    	return heroAlias;
    }
	
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
