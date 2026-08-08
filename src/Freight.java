/**
 * class Freight 
 * abstract class, implements PriceQuoter interface
 *  
 */  
public abstract class Freight implements PriceQuoter 
{
    private String address; //the address to send the freight to
    private String dateSent; //the date the freight was sent

    /**
     * @param anAddress the address the freight is to be sent to
     */
    public Freight(String anAddress)
    {
        address = anAddress;
    }
    
    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }
    
    /**
     * @return the dateSent
     */
    public String getDateSent()
    {
        return dateSent;
    }

    /**
     * @param aPostDate the dateSent to set
     */
    public void setDateSent(String aPostDate)
    {
        dateSent = aPostDate;
    }
}