import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GeografiPanel extends JPanel {

	GeografiPanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(new GridLayout(2,0));
		setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.BLACK));
		JLabel geografiLabel = new JLabel("Geografiske data");
		geografiLabel.setForeground(Color.ORANGE);
		this.add(geografiLabel);	
	}
	
	public void skrivGeografiInfo(GeografiInfo gi) {
		System.out.println("Geografiinfo kommer etterhvert");
	}
}

