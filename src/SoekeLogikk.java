import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SoekeLogikk {

	@SuppressWarnings("unused")
	public void startSoek(String soekeStreng) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(
					"SoekeInfo.txt"));

			String brukerInput = soekeStreng;
			String resultatAvSok;

			while ((resultatAvSok = bf.readLine()) != null) {
				int resultatFunnet = resultatAvSok.indexOf(brukerInput);
				if (brukerInput.isEmpty()) {
					System.out.println("Ingen søk utført");
					break;
				}

				if (resultatFunnet > -1) {
					String strArray[] = resultatAvSok.split("\t");
					for (int i = 0; i < strArray.length;) {
						String komunenummer 	= strArray[0];
						String stedsnavn 		= strArray[1];
						String prioritet 		= strArray[2];
						String stedtypeNynorsk 	= strArray[3];
						String stedtypeBokmål 	= strArray[4];
						String stedEngelsn 		= strArray[5];
						String komune 			= strArray[6];
						String fylke 			= strArray[7];
						String lengdeGrad 		= strArray[8];
						String breddeGrad 		= strArray[9];
						String hoydeOverHavet 	= strArray[10];
						String urlNyNorsk 		= strArray[11];
						String urlNorsk 		= strArray[12];
						String urlEngelsk 		= strArray[13];

						System.out.print("Sted: "+stedsnavn+"    ");
						System.out.print("Komune: "+komune +"    ");
						System.out.println("Fylke: "+fylke);
						System.out.println("URL: " +urlNorsk);
						System.out.println("------------------------------------------------------------------");
						System.out.println("");
						break;
						

					}
				}
			}

			bf.close();
		} catch (IOException e) {
			System.out.println("IO Error Occurred: " + e.toString());}
	}
}