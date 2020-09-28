
public class Avenger implements Comparable <Avenger> {
	//declaring variables
	private String heroName;
	private String heroAlias;
	private int frequency;
    public Avenger(String givenName, String givenAlias) {
        heroName = givenName;
        heroAlias = givenAlias;
    }
    /*
     * setFreq sets the frequency of an Avenger
     */
    public void setFreq() {
		frequency = 1;
	}
    /*
     * increaseFreq increases the frequency of Avenger by 1
     */
    public void increaseFreq() {
        frequency++;
    }
    /*
     * getFreq returns the frequency
     */
    public int getFreq() {
    	return frequency;
    }
    /*
     * getName returns the Hero name
     */
    public String getName() {
    	return heroName;
    }
    /*
     * get Alias returns the Hero's alias
     */
    public String getAlias() {
    	return heroAlias;
    }
	
	@Override
	/*
	 * compareTo takes in one Avenger and compares it to another
	 * @param Avenger needed to compare one to the other
	 */
	public int compareTo(Avenger other) {
		return this.heroAlias.compareTo(other.heroAlias);
	}
	
	/*
	 * equals takes in one avenger and compares it with the other avenger
	 * @param Avenger
	 */
    public boolean equals(Avenger other) {
        return this.heroAlias.equals(other.heroAlias);
    }
    @Override
    /*
     * overriding toString to fit the format that was specified
     */
    public String toString() {
    	String format = heroAlias + " aka " + heroName
    			+ " mentioned " + frequency + " time(s)";
    	return format;
    }
}
