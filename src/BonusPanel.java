import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class BonusPanel extends JPanel {

	BonusPanel() {
		setBackground(Color.LIGHT_GRAY);		
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder(getBorder(), "Tilleggsdata");
		title.setTitleJustification(TitledBorder.RIGHT);
		setBorder(title);
		




		JLabel bonusLabel = new JLabel("Tilleggsdata");
		this.add(bonusLabel);
		
	}
	
//	public void skrivBonusInfo(BonusInfo bi) {
//		System.out.println("Bonusinfo kommer etterhvert");
//	}
}