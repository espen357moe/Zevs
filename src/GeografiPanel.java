import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GeografiPanel extends JPanel {

	GeografiPanel() {
		setBackground(Color.RED);
		JButton geografiKnapp = new JButton("Her kommer geografiinfo etterhvert");
		this.add(geografiKnapp);
	}
	
	public void skrivGeografiInfo(GeografiInfo gi) {
		System.out.println("Geografiinfo kommer etterhvert");
	}
}

