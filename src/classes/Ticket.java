package classes;

public class Ticket {

	private Event event;
	private int row;
	private int seat;
	
	public Ticket(Event e, String ticketString) {
		String[] ticketInfo = ticketString.split(" "); //row seat
		this.event = e;
		this.row = Integer.valueOf(ticketInfo[0]);
		this.seat = Integer.valueOf(ticketInfo[1]);
	}
	
	public Event getEvent() {
		return event; 
	}
	
	public int getSeat() {
		return seat;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public String toString() {
		return this.event.getEventID()+" "+this.row+" "+this.seat;
	}

}
	
