package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import classes.Event;

public class EventTests {

	private static Event testEvent;
	
	@BeforeClass
	public static void setup() {
			testEvent = new Event("name", "date", "time", 5, 3);
		}
	
	@Test 
	public void getAndSetName() {
		assertEquals("name", testEvent.getEventName());
		testEvent.setEventName("newName");
		assertEquals("newName", testEvent.getEventName());
	}
	
	public void getAndSetDate() {
		assertEquals("00/00/00", testEvent.getEventDate());
		testEvent.setEventDate("01/01/20");
		assertEquals("01/01/20", testEvent.getEventDate());
	}
	
	public void getAndSetTime() {
		assertEquals("00:00", testEvent.getEventTime());
		testEvent.setEventTime("01:30");
		assertEquals("01:30", testEvent.getEventTime());
	}
	
	boolean[][] testSeat = new boolean[7][6];
	public void getAndSetSold() {
		assertEquals(true, testEvent.getSold());
		testEvent.setSold(testSeat);
		assertEquals(true, testEvent.getSold());
	}
	
	

	
}
