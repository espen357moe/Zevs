package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;

import model.DataEndret;
import model.MeteorologiData;

@SuppressWarnings("serial")
public class GeografiPanel extends DataPanel {
	private final DataEndret endret;

	public DataEndret getEndret() {
		return endret;
	}

	private JButton googleMapsKnapp = new JButton("Google Maps");
	private String googleMapsUrl = "http://maps.google.com";

	public GeografiPanel() {
		lagEtikett("Geografiske data");
		lagNyttDataTekstFelt();
		this.add(googleMapsKnapp, BorderLayout.SOUTH);

		googleMapsKnapp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ev) {

				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.browse(new URI(googleMapsUrl));
					} catch (IOException | URISyntaxException e) {
						e.printStackTrace();
					}
				} else {
					Runtime runtime = Runtime.getRuntime();
					try {
						runtime.exec("xdg-open " + googleMapsUrl);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		});

		endret = new DataEndret() {
			@Override
			public void oppdater(MeteorologiData data) {
				fjernData();
				skrivUtData(data.getStedsNavn());
				skrivUtData(new Integer(data.getHoydeOverHavet()).toString()
						+ " m.o.h.");
				skrivUtData("Lengdegrad : " + data.getLengdegrad());
				skrivUtData("Breddegrad : " + data.getBreddegrad());
				googleMapsUrl = ("http://maps.google.com/maps/place/"
						+ data.getLengdegrad() + "," + data.getBreddegrad());
				googleMapsKnapp.setText("Gå til " + data.getStedsNavn()
						+ " i Google Maps");
			}

		};

	}

}
