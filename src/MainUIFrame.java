import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.io.*;


public class MainUIFrame {

	private JFrame frame;
	private boolean userValidated;
	private boolean accountValidated;
	private boolean creditCardValidated;
	private String selectedDateAndBandItem;
	private String selectedSeatItem;
	

	public boolean getUserValidated() {
		return userValidated;
	}

	public void setUserValidated(Boolean userValidated) {
		this.userValidated = userValidated;
	}

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
	public static void writingPassword(String password, String email) throws IOException {
		FileWriter fileWriter = new FileWriter("./"+ email + "/" + "password.txt");
		fileWriter.write(password);
		fileWriter.close();
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
		
		
		
		//upcoming events label
		JLabel upcomingEventsLabel = new JLabel("Upcoming Events");
		springLayout.putConstraint(SpringLayout.NORTH, upcomingEventsLabel, 127, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, upcomingEventsLabel, 130, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(upcomingEventsLabel);
		
		//band name labels
		JLabel firstBandNameLabel = new JLabel("Band Name");
		springLayout.putConstraint(SpringLayout.NORTH, firstBandNameLabel, 8, SpringLayout.SOUTH, upcomingEventsLabel);
		springLayout.putConstraint(SpringLayout.WEST, firstBandNameLabel, 189, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, firstBandNameLabel, -792, SpringLayout.EAST, frame.getContentPane());
		firstBandNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(firstBandNameLabel);
		
		JLabel secondBandNameLabel = new JLabel("Band Name");
		springLayout.putConstraint(SpringLayout.NORTH, secondBandNameLabel, 201, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, secondBandNameLabel, 189, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, firstBandNameLabel, -4, SpringLayout.NORTH, secondBandNameLabel);
		springLayout.putConstraint(SpringLayout.EAST, secondBandNameLabel, -792, SpringLayout.EAST, frame.getContentPane());
		secondBandNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(secondBandNameLabel);
		
		JLabel thirdBandNameLabel = new JLabel("Band Name");
		springLayout.putConstraint(SpringLayout.NORTH, thirdBandNameLabel, 255, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, secondBandNameLabel, -6, SpringLayout.NORTH, thirdBandNameLabel);
		springLayout.putConstraint(SpringLayout.WEST, thirdBandNameLabel, 189, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, thirdBandNameLabel, -792, SpringLayout.EAST, frame.getContentPane());
		thirdBandNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(thirdBandNameLabel);
		
		JLabel fourthBandNameLabel = new JLabel("Band Name");
		springLayout.putConstraint(SpringLayout.NORTH, fourthBandNameLabel, 307, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, fourthBandNameLabel, -225, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, thirdBandNameLabel, -6, SpringLayout.NORTH, fourthBandNameLabel);
		springLayout.putConstraint(SpringLayout.WEST, fourthBandNameLabel, 189, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, fourthBandNameLabel, -792, SpringLayout.EAST, frame.getContentPane());
		fourthBandNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(fourthBandNameLabel);
		
		//featured events label
		JLabel featuredEventsLabel = new JLabel("Featured Events");
		springLayout.putConstraint(SpringLayout.NORTH, featuredEventsLabel, 0, SpringLayout.NORTH, upcomingEventsLabel);
		springLayout.putConstraint(SpringLayout.WEST, featuredEventsLabel, 123, SpringLayout.EAST, upcomingEventsLabel);
		springLayout.putConstraint(SpringLayout.EAST, featuredEventsLabel, -629, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(featuredEventsLabel);
		
		//date labels
		JLabel firstDateLabel = new JLabel("June 5");
		springLayout.putConstraint(SpringLayout.NORTH, firstDateLabel, 23, SpringLayout.SOUTH, upcomingEventsLabel);
		springLayout.putConstraint(SpringLayout.EAST, firstDateLabel, -15, SpringLayout.WEST, firstBandNameLabel);
		frame.getContentPane().add(firstDateLabel);
		
		JLabel secondDateLabel = new JLabel("June 12");
		springLayout.putConstraint(SpringLayout.NORTH, secondDateLabel, 34, SpringLayout.SOUTH, firstDateLabel);
		springLayout.putConstraint(SpringLayout.EAST, secondDateLabel, -15, SpringLayout.WEST, secondBandNameLabel);
		frame.getContentPane().add(secondDateLabel);
		
		JLabel thirdDateLabel = new JLabel("June 19");
		springLayout.putConstraint(SpringLayout.SOUTH, thirdDateLabel, -290, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, thirdDateLabel, -15, SpringLayout.WEST, thirdBandNameLabel);
		frame.getContentPane().add(thirdDateLabel);
		
		JLabel fourthDateLabel = new JLabel("June 26");
		springLayout.putConstraint(SpringLayout.NORTH, fourthDateLabel, 35, SpringLayout.SOUTH, thirdDateLabel);
		springLayout.putConstraint(SpringLayout.EAST, fourthDateLabel, -15, SpringLayout.WEST, fourthBandNameLabel);
		frame.getContentPane().add(fourthDateLabel);
		
		
		JLabel signInToBookAndPurchaseTicketsLabel = new JLabel("SIGN IN TO BOOK AND PURCHASE TICKETS");
		springLayout.putConstraint(SpringLayout.NORTH, signInToBookAndPurchaseTicketsLabel, 66, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, signInToBookAndPurchaseTicketsLabel, 20, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, signInToBookAndPurchaseTicketsLabel, -15, SpringLayout.NORTH, upcomingEventsLabel);
		springLayout.putConstraint(SpringLayout.EAST, signInToBookAndPurchaseTicketsLabel, 383, SpringLayout.WEST, frame.getContentPane());
		signInToBookAndPurchaseTicketsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(signInToBookAndPurchaseTicketsLabel);
		
		JLabel comboBoxLabel = new JLabel("Select a date or band to book or purhcase a ticket for:");
		springLayout.putConstraint(SpringLayout.NORTH, comboBoxLabel, -166, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBoxLabel, 76, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, comboBoxLabel, -150, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(comboBoxLabel);
		comboBoxLabel.setVisible(false);
		
		JButton proceedToCheckoutButton = new JButton("Click here when ready to checkout");
		springLayout.putConstraint(SpringLayout.NORTH, proceedToCheckoutButton, -65, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, proceedToCheckoutButton, 353, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, proceedToCheckoutButton, -36, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(proceedToCheckoutButton);
		proceedToCheckoutButton.setVisible(false);
		
		String[] dropDownMenuItemsForDateAndBand = { "Date : Band", firstDateLabel.getText() + " : " + firstBandNameLabel.getText(), secondDateLabel.getText() + " : " + secondBandNameLabel.getText(), thirdDateLabel.getText() + " : " + thirdBandNameLabel.getText(), 
				fourthDateLabel.getText() + " : " + fourthBandNameLabel.getText() };
		
		DefaultComboBoxModel<String> comboModelForDateAndBandDropDownMenu = new DefaultComboBoxModel<String>(dropDownMenuItemsForDateAndBand);
		
		
		JComboBox dateAndBandComboBox = new JComboBox(comboModelForDateAndBandDropDownMenu);
		springLayout.putConstraint(SpringLayout.NORTH, dateAndBandComboBox, 6, SpringLayout.SOUTH, comboBoxLabel);
		springLayout.putConstraint(SpringLayout.WEST, dateAndBandComboBox, 96, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, dateAndBandComboBox, 403, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(dateAndBandComboBox);
		dateAndBandComboBox.setVisible(false);
		
		String[] dropDownMenuItemsForSeating = {"Row#,Seat#,Price", "Row1,Seat1,$20", "Row1,Seat2,$20", "Row1,Seat3,$20", "Row1,Seat,4,$20", "Row1,Seat5,$20", "Row1,Seat6,$20"};
		
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
				
				/*
				
				if(selectedDateAndBandItem == "Date : Band") {
					
					JOptionPane.showMessageDialog(frame, "Error! Please choose a valid Date/Band and Seat.", null, JOptionPane.ERROR_MESSAGE);
					System.out.println("error");
				}
				
				*/
				
				System.out.println(selectedDateAndBandItem);
				
				/*
				if(selectedDateAndBandItem.equals(firstDateLabel.getText() + " : " + firstBandNameLabel.getText())) {
					
					System.out.println("success");
					dateAndBandSelected = firstDateLabel.getText() + " : " + firstBandNameLabel.getText();
					
				}else if(selectedDateAndBandItem.equals(secondDateLabel.getText() + " : " + secondBandNameLabel.getText())) {
					
					dateAndBandSelected = secondDateLabel.getText() + " : " + secondBandNameLabel.getText();
					
				}else if(selectedDateAndBandItem.equals(thirdDateLabel.getText() + " : " + thirdBandNameLabel.getText())) {
					
					dateAndBandSelected = thirdDateLabel.getText() + " : " + thirdBandNameLabel.getText();
					
				}else if(selectedDateAndBandItem.equals(fourthDateLabel.getText() + " : " + fourthBandNameLabel.getText())) {
					
					dateAndBandSelected = fourthDateLabel.getText() + " : " + fourthBandNameLabel.getText();
					
				}
				*/
				
				
				seatingComboBox.setVisible(true);
				
				
				
			}
			
			
			
		});
		
		seatingComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectedSeatItem = (String) seatingComboBox.getSelectedItem();
				
				System.out.println(selectedSeatItem);
				
				/*
				
				if(selectedSeatItem == "Row#,Seat#,Price") {
					
					JOptionPane.showMessageDialog(frame, "Error! Please choose a valid Date/Band and Seat.", null, JOptionPane.ERROR_MESSAGE);
					
					
				}
 				
				*/
				
				proceedToCheckoutButton.setVisible(true);
				
			}
			
		});
		
		proceedToCheckoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if((selectedDateAndBandItem == "Date : Band") || (selectedSeatItem == "Row#,Seat#,Price")) {
					
					JOptionPane.showMessageDialog(frame, "Error! Please choose a valid Date/Band and Seat.", null, JOptionPane.ERROR_MESSAGE);
					
				}else {
					
					JTextField creditCardNumberField = new JTextField();
					JTextField firstNameCreditCardField = new JTextField();
					JTextField lastNameCreditCardField = new JTextField();
					JTextField expiryMonthCreditCardField = new JTextField();
					JTextField cvcCreditCardField = new JTextField();
					String paymentDialogMessage = "Please enter your card number, first name, last name, expiry month, and CVC";
					int creditCardResult = JOptionPane.showOptionDialog(frame, new Object[] {paymentDialogMessage, creditCardNumberField, firstNameCreditCardField, lastNameCreditCardField, expiryMonthCreditCardField, cvcCreditCardField}, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, paymentDialogMessage);   
					
					if((creditCardResult == JOptionPane.OK_OPTION) && (cardInfoValidated())) {
				
						
						String confirmPurchaseMessage = "Confirm Purchase of: '" + selectedDateAndBandItem + "', seat number: '" + selectedSeatItem + "' ?";
						
						int confirmPurchaseResult = JOptionPane.showConfirmDialog(frame, new Object[] {confirmPurchaseMessage}, null, JOptionPane.YES_NO_OPTION);
						
						if(confirmPurchaseResult == JOptionPane.YES_OPTION) {
							
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
				
				String createAccountMessage = "Please enter your first name, last name, email, password, and retyped password";
				
				int createAccountResult = JOptionPane.showOptionDialog(frame, new Object[] {createAccountMessage, firstNameFieldCA,  lastNameFieldCA,  emailFieldCA,  passwordFieldCA,  retypePasswordFieldCA}, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, createAccountMessage);
				
				
				
				if((createAccountResult == JOptionPane.OK_OPTION) && checkIfAccountCreated()) {

					// create directory for email
					File file = new File(emailFieldCA.getText());
					if (!file.exists()) {
						if (file.mkdir()) {

							System.out.println("Directory is created!");
						} else {
							System.out.println("Failed to create directory!");
						}
					}
					
					// save password in textfile
    				String fileContent = "Hello Learner !! Welcome to howtodoinjava.com.";
    				try {
						writingPassword(passwordFieldCA.getText(), emailFieldCA.getText());
					}
					catch(IOException error){
						error.printStackTrace();
					}
					System.out.println(firstNameFieldCA.getText() + " " + lastNameFieldCA.getText() + " " + emailFieldCA.getText() + " " +
							new String(passwordFieldCA.getPassword()) + " " + new String(retypePasswordFieldCA.getPassword()));
					
					JLabel signedInAsLabel = new JLabel("Signed in as: " + " '" + emailFieldCA.getText() + "' ");
					springLayout.putConstraint(SpringLayout.NORTH, signedInAsLabel, 20, SpringLayout.NORTH, frame.getContentPane());
					springLayout.putConstraint(SpringLayout.WEST, signedInAsLabel, 55, SpringLayout.EAST, createAccountButton);
					frame.getContentPane().add(signedInAsLabel);
					
					comboBoxLabel.setVisible(true);
					dateAndBandComboBox.setVisible(true);
					signInToBookAndPurchaseTicketsLabel.setVisible(false);
					
				}else if((createAccountResult == JOptionPane.OK_OPTION) && !(checkIfAccountCreated())) {
					
					JOptionPane.showMessageDialog(null, "Error: an account with this email already exists. Please try again.");
				
				
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
				String signInMessage = "Please enter your email and password.";
				int result = JOptionPane.showOptionDialog(frame, new Object[] {signInMessage,  emailField,  passwordField}, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, signInMessage);
				
				
				if((result == JOptionPane.OK_OPTION) && (checkIfUserValidated())) {
					
					
					
					System.out.println(emailField.getText() + " " + new String(passwordField.getPassword()));
					
					
					
					JLabel signedInAsLabel = new JLabel("Signed in as: " + " '" + emailField.getText() + "' ");
					springLayout.putConstraint(SpringLayout.NORTH, signedInAsLabel, 20, SpringLayout.NORTH, frame.getContentPane());
					springLayout.putConstraint(SpringLayout.WEST, signedInAsLabel, 55, SpringLayout.EAST, createAccountButton);
					frame.getContentPane().add(signedInAsLabel);
					
					comboBoxLabel.setVisible(true);
					dateAndBandComboBox.setVisible(true);
					signInToBookAndPurchaseTicketsLabel.setVisible(false);
					
					
				}else if((result == JOptionPane.OK_OPTION) && !(checkIfUserValidated())) {
					
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
		
		
	}
	/**
	 * Check for sign in validation by checking database for the account that matches the email and password that was input
	 * @return Boolean for whether or not the the user validation was successful
	 */
	public Boolean checkIfUserValidated() {
		
		userValidated = true;
		
		//get email from textbox
		
		return userValidated;
		
	}
	/**
	 * Check for account validation by confirming the inputs are valid and there is no existent account that has the same information as the input
	 * @return Boolean for whether or not the account was created successfully
	 */
	public boolean checkIfAccountCreated() {
		
		accountValidated = true;
		
		return accountValidated;
		
	}
	
	
	/**
	 * Check that the card info input by the user is valid (correct digits in the card/CVC code is 3 characters
	 * @return Boolean for whether or not the account is validated successfully
	 */
	public boolean cardInfoValidated() {
		
		creditCardValidated = true;
		
		return creditCardValidated;
		
	}
	
	
}
