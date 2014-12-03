package controller;
import java.io.*;
import java.net.*;


import view.SoekePanel;
import model.SoekeTreff;

public class SoekeLogikk {
	public SoekeTreff soekeTreff;

	@SuppressWarnings("unused")
	public void startSoek(String soekeStreng) throws Exception {
		
		XmlParser xmlParser = new XmlParser();
		SoekePanel sokepanel = new SoekePanel ();
		
		try {
			URL noregText = new URL ("http://fil.nrk.no/yr/viktigestader/noreg.txt");
			BufferedReader dokumentLeser = new BufferedReader(
			        new InputStreamReader(noregText.openStream()));
			String brukerInput = soekeStreng;
			String resultatAvSoek;

			while ((resultatAvSoek = dokumentLeser.readLine()) != null) {
				int resultatFunnet = resultatAvSoek.indexOf(brukerInput);
				if (brukerInput.isEmpty()) {
					System.out.println("Ingen søk utført");
					break;
				}

				if (resultatFunnet > -1) {
					
					String strArray[] = resultatAvSoek.split("\t");
					for (int i = 0; i < strArray.length;) {
						
						String kommuneNummer 	= strArray[0];
						String stedsNavn 		= strArray[1];
						String prioritet 		= strArray[2];
						String stedtypeNynorsk 	= strArray[3];
						String stedtypeBokmål 	= strArray[4];
						String stedEngelsk 		= strArray[5];
						String kommune 			= strArray[6];
						String fylke 			= strArray[7];
						String lengdeGrad 		= strArray[8];
						String breddeGrad 		= strArray[9];
						String hoydeOverHavet 	= strArray[10];
						String urlNyNorsk 		= strArray[11];
						String urlNorsk 		= strArray[12];
						String urlEngelsk 		= strArray[13];

						
						soekeTreff = new SoekeTreff(fylke, kommune, stedsNavn, urlNorsk);
						System.out.println("Søketreff : " +soekeTreff.getFylke()+ " " +soekeTreff.getKommune()
								+ " " + soekeTreff.getStedsNavn());
						System.out.println(xmlParser.parseXml(soekeTreff));
						System.out.println(sokepanel.getFullSoekeStreng(soekeTreff));
						
						break;
						
					}
				}
			}

			dokumentLeser.close();
		} catch (IOException e) {
			System.out.println("IO Error Occurred: " + e.toString());}
	}
	
	public SoekeTreff getSoekeTreff() {
		
		return(this.soekeTreff);
	}
	
}