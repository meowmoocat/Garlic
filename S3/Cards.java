package S3;

public class Cards {
	//superclass of all cards
	
	public static int cardNum;
	public static String cardName;
	
	public Cards(int cardNum, String cardName) {
		this.cardNum=cardNum++;
		this.cardName=cardName;
	}
	
	public int getCardNum(){
		return cardNum;
	}
	
	public String getCardName(){
		return cardName;
	}

}
