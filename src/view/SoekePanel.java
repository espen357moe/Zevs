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
import model.DataChanged;

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

	private JTextField soekeFelt;
	private String soekeStreng;

	private String[] resultatListe = new String[5];
	private JComboBox nedtrekksResultatListe = new JComboBox();

	private String[] fullSoekeStreng = new String [5];
	private JComboBox listeOverSoek = new JComboBox();
	private JButton soekeKnapp;
	
	private final ArrayList<DataChanged> subscribers;
	
	public void addSubscriber(DataChanged changed) {
		subscribers.add(changed);
	}
	
	private void updateSubscribers(MeteorologiData data) {
		for(DataChanged ch : subscribers) {
			ch.Update(data);
		}
	}
	
	public SoekePanel() {
		subscribers = new ArrayList<DataChanged>();
		this.soekeFelt = new JTextField(30);
		this.add(soekeFelt);	
		
		soekeKnapp = new JButton("Søk");
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

			SoekeTreff treff = soekeLogikk.startSoek(soekeStreng);
			
			XmlParser xmlParser = new XmlParser();
			
			MeteorologiData meteorologiData = xmlParser.parseXml(treff);
			
			updateSubscribers(meteorologiData);
			
			nedtrekksResultatListe.addItem(treff.getUrlNorsk());
			
			listeOverSoek.addItem(soekeStreng);
			
		}
		
	}

}
