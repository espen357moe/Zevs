package view;

import java.awt.Color;
import model.DataEndret;
import model.MeteorologiData;

@SuppressWarnings("serial")
public class MeteorologiPanel extends DataPanel {	
	private final DataEndret endret; 

	public DataEndret getEndret() { return endret; }
	
	public MeteorologiPanel() {		

		lagEtikett("Meteorologiske data");
		lagNyttDataTekstFelt();
		lagNyttDataTekstFelt();
		lagNyttDataTekstFelt();
		
		
		dataTekstFelt.setBackground(Color.GRAY);
		dataTekstFelt.setForeground(Color.DARK_GRAY);
		
		endret = new DataEndret() { @Override
			public void oppdater(MeteorologiData data) {
				fjernData();
				skrivUtData(new Integer(data.getTemperatur()).toString() + " °C");	
				skrivUtData(new Float(data.getNedbor()).toString() + " mm nedbør");
				skrivUtData(data.getSkydekke());
				skrivUtData(data.getVindBetegnelse());
				skrivUtData(new Float(data.getVindHastighet()).toString() + " m/s");
				skrivUtData(data.getVindRetning());	
			
			}	
		
		};
		
	}
	
}