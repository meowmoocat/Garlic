package  S3;

public class CardTokens extends Cards{
	
	private String type = "token";
	public String tokenName;

	public CardTokens(String name) {
		super(name);
		this.tokenName=name;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
	public String getType() {
		return type;
	}
}
