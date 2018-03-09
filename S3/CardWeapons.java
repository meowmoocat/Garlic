package S3;

public class CardWeapons extends Cards{
	
	private String type = "weapon";
	public String weaponName;

	public CardWeapons(String name) {
		super(name);
		this.weaponName=name;
	}
	
	public String getWeaponName() {
		return weaponName;
	}
	
	public String getType() {
		return type;
	}
}
