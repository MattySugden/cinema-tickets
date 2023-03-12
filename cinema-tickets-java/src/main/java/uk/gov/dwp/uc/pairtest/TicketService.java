package uk.gov.dwp.uc.pairtest;

import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;

public interface TicketService {

    void purchaseTickets(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException;

    void infantAdultTickets(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException;

    void ticketRequestTotalCalculator(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException;

    void childTicketNoAdultTicket(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException;

    void infantTicketNoAdultTicket(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException;
}

