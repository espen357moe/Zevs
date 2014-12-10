package view;

import model.DataEndret;
import model.MeteorologiData;

public class VaerVarselPanel extends DataPanel {
	private final DataEndret endret;

	public DataEndret getEndret() {
		return endret;
	}

	public VaerVarselPanel() {
		lagEtikett("Regionsvarsel");
		lagNyttDataTekstFelt();

		endret = new DataEndret() {
			@Override
			public void oppdater(MeteorologiData data) {
				fjernData();
				skrivUtData(data.getvaerVarsel());

			}

		};

	}

}
