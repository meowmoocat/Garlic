package garlic;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class InfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int TEXT_AREA_HEIGHT = 40;
	private static final int CHARACTER_WIDTH = 60;
	private static final int FONT_SIZE = 12;

	private final JTextArea textArea  = new JTextArea(TEXT_AREA_HEIGHT, CHARACTER_WIDTH);

	//creates text area to print commands to
	InfoPanel() {
		JScrollPane scrollPane = new JScrollPane(textArea);
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		textArea.setEditable(false);
		textArea.setFont(new Font("monospaced", Font.PLAIN, FONT_SIZE));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
	}

	//adds text to text area
	public void addText(String text) {
		textArea.setText(textArea.getText()+"\n"+text);
	}

	//emptys text area
	public void refresh() {
		textArea.setText("");
	}

}
