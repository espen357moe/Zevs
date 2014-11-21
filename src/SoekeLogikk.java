import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SoekeLogikk {

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
						System.out.print("Sted: "+strArray[1] +"    ");
						System.out.print("Komune: "+strArray[6]+"    ");
						System.out.println("Fylke: "+strArray[7]);
						System.out.println("URL: "+strArray[12]+"	");
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