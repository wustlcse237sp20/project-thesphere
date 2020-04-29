package classes;

public class Ticket {

	private Event event;
	private int row;
	private int seat;
	
	public Ticket(String ticketString) {
		String[] ticketInfo = ticketString.split(" "); //event_id row seat
		this.event = new Event(ticketInfo[0]);
		this.row = Integer.valueOf(ticketInfo[1]);
		this.seat = Integer.valueOf(ticketInfo[2]);
	}
	
	public Event getEvent() {
		return event; 
	}
	
	public int getSeat() {
		return seat;
	}
	
	public String toString() {
		return this.event.getEventID()+" "+this.row+" "+this.seat;
	}

}
	
