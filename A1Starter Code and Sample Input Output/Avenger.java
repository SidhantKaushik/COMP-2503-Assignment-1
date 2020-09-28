/**
 * Represents fuctionality of an Avenger, including their name and alias
 * 
 * @author Sidhant Kaushik, Erika Robles
 * @version Fall 2020
 */


public class Avenger implements Comparable <Avenger> {

		/**
		 * declaring instance variables
		 */
	private String heroName;
	private String heroAlias;
	private int frequency;
	
		/**
		 * Constructor
		 * @param takes in two strings, the first one is the name
		 * 			and the second one is the alias
		 */
    public Avenger(String givenName, String givenAlias) {
        heroName = givenName;
        heroAlias = givenAlias;
    }
    
	    /**
		 * sets the frequency to 1
		 */

    public void setFreq() {
		frequency = 1;
	}
    
	    /**
		 * increases the frequency by 1
		 */
    
    public void increaseFreq() {
        frequency++;
    }

	    /**
		 * gets the frequency
		 * @return returns the current frequency
		 */
    
    public int getFreq() {
    	return frequency;
    }
    
	    /**
		 * gets the name
		 * @return returns the heroName
		 */
    public String getName() {
    	return heroName;
    }
  
	    /**
		 * gets the alias
		 * @return returns the heroAlias
		 */
    
    public String getAlias() {
    	return heroAlias;
    }
	
    	/**
  		 * compares this object to another avenger
  		 * compares them by their alias
  		 * @param the avenger to compare to
  		 */
	@Override
	public int compareTo(Avenger other) {
		return this.heroAlias.compareTo(other.heroAlias);
	}
	
		/**
		 * compares if two avengers are equal
		 * they are equal if they have the same alias name
		 * @param other Avenger to check if equal
		 * @return true if same alias name, false otherwise
		*/
	
    public boolean equals(Avenger other) {
        return this.heroAlias.equals(other.heroAlias);
    }
    
    	/**
  		 * overrides toString to fit the format that was specified
  		 * @return String of avenger to display how many times it was mentioned
  		*/
     
    public String toString() {
    	String format = heroAlias + " aka " + heroName
    			+ " mentioned " + frequency + " time(s)";
    	return format;
    }
}
