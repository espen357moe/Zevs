package view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.DataEndret;
import model.FilTilknytning;
import model.MeteorologiData;

@SuppressWarnings("serial")
public class MeteorologiPanel extends DataPanel {	
	private final DataEndret endret; 
	//private Image vaerSymbol = null;
	public DataEndret getEndret() { return endret; }
	
	public MeteorologiPanel() {		
//		JLabel vaerSymbolRute = new JLabel();
//		this.add(vaerSymbolRute);
//		vaerSymbolRute.setOpaque(true);
//		vaerSymbolRute.setBackground(Color.DARK_GRAY);
		lagEtikett("Meteorologiske data");
		
		endret = new DataEndret() { @Override
			public void oppdater(MeteorologiData data) {
				fjernData();
				skrivUtData(new Float(data.getNedbor()).toString() + " mm nedbør");
				skrivUtData(data.getVindBetegnelse());
				skrivUtData(data.getSkydekke());
				skrivUtData(new Float(data.getVindHastighet()).toString() + " m/s");
				skrivUtData(data.getVindRetning());
				skrivUtData(new Integer(data.getSymbolNummer()).toString());
				
//				FilTilknytning ft = new FilTilknytning();
//				vaerSymbol = ft.knyttSymbolNummerTilBilde(data.getSymbolNummer());	
//				tegnVaerSymbol(vaerSymbol);	
			}
		
//			public void tegnVaerSymbol(Image vaerSymbol) {
//				ImageIcon icon = new ImageIcon(vaerSymbol);
//				vaerSymbolRute.setIcon(icon);
//			}
			
		};
		
	}
	
}