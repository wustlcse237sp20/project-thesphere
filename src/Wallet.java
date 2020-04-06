public class Wallet{
	private Ticket[] tickets
	private int rewardPoints;
	private String cardNum;
	private String cardName;
	private String cardExpDate;
	private int cardZip;
	private int cardSecurityCode;

	public Wallet(){
		//sql stuff here since no wallet info should be coming from db
	}

	public void updateInfo(String newNum, String newName, String newExpDate, int newZip, int newSecCode){
		this.cardNum = newNum;
		this.cardName = newName;
		this.cardExpDate = newExpDate;
		this.cardZip = newZip;
		this.cardSecurityCode = newSecCode;

		//sql update
	}


}