
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SoekePanel extends JPanel implements ActionListener {
	
	private SoekeLogikk soekeLogikk = new SoekeLogikk();
	private String soekeStreng;
	private String[] resultatListe = new String[5];
	private JTextField soekeFelt;
	private JComboBox nedtrekksResultatListe = new JComboBox();
	
	public SoekePanel() {
		this.soekeFelt = new JTextField(30);
		this.add(soekeFelt);	
		
		JButton soekeKnapp = new JButton("Søk");
		this.add(soekeKnapp);
		soekeKnapp.addActionListener(this);
		
		nedtrekksResultatListe = new JComboBox(resultatListe);
		nedtrekksResultatListe.setSelectedIndex(0);
		//nedtrekksResultatListe.addActionListener(this);
		
		this.add(nedtrekksResultatListe);		
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
			
			nedtrekksResultatListe.addItem(soekeStreng);
		}
		
	}

}
