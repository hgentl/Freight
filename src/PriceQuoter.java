
/**
 * Interface PriceQuoter.
 *
 * Enhances the loose coupling between classes Parcel and Removal by 
 * reducing code dependency by allowing different methods to create a 
 * Shipping quote.
 *
 */
public interface PriceQuoter
{
    /**
     * 
     * Abstract method createQuote. Used in Parcel and Removal to create a
     * shipping Quote.
     * 
     * @peram unitPrice - price of one unit
     * @return cost in pence per unit
     */
    double createQuote(int unitPrice);
}
