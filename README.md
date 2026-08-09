## Project Outline
This project was developed as part of the M250 Object-Oriented Java Programming module at The Open University. It models a freight company's booking system using object-oriented design principles to represent different freight services, their pricing rules, and their shared behaviour.

### Assignment Context
This project challenged me to design a small but extensible object model. Rather than implementing each freight service independently, I identified the behaviour they shared and modelled it in a common base class, allowing specialised services to extend that functionality where required.

### Features
* Models different freight service types.
* Calculates service prices based on freight characteristics.
* Uses a common abstraction to represent different freight types.
* Demonstrates polymorphic price calculation through a shared interface.

---
## Design Highlights
The project separates shared freight behaviour into an abstract Freight class while allowing specialised freight services to extend and customise that behaviour. Pricing is represented through a dedicated interface, demonstrating how inheritance and interfaces can be combined to create a flexible object-oriented design.

### Inheritance & Abstract Classes
`Parcel`, `TrackedParcel` and `Removal` inherit common functionality from `Freight`, extending it with behaviour specific to each freight service. 
 
The different freight services all share common information, such as customer details and pricing behaviour. Rather than duplicating this logic across multiple classes, I introduced an abstract Freight class to provide a common foundation while allowing each service to implement its own specialised behaviour.
### Polymorphism & Interfaces
Different freight services calculate their prices in different ways. By introducing a PriceQuoter interface, each service can implement its own pricing logic while still being used in a consistent way by the rest of the application.

### Class Hierarchy
```
                     Freight
                (Abstract Class)
                        │
        ┌───────────────┴─────────────┐
        │                             │
      Parcel                       Removal
        │                            
  TrackedParcel  
    
   PriceQuoter 
   (Interface)  
        ▲
        │
     Freight
```

---
## Demonstration


---
## Reflections 
While working on this project I developed an understanding of Responsibility-driven design. Before completing this project, I tended to think about classes individually. Designing this system helped me appreciate the importance of well defined responsibility, class and inheritance hierarchies. It highlighted the value of designing around shared behaviour rather than immediately creating specialised classes with shared responsibilities.

### Future Improvements
If I was to design a similar system, I would:
* Add validation of freight data. 
* introduce unit tests using JUnit. 

---
