import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SoekePanel extends JPanel {
	
	private SoekeLogikk soekeLogikk = new SoekeLogikk();
	
	public SoekePanel() {
		JTextField soekeFelt = new JTextField(10);
		this.add(soekeFelt);
		
		JButton soekeKnapp = new JButton("Søk");
		this.add(soekeKnapp);
	}

}
