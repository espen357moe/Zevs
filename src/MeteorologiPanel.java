import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MeteorologiPanel extends JPanel {
	
	MeteorologiPanel() {
		setBackground(Color.GREEN);
		JButton meteorologiKnapp = new JButton("Her kommer meteorologidata etterhvert");
		this.add(meteorologiKnapp);
	}
	
	public void skrivMeteorologiInfo(MeteorologiInfo mi) {
		System.out.println("Geografiinfo kommer etterhvert");
	}

}
