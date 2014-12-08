package view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.DataEndret;
import model.FilTilknytning;
import model.MeteorologiData;

@SuppressWarnings("serial")
public class MeteorologiPanel extends DataPanel {	
	private final DataEndret endret; 

	public DataEndret getEndret() { return endret; }
	
	public MeteorologiPanel() {		

		lagEtikett("Meteorologiske data");
		lagNyttDataTekstFelt();
		
		dataTekstFelt.setBackground(Color.GRAY);
		dataTekstFelt.setForeground(Color.DARK_GRAY);
		
		endret = new DataEndret() { @Override
			public void oppdater(MeteorologiData data) {
				fjernData();
				skrivUtData(new Float(data.getNedbor()).toString() + " mm nedbør");
				skrivUtData(data.getVindBetegnelse());
				skrivUtData(data.getSkydekke());
				skrivUtData(new Float(data.getVindHastighet()).toString() + " m/s");
				skrivUtData(data.getVindRetning());				
			}	
		
		};
		
	}
	
}