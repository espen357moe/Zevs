package view;

import model.DataEndret;
import model.MeteorologiData;

@SuppressWarnings("serial")
public class GeografiPanel extends DataPanel {

	private final DataEndret endret;
	
	public DataEndret getChanged() { return endret; }
	
	public GeografiPanel() {
		lagEtikett("Geografiske data");
		
		endret = new DataEndret() {
			
			@Override
			public void oppdater(MeteorologiData data) {
				fjernData();
				skrivUtData(data.getStedsNavn());
				skrivUtData(new Integer(data.getHoydeOverHavet()).toString() + "m.o.h.");
				skrivUtData("Koordinater: " + data.getKoordinater());
			}
		};
	}
	
}