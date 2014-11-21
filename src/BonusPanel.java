import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BonusPanel extends JPanel {

	BonusPanel() {
		setBackground(Color.DARK_GRAY);
		setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.BLACK));
		JLabel bonusLabel = new JLabel("Tilleggsdata");
		this.add(bonusLabel);
		
	}
	
//	public void skrivBonusInfo(BonusInfo bi) {
//		System.out.println("Bonusinfo kommer etterhvert");
//	}
}