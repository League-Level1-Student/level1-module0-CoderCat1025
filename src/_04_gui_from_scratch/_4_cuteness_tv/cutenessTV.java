package _04_gui_from_scratch._4_cuteness_tv;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class cutenessTV implements ActionListener {
JFrame frame = new JFrame();
JButton button1 = new JButton("duck");
JButton button2 = new JButton("frog");
JButton button3 = new JButton("unicorn");
JPanel panel = new JPanel();
public void run() {
	panel.add(button1);
	panel.add(button2);
	panel.add(button3);
	frame.add(panel);
	frame.pack();
	button1.addActionListener(this);
	button2.addActionListener(this);;
	button3.addActionListener(this);
	frame.setVisible(true);
}


void showDucks() {
     playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
}

void showFrog() {
     playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
}

void showFluffyUnicorns() {
     playVideo("https://www.youtube.com/watch?v=a-xWhG4UU_Y");
}

void playVideo(String videoID) {
     
     // Workaround for Linux because "Desktop.getDesktop().browse()" doesn't
     //work on some Linux implementations
     try {
     if (System.getProperty("os.name").toLowerCase().contains("linux")) {
     if (Runtime.getRuntime().exec(new String[] {
      "which", "xdg- open" }).getInputStream().read() != -1) {
     Runtime.getRuntime().exec(new String[] { "xdg-open", videoID });
     }
     } else {
          URI uri = new URI(videoID);
          java.awt.Desktop.getDesktop().browse(uri);
     }      } catch (Exception e) {
          e.printStackTrace();
     }
}

@Override
public void actionPerformed(ActionEvent e) {
JButton buttonClicked = (JButton) e.getSource();

if (buttonClicked == button1) {
	showDucks();
}
if (buttonClicked == button2) {
	showFrog();
}
if (buttonClicked == button3) {
	showFluffyUnicorns();
}
}
}
