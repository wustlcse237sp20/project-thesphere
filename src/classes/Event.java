package classes;


public class Event{
	private String eventName;
	private String eventDate;
	private String eventTime;
	private boolean[][] sold;
	
	public Event(String eventName, String eventDate, String eventTime, int numRows, int numSeats) {
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.sold = new boolean[numRows][numSeats];
	}
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public boolean[][] getSold() {
		return sold;
	}

	public void setSold(boolean[][] sold) {
		this.sold = sold;
	}
	
	public void sellTicket(int row, int seat) {
		sold[row][seat] = true;
	}
}