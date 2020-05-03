package classes;

import java.io.*;

import classes.Ticket;
import java.util.*;


import java.util.Scanner;

public class Event {
	private String artist;
	private String eventDate;
	private String IMGpath;

	
	
	public Event(String name, String date) {
		this.artist = name;
		this.eventDate = date;
		this.IMGpath = name;
		
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

//	public void sellTicket(int row, int seat) {
//		sold[row][seat] = true;
//	}
}
