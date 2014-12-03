package view;

import model.DataChanged;
import model.MeteorologiData;

@SuppressWarnings("serial")
public class GeografiPanel extends DataPanel {

	private final DataChanged changed;
	
	public DataChanged getChanged() { return changed; }
	
	public GeografiPanel() {
		lagEtikett("Geografiske data");
		
		changed = new DataChanged() {
			
			@Override
			public void Update(MeteorologiData data) {
				// TODO Auto-generated method stub

			}
		};
	}
	
}