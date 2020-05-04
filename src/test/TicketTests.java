package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import classes.Event;
import classes.Ticket;

public class TicketTests {
	
	private static Ticket testTicket;
	
	@BeforeClass
	public static void setup() {
		testTicket = new Ticket("1 3 5");
	}

	@Test
	public void getEventID() {
		assertEquals("1", testTicket.getEvent().getEventID());
	}
	
	@Test 
	public void getRowAndSeat() {
		assertEquals(3, testTicket.getRow());
		assertEquals(5, testTicket.getSeat());
	}

}
