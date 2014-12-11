package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.DataEndret;
import model.MeteorologiData;
import model.FilTilknytning48;

@SuppressWarnings("serial")
public class MeteorologiPanel48 extends DataPanel {
	
	private Image vaerSymbol;
	private ImageIcon icon;
	private int symbolNummer48;
	
	private final DataEndret endret;
	
	public DataEndret getEndret() {return endret;}
	
	public MeteorologiPanel48() {
		this.setLayout(new BorderLayout());
		lagEtikett("Været om 48 timer");
		lagNyttDataTekstFelt();
		lagNyBildeRute();
		lagNyttDataTekstFelt();
		
		JPanel tekstOgSymbolPanel = new JPanel();
		tekstOgSymbolPanel.setLayout(new GridLayout(0,2));
		
		dataTekstFelt.setBackground(Color.GRAY);
		dataTekstFelt.setForeground(Color.DARK_GRAY);
		
		this.add(panelEtikett, BorderLayout.NORTH);
		this.add(tekstOgSymbolPanel, BorderLayout.CENTER);
		tekstOgSymbolPanel.add(dataTekstFelt);
		tekstOgSymbolPanel.add(bildeRute, BorderLayout.EAST);
		
		endret = new DataEndret () { @Override
			public void oppdater(MeteorologiData data) {
				fjernData();
				skrivUtData(new Integer(data.getTemperatur48()).toString() + " °C");
				skrivUtData(new Float(data.getNedbor48()).toString() + " mm nedbør");		
				skrivUtData(data.getSkydekke48());
				skrivUtData(data.getVindBetegnelse48());
				skrivUtData(new Float(data.getVindHastighet48()).toString() + " m/s");
				skrivUtData(data.getVindRetning48());	
				
				symbolNummer48 = data.getSymbolNummer48();
				
				FilTilknytning48 ft48 = new FilTilknytning48();
				vaerSymbol = ft48.knyttSymbolNummerTilBilde48(symbolNummer48);	
				icon = new ImageIcon(vaerSymbol);
				
				bildeRute.setIcon(icon);
			
			}
		
		};
		
	}

}