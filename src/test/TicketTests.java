package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import classes.Event;
import classes.Ticket;

public class TicketTests {
	
	private static Ticket testTicket;
	private static Event e;
	
	@BeforeClass
	public static void setup() {
		e = new Event("1");
		testTicket = new Ticket(e, "1 3");
	}

	@Test
	public void getEventID() {
		assertEquals("1", testTicket.getEvent().getEventID());
	}
	
	@Test 
	public void getRowAndSeat() {
		assertEquals(1, testTicket.getRow());
		assertEquals(3, testTicket.getSeat());
	}

}
