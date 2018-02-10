package ui;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

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

		textField = new JTextField(50);

		textField.setText("");



		this.add(textField, BorderLayout.SOUTH);


		//action listener that moves text to text area when return is pressed
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enteredText = textField.getText();
				InfoPanel.textArea.append(enteredText + "\n");
				textField.setText("");
			}
		});
	}



}
