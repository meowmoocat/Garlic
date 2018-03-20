package S3;

/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

public class Card {

	private String cardName;
	private String cardType;
	private String player;	//stores player name or A for ownership

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
