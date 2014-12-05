package controller;
import java.io.*;
import java.util.*;
import java.net.*;

import model.MeteorologiData;
import model.SoekeTreff;

public class SoekeLogikk {
	public SoekeTreff soekeTreff;

	private class Rad {
		// Kommunenummer	Stadnamn Prioritet Stadtype nynorsk Stadtype bokmål	Stadtype engelsk Kommune Fylke Lat	Lon	Høgd	Nynorsk	Bokmål	Engelsk
		private final String kommune;
		private final String stedsNavn;
		private final String varselUrl;
		private final String fylke;
		
		public String getKommune() { return kommune; }
		public String getStedsNavn() { return stedsNavn; }
		public String getVarselUrl() { return varselUrl; }
		public String getFylke() { return fylke; }
		
		public Rad(String fylke, String kommune, String stedsNavn, String varselUrl) {
			this.fylke = fylke;
			this.kommune = kommune;
			this.stedsNavn = stedsNavn;
			this.varselUrl = varselUrl;
		}
	}
	
	private final java.util.Map<String, ArrayList<Rad>> rader; 
	
	public SoekeLogikk() {
		rader = new TreeMap<String, ArrayList<Rad>>(String.CASE_INSENSITIVE_ORDER);
		URL noregText;
		try
		{
			noregText = new URL ("http://fil.nrk.no/yr/viktigestader/noreg.txt");
		}catch(MalformedURLException ex){
			System.out.println("Misformet URL!");
			return;
		}
		
		InputStream stream;
		try
		{
			stream = noregText.openStream(); //Prøver å lese tekstfilen fra yr.no
		}
		catch(IOException ex)
		{
			try {
				stream = new FileInputStream(".\\NoregInfo.txt"); //Prøver å lese tekstfilen lokalt, dersom det feiler å hente fra yr.no
			} catch(IOException ioc) {
				System.out.println("Kunne ikke finne NoregInfo.txt :(");
				return;
			}
		}
		
		Parse(new InputStreamReader(stream));
	}
	
	private void Parse(InputStreamReader source) {
		String linje;
		BufferedReader dokumentLeser = new BufferedReader(source);
		try
		{
		while ((linje = dokumentLeser.readLine()) != null) {
			String strArray[] = linje.split("\t");
				
			String kommuneNummer 	= strArray[0];
			String stedsNavn 		= strArray[1];
			/*String prioritet 		= strArray[2];
			String stedtypeNynorsk 	= strArray[3];
			String stedtypeBokmål 	= strArray[4];
			String stedEngelsk 		= strArray[5];*/
			String kommune 			= strArray[6];
			String fylke 			= strArray[7];
			/*String lengdeGrad 		= strArray[8];
			String breddeGrad 		= strArray[9];
			String hoydeOverHavet 	= strArray[10];
			String urlNyNorsk 		= strArray[11];*/
			String urlNorsk 		= strArray[12];
			//String urlEngelsk 		= strArray[13];

			Rad rad = new Rad(fylke, kommune, stedsNavn, urlNorsk);
			ArrayList<Rad> liste = rader.get(stedsNavn);
			if(liste == null) {
				liste = new ArrayList<Rad>();
				rader.put(stedsNavn, liste);
			}
			
			liste.add(rad);
		}
		}catch(IOException ex){
			System.out.println("Kunne ikke lese fra strømmen!");
		}
		
	}
	
	@SuppressWarnings("unused")
	public SoekeTreff startSoek(String soekeStreng) {
		
		String brukerInput = soekeStreng;
		String resultatAvSoek;

		ArrayList<Rad> liste = rader.get(soekeStreng);
		
		if(liste == null)
			return null;
		//System.out.println(rad.getVarselUrl());
		Rad rad = liste.get(0);
		SoekeTreff soekeTreff = new SoekeTreff(rad.getFylke(), rad.getKommune(), rad.getStedsNavn(), rad.getVarselUrl());
	
	
		return soekeTreff;
	}
	
	public SoekeTreff getSoekeTreff() {
		
		return(this.soekeTreff);
	}
	
}