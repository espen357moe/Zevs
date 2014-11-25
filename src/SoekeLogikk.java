import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SoekeLogikk {
	
	public SoekeTreff soekeTreff;

	@SuppressWarnings("unused")
	public void startSoek(String soekeStreng) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(
					"SoekeInfo.txt"));

			String brukerInput = soekeStreng;
			String resultatAvSoek;

			while ((resultatAvSoek = bf.readLine()) != null) {
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

						System.out.print("Sted: "+stedsNavn+"    ");
						System.out.print("Kommune: "+kommune +"    ");
						System.out.println("Fylke: "+fylke);
						System.out.println("URL: " +urlNorsk);
						System.out.println("------------------------------------------------------------------");
						System.out.println("");
						
						soekeTreff = new SoekeTreff(fylke, kommune, stedsNavn, urlNorsk);
						System.out.println("Søketreff fra SoekeLogikk : " +soekeTreff.getFylke()+ " " +soekeTreff.getKommune()+ " " + soekeTreff.getStedsNavn()+ " " + soekeTreff.getUrlNorsk());
						
						break;
						
					}
				}
			}

			bf.close();
		} catch (IOException e) {
			System.out.println("IO Error Occurred: " + e.toString());}
	}
	
	public SoekeTreff getSoekeTreff() {
		return(this.soekeTreff);
	}
	
}