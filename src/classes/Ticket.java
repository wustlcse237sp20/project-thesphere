package classes;

public class Ticket {

	private String eventID;
	private int row;
	private int seat;
	
	public Ticket(String ticketString) {
		String[] ticketInfo = ticketString.split(" "); //event_id row seat
		this.eventID = ticketInfo[0];
		this.row = Integer.valueOf(ticketInfo[1]);
		this.seat = Integer.valueOf(ticketInfo[2]);
	}
	
	public String getEventID() {
		return eventID; 
	}
	
	public int getSeat() {
		return seat;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public String toString() {
		return this.eventID+" "+this.row+" "+this.seat;
	}

}
	
