package classes;

public class Ticket {

	private String dateAndBand;
	private String seat;
	private String IMGpath;
	
	
	public Ticket(String dateAndBand_, String seat_) {
		this.dateAndBand = dateAndBand_;
		this.seat = seat_;
		int indexToStart = 0;
		for (int i =0; i <dateAndBand_.length(); i++) {
			if (dateAndBand_.charAt(i) == ':') {
				indexToStart = i+2;
				break;
			}
		}
		this.IMGpath = dateAndBand_.substring(indexToStart);
		
	}
	
	public String getDateAndBand() {
		
		return dateAndBand; 
		
	}
	
	public String getSeat() {
		
		return seat;
		
	}
	
	public String getIMGpath() {
		return IMGpath;
	}
	
	public void setDateAndBand(String d) {
		
		this.dateAndBand = d;
		
	}
	
	public void setSeat(String s) {
		
		this.seat = s;
		
	}

}
	
