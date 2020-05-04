package classes;

import java.io.*;
import java.util.*;

public class Event {
	private String eventID;
	private String artist;
	private String eventDate; // MM/DD/YYYY format
	private String IMGpath;
	private int rows;
	private int seatsPerRow;
	private int price;
	private boolean[][] sold;

	
	
	public Event(String event_id) {
		if (event_id == null) {
			System.out.println("here");
		}
		if (!event_id.contentEquals(".DS_Store")) {
			try {
				this.eventID = event_id;
				File f = new File("Events/"+event_id+"/info.txt");
				Scanner fs = new Scanner(f);
				
				String eventInfo = fs.nextLine();
				String[] eventInfoArray = eventInfo.split(", ");
				
				this.artist = eventInfoArray[0];
				this.eventDate = eventInfoArray[1];
				this.price = Integer.valueOf(eventInfoArray[2]);
				this.rows = Integer.valueOf(eventInfoArray[3]);
				this.seatsPerRow = Integer.valueOf(eventInfoArray[4]);
				this.sold = new boolean[rows][seatsPerRow];
				
				fs.close();
				
				File t = new File("Events/"+event_id+"/seats.txt");
				Scanner ts = new Scanner(t);
				for (int i = 0; i < rows; i++) {
					String seatString = ts.nextLine();
					for (int j = 0; j < seatsPerRow; j++) {
						if (seatString.split(" ")[j].equals("1")) {
							sold[i][j] = true;
						}
					}
				}
				ts.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public String getEventID() {
		return this.eventID;
	}
	
	public String getArtist(){
		return this.artist;
	}
	
	public String getEventDate() {
		return this.eventDate;
	}
	
	public String getIMGpath() {
		return this.IMGpath;
	}

	public void sellTicket(int row, int seat) {
		sold[row-1][seat-1] = true;
	}
	
	public void saveSeatsSold() throws IOException {
		FileWriter fw = new FileWriter("Events/"+this.eventID+"/seats.txt", false);
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.seatsPerRow; j++) {
				if (sold[i][j]) {
					fw.write("1 ");
				}
				else {
					fw.write("0 ");
				}
			}
			fw.write(System.lineSeparator());
		}
		fw.close();
	}
}
