package S3;

public class Card {
	
	private String cardName;
	private String cardType;
	private String player;

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
	
	public void setPlayer(String player)
	{
		this.player = player;
	}
	
	public String getPlayer()
	{
		return player;
	}
}
