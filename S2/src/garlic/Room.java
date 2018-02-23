package garlic;


public class Room {
	
	private final String name;
	private final Coordinates weaponPosition;
	
	private final Coordinates door1;
	private final Coordinates door2;
	private final Coordinates door3;
	private final Coordinates door4;
	private final Coordinates secretPassage;


	
	Room(String name,Coordinates weaponPosition, 
			Coordinates door1, Coordinates door2,
			Coordinates door3, Coordinates door4, Coordinates secretPassage)
	{
		this.name = name;
		this.weaponPosition = weaponPosition;

		this.door1 = door1;
		this.door2 = door2;
		this.door3 = door3;
		this.door4 = door4;
		this.secretPassage = secretPassage;
	}
	
	public String getName()
	{
		return name;
	}
	public Coordinates getWeaponPosition()
	{
		return weaponPosition;
	}

	public Coordinates getDoor1()
	{
		return door1;
	}
	public Coordinates getDoor2()
	{
		return door2;
	}
	public Coordinates getDoor3()
	{
		return door3;
	}
	public Coordinates getDoor4()
	{
		return door4;
	}
	public Coordinates getSecretPassage()
	{
		return secretPassage;
	}
}
