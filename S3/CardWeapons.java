package S3;

public class CardWeapons extends Cards{
	
	private String type = "weapon";

	public CardWeapons(String name) {
		super(name);
	}
		
	public String getType() {
		return type;
	}
}
