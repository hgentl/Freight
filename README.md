## Project Outline
This project was developed as part of the M250 Object-Oriented Java Programming module at The Open University. It models a freight company's booking system using object-oriented design principles to represent different freight services, their pricing rules, and their shared behaviour.

### Assignment Context
This project challenged me to design a small but extensible object model. Rather than implementing each freight service independently, I identified the behaviour they shared and modelled it in a common base class, allowing specialised services to extend that functionality where required.
---

## Features
* Models different types of freight services.
* Calculates prices based on freight characteristics.
* Calculates parcel dimensions and checks them against shipping limits.
* Stores tracking information and parcel contents for tracked parcels.
* Calculates removal service prices based on freight volume.

---
## Design Highlights

The project separates shared freight behaviour into an abstract `Freight` class while allowing specialised freight services to extend and customise that behaviour. Pricing is represented through a dedicated `PriceQuoter` interface, demonstrating how inheritance and interfaces can be combined to create a flexible object-oriented design.

### Inheritance & Abstract Classes
`Parcel`, `TrackedParcel`, and `Removal` inherit common functionality from `Freight`, extending it with behaviour specific to each freight service.

The different freight services share common information, such as delivery addresses and dispatch dates. Rather than duplicating this logic across multiple classes, I introduced an abstract `Freight` class to provide a common foundation while allowing each service to implement its own specialised behaviour.

`TrackedParcel` also extends the existing `Parcel` class rather than duplicating its functionality. It adds tracking information, parcel contents, and an additional tracking fee while retaining the existing parcel behaviour.

### Interfaces & Polymorphism
Different freight services calculate their prices in different ways. The `PriceQuoter` interface defines a common contract for creating quotes, which is implemented by the abstract `Freight` class.

The subclasses then provide their own implementations of `createQuote()` to apply the appropriate pricing rules. This allows different freight types to be treated consistently while retaining their own specialised pricing behaviour.
### Method Overriding
Several subclasses override inherited methods to provide specialised behaviour.

For example, `TrackedParcel` overrides `createQuote()` to add a tracking fee to the standard parcel price. It also overrides `toString()` and `equals()` to include information specific to tracked parcels.

--- 
## Class Hierarchy
``` text
               PriceQuoter 
               (Interface)  
                    ▲
                    │ implements
                    │ 
                 Freight
               (Abstract Class)
                    │
        ┌───────────┴──────────┐
        │                      │
      Parcel                 Removal
        │                            
  TrackedParcel  
    

     
```

---

## Demonstration

The `Main.java` class provides a small demonstration of the project's main functionality and object-oriented design.

It creates examples of `Parcel`, `TrackedParcel`, and `Removal` and demonstrates:

* Creating and displaying different freight types.
* Adding tracking information and parcel contents.
* Checking parcel dimensions against the shipping limits.
* Generating quotes using the different pricing implementations.
* Treating different freight types through the common `Freight` abstraction.

The demonstration also shows polymorphism by storing the different freight types in a `Freight` collection and calling the overridden `createQuote()` method on each object.


**Note**: This project was originally developed using BlueJ as part of a university module focused on object-oriented design rather than building complete Java applications. To make the project easier to explore outside the university environment, I have added a small Main.java class that demonstrates the core functionality. The demonstration is intended to showcase the design of the classes rather than every aspect of the original assignment.



---

## Reflections 
While working on this project, I developed an understanding of responsibility-driven design. Before completing this project, I tended to think about classes individually. Designing this system helped me appreciate the importance of well-defined responsibilities, class structures, and inheritance hierarchies. It highlighted the value of identifying shared behaviour and responsibilities before creating specialised classes.

### Future Improvements
If I were to design a similar system, I would:

* Add validation of freight data.
* Introduce unit tests using JUnit.

---
