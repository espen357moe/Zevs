package view;

import model.DataEndret;
import model.MeteorologiData;


@SuppressWarnings("serial")
public class MeteorologiPanel extends DataPanel {

	private final DataEndret endret; 
	
	public DataEndret getChanged() { return endret; }
	
	public MeteorologiPanel() {
		lagEtikett("Meteorologiske data");
		endret = new DataEndret() { @Override
		public void oppdater(MeteorologiData data) {
			fjernData();
			skrivUtData(new Float(data.getNedbor()).toString() + " mm nedbør");
			skrivUtData(data.getVindBetegnelse());
			skrivUtData(new Float(data.getVindHastighet()).toString() + " m/s");
			skrivUtData(data.getVindRetning());
			
		}
		};
	}
}