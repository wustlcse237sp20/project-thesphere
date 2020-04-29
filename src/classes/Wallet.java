package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Wallet{
	private ArrayList<Ticket> tickets;
	private int rewardPoints;
	private String cardNum;
	private String cardName;
	private String cardExpDate;
	private int cardZip;
	private int cardSecurityCode;

	public Wallet(String email){
		try {
			File f = new File("Users/"+email+"/Wallet/tickets.txt");
			Scanner s = new Scanner(f);
			this.tickets = new ArrayList<Ticket>();
			
			while (s.hasNextLine()) {
				String line = s.nextLine();
				this.tickets.add(new Ticket(line));
			}
			s.close();
			
			File r = new File("Users/"+email+"/Wallet/rewardpts.txt");
			Scanner rs = new Scanner(r);
			String ptString = rs.nextLine();
			this.rewardPoints = Integer.valueOf(ptString);
			rs.close();
		}
			
		//Card read in here I'll do that later
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateInfo(String newNum, String newName, String newExpDate, int newZip, int newSecCode){
		this.cardNum = newNum;
		this.cardName = newName;
		this.cardExpDate = newExpDate;
		this.cardZip = newZip;
		this.cardSecurityCode = newSecCode;

		//sql update
	}
	
	public static Wallet createWallet(String email) throws IOException {
		File u = new File("Users/"+email+"/Wallet");
		u.mkdir();
		
		FileWriter ticketWriter = new FileWriter("./Users/"+email+"/Wallet/tickets.txt");
		ticketWriter.write("");
		ticketWriter.close();
		
		FileWriter rewardWriter = new FileWriter("./Users/"+email+"/Wallet/rewardpts.txt");
		rewardWriter.write("0");
		rewardWriter.close();
		
		FileWriter cardWriter = new FileWriter("./Users/"+email+"/Wallet/cardinfo.txt");
		cardWriter.write("");
		cardWriter.close();
		
		return new Wallet(email);
	}
	
	public void addTicket(String ticketString) throws IOException{
		// add to List<Ticket> variable and update db
		//TODO
	}


}