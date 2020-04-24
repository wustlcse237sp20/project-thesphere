package ui;
import classes.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class UserAccountPage {

	private JFrame userAccountPageFrame;
	private String purchasedTicket;
	private String signedInEmail;
	private String signedInName;
	private List<Ticket> purchasedTicketsList;
	private int numberOfPurchasedTickets;

	


	public UserAccountPage(String signedInName, List<Ticket> purchasedTicketsList) {
		
		super();
		this.signedInName = signedInName;
		this.purchasedTicketsList = purchasedTicketsList;
		initialize();
		
	}
	
	public UserAccountPage(String signedInEmail) {
		
		super();
		this.signedInName = signedInEmail;
		initialize();
		
	}
	

	public JFrame getUserAccountPageFrame() {
		return userAccountPageFrame;
	}

	public void setUserAccountPageFrame(JFrame userAccountPageFrame) {
		this.userAccountPageFrame = userAccountPageFrame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		userAccountPageFrame = new JFrame();
		userAccountPageFrame.setBounds(100, 100, 1100, 600);
		userAccountPageFrame.setResizable(false);
		userAccountPageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		userAccountPageFrame.getContentPane().setLayout(springLayout);
		
		JLabel yourAccountPageLabel = new JLabel("Your Account Page");
		yourAccountPageLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		yourAccountPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, yourAccountPageLabel, 10, SpringLayout.NORTH, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, yourAccountPageLabel, 10, SpringLayout.WEST, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, yourAccountPageLabel, 52, SpringLayout.NORTH, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, yourAccountPageLabel, 270, SpringLayout.WEST, userAccountPageFrame.getContentPane());
		userAccountPageFrame.getContentPane().add(yourAccountPageLabel);
		
		
		try {
			
			numberOfPurchasedTickets = purchasedTicketsList.size();
			
		}
		
		catch(Exception e) {
			
			numberOfPurchasedTickets = 0;
			
		}
		
		JLabel upcomingTicketsLabel = new JLabel("Your Upcoming Tickets: " + numberOfPurchasedTickets);
		springLayout.putConstraint(SpringLayout.NORTH, upcomingTicketsLabel, -435, SpringLayout.SOUTH, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, upcomingTicketsLabel, 75, SpringLayout.WEST, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, upcomingTicketsLabel, -419, SpringLayout.SOUTH, userAccountPageFrame.getContentPane());
		upcomingTicketsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		userAccountPageFrame.getContentPane().add(upcomingTicketsLabel);
		
		JLabel firstPurchasedTicketLabel;
		
		if(numberOfPurchasedTickets == 0) {
			
			firstPurchasedTicketLabel = new JLabel("No tickets purchased yet");
			
			
		}else {
			
			firstPurchasedTicketLabel = new JLabel(purchasedTicketsList.get(0).getDateAndBand() + "; " + purchasedTicketsList.get(0).getSeat());
			
		}
		
		springLayout.putConstraint(SpringLayout.NORTH, firstPurchasedTicketLabel, -387, SpringLayout.SOUTH, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, firstPurchasedTicketLabel, 87, SpringLayout.WEST, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, firstPurchasedTicketLabel, -371, SpringLayout.SOUTH, userAccountPageFrame.getContentPane());
		userAccountPageFrame.getContentPane().add(firstPurchasedTicketLabel);
		
		JLabel signedInAsLabel = new JLabel("Signed in as: " + signedInName);
		signedInAsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, signedInAsLabel, 24, SpringLayout.NORTH, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, signedInAsLabel, -789, SpringLayout.EAST, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, signedInAsLabel, -547, SpringLayout.EAST, userAccountPageFrame.getContentPane());
		userAccountPageFrame.getContentPane().add(signedInAsLabel);
		
		
		// display tickets
		if(numberOfPurchasedTickets > 1) {
			
			for(int i = 0; i < purchasedTicketsList.size(); i++) {
				// debugging
				System.out.println(purchasedTicketsList.get(i).getDateAndBand());
				
				
				JLabel label = new JLabel(purchasedTicketsList.get(i).getDateAndBand() + "; " + purchasedTicketsList.get(i).getSeat());
				springLayout.putConstraint(SpringLayout.NORTH, label, (-387 + i*60), SpringLayout.SOUTH, userAccountPageFrame.getContentPane());
				springLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, firstPurchasedTicketLabel);
				springLayout.putConstraint(SpringLayout.SOUTH, label, (-371 + i*60), SpringLayout.SOUTH, userAccountPageFrame.getContentPane());

				// display
				try {
					File image = new File("images/" + purchasedTicketsList.get(i).getIMGpath() +".jpg");
					if (image.exists()){
						System.out.println("exists");
					}
					BufferedImage travisScott = ImageIO.read(image);
					ImageIcon icon = new ImageIcon(travisScott);
					label.setIcon(icon);
				} catch(Exception e) {
					e.printStackTrace();
				}
				userAccountPageFrame.getContentPane().add(label);
				
				
			}
			
		}
		
		
		
	}
	
	
}