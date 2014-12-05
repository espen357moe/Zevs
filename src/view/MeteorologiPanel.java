package view;

import model.DataEndret;
import model.MeteorologiData;


@SuppressWarnings("serial")
public class MeteorologiPanel extends DataPanel {

	private final DataEndret changed; 
	
	public DataEndret getChanged() { return changed; }
	
	public MeteorologiPanel() {
		lagEtikett("Meteorologiske data");
		changed = new DataEndret() { @Override
		public void oppdater(MeteorologiData data) {
			fjernData();
			skrivUtData(new Float(data.getNedbor()).toString());
			skrivUtData(data.getVindBetegnelse());
			skrivUtData(new Float(data.getVindHastighet()).toString());
			skrivUtData(data.getVindRetning());
			
		}
		};
	}
}