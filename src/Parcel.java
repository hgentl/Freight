import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


/**
 * Subclass of Freight.
 * 
 * Contains the physical characteristics and logistical information
 * of the parcel, such the packages dimensions and shipping address. 
 * Includes methods to calculate and orgnise these aspects and 
 * characteristics assosiated with them.
 * 
 * Also Includes methods to check if parcel is within the 
 * limits set by the shipping company.
 * 
 */
public class Parcel extends Freight
{    
    // Parcels weight, reopresented in kg.  
    private double weight;  
    // Parcels  width, represented in cm.
    private int width; 
    // Parcels length, represented in cm.
    private int length;
    // Parcels height, represented in cm.  
    private int height; 
    // the maximum permissible length of the parcel in cms
    public static final int LENGTH_LIMIT = 120;
    // the maximum permissible size of the parcel in cms
    public static final int SIZE_LIMIT = 245;
    // the maximum permissible size of the parcel in kilos
    public static final int WEIGHT_LIMIT = 5;
    
    /**
     * Constructor for the Parcel class.
     * 
     * @param deliveryAddress - The parcels shipping address 
     * @param parcelWeight - The parcels weight in Kg
     * @param parcelWidth - The width of the parcel
     * @param parcelLength - The length of the parcel
     * @param parcelHight - The hight of the parcel
     */
    public Parcel(String deliveryAddress, double parcelWeight, int parcelWidth, 
                int parcelLength, int parcelHeight)
    {
       // set the address to the @param in the Freight class
       super(deliveryAddress);
       /* call setDateSent() in Freight to set the default shipping 
       date to an empty String */
       setDateSent("");
       weight = parcelWeight; 
       width = parcelWidth;
       length = parcelLength;
       height = parcelHeight;

    }
    
    /**
     * @return the parcels weight of the parcel
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * Equals method for this object.
     * 
     * @return true if objects compared are same class or subclass and
     * have the same address and dateSent
     */
    public boolean equals(Object o)
    {
        if(o != null && o instanceof Parcel) {
            Parcel p = (Parcel) o;
            return getAddress().equals(p.getAddress()) && getDateSent().equals(p.getDateSent());
        }
        return false;
    }

    /**
     * 
     * @return a string representation of the parcel
     */
    public String toString()
    {
        String returnString = "A parcel for " + getAddress()  + "\nWeight " + weight + 
        "Kg, Width " + width + "cms,  Height " + height + "cms,  Length "  + length + "cms.";

        return returnString;
    }  
    
    /**
     * 
     * Sorts the width, height & length of the parcel from shortest 
     * to longest.
     * 
     * @param width - The width of the Parcel
     * @param length - The Parcels Length
     * @param height - The height of the Parcel
     * 
     * @return, the width, length and height ordered by size in an ArrayList.
     */
    public static ArrayList<Integer> getOrderedSides(int width, int length, int height)
    {   
        // create an arraryList of Integers to hold the parcels sides
        ArrayList<Integer> packageSides = new ArrayList<>();
        
        // add the height, lenght and width to packageSides.        
        packageSides.add(width);
        packageSides.add(length);
        packageSides.add(height);
        
        /* sort the contents of the ArrayList using collections.sort() 
        from shortest - longest */
        Collections.sort(packageSides);
        
        // return the sorted ArrayList
        return packageSides;
    }

    /**
     * 
     * Gets the parcels longest side.
     * 
     * @return longestSide - the longest side of the parcel.
     */
    
    public int getLongestSide()
    {
        /*sides are organised  smallest to biggest in the ArrayList
        the longest side will always be the last in the ArrayList. */
        return getOrderedSides(width, length, height).get(2);

    } 
    
    /**
     * 
     * Calculates the size of the parcel using three sides using the 
     * formula (smallest  side + next shortest side) x 2 + largest side.
     * 
     * @return sizeOfParcel - the size of the package
     */
    public int getParcelSize()
    {
        // get the ordered sides of the parcel
        ArrayList<Integer> side = getOrderedSides(width, length, height);
        // calculate  the size using the formula stated above
        int sizeOfParcel = (side.get(0) + side.get(1)) * 2 + side.get(2);

        return sizeOfParcel;
    }
    
    /**
     * 
     * Checks the parcels length, size and weight is within the set limits.
     * 
     * @return true if the parcel in withing the set limits
     */
    public boolean isWithinLimits()
    {
        
        if ((getLongestSide() <= LENGTH_LIMIT) 
            && (getParcelSize() <= SIZE_LIMIT) 
            && (getWeight() <= WEIGHT_LIMIT)) {
                return true;
        }
        
        return false; 
    }
    
    /**
     * Implements the abstract method createQuote.
     * Creates a shipping quote in GBP calculated from the weigth of the 
     * pacel & cost in pence per KG.
     * 
     * @param pencePerKg - price in pence per KG
     * @return A quote calculated from the price in pencePerKg and the weight
     */
    public double createQuote (int pencePerKg)
    {              

       double quote = Math.round(pencePerKg * weight);
       // convert the quote from GBX to GBP by dividing quote by 100
       double quoteInGBP = quote / 100;
       
       return quoteInGBP;
    }
}
