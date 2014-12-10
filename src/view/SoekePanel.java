package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class SoekePanel extends JPanel implements ActionListener {	
	private SoekeLogikk soekeLogikk = new SoekeLogikk();
	private JComboBox<String> soekeFelt;	
	private String soekeStreng;
	private String url = "http://www.yr.no";
	private JButton soekeKnapp;	
	private JButton yrLenkeKnapp = new JButton("Værvarsel fra yr.no, levert av Meteorologisk institutt og NRK");
	private JPanel soekeFeltKnappPanel;
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
		this.setLayout(new BorderLayout());
		abonnenter = new ArrayList<DataEndret>();
		
		JPanel soekeFeltKnappPanel = new JPanel();
		soekeFeltKnappPanel.setLayout(new FlowLayout());
		this.add(soekeFeltKnappPanel, BorderLayout.CENTER);
		this.add(yrLenkeKnapp, BorderLayout.NORTH);
		
		
		this.soekeFelt = new JComboBox<String>();
		soekeFeltKnappPanel.add(soekeFelt);	
		soekeFelt.setEditable(true);
		//soekeFelt.addActionListener(this);
		
		soekeKnapp = new JButton("Søk");
		soekeFeltKnappPanel.add(soekeKnapp);				
		soekeKnapp.addActionListener(this);		
		soekeKnapp.requestFocusInWindow();
		yrLenkeKnapp.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ev) {

			        if(Desktop.isDesktopSupported()){
			            Desktop desktop = Desktop.getDesktop();
			            try {
			                desktop.browse(new URI(url));
			            } catch (IOException | URISyntaxException e) {
			                // TODO Auto-generated catch block
			                e.printStackTrace();
			            }
			        }else{
			            Runtime runtime = Runtime.getRuntime();
			            try {
			                runtime.exec("xdg-open " + url);
			            } catch (IOException e) {
			                // TODO Auto-generated catch block
			                e.printStackTrace();
			            }
			        }
			    }
				
				
			
			
		});
		
		
		
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
		soekeStreng = ((String) soekeFelt.getSelectedItem()).trim();
		System.out.println("Søker etter - " + soekeStreng);
			
		boolean validertSoekeStreng = soekeLogikk.validerSoekeStreng(soekeStreng);
		int antallItems = soekeFelt.getItemCount();
			
		if(validertSoekeStreng==true) {
			SoekeTreff treff = soekeLogikk.startSoek(soekeStreng);			
			XmlParser xmlParser = new XmlParser();				
			MeteorologiData meteorologiData = xmlParser.parseXml(treff);				
			oppdaterAbonnenter(meteorologiData);				

		
			
			
			
			
			String[] soekeTreffItemsArray = new String[antallItems];
			boolean soekeTreffFinnesAllerede = false;
			
			for(int i=0; i<antallItems; i++){
				soekeTreffItemsArray[i]=soekeFelt.getItemAt(i);
			}
			
			for(int i=0; i<antallItems; i++){
				
				if(soekeStreng.equalsIgnoreCase(soekeTreffItemsArray[i]))  {
				    soekeTreffFinnesAllerede=true;
				    break;
				}
			}
			
			if(soekeTreffFinnesAllerede==false){
				soekeFelt.addItem(soekeStreng);	
				url = treff.getUrlNorsk().replaceAll("varsel.xml", "");
			}
		
		
		
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
