package view;

<<<<<<< HEAD
import java.awt.GridLayout;

import javax.swing.JTextField;
=======
>>>>>>> cebb8d36d4ed62583464f4251b320f0f71324835

import model.DataEndret;
import model.MeteorologiData;

@SuppressWarnings("serial")
public class GeografiPanel extends DataPanel {
	private final DataEndret endret;	
	public DataEndret getEndret() { return endret; }
	
	public GeografiPanel() {
		lagEtikett("Geografiske data");
		lagNyttDataTekstFelt();
		
		endret = new DataEndret() {	@Override
			public void oppdater(MeteorologiData data) {
				fjernData();
				skrivUtData(data.getStedsNavn());
				skrivUtData(new Integer(data.getHoydeOverHavet()).toString() + " m.o.h.");
				skrivUtData("Lengdegrad : " + data.getLengdegrad());
				skrivUtData("Breddegrad : " + data.getBreddegrad());
			}
		
		};
		
	}
	
}