package src.Garlic;



package src.Garlic;

import java.util.Random;

public class Roll {
	
	 static String roll = "";
	public static void roll() {
		   Random dice = new Random();
           do {
             Moves.ui.displayString("type roll to roll dice");
           	 roll = Moves.ui.getCommand();
           }while(!roll.equals("roll"));
          
           int n = dice.nextInt(10) + 2;
   		String numberAsString = Integer.toString(n);
   		Moves.ui.displayString(numberAsString);
          
	}

}
