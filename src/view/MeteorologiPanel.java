package view;

import model.DataChanged;
import model.MeteorologiData;


@SuppressWarnings("serial")
public class MeteorologiPanel extends DataPanel {

	private final DataChanged changed; 
	
	public DataChanged getChanged() { return changed; }
	
	public MeteorologiPanel() {
		lagEtikett("Meteorologiske data");
		changed = new DataChanged() { @Override
		public void Update(MeteorologiData data) {
			fjernData();
			skrivUtData(new Float(data.getNedbor()).toString());
			skrivUtData(data.getVindBetegnelse());
			skrivUtData(new Float(data.getVindHastighet()).toString());
			skrivUtData(data.getVindRetning());
			
		}
		};
	}
}