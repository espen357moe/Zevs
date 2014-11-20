import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SoekePanel extends JPanel implements ActionListener {
	
	private SoekeLogikk soekeLogikk = new SoekeLogikk();
	public String soekeStreng;	
	private JTextField soekeFelt;
	
	public SoekePanel() {
		this.soekeFelt = new JTextField(30);
		this.add(soekeFelt);	

		JLabel soekeTreffLabel = new JLabel();
		this.add(soekeTreffLabel);
		
		JButton soekeKnapp = new JButton("Søk");
		this.add(soekeKnapp);
		soekeKnapp.addActionListener(this);
	}	
	
	public String getSoekeStreng() {
		return soekeStreng;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		if(event.equals("Søk")) {
			soekeStreng = soekeFelt.getText();
			System.out.println("Søker etter - " + soekeStreng);
			soekeLogikk.startSoek(soekeStreng);
		}
		
	}

}
