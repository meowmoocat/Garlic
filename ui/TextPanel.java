package ui;

/* created by Garlic
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextPanel extends JPanel
{

	JTextField textField;

	public TextPanel()
	{

		textP();
	}

	private void textP()
	{

		textField = new JTextField(50); //creates input field of 50 visible characters

		textField.setText("Click Board to move Scarlett and spanner!!"); //sets text for text field



		this.add(textField, BorderLayout.SOUTH); //adds and sets location


		//action listener that moves text to text area when return is pressed
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredText = textField.getText();
				InfoPanel.textArea.append(enteredText + "\n");

			}
		});
	}

}
