package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SoekeTreff;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

import model.SoekeTreff;
import controller.SoekeLogikk;

public class SoekePanel extends JPanel implements ActionListener {
	
//	public String soekeResultatListe (SoekeTreff soekeTreff) {
//		String stedsNavn = soekeTreff.getStedsNavn();
//		System.out.println();
//		System.out.println();
//		System.out.println("Søkeresultat som skal inn i droppdown: " +stedsNavn);
//		return stedsNavn;
//		
//	}
	
	private SoekeLogikk soekeLogikk = new SoekeLogikk();

	private JTextField soekeFelt;
	private String soekeStreng;

	private String[] resultatListe = new String[5];
	private JComboBox nedtrekksResultatListe = new JComboBox();

	private String[] fullSoekeStreng = new String [5];
	private JComboBox listeOverSoek = new JComboBox();

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


		listeOverSoek = new JComboBox(fullSoekeStreng);
		listeOverSoek.setSelectedIndex(0);
		this.add(listeOverSoek);


	}	
	
	public String getSoekeStreng() {
		return soekeStreng;
	}
	
	public String getFullSoekeStreng(SoekeTreff soekeTreff) {	
		String fullSoekeStreng = soekeTreff.getStedsNavn();
		System.out.println("Skriver ut til liste boks under : "+fullSoekeStreng );

		return fullSoekeStreng;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		
		if(event.equals("Søk")) {
			System.out.println();
			System.out.println();
			soekeStreng = soekeFelt.getText();
			System.out.println("Søker etter - " + soekeStreng);
			try {
				soekeLogikk.startSoek(soekeStreng);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			nedtrekksResultatListe.addItem(soekeStreng);
			
			listeOverSoek.addItem(fullSoekeStreng);
		}
		
	}

}
