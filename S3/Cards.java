package S3;

public class Cards {
	//superclass of all cards
	
	public static int cardNum;
	
	public Cards(int cardNum) {
		this.cardNum=cardNum++;
	}
	
	public int getCardNum(){
		return cardNum;
	}
	
}
