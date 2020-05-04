package ui;
import classes.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import java.awt.event.*;

public class UserAccountPage {

	private JFrame userAccountPageFrame;
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
		springLayout.putConstraint(SpringLayout.WEST, upcomingTicketsLabel, 25, SpringLayout.WEST, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, upcomingTicketsLabel, -419, SpringLayout.SOUTH, userAccountPageFrame.getContentPane());
		upcomingTicketsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		userAccountPageFrame.getContentPane().add(upcomingTicketsLabel);
		
		JLabel rowAndSeatLabel = new JLabel("Click on your ticket to display row and seat number:");
		springLayout.putConstraint(SpringLayout.NORTH, rowAndSeatLabel, 100, SpringLayout.NORTH, upcomingTicketsLabel);
		springLayout.putConstraint(SpringLayout.WEST, rowAndSeatLabel, 25, SpringLayout.WEST, userAccountPageFrame.getContentPane());

		rowAndSeatLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		userAccountPageFrame.getContentPane().add(rowAndSeatLabel);
		
		
		JLabel rowAndSeatInfo = new JLabel();
		springLayout.putConstraint(SpringLayout.NORTH, rowAndSeatInfo, 10, SpringLayout.SOUTH,rowAndSeatLabel);
		springLayout.putConstraint(SpringLayout.WEST, rowAndSeatInfo, 50, SpringLayout.WEST, userAccountPageFrame.getContentPane());

		userAccountPageFrame.getContentPane().add(rowAndSeatInfo);
		rowAndSeatInfo.setVisible(false);

		
		
		JLabel signedInAsLabel = new JLabel("Signed in as: " + signedInName);
		signedInAsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, signedInAsLabel, 10, SpringLayout.NORTH, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, signedInAsLabel, -150, SpringLayout.EAST, userAccountPageFrame.getContentPane());
		signedInAsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		userAccountPageFrame.getContentPane().add(signedInAsLabel);
		
		
		// scroller
		JPanel panelScroll = new JPanel();

		System.out.println(numberOfPurchasedTickets);
		for (int i = 0; i < numberOfPurchasedTickets; i++) {

			Ticket ticket = purchasedTicketsList.get(i);
			JLabel artistLabel = new JLabel();
			springLayout.putConstraint(SpringLayout.WEST, artistLabel, 100 + 330*i, SpringLayout.WEST, userAccountPageFrame.getContentPane());
			artistLabel.setHorizontalAlignment(SwingConstants.CENTER);
			artistLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					rowAndSeatInfo.setText("Row # " + ticket.getRow() + " Seat # " + ticket.getSeat());
					rowAndSeatInfo.setVisible(true);
				}
			});
			try {
				System.out.println(purchasedTicketsList.get(i).getEvent().getArtist());
				File image = new File("images/"+ purchasedTicketsList.get(i).getEvent().getArtist() +".jpg");
				System.out.println("found image");
				BufferedImage buffered_image = ImageIO.read(image);
				ImageIcon icon = new ImageIcon(buffered_image);
				artistLabel.setIcon(icon);
			} catch(Exception e) {
				e.printStackTrace();
			}

			panelScroll.add(artistLabel);
		}
		
		// side scroller

		JScrollPane scrollPane = new JScrollPane(panelScroll);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setBounds(450,80, 600,320);
		
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(1400,440));
		contentPane.add(scrollPane);
		userAccountPageFrame.getContentPane().add(contentPane);
		
		
		
	}
	
	
}