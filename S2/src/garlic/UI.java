package garlic;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.awt.BorderLayout;
import javax.swing.*;

public class UI {

	private static final int FRAME_WIDTH = 1095;
	private static final int FRAME_HEIGHT = 700;

	private final BoardPanel boardPanel;
	private final InfoPanel infoPanel = new InfoPanel();
	private final CommandPanel commandPanel = new CommandPanel();

	//adds boardPanel, infoPanel and commandPanel to jFrame in correct board layout
	UI(Tokens characters, Weapons weapons) {
		JFrame frame = new JFrame();
		boardPanel = new BoardPanel(characters, weapons);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Cluedo");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(boardPanel, BorderLayout.LINE_START);
		frame.add(infoPanel, BorderLayout.LINE_END);
		frame.add(commandPanel,BorderLayout.PAGE_END);
		frame.setResizable(true);
		frame.setVisible(true);
	}

	//get command form commandPanel
	public String getCommand() {
		return commandPanel.getCommand();
	}

	//redraws board
	public void display() {
		boardPanel.refresh();
	}

	//emptys infoPanel
	public void refreshInfoPanel() {
		infoPanel.refresh();
	}

	//adds string to infoPanel
	public void displayString(String string) {
		infoPanel.addText(string);
	}
}
