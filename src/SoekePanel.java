import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SoekePanel extends JPanel implements ActionListener {
	
	private String soekeStreng;	
	
	SoekeLogikk soekeLogikk = new SoekeLogikk(soekeStreng);
	
	public SoekePanel() {
		JTextField soekeFelt = new JTextField(30);
		this.add(soekeFelt);
		
		JButton soekeKnapp = new JButton("Søk");
		this.add(soekeKnapp);
		
		soekeStreng = soekeFelt.getText();
	}
	
	public String getSoekeStreng() {
		return soekeStreng;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		if(event.equals("Søk")) {
			getSoekeStreng();	
			soekeLogikk.startSoek(soekeStreng);
		}
		
	}

}
