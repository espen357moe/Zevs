import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MeteorologiPanel extends JPanel {
	
	MeteorologiPanel() {
		setBackground(Color.DARK_GRAY);
		setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.BLACK));
		JLabel meteorologiLabel = new JLabel("Meteorologiske data");
		this.add(meteorologiLabel);
	}
	
	public void skrivMeteorologiInfo(MeteorologiInfo mi) {
		System.out.println("Geografiinfo kommer etterhvert");
	}

}
