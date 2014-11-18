import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GeografiPanel extends JPanel {
	GeografiPanel() {
		setBackground(Color.RED);
		JButton geografiKnapp = new JButton("Her kommer geografidata etterhvert");
		this.add(geografiKnapp);
	}
}
