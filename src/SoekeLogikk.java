
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SoekeLogikk {

	public void startSoek(String soekeStreng) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(
					"SoekeInfo.txt"));
			String line;
			String df = soekeStreng;
			while ((line = bf.readLine()) != null) {

				int indexfound = line.indexOf(df);
				if (df.isEmpty()) {
					System.out.println("Ingen søk utført");
					break;
				}

<<<<<<< HEAD
				if (resultatFunnet > -1) {
					String strArray[] = resultatAvSok.split("\t");
					for (int i = 0; i < strArray.length;) {
						String kommunenummer 	= strArray[0];
						String stedsnavn 		= strArray[1];
						String prioritet 		= strArray[2];
						String stedtypeNynorsk 	= strArray[3];
						String stedtypeBokmaal 	= strArray[4];
						String stedEngelsk 		= strArray[5];
						String kommune 			= strArray[6];
						String fylke 			= strArray[7];
						String lengdeGrad 		= strArray[8];
						String breddeGrad 		= strArray[9];
						String hoydeOverHavet 	= strArray[10];
						String urlNyNorsk 		= strArray[11];
						String urlNorsk 		= strArray[12];
						String urlEngelsk 		= strArray[13];

						System.out.print("Sted: "+stedsnavn+"    ");
						System.out.print("Kommune: "+kommune +"    ");
						System.out.println("Fylke: "+fylke);
						System.out.println("URL: " +urlNorsk);
						System.out.println("------------------------------------------------------------------");
						System.out.println("");
						break;
						

					}
=======
				if (indexfound > -1) {


					System.out.println("Funnet " + " " + line + " ganger" + " på  ");
					
					
//					Omgjøring til Array testing.  
//			System.out.println (java.util.Arrays.toString(line.split(";")));
					
					System.out.println(line + " ganger"
							+ " på ");
					// Omgjøring til Array testing.
					// System.out.println
					// (java.util.Arrays.toString(line.split(" 	")));

				}
				if (indexfound == 0) {
					System.out.println("Ingen treff");
>>>>>>> 66c572fe8d37d2dcd4b0f3a7ecb8418c70624309
				}
			}

			bf.close();
		} catch (IOException e) {
			System.out.println("IO Error Occurred: " + e.toString());

		}

	}
}
