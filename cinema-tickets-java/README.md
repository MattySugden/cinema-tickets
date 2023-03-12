# Cinema Ticket System

Libraries and Dependencies to install:
- JDK Version 17.0.3
- Maven Junit 5 Jupiter 5.9.2 - accessible from:
[Maven Repository](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine)

  
## Introduction

The cinema ticketing system allows customers to order 3 types of tickets with various prices:

- Adult - £20.00
- Child - £10.00
- Infant - £0.00

Infant tickets are £0.00 cost and requires 1 paying adult per 1 infant ticket.  

The infant is expected to sit on the adult's lap while in the cinema.

Child tickets can only be purchased with a paying adult.

Multiple tickets can be purchased by the customer, up to a maximum of 20 tickets at one time.

The _'TicketPaymentService'_ and _'SeatReservationService'_ classes are implemented by external service providers.  
The _'TicketPaymentService'_ role is to take payments from the customer.
The _'SeatReservationService'_ role is to reserve the amount of seats requested on the booking is complete.

## Unit Tests

The tests are found in /cinema-tickets-java/src/test/java/uk.gov.dwp.uc.pairtest/ and are associate with each class in _'main'._




