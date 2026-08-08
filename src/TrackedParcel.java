import java.util.HashSet;
import java.util.TreeSet;
import java.util.Objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.text.DecimalFormat;

/**
 * Subclass of Parcel.
 *
 * Represents a tracked parcel. Extends Parcel by adding tracking  
 * information. Includes methods to add the package contents and create a 
 * tracking Number and set the dateSent.
 *
 */
public class TrackedParcel extends Parcel 
{
    // Represents  the parcels tracking number
    private String trackingNumber; 
    // The parcels value in GBX/Pence
    private int value; 
    // Holds the packages contents
    private HashSet<String> contents; 
    public static final double TRACKING_FEE = 2.0;
    
    /**
     * Constructor for the TrackedParcel Class.
     * 
     * @param shippingAddress - The parcels delivery address
     * @param parcelWeight - The given weight of the parcel
     * @param parcelWidth - The given width of the parcel
     * @param parcelLength - The given length of the parcel
     * @param parcelHight - The given hight of the parcel
     * @param parcelValue - the given value of the parcel
     * 
     */
    public TrackedParcel(String shippingAddress, double parcelWeight, 
                        int parcelWidth, int parcelLength, int parcelHeight, 
                        int parcelValue)
    {
        // set the address, weight, width, length, hight in the superclass
        super(shippingAddress, parcelWeight, parcelWidth, parcelLength, parcelHeight);
        // set the trackingNumber to a default  value of an empty String
        trackingNumber = "";
        // set the parcles value in GBX/Pence
        value = parcelValue; 
        contents = new HashSet<String>();
    }
    
    /**
     * Sets dateSent using LocalDate.now() and the trackingNumber.
     * 
     * @param trackingId - used to set the tracking number
     */
    public void setDateAndTracking(String trackingId)
    {
        // set the trackingNumber using the passed parameter.
        trackingNumber = trackingId;
        
        LocalDate date = LocalDate.now();
        DateTimeFormatter patten = DateTimeFormatter.ofPattern("dd MMM yyyy");
        
        setDateSent(date.format(patten));
    }
    
    /**
     * Overrides the toSting() method from parcel to create String 
     * representation of the trackedParcel class.
     * 
     * @return a String representation of the trackedParcel
     */
    @Override 
    public String toString()
    {   
        // alphabetise the package contents using a TreeSet
        TreeSet<String> sortedContents = new TreeSet<>(contents);
        // Used to format the Parcels value to an appropriate  format
        DecimalFormat valueFormat = new DecimalFormat("£0.00"); 
        
        /* change value from and int to a double and divide by 100 to convert
        from GBX to GBP */
        double valueInGBP = (double)value / 100.0;
        // convert sortedContents to a string and remove the [] & , 
        String formatedContents = sortedContents.toString().replaceAll("\\[|\\]|,", "");
                
        /* The basic returnString, returns when contents is empty and 
        dateSent & trackingNumber are not set */
        String returnString = super.toString() +"\nValue: " + valueFormat.format(valueInGBP);                     
        
        // Add the sorted contents if it's not empty
        if (!formatedContents.equals("")) {
            returnString = super.toString() +"\nContents: " + formatedContents +
            "\nValue: " + valueFormat.format(valueInGBP);
        }
        // Add dateSent if it has been set
        if (!getDateSent().equals("")) {
            returnString = returnString + "\nDate Sent: "+ getDateSent();
        }
        // Add trackingNumer if it has been set
        if (!getTrackingNumber().equals("")){
           returnString = returnString + "\nTracking Number: " + getTrackingNumber(); 
        }     
        
        return returnString;
    }

    /**
     * Override the equals method from parcel.
     * 
     * @param obj - an object to be compared.
     * @return false if both objects compared are not equal
     */
    @Override
    public boolean equals(Object obj)
    {   
        // Check if the @param obj is an instance of TrackedParcel
        if (!(obj instanceof TrackedParcel)) {
            return false; 
        }
        
        /* cast obj to TrackedParcel and compare trackingnumber() along with 
        the checks in the super.equals() */
        TrackedParcel tP = (TrackedParcel) obj;
        return super.equals(tP) && 
        getTrackingNumber().equals(tP.getTrackingNumber()); 
    }
    
    /**
     * Create a hashCode using Objects,hash().
     * 
     * @return hashCode derived from the address, dateSent and trackingNumber
     */
    @Override
    public int hashCode()
    {      
        // create references  to the address, dateSent and trackingNumber.
        String postageAddress = getAddress();
        String dateShipped = getDateSent();
        String trackingNum = getTrackingNumber();

        return Objects.hash(postageAddress, dateShipped, trackingNum);
        
    }
    
    /**
     * Overrides the createdQuote method in parcel.
     * Adds the tracking fee to the quote.
     * 
     * @peram pencePerKg - the price for 1 unit in pence per Kg
     * @return Quote rounded to 2 decimal places
     */
    @Override
    public double createQuote(int pencePerKg)
    {
        // add TRACKING_FEE to the result of Parcel's createQuote method
        double trackedParcelQuote = super.createQuote(pencePerKg) + TRACKING_FEE;
  
        return trackedParcelQuote;
    }
    
    /**
     * 
     * @return the tracking number of the parcel
     * 
     */
    public String getTrackingNumber()
    {
        return trackingNumber;
    }
    
    /**
     * 
     * @param  anItem Adds anItem to the contents set for the parcel
     */
    public void addItem(String anItem)
    {   
        contents.add(anItem);
    }
    
}
