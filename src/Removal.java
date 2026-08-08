/**
 * Subclass of Freight.
 * 
 * Calculates the volume of freight requierd to be transported and 
 * creates a quote based on the voulme and pence per meter cubed to 2DP.
 * 
 */
public class Removal extends Freight
{
   private int volume; //the volume of freight required to be transported

    /**
     * Constructor for objects of class Removals
     * @param anAddress the address the removal is to
     * @param volume the volume of the goods to be removed
     */
    public Removal(String anAddress, int volume)
    {
       super(anAddress);
       this.volume = volume;
    }
    
    /**
     * 
     * Implements the abstract method createQuote in removal
     * 
     * @param pencePerM3 - the price in pence per meter cubed
     * @return price in GBP from volume and pence per m3 
     */
    public double createQuote(int pencePerM3)
    {
        // calculate the price in GBP
        double priceInGBP = volume * pencePerM3;
        // round the price in GBP to 2 decimal places
        double roundedPriceInGBP = Math.round(priceInGBP * 100) / 100.0;
        // return the rounded price of the unit
        return roundedPriceInGBP;
    }
}