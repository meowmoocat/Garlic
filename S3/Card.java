package S3;

public class Card {
	
	private String cardName;
	private String cardType;

	Card(String cardName, String cardType)
	{
		this.cardName = cardName;
		this.cardType = cardType;
	}
	
	public String getCardName()
	{
		return cardName;
	}
	
	public String getCardType()
	{
		return cardType;
	}
}
