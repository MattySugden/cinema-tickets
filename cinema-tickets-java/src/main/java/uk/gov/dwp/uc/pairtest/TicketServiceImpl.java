package uk.gov.dwp.uc.pairtest;

import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;

public class TicketServiceImpl implements TicketService {
    /**
     * Should only have private methods other than the one below.
     */

    private static final double ADULT_TICKET_PRICE = 20.00;
    private static final double CHILD_TICKET_PRICE = 10.00;
    private static final double INFANT_TICKET_PRICE = 0.00;

    @Override
    public void purchaseTickets(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException {
        int ticketCount = 0;
        for (TicketTypeRequest ttr : ticketTypeRequests) {
            ticketCount = ticketCount + ttr.getNoOfTickets();
        }
        if (ticketCount > 20) {
            throw new InvalidPurchaseException("Maximum number of tickets exceeded!");
        }
    }
    @Override
    public void infantAdultTickets(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException {
        int infantCount = 0;
        int adultCount = 0;
        for (TicketTypeRequest ttr : ticketTypeRequests) {
            infantCount = infantCount + ttr.getNoOfTickets();
            adultCount = adultCount + ttr.getNoOfTickets();
        }
        if (infantCount > adultCount) {
            throw new InvalidPurchaseException("You have requested more infant tickets than adults.  Only one infant per one paying adult allowed.");
        }
    }
    @Override
    public void childTicketNoAdultTicket(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException {
        int childCount = 0;
        int adultCount = 0;
        for (TicketTypeRequest ttr : ticketTypeRequests) {
            childCount = childCount + ttr.getNoOfTickets();
        }
        for (TicketTypeRequest ttr : ticketTypeRequests) {
            adultCount = adultCount + ttr.getNoOfTickets();
        }
        if (adultCount == 0 && childCount > 1) {
            throw new InvalidPurchaseException("A child ticket cannot be purchased without a paying adult.");
        }
    }
    @Override
    public void infantTicketNoAdultTicket(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException {
        int adultSeatCount = 0;
        int infantSeatCount = 0;
        for (TicketTypeRequest ttr : ticketTypeRequests) {
            adultSeatCount = ttr.getNoOfTickets();
        }
        for (TicketTypeRequest ttr : ticketTypeRequests) {
            infantSeatCount = ttr.getNoOfTickets();
        }
        if (adultSeatCount == 0 && infantSeatCount > 1) {
            throw new InvalidPurchaseException("An infant ticket cannot be purchased without a paying adult.");
        }
    }
    public void ticketRequestTotalCalculator(Long accountId, TicketTypeRequest... ticketTypeRequests) {
        double totalAdultCost = 0;
        for (TicketTypeRequest ttr : ticketTypeRequests) {
            totalAdultCost = ADULT_TICKET_PRICE * ttr.getNoOfTickets();
        }
        double totalChildCost = 0;
        for (TicketTypeRequest ttr : ticketTypeRequests) {
            totalChildCost = CHILD_TICKET_PRICE * ttr.getNoOfTickets();
        }
        double totalInfantCost = 0;
        for (TicketTypeRequest ttr : ticketTypeRequests) {
            totalInfantCost = INFANT_TICKET_PRICE * ttr.getNoOfTickets();
        }
        double totalAmountToPay = totalAdultCost + totalChildCost + totalInfantCost;
    }

    public void totalNumberOfSeatsToReserve(Long accountId, TicketTypeRequest... ticketTypeRequests) {
        int totalAdultSeats = 0;
        for (TicketTypeRequest ttr : ticketTypeRequests) {
            totalAdultSeats = ttr.getNoOfTickets();
        }
        int totalChildSeats = 0;
        for (TicketTypeRequest ttr : ticketTypeRequests) {
            totalChildSeats = ttr.getNoOfTickets();
        }
        int totalInfantSeats = 0;
        for (TicketTypeRequest ttr : ticketTypeRequests) {
            totalInfantSeats = ttr.getNoOfTickets();
        }
        int totalSeatsToBook = (totalAdultSeats + totalChildSeats) - totalInfantSeats;
    }
}

        //  throw new InvalidPurchaseException("Infant tickets cannot be purchased without an adult ticket!");
        //
        // TO-DO - Call the calculate method at this point.
        //  Build the calculator that calculates the price of the tickets requests.
        // eg. check out the ticket counter above.
        //  TicketPaymentService payment = new ticketPaymentService
        //  accountId
        //  totalAmountToPay


//
//    public double calculateTotalPrice(TicketTypeRequest... ticketTypeRequests) {
//    throw new UnsupportedOperationException("Not developed yet!");
//    }

