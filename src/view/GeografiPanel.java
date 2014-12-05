package view;

import model.DataEndret;
import model.MeteorologiData;

@SuppressWarnings("serial")
public class GeografiPanel extends DataPanel {

	private final DataEndret changed;
	
	public DataEndret getChanged() { return changed; }
	
	public GeografiPanel() {
		lagEtikett("Geografiske data");
		
		changed = new DataEndret() {
			
			@Override
			public void oppdater(MeteorologiData data) {
				// TODO Auto-generated method stub

			}
		};
	}
	
}