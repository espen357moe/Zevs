package view;

import model.DataEndret;
import model.MeteorologiData;

@SuppressWarnings("serial")
public class VaerVarselPanel extends DataPanel {
	private final DataEndret endret;
	public DataEndret getEndret() {return endret;}
	
	public VaerVarselPanel() {
		lagEtikett("Værvarsel info");
		lagNyttDataTekstFelt();
		
		endret = new DataEndret () { @Override
			public void oppdater(MeteorologiData data) {
				fjernData();
				skrivUtData(data.getvaerVarsel()); //Her skrives data ut!
				
			}
		};
		
	}

}
