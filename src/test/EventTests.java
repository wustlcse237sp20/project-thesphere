package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import classes.Event;

public class EventTests {

	private static Event testEvent1;
	private static Event testEvent2;
	
	@BeforeClass
	public static void setup() {
		testEvent1 = new Event("1");
		testEvent2 = new Event("2");
	}
	
	@Test 
	public void getID() {
		assertEquals("1", testEvent1.getEventID());
		assertEquals("2", testEvent2.getEventID());
	}
	
	@Test
	public void getDate() {
		assertEquals("06/13/20", testEvent1.getEventDate());
		assertEquals("06/15/20", testEvent2.getEventDate());
	}
	
	@Test
	public void getRowsAndSeats() {
		assertEquals(10, testEvent1.getRows());
		assertEquals(10, testEvent2.getRows());
		assertEquals(10, testEvent1.getSeatsPerRow());
		assertEquals(10, testEvent2.getSeatsPerRow());
	}
	
	@Test
	public void getArtist() {
		assertEquals("The Weeknd", testEvent1.getArtist());
		assertEquals("Cage The Elephant", testEvent2.getArtist());
	}
	
	
	@Test
	public void saveSeatsSold() {
		Event originalEvent1 = new Event("1");
		for (int i = 0; i < testEvent1.getRows(); i++) {
			for (int j = 0; j < testEvent1.getSeatsPerRow(); j++) {
			}
		}
		try {
			testEvent1.saveSeatsSold();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Event newEvent1 = new Event("1");

		try {
			originalEvent1.saveSeatsSold();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
