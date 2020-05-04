# cse237-project

To Run Program:

- Eclipse: Open the entire repo folder in Eclipse and run the file "MainUIFrame.java". 

- Terminal: "cd" to the directory that the repo is cloned to, cd into the head directory (wheree the file 'theSphere.jar' is located), and run 'java -jar theSphere.jar'.

Iteration 2:

- What user stories were completed this iteration?
	
	The account creation and login logic has been completed and now utilizes the User class to move back end functionality out of the UI class. The UI has been updated with code for ticket purchasing.

- What user stories do you intend to complete next iteration?
	
	Next iteration, we intend to complete the Event and Ticket classes, which are already started in development branches, to round out the back end support of purchasing tickets. Time permitting we will begin adding functionality to the Wallet class.

- Is there anything that you implemented but doesn't currently work?
	
	The front-end code for purchasing tickets is in place but there is no back-end code to provide any functionality behind that.
	
	
Iteration 3:

- What user stories were completed this iteration?
	
	Ticket and wallet functionality was added with the user class. Integrated input/output system with the event and wallet classes to update "database" between app sessions. Added more events to our upcoming events. Include ticket information display on profile page. Cleaned up the presentation of the site a little by adding and removing JLabels as needed. Improved credit card verification by verifying the following:
	1) Credit card is composed of 16 digits.
	2) The expiration date is valid (months between 0 and 12 and years between 0 and 99).
	3) The CVC is a 3 digit number.
Added default text to sign in, create account, and payment forms to help user know what information to put down in each field. 

- Is there anything that you implemented but doesn't currently work?
	
	Not as far as we know from our tests and our experience with the app. 

# Project Description
The Sphere is a concert venue; customers can go to our venue's website to view upcoming events and purchase tickets. Users can make an account and see all of their purchased tickets on the account page. The site also includes a points-based reward system: for each ticket purchase, users earn an amount of points that can go towards a discount on following ticket purchases
