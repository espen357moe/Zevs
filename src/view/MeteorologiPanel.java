package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.DataEndret;
import model.FilTilknytning;
import model.MeteorologiData;

public class MeteorologiPanel extends DataPanel {

	private Image vaerSymbol;
	private ImageIcon icon;
	private int symbolNummer;

	private final DataEndret endret;

	public DataEndret getEndret() {
		return endret;
	}

	public MeteorologiPanel() {
		this.setLayout(new BorderLayout());
		lagEtikett("Meteorologiske data");
		lagNyttDataTekstFelt();
		lagNyBildeRute();
		lagNyttDataTekstFelt();
		JPanel tekstOgSymbolPanel = new JPanel();
		tekstOgSymbolPanel.setLayout(new GridLayout(0, 2));

		dataTekstFelt.setBackground(Color.GRAY);
		dataTekstFelt.setForeground(Color.DARK_GRAY);

		this.add(panelEtikett, BorderLayout.NORTH);
		this.add(tekstOgSymbolPanel, BorderLayout.CENTER);
		tekstOgSymbolPanel.add(dataTekstFelt);
		tekstOgSymbolPanel.add(bildeRute, BorderLayout.EAST);

		endret = new DataEndret() {
			@Override
			public void oppdater(MeteorologiData data) {
				fjernData();
				skrivUtData(new Integer(data.getTemperatur()).toString()
						+ " °C");
				skrivUtData(new Float(data.getNedbor()).toString()
						+ " mm nedbør");
				skrivUtData(data.getSkydekke());
				skrivUtData(data.getVindBetegnelse());
				skrivUtData(new Float(data.getVindHastighet()).toString()
						+ " m/s");
				skrivUtData(data.getVindRetning());

				symbolNummer = data.getSymbolNummer();

				FilTilknytning ft = new FilTilknytning();
				vaerSymbol = ft.knyttSymbolNummerTilBilde(symbolNummer);
				icon = new ImageIcon(vaerSymbol);

				bildeRute.setIcon(icon);

			}

		};

	}

}