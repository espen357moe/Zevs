package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.MeteorologiData;
import model.SoekeTreff;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import controller.SoekeLogikk;
import controller.XmlParser;
import model.DataEndret;
import java.util.ArrayList;

public class SoekePanel extends JPanel implements ActionListener {	
	private SoekeLogikk soekeLogikk = new SoekeLogikk();
	private JComboBox<String> soekeFelt;	
	private String soekeStreng;
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
		//soekeFelt.addActionListener(this);
		
		soekeKnapp = new JButton("Søk");
		this.add(soekeKnapp);				
		soekeKnapp.addActionListener(this);		
		soekeKnapp.requestFocusInWindow();	
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
		
		System.out.println();
		System.out.println();
		soekeStreng = (String) soekeFelt.getSelectedItem();
		System.out.println("Søker etter - " + soekeStreng);
			
		boolean validertSoekeStreng = soekeLogikk.validerSoekeStreng(soekeStreng);
			
		if(validertSoekeStreng==true) {
			SoekeTreff treff = soekeLogikk.startSoek(soekeStreng);			
			XmlParser xmlParser = new XmlParser();				
			MeteorologiData meteorologiData = xmlParser.parseXml(treff);				
			oppdaterAbonnenter(meteorologiData);				
			soekeFelt.addItem(soekeStreng);				
		}			
						
		else {	
	
			
			if(soekeStreng==null || soekeStreng.isEmpty() || soekeStreng.trim().length() < 1) {
				FeilDialog feilDialog = new FeilDialog("Du må skrive noe i søkefeltet!");				
				System.out.println("Søkestrengen var tom!");
			}

			else { 
				FeilDialog feilDialog = new FeilDialog("Ingen treff på \"" + soekeStreng +"\".\n"+"Stedsnavnet må være korrekt stavet og eksistere i databasen.");
				System.out.println("Søkestrengen validerte ikke!");
			}
				
		}

	}
	
}
