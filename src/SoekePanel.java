import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SoekePanel extends JPanel {
	SoekePanel() {
		JTextField soekeFelt = new JTextField(10);
		this.add(soekeFelt);
		
		JButton soekeKnapp = new JButton("S�k");
		this.add(soekeKnapp);
	}

}
