package uk.gov.dwp.uc.pairtest;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import thirdparty.paymentgateway.TicketPaymentServiceImpl;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;

public class TicketServiceImplTest {

    private TicketServiceImpl service = new TicketServiceImpl();

    @Test
    public void orderingTwentyOneTicketsShouldProduceAInvalidPurchaseException() {
        TicketTypeRequest ticketRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 21);
        Exception exception = Assertions.assertThrows(
                InvalidPurchaseException.class, () -> service.purchaseTickets(123456l, ticketRequest));
        Assertions.assertEquals(exception.getMessage(), "Maximum number of tickets exceeded!");
    }

    @Test
    public void orderingTwentyOneTicketsOfMixedTypesShouldProduceAInvalidPurchaseException() {
        TicketTypeRequest ticketRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 10);
        TicketTypeRequest ticketRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 11);
        Exception exception = Assertions.assertThrows(
                InvalidPurchaseException.class, () -> service.purchaseTickets(123456l, ticketRequest, ticketRequest1));
    }
    // Under development
    @Test
    public void orderingAChildTicketWithNoAdultTicketShouldProduceAInvalidPurchaseException() {
        TicketTypeRequest ticketRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 0);
        TicketTypeRequest ticketRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1);
        Exception exception = Assertions.assertThrows(
                InvalidPurchaseException.class, () -> service.childTicketNoAdultTicket(123456l, ticketRequest, ticketRequest1));
        Assertions.assertEquals(exception.getMessage(), "A child ticket cannot be purchased without a paying adult.");
    }
    // Under development
    @Test
    public void orderingAnInfantTicketWithNoAdultTicketShouldProduceAInvalidPurchaseException() {
        TicketTypeRequest ticketRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 0);
        TicketTypeRequest ticketRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1);
        Exception exception = Assertions.assertThrows(
                InvalidPurchaseException.class, () -> service.infantTicketNoAdultTicket(123456l, ticketRequest, ticketRequest1));
        Assertions.assertEquals(exception.getMessage(), "An infant ticket cannot be purchased without a paying adult.");
    }
    // Under development
    @Test
    public void willThrowExceptionIfTheAmountOfInfantTicketsIsGreaterThanTheAmountOfAdultTicketsPurchased() {
        TicketTypeRequest ticketRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1);
        TicketTypeRequest ticketRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 2);
        Exception exception = Assertions.assertThrows(
                InvalidPurchaseException.class, () -> service.infantAdultTickets(123456l, ticketRequest, ticketRequest1));
        Assertions.assertEquals(exception.getMessage(), "You have requested more infant tickets than adults.  Only one infant per one paying adult allowed.");
    }
    // Under development
    @Ignore
    @Test
    public void totalPriceOfThreeAdultsTicketsAndTwoChildrenShouldBeEightyPounds() {
    }
    // Under development
    @Ignore
    @Test
    public void totalPriceOfThreeAdultsTicketsShouldBeSixtyPounds() {
        TicketTypeRequest ticketRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 3);
        TicketServiceImpl ticketType = new TicketServiceImpl(TicketTypeRequest.Type.ADULT, );
        Assertions.assertEquals(service.ticketRequestTotalCalculator(123456l, ticketRequest, ticketType), 60);
    }
}