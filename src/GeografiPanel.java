import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GeografiPanel extends JPanel {

	GeografiPanel() {
		setBackground(Color.DARK_GRAY);
		setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.BLACK));
		JLabel geografiLabel = new JLabel("Geografiske data");
		geografiLabel.setForeground(Color.ORANGE);
		this.add(geografiLabel);
		
	}
	
	public void skrivGeografiInfo(GeografiInfo gi) {
		System.out.println("Geografiinfo kommer etterhvert");
	}
}

