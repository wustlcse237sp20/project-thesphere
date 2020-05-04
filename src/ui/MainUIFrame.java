package ui;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import classes.*;
import classes.Event;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MainUIFrame {

	private JFrame frame;
	private boolean creditCardValidated;
	private String selectedDateAndBandItem;
	private String selectedSeatItem;
	private User loggedInUser;
	private List<Event> eventList = new ArrayList<Event>();

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUIFrame window = new MainUIFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainUIFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setBounds(100, 100, 450, 300);
		//frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.setBounds(0, 0, 1100, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		//Get events
		File eventDir = new File("Events");
		for (File e : eventDir.listFiles()) {
			this.eventList.add(new Event(e.getName()));
		}
		
		// Set up labels:
		JLabel welcomeLabel = new JLabel("The Sphere: Concert Venue");
		welcomeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		springLayout.putConstraint(SpringLayout.NORTH, welcomeLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, welcomeLabel, -350, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(welcomeLabel);
		
		// upcoming events label
		JLabel upcomingEventsLabel = new JLabel("Upcoming Events");
		springLayout.putConstraint(SpringLayout.NORTH, upcomingEventsLabel, 80, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, upcomingEventsLabel, 100, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(upcomingEventsLabel);
		
		JLabel signInToBookAndPurchaseTicketsLabel = new JLabel("SIGN IN TO BOOK AND PURCHASE TICKETS");
		springLayout.putConstraint(SpringLayout.NORTH, signInToBookAndPurchaseTicketsLabel, 60, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, signInToBookAndPurchaseTicketsLabel, 100, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, signInToBookAndPurchaseTicketsLabel, 0, SpringLayout.NORTH, upcomingEventsLabel);
		signInToBookAndPurchaseTicketsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(signInToBookAndPurchaseTicketsLabel);
		
		JLabel comboBoxLabel = new JLabel("Select a date or band to book or purhcase a ticket for:");
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxLabel, -166, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxLabel, 76, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, comboBoxLabel, -150, SpringLayout.SOUTH, frame.getContentPane());

		frame.getContentPane().add(comboBoxLabel);
		comboBoxLabel.setVisible(false);
		
		final JLabel signedInAsLabel = new JLabel();
		springLayout.putConstraint(SpringLayout.NORTH, signedInAsLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, signedInAsLabel, -150, SpringLayout.EAST, frame.getContentPane());
		signedInAsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		frame.getContentPane().add(signedInAsLabel);
		signedInAsLabel.setVisible(false);
		
		JButton proceedToCheckoutButton = new JButton("Click here when ready to checkout");
		springLayout.putConstraint(SpringLayout.NORTH, proceedToCheckoutButton, -65, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, proceedToCheckoutButton, 353, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, proceedToCheckoutButton, -36, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(proceedToCheckoutButton);
		proceedToCheckoutButton.setVisible(false);
		
		JButton viewAccountButton = new JButton("Click Here to View Account");
		springLayout.putConstraint(SpringLayout.NORTH, viewAccountButton, -497, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, viewAccountButton, -468, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, viewAccountButton, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(viewAccountButton);
		viewAccountButton.setVisible(false);

		
		String[] dropDownMenuItemsForDateAndBand = { "Band : Date", eventList.get(1).getEventDate() + " : " + eventList.get(1).getArtist(),
				eventList.get(2).getEventDate() + " : " + eventList.get(2).getArtist(),
				eventList.get(3).getEventDate() + " : " + eventList.get(3).getArtist(),
				eventList.get(4).getEventDate() + " : " + eventList.get(4).getArtist(),
				eventList.get(5).getEventDate() + " : " + eventList.get(5).getArtist()};
		
		DefaultComboBoxModel<String> comboModelForDateAndBandDropDownMenu = new DefaultComboBoxModel<String>(dropDownMenuItemsForDateAndBand);
		
		JComboBox dateAndBandComboBox = new JComboBox(comboModelForDateAndBandDropDownMenu);
		springLayout.putConstraint(SpringLayout.NORTH, dateAndBandComboBox, 6, SpringLayout.SOUTH, comboBoxLabel);
		springLayout.putConstraint(SpringLayout.WEST, dateAndBandComboBox, 96, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, dateAndBandComboBox, 403, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(dateAndBandComboBox);
		dateAndBandComboBox.setVisible(false);
		
		for (int i = 1; i <=10;i++) {
			
		}
		String[] dropDownMenuItemsForSeating = new String[101];
		dropDownMenuItemsForSeating[0] = "Row#,Seat#,Price";
		int index = 1;
		for (int i = 1; i <=10;i++) {
			for (int j = 1; j <=10;j++) {

				dropDownMenuItemsForSeating[index] = "Row"+i+",Seat"+j+",$"+100/i;
				index++;
			}
		}
		
		DefaultComboBoxModel<String> comboModelForSeatingDropDownMenu = new DefaultComboBoxModel<String>(dropDownMenuItemsForSeating);
		
		
		JComboBox seatingComboBox = new JComboBox(comboModelForSeatingDropDownMenu);
		springLayout.putConstraint(SpringLayout.NORTH, seatingComboBox, -27, SpringLayout.SOUTH, dateAndBandComboBox);
		springLayout.putConstraint(SpringLayout.WEST, seatingComboBox, 100, SpringLayout.EAST, dateAndBandComboBox);
		springLayout.putConstraint(SpringLayout.SOUTH, seatingComboBox, 0, SpringLayout.SOUTH, dateAndBandComboBox);
		springLayout.putConstraint(SpringLayout.EAST, seatingComboBox, -359, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(seatingComboBox);
		seatingComboBox.setVisible(false);
		
		
		
		
		dateAndBandComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedDateAndBandItem = (String) dateAndBandComboBox.getSelectedItem();
				
				seatingComboBox.setVisible(true);	
			}
		});
		
		seatingComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedSeatItem = (String) seatingComboBox.getSelectedItem();
				
				proceedToCheckoutButton.setVisible(true);
			}
		});
		
		proceedToCheckoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if((selectedDateAndBandItem == "Band : Date") || (selectedSeatItem == "Row#,Seat#,Price")) {
					
					JOptionPane.showMessageDialog(frame, "Error! Please choose a valid Date/Band and Seat.", null, JOptionPane.ERROR_MESSAGE);
					
				}else {
					
					JTextField creditCardNumberField = new JTextField();
					JTextField firstNameCreditCardField = new JTextField();
					JTextField lastNameCreditCardField = new JTextField();
					JTextField expiryMonthCreditCardField = new JTextField();
					JTextField cvcCreditCardField = new JTextField();
					creditCardNumberField.setText("0000000000000000");
					firstNameCreditCardField.setText("First Name");
					lastNameCreditCardField.setText("Last Name");
					expiryMonthCreditCardField.setText("Expiration Date (MM/YY)");
					cvcCreditCardField.setText("CVC");
					
					String paymentDialogMessage = "Please enter your card number, first name, last name, expiry month, and CVC";
					int creditCardResult = JOptionPane.showOptionDialog(frame, new Object[] {paymentDialogMessage, creditCardNumberField, firstNameCreditCardField, lastNameCreditCardField, expiryMonthCreditCardField, cvcCreditCardField}, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, paymentDialogMessage);   
					
					if((creditCardResult == JOptionPane.OK_OPTION) && (cardInfoValidated(creditCardNumberField.getText(), expiryMonthCreditCardField.getText(), cvcCreditCardField.getText()))) {
				
						
						String confirmPurchaseMessage = "Confirm Purchase of: '" + selectedDateAndBandItem + "', seat number: '" + selectedSeatItem + "' ?";
						
						int confirmPurchaseResult = JOptionPane.showConfirmDialog(frame, new Object[] {confirmPurchaseMessage}, null, JOptionPane.YES_NO_OPTION);
						
						if(confirmPurchaseResult == JOptionPane.YES_OPTION) {



							String[] selected_string = selectedDateAndBandItem.split(": "); //event_id row seat
							String selected_artist = selected_string[1];
							String[] selected_string2 = selectedSeatItem.split(","); //event_id row seat
							String[] selected_string2_row = selected_string2[0].split("Row"); //event_id row seat
							String[] selected_string2_seat = selected_string2[1].split("Seat"); //event_id row seat
							int row = Integer.parseInt(selected_string2_row[1]);
							int seat = Integer.parseInt(selected_string2_seat[1]);
							

							Event selectedEvent = null;
							try {
								for (int i = 1; i < eventList.size(); i ++){
									if(eventList.get(i).getArtist().contentEquals(selected_artist)) {
										selectedEvent= eventList.get(i);
									}
								}
								// update wallet with ticket
								loggedInUser.getWallet().addTicket(selectedEvent.getEventID() + " " +row + " " +seat);
								
								// save user's wallet info in db
								loggedInUser.getWallet().saveTickets();
								
								// update event's seating info in db 
								selectedEvent.sellTicket(row, seat);
								selectedEvent.saveSeatsSold();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
							JOptionPane.getRootFrame().dispose();
							
							String confirmedPurchaseMessage = "Thank you for you purchase of: '" + selectedDateAndBandItem + "' ! Your seat number is: '" + selectedSeatItem + "'!";
							
							int confirmedPurchaseResult = JOptionPane.showConfirmDialog(frame, new Object[] {confirmedPurchaseMessage}, null, JOptionPane.OK_OPTION);
							
							if(confirmedPurchaseResult == JOptionPane.OK_OPTION) {
								
								JOptionPane.getRootFrame().dispose();
								
							}
							
						}else if(confirmPurchaseResult == JOptionPane.NO_OPTION) {
							
							JOptionPane.getRootFrame().dispose();
							
						}
					
					}else if(creditCardResult == JOptionPane.CANCEL_OPTION) {
						
						JOptionPane.getRootFrame().dispose();
						
					}

				}	
			}
			
		});
		
		//create account button and action listener; always visible on main frame
		JButton createAccountButton = new JButton("Create New Account");
		springLayout.putConstraint(SpringLayout.NORTH, createAccountButton, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, createAccountButton, -832, SpringLayout.EAST, frame.getContentPane());
		createAccountButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				JTextField firstNameFieldCA = new JTextField();
				JTextField lastNameFieldCA = new JTextField();
				JTextField emailFieldCA = new JTextField();
				JPasswordField passwordFieldCA = new JPasswordField();
				JPasswordField retypePasswordFieldCA = new JPasswordField();
				firstNameFieldCA.setText("First Name");
				lastNameFieldCA.setText("Last Name");
				emailFieldCA.setText("Email Address");
				passwordFieldCA.setText("Password");
				retypePasswordFieldCA.setText("Retype Password");

				
				String createAccountMessage = "Please enter your first name, last name, email, password, and retyped password";
				
				int createAccountResult = JOptionPane.showOptionDialog(frame, new Object[] {createAccountMessage, firstNameFieldCA,  lastNameFieldCA,  emailFieldCA,  passwordFieldCA,  retypePasswordFieldCA}, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, createAccountMessage);
				
				if(createAccountResult == JOptionPane.OK_OPTION) {
					if (firstNameFieldCA.getText().equals("") || lastNameFieldCA.getText().equals("") || emailFieldCA.getText().equals("") || passwordFieldCA.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Error: Please fill out each field");
					}
					else if (User.checkIfEmailUsed(emailFieldCA.getText())) {
						JOptionPane.showMessageDialog(null, "Error: an account with this email already exists. Please try again.");
					}
					else if(!String.valueOf(passwordFieldCA.getPassword()).equals(String.valueOf(retypePasswordFieldCA.getPassword()))) {
						JOptionPane.showMessageDialog(null, "Error: passwords do not match");
					}
					else {	    
	    				try {
							loggedInUser = User.createNewUser(firstNameFieldCA.getText(), lastNameFieldCA.getText(), emailFieldCA.getText(), String.valueOf(passwordFieldCA.getPassword()));
						}
						catch(IOException error){
							error.printStackTrace();
						}
						signedInAsLabel.setText("Signed in as: "+ loggedInUser.getName());
						signedInAsLabel.setVisible(true);
						
						comboBoxLabel.setVisible(true);
						dateAndBandComboBox.setVisible(true);
						signInToBookAndPurchaseTicketsLabel.setVisible(false);
						viewAccountButton.setVisible(true);
						createAccountButton.setVisible(false);
						}
					
				}else if(createAccountResult == JOptionPane.CANCEL_OPTION) {
					
					JOptionPane.getRootFrame().dispose();
					
				}			
			}});
		
		frame.getContentPane().add(createAccountButton);
		
		//sign in button and action listener; always visible on main frame
		JButton signInButton = new JButton("Sign In");
		springLayout.putConstraint(SpringLayout.WEST, createAccountButton, 15, SpringLayout.EAST, signInButton);
		
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				JTextField emailField = new JTextField();
				JPasswordField passwordField = new JPasswordField();
				
				emailField.setText("Email");
				passwordField.setText("Password");
				
				String signInMessage = "Please enter your email and password.";
				int result = JOptionPane.showOptionDialog(frame, new Object[] {signInMessage,  emailField,  passwordField}, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, signInMessage);

				if(result == JOptionPane.OK_OPTION && User.checkEmailAndPassword(emailField.getText(), String.valueOf(passwordField.getPassword()))) {
					loggedInUser = new User(emailField.getText());
					signedInAsLabel.setText("Signed in as: "+ loggedInUser.getName());
					signedInAsLabel.setVisible(true);
					
					comboBoxLabel.setVisible(true);
					dateAndBandComboBox.setVisible(true);
					signInToBookAndPurchaseTicketsLabel.setVisible(false);
					viewAccountButton.setVisible(true);
					signInButton.setVisible(false);
					
					
				}else if(result == JOptionPane.OK_OPTION && !User.checkEmailAndPassword(emailField.getText(), String.valueOf(passwordField.getPassword()))) {
					
					JOptionPane.showMessageDialog(null, "An account with this email and password does not exist. Try again.");
					
				}else if(result == JOptionPane.CANCEL_OPTION) {
					
					JOptionPane.getRootFrame().dispose();
					
				}				
			}
		});
		
		
		springLayout.putConstraint(SpringLayout.NORTH, signInButton, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, signInButton, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(signInButton);
	
		
		//Sign out button and action listener; always visible on main frame
		
		
		JButton signOutButton = new JButton("Sign out");
		springLayout.putConstraint(SpringLayout.NORTH, signOutButton, -568, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, signOutButton, -539, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, signOutButton, -10, SpringLayout.EAST, frame.getContentPane());
		signOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String message = "Are you sure you want to sign out?";
				
				int signOutResult = JOptionPane.showConfirmDialog(frame, new Object[] {message}, null, JOptionPane.YES_NO_OPTION);
				
				if(signOutResult == JOptionPane.YES_OPTION) {
					loggedInUser = null;
					frame.dispose();
					
					MainUIFrame f = new MainUIFrame();
					JFrame newMainFrame = f.getFrame();
					newMainFrame.setVisible(true);
					
					
				}else if(signOutResult == JOptionPane.NO_OPTION) {
					
					JOptionPane.getRootFrame().dispose();
					
				}		
			}
		});
		frame.getContentPane().add(signOutButton);
		
		
		
		viewAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(loggedInUser.getWallet().getTickets().isEmpty()) {
					
					UserAccountPage u = new UserAccountPage(loggedInUser.getName());
					JFrame userAccountFrame = u.getUserAccountPageFrame();
					userAccountFrame.setVisible(true);
					
				}else {
					
					UserAccountPage u = new UserAccountPage(loggedInUser.getName(), loggedInUser.getWallet().getTickets());
					JFrame userAccountFrame = u.getUserAccountPageFrame();
					userAccountFrame.setVisible(true);
					
				}
			
			}
			
		});
		
		
		// scroller
		JPanel panelScroll = new JPanel();

		for (int i = 1; i < eventList.size(); i++) {

			JLabel artistLabel = new JLabel();
			springLayout.putConstraint(SpringLayout.NORTH, artistLabel, 8, SpringLayout.SOUTH, upcomingEventsLabel);
			springLayout.putConstraint(SpringLayout.WEST, artistLabel, 100 + 330*i, SpringLayout.WEST, frame.getContentPane());
			artistLabel.setHorizontalAlignment(SwingConstants.CENTER);
			JLabel dateLabel = new JLabel("June "+ (5+7*i));
			dateLabel.setVisible(false);

			try {
				File image = new File("images/"+ eventList.get(i).getArtist() +".jpg");
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
	
	/**
	 * Check that the card info input by the user is valid (correct digits in the card/CVC code is 3 characters
	 * @return Boolean for whether or not the account is validated successfully
	 */
	public boolean cardInfoValidated(String creditCardNumberField, String expiryMonthCreditCardField,String cvcCreditCardField) {
		creditCardValidated = true;
		
		if (creditCardNumberField.length() != 16) {
			creditCardValidated = false;
		}

		try {
			Integer.parseInt(creditCardNumberField); 
		} catch(NumberFormatException e) { 
			JOptionPane.showMessageDialog(frame, "Error! Please enter a valid credit card number.", null, JOptionPane.ERROR_MESSAGE);
	        return false; 
	    } catch(NullPointerException e) {
			JOptionPane.showMessageDialog(frame, "Error! Please enter a valid credit card number.", null, JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

		try {
			String[] month_year = expiryMonthCreditCardField.split("/"); //event_id row seat
			int month = Integer.parseInt(month_year[0]);
			int year = Integer.parseInt(month_year[1]);
			if (month >= 0 && month <=12 && year <= 99 && year >=0) {

			}
			else {
				JOptionPane.showMessageDialog(frame, "Error! Please enter a expiration date.", null, JOptionPane.ERROR_MESSAGE);
				creditCardValidated = false;
			}
		} catch(NumberFormatException e) { 
			JOptionPane.showMessageDialog(frame, "Error! Please enter a valid expiration date.", null, JOptionPane.ERROR_MESSAGE);
	        return false; 
	    } catch(NullPointerException e) {
			JOptionPane.showMessageDialog(frame, "Error! Please enter a valid expiration date.", null, JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

		
		if (cvcCreditCardField.length() != 3) {
			JOptionPane.showMessageDialog(frame, "Error! Please enter a valid expiration date.", null, JOptionPane.ERROR_MESSAGE);
			creditCardValidated = false;
		}

		try {
			Integer.parseInt(cvcCreditCardField); 
		} catch(NumberFormatException e) { 
			JOptionPane.showMessageDialog(frame, "Error! Please enter a valid CVC.", null, JOptionPane.ERROR_MESSAGE);
	        return false;
	    } catch(NullPointerException e) {
			JOptionPane.showMessageDialog(frame, "Error! Please enter a valid CVC.", null, JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
		return creditCardValidated;
	}
}
