package view;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.MeteorologiData;

@SuppressWarnings("serial")
public class DataPanel extends JPanel {
	
	public JLabel panelEtikett = new JLabel();
	
	public JTextArea dataTekstFelt = new JTextArea();
	
	public DataPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.DARK_GRAY);
		
		dataTekstFelt.setBackground(Color.GRAY);
		dataTekstFelt.setForeground(Color.DARK_GRAY);
		
		panelEtikett.setForeground(Color.ORANGE);
				
		this.add(panelEtikett, BorderLayout.NORTH);
		this.add(dataTekstFelt, BorderLayout.CENTER);
	}	
	
	public void skrivUtData(MeteorologiData meteorologiData) {
		
		String stedsNavn = meteorologiData.getStedsNavn();
		int hoydeOverHavet = meteorologiData.getHoydeOverHavet();
		String koordinater = meteorologiData.getKoordinater();
		float nedbor = meteorologiData.getNedbor();
		String skyDekke = meteorologiData.getSkydekke();
		int temperatur = meteorologiData.getTemperatur();
		String vindRetning = meteorologiData.getVindRetning();
		String vindBetegnelse = meteorologiData.getVindBetegnelse();
		float vindHastighet = meteorologiData.getVindHastighet();
		String symbolNummer = meteorologiData.getSymbolNummer();
		String sistOppdatert = meteorologiData.getSistOppdatert();
		String nesteOppdatering = meteorologiData.getNesteOppdatering(); 
	
		dataTekstFelt.append(stedsNavn+"/n"+skyDekke);
	}
	
	public void lagEtikett(String tekst) {
		panelEtikett.setText(tekst);
	}
	
}
