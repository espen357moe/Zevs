package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MeteorologiData;
import model.SoekeTreff;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

import model.SoekeTreff;
import controller.SoekeLogikk;
import controller.XmlParser;
import model.DataEndret;

import java.util.ArrayList;
public class SoekePanel extends JPanel implements ActionListener {
	
//	public String soekeResultatListe (SoekeTreff soekeTreff) {
//		String stedsNavn = soekeTreff.getStedsNavn();
//		System.out.println();
//		System.out.println();
//		System.out.println("SÃ¸keresultat som skal inn i droppdown: " +stedsNavn);
//		return stedsNavn;
//		
//	}
	
	private SoekeLogikk soekeLogikk = new SoekeLogikk();

	private JComboBox<String> soekeFelt;
	private String soekeStreng;

	private String[] resultatListe = new String[5];
	private JComboBox<String> nedtrekksResultatListe = new JComboBox<String>();

	private String[] fullSoekeStreng = new String [5];

	private JButton soekeKnapp;
	
	private final ArrayList<DataEndret> abonnenter;
	
	public void addAbonnent(DataEndret changed) {
		abonnenter.add(changed);
	}
	
	private void oppdaterAbonnenter(MeteorologiData data) {
		for(DataEndret de : abonnenter) {
			de.oppdater(data);
		}
	}
	
	public SoekePanel() {
		abonnenter = new ArrayList<DataEndret>();
		this.soekeFelt = new JComboBox<String>();
		this.add(soekeFelt);	
		soekeFelt.setEditable(true);
		
		soekeKnapp = new JButton("Søk");
		this.add(soekeKnapp);				
		soekeKnapp.addActionListener(this);
		soekeKnapp.requestFocusInWindow();
		
		nedtrekksResultatListe = new JComboBox<String>(resultatListe);
		nedtrekksResultatListe.setSelectedIndex(0);
		//nedtrekksResultatListe.addActionListener(this);
		this.add(nedtrekksResultatListe);
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
			soekeStreng = (String) soekeFelt.getSelectedItem();
			System.out.println("Søker etter - " + soekeStreng);

			SoekeTreff treff = soekeLogikk.startSoek(soekeStreng);
			
			XmlParser xmlParser = new XmlParser();
			
			MeteorologiData meteorologiData = xmlParser.parseXml(treff);
			
			oppdaterAbonnenter(meteorologiData);
			
			nedtrekksResultatListe.addItem(treff.getUrlNorsk());
			
			soekeFelt.addItem(soekeStreng);		
		}
		
	}

}
