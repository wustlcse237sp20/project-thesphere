package classes;

import java.io.*;

import classes.Ticket;
import java.util.*;


import java.util.Scanner;


public class User {
	private String firstName;
	private String lastName;
	private String email;
	private List<Ticket> tickets = new ArrayList<>();
	
	//Eventually put a wallet object here and in constructor


	public User(String emailAddress){
		this.email = emailAddress;

		try {
			File f = new File("Users/"+this.email+"/info.txt");
			Scanner s = new Scanner(f);
			int counter = 0;
			while (s.hasNextLine()) {
				String line = s.nextLine();
				if (counter==0) {
					this.firstName = line.split(": ")[1];
				}
				else if (counter==1) {
					this.lastName = line.split(": ")[1];
				}
				counter++;
			}
			s.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return this.firstName+" "+this.lastName;
	}

	public String getEmail() {
		
		return this.email;
		
	}
	public List<Ticket> getTickets(){
		return this.tickets;
	}

	//All of these update functions can be made to return boolean (true=successful update)
	
	//updating individual items will use this to avoid writing a bunch of sql updates
	private void updateInfo(String first, String last, String emailAddress){
		this.firstName = first;
		this.lastName = last;
		this.email = emailAddress;

		//sql update statement
	}

	public void updateName(String first, String last){
		updateInfo(first, last, this.email);
	}

	public void updateEmail(String newEmail){
		updateInfo(this.firstName, this.lastName, newEmail);
	}

	//dont want to store password anywhere besides db so this one is separate
	public void updatePassword(String newPass){
		//sql update here
	}

	// Ticket Functionality

	public boolean addTicket(Ticket ticketPurchased) throws IOException{
		// add to List<Ticket> variable and update db
		if(ticketPurchased != null){
			tickets.add(ticketPurchased);
			File tickets_file = new File("Users/" + email + "/tickets.txt");
			try {
				if (tickets_file.createNewFile()){
					System.out.println("File is created!");
				}
				else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileWriter ticketInfo = new FileWriter(tickets_file);
			ticketInfo.write(ticketPurchased.getDateAndBand() + " " + ticketPurchased.getSeat());
			ticketInfo.close();
			return true;
		}
		return false;
	}

	public void initializeTicketList(){
		File f = new File("Users/"+email+"/tickets.txt");

		// read through tickets.txt and fill in variable
//		try {
//			Scanner s = new Scanner(f);
//			String pass = s.nextLine();
//			s.close();
//			return password.equals(pass);
//		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return false;
//		}
	}


	
	public static User createNewUser(String first, String last, String email, String password) throws IOException {
		File u = new File("Users");
		if (!u.exists()) {
			u.mkdir();
		}
		File f = new File("Users/"+email);
		f.mkdir();
				
		
		FileWriter passWriter = new FileWriter("./Users/"+email+"/password.txt");
		passWriter.write(password);
		passWriter.close();
		
		FileWriter infoWriter = new FileWriter("./Users/"+email+"/info.txt");
		infoWriter.write("First Name: "+first+System.lineSeparator()+"Last Name: "+last);
		infoWriter.close();

//		initializeTicketList();
		
		return new User(email);
	}
	
	public static boolean checkIfEmailUsed(String email) {
		File f = new File("Users/"+email);
		return f.exists();
	}
	
	public static boolean checkEmailAndPassword(String email, String password) {
		File f = new File("Users/"+email+"/password.txt");
		try {
			Scanner s = new Scanner(f);
			String pass = s.nextLine();
			s.close();
			return password.equals(pass);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}


}