import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class BonusPanel extends JPanel {

	BonusPanel() {
		setBackground(Color.DARK_GRAY);			
		setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.BLACK));		
		JLabel bonusLabel = new JLabel("Tilleggsdata");
		bonusLabel.setForeground(Color.ORANGE);
		
		this.add(bonusLabel);
		
	}
	
//	public void skrivBonusInfo(BonusInfo bi) {
//		System.out.println("Bonusinfo kommer etterhvert");
//	}
}