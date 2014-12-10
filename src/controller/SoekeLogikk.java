package controller;

import java.io.*;
import java.util.*;
import java.net.*;

import view.FeilDialog;
import model.SoekeTreff;

public class SoekeLogikk {
	public SoekeTreff soekeTreff;

	private class Rad {
		private final String kommune;
		private final String stedsNavn;
		private final String varselUrl;
		private final String fylke;

		public String getKommune() {
			return kommune;
		}

		public String getStedsNavn() {
			return stedsNavn;
		}

		public String getVarselUrl() {
			return varselUrl;
		}

		public String getFylke() {
			return fylke;
		}

		public Rad(String fylke, String kommune, String stedsNavn,
				String varselUrl) {
			this.fylke = fylke;
			this.kommune = kommune;
			this.stedsNavn = stedsNavn;
			this.varselUrl = varselUrl;
		}
	}

	private final java.util.Map<String, ArrayList<Rad>> rader;

	public SoekeLogikk() {
		rader = new TreeMap<String, ArrayList<Rad>>(
				String.CASE_INSENSITIVE_ORDER);
		URL noregText;
		try {
			noregText = new URL("http://fil.nrk.no/yr/viktigestader/noreg.txt");
		} catch (MalformedURLException ex) {
			FeilDialog feilDialog = new FeilDialog("Misformet URL!");
			return;
		}

		InputStream stream;
		try {
			stream = noregText.openStream();
		} catch (IOException ex) {
			try {
				stream = new FileInputStream(".\\NoregInfo.txt");
			} catch (IOException ioc) {
				FeilDialog feilDialog = new FeilDialog(
						"Kunne ikke finne NoregInfo.txt :(");
				return;
			}
		}

		Parse(new InputStreamReader(stream));
	}

	private void Parse(InputStreamReader source) {
		String linje;
		BufferedReader dokumentLeser = new BufferedReader(source);
		try {
			while ((linje = dokumentLeser.readLine()) != null) {
				String strArray[] = linje.split("\t");

				String stedsNavn = strArray[1];
				String kommune = strArray[6];
				String fylke = strArray[7];
				String urlNorsk = strArray[12];
				Rad rad = new Rad(fylke, kommune, stedsNavn, urlNorsk);
				ArrayList<Rad> liste = rader.get(stedsNavn);
				if (liste == null) {
					liste = new ArrayList<Rad>();
					rader.put(stedsNavn, liste);
				}

				liste.add(rad);
			}
		} catch (IOException ex) {
			FeilDialog feilDialog = new FeilDialog(
					"Kunne ikke lese fra strømmen!");
		}

	}

	public boolean validerSoekeStreng(String soekeStreng) {

		if (soekeStreng == null) {
			FeilDialog feilDialog = new FeilDialog("Ingen treff på "
					+ soekeStreng);
			return false;
		}

		ArrayList<Rad> liste = rader.get(soekeStreng);

		if (liste == null) {

			FeilDialog feilDialog = new FeilDialog("Ingen treff på "
					+ soekeStreng);
			return false;
		}

		return true;

	}

	public SoekeTreff startSoek(String soekeStreng) {

		ArrayList<Rad> liste = rader.get(soekeStreng);

		if (liste == null) {
			FeilDialog feilDialog = new FeilDialog("Ingen treff på "
					+ soekeStreng);
		}
		Rad rad = liste.get(0);
		SoekeTreff soekeTreff = new SoekeTreff(rad.getFylke(),
				rad.getKommune(), rad.getStedsNavn(), rad.getVarselUrl());

		return soekeTreff;
	}

	public SoekeTreff getSoekeTreff() {

		return (this.soekeTreff);
	}

}