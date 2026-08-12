/**
 * Demonstrates the main features and object-oriented design of the
 * Freight project.
 *
 * This class was added for portfolio purposes to demonstrate how the
 * different freight types can be created and used outside of BlueJ.
 */
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("--- Freight Company Demonstration ---\n");

        /*
         * Create different types of freight.
         * Although these objects have different classes, they all share
         * the common Freight abstraction.
         */
        Parcel parcel = new Parcel(
            "10 High Street, London",
            3.5,
            30,
            50,
            20
        );

        TrackedParcel trackedParcel = new TrackedParcel(
            "25 Station Road, London",
            2.0,
            25,
            40,
            15,
            5000
        );

        Removal removal = new Removal(
            "15 Church Lane, London",
            20
        );

        // Set tracking information and add contents to the tracked parcel.
        trackedParcel.setDateAndTracking("TRK123456");
        trackedParcel.addItem("Laptop");
        trackedParcel.addItem("Charger");
        trackedParcel.addItem("Notebook");

        /*
         * Display the different freight types.
         * Each class provides its own string representation.
         */
        System.out.println("--- Freight Details ---\n");

        System.out.println("Standard Parcel:");
        System.out.println(parcel);
        System.out.println();

        System.out.println("Tracked Parcel:");
        System.out.println(trackedParcel);
        System.out.println();

        System.out.println("Removal Service:");
        System.out.println("Address: " + removal.getAddress());
        System.out.println();

        /*
         * Demonstrate parcel-specific functionality.
         */
        System.out.println("--- Parcel Information ---\n");

        System.out.println("Parcel longest side: "
            + parcel.getLongestSide() + " cm");

        System.out.println("Parcel size: "
            + parcel.getParcelSize() + " cm");

        System.out.println("Within shipping limits: "
            + parcel.isWithinLimits());

        System.out.println();

        /*
         * Demonstrate polymorphism.
         *
         * Each object is treated as a Freight reference, but the
         * appropriate implementation of createQuote() is called for
         * each object at runtime.
         */
        System.out.println("--- Price Quotes ---\n");

        Freight[] freightItems = {
            parcel,
            trackedParcel,
            removal
        };

        for (Freight freight : freightItems)
        {
            System.out.println(freight.getClass().getSimpleName()
                + " quote: "
                + getQuote(freight));
        }

        System.out.println("\n--- Demonstration Complete ---");
    }

    /**
     * Creates a quote for each type of freight.
     *
     * Parcels are charged per kilogram, while removal services
     * are charged per cubic metre.
     */
    private static double getQuote(Freight freight)
    {
        if (freight instanceof Removal)
        {
            return freight.createQuote(150);
        }

        return freight.createQuote(250);
    }
}