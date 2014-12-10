package view;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;

import model.DataEndret;
import model.FilTilknytning;
import model.MeteorologiData;

@SuppressWarnings("serial")
public class BonusPanel extends DataPanel {

	private Image vaerSymbol;
	private ImageIcon icon;
	private int symbolNummer;
	
	private final DataEndret endret; 
	public DataEndret getEndret() { return endret; }
	
	public BonusPanel() {
		this.setLayout(new GridLayout(0,3));
		lagEtikett("");
		lagNyBildeRute();
		
		endret = new DataEndret() { @Override
			public void oppdater(MeteorologiData data) {
				symbolNummer = data.getSymbolNummer();
				
				FilTilknytning ft = new FilTilknytning();
				vaerSymbol = ft.knyttSymbolNummerTilBilde(symbolNummer);	
				icon = new ImageIcon(vaerSymbol);
				
				bildeRute.setIcon(icon);
			}
		
		};
		
	}
	
}