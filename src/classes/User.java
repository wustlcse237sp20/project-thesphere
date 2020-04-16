package classes;
public class User {
	private String firstName;
	private String lastName;
	private String email;
	//Eventually put a wallet object here and in constructor


	public User(String first, String last, String emailAddress){
		this.firstName = first;
		this.lastName = last;
		this.email = emailAddress;

		//eventually an sql query here to get their wallet

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

}