package ui;
import classes.*;
import java.awt.*;
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

public class UserAccountPage {

	private JFrame userAccountPageFrame;
	private String purchasedTicket;
	private String signedInEmail;
	private String signedInName;
	private List<Ticket> purchasedTicketsList;
	private int numberOfPurchasedTickets;
	private User loggedInUser;


	


	public UserAccountPage(String signedInName, List<Ticket> purchasedTicketsList, User user) {
		
		super();
		this.signedInName = signedInName;
		this.purchasedTicketsList = purchasedTicketsList;
		this.loggedInUser = user;
		initialize();
		
	}
	
	public UserAccountPage(String signedInEmail, User user) {
		
		super();
		this.signedInName = signedInEmail;
		this.loggedInUser = user;
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
	
	public void loadTickets(SpringLayout springLayout, JFrame frame) {
		JLabel upcomingTicketsLabel = new JLabel("Your Upcoming Tickets: " + numberOfPurchasedTickets);
		springLayout.putConstraint(SpringLayout.NORTH, upcomingTicketsLabel, -435, SpringLayout.SOUTH, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, upcomingTicketsLabel, 75, SpringLayout.WEST, userAccountPageFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, upcomingTicketsLabel, -419, SpringLayout.SOUTH, userAccountPageFrame.getContentPane());
		upcomingTicketsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		userAccountPageFrame.getContentPane().add(upcomingTicketsLabel);
		
		// scroller
		JPanel panelScroll = new JPanel();

		
		for (int i = 0; i < loggedInUser.getTickets().size(); i++) {
			JLabel artistLabel = new JLabel(loggedInUser.getTickets().get(i).getDateAndBand());
			springLayout.putConstraint(SpringLayout.NORTH, artistLabel, 8, SpringLayout.SOUTH, upcomingTicketsLabel);
			springLayout.putConstraint(SpringLayout.WEST, artistLabel, 100 + 330*i, SpringLayout.WEST, frame.getContentPane());
			artistLabel.setHorizontalAlignment(SwingConstants.CENTER);
			JLabel dateLabel = new JLabel("June "+ (5+7*i));
			dateLabel.setVisible(false);

			try {
				File image = new File("images/"+ loggedInUser.getTickets().get(i).getIMGpath() +".jpg");
				System.out.println("found image");
				BufferedImage buffered_image = ImageIO.read(image);
				ImageIcon icon = new ImageIcon(buffered_image);
				artistLabel.setIcon(icon);
			} catch(Exception e) {
				e.printStackTrace();
			}
			panelScroll.add(artistLabel);
			frame.getContentPane().add(dateLabel);
		}
		
		// side scroller

		JScrollPane scrollPane = new JScrollPane(panelScroll);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setBounds(100,100, 600,350);
		
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(1400,400));
		contentPane.add(scrollPane);
		frame.getContentPane().add(contentPane);
	}
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
		
		loadTickets(springLayout, userAccountPageFrame);
		
		try {
			
			numberOfPurchasedTickets = purchasedTicketsList.size();
			
		}
		
		catch(Exception e) {
			
			numberOfPurchasedTickets = 0;
			
		}
		
		
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