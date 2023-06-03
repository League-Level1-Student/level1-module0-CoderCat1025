package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FortuneCookie implements ActionListener {
public void showButton() {
	System.out.println("Button clicked");
	JFrame frame = new JFrame();
	frame.setVisible(true);
	JButton button = new JButton();
	frame.add(button);
	frame.pack();
	button.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	JOptionPane.showMessageDialog(null, "Woohoo");
	int rand = new Random().nextInt(5);
	if (rand == 1) {
		JOptionPane.showMessageDialog(null, "You will have bad luck.");
	}
	else {
		if (rand == 2) {
			JOptionPane.showMessageDialog(null, "You will have good luck.");
		}
		else {
			if (rand == 3 ) {
				JOptionPane.showMessageDialog(null,  "You won't have any bad or good luck.");
			}
			else {
				if (rand == 4) {
					JOptionPane.showMessageDialog(null, "You will have a little bad luck.");
				}
				else {
					if (rand == 5) {
						JOptionPane.showMessageDialog(null, "You will have a little good luck.");
					}
				}
			}
		}
	}
}
}
