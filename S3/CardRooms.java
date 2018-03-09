package S3;

public class CardRooms extends Cards{
	
	private String type = "room";
	public String roomName;

	public CardRooms(String name) {
		super(name);
		this.roomName=name;
	}
	
	public String getRoomName() {
		return roomName;
	}
}
