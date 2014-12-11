package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.DataEndret;
import model.MeteorologiData;
import model.FilTilknytning24;

@SuppressWarnings("serial")
public class MeteorologiPanel24 extends DataPanel {
	
	private Image vaerSymbol;
	private ImageIcon icon;
	private int symbolNummer24;
	
	private final DataEndret endret;
	
	public DataEndret getEndret() {return endret;}
	
	public MeteorologiPanel24() {
		this.setLayout(new BorderLayout());
		lagEtikett("Været om 24 timer");
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
				skrivUtData(new Integer(data.getTemperatur24()).toString() + " °C");
				skrivUtData(new Float(data.getNedbor24()).toString() + " mm nedbør");		
				skrivUtData(data.getSkydekke24());
				skrivUtData(data.getVindBetegnelse24());
				skrivUtData(new Float(data.getVindHastighet24()).toString() + " m/s");
				skrivUtData(data.getVindRetning24());	
				
				symbolNummer24 = data.getSymbolNummer24();
				
				FilTilknytning24 ft24 = new FilTilknytning24();
				vaerSymbol = ft24.knyttSymbolNummerTilBilde24(symbolNummer24);	
				icon = new ImageIcon(vaerSymbol);
				
				bildeRute.setIcon(icon);
			
			}
		
		};
		
	}

}