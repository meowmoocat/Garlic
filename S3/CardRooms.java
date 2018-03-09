package S3;

public class CardRooms extends Cards{
	
	private String type = "room";

	public CardRooms(String name) {
		super(name);
	}
		
	public String getType() {
		return type;
	}
}