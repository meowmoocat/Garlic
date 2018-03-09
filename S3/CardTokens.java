package S3;

public class CardTokens extends Cards{
	
	private String type = "token";

	public CardTokens(String name) {
		super(name);
	}
	
	public String getType() {
		return type;
	}
}
