package garlic;


public class Room {

	private final String name;
	private final Coordinates weaponPosition;

	private final Coordinates door1;
	private final Coordinates door2;
	private final Coordinates door3;
	private final Coordinates door4;
	private final Coordinates secretPassage;
	private final Coordinates door1Exit;
	private final Coordinates door2Exit;
	private final Coordinates door3Exit;
	private final Coordinates door4Exit;
	



	Room(String name,Coordinates weaponPosition, 
			Coordinates door1, Coordinates door2,
			Coordinates door3, Coordinates door4, Coordinates secretPassage,
			Coordinates door1Exit, Coordinates door2Exit,
			Coordinates door3Exit, Coordinates door4Exit)
	{
		this.name = name;
		this.weaponPosition = weaponPosition;

		this.door1 = door1;
		this.door2 = door2;
		this.door3 = door3;
		this.door4 = door4;
		this.secretPassage = secretPassage;
		this.door1Exit = door1Exit;
		this.door2Exit = door2Exit;
		this.door3Exit = door3Exit;
		this.door4Exit = door4Exit;
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
	public Coordinates getDoor1Exit()
	{
		return door1Exit;
	}
	public Coordinates getDoor2Exit()
	{
		return door2Exit;
	}
	public Coordinates getDoor3Exit()
	{
		return door3Exit;
	}
	public Coordinates getDoor4Exit()
	{
		return door4Exit;
	}
}
