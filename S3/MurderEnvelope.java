package S3;

import java.util.ArrayList;


public class MurderEnvelope {
	
	ArrayList<Card> cards = new ArrayList<Card>();

	Card murderToken;
	Card murderRoom;
	Card murderWeapon;

	//public void RandomSuspect() {
	//	number = rand.nextInt(6);
	
	MurderEnvelope()
	{
//		System.out.println("token: "+murderToken.getCardName());
//		System.out.println("weapon: "+murderWeapon.getCardName());
//		System.out.println("room: "+murderRoom.getCardName());
		
		int i=0;
		for(Card card : cards)
		{
			System.out.println(i + card.getCardName());
			i++;
		}
		
	}
	
	

}
