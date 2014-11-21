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
			
			
			while ((resultatAvSok = bf.readLine()) == null) {
				int resultatFunnet = resultatAvSok.indexOf(brukerInput);
				if (resultatFunnet == 0) {
					System.out.println("Ingen treff på  "+resultatAvSok);
				}
			}
			
			while ((resultatAvSok = bf.readLine()) != null) {

				int resultatFunnet = resultatAvSok.indexOf(brukerInput);
				if (brukerInput.isEmpty()) {
					System.out.println("Ingen søk utført");
					break;
				}
				
				if (resultatFunnet > -1) {
					System.out.println("Funnet " + " " + resultatAvSok + " ganger"
							+ " på  ");
				}

			}

			bf.close();
		} catch (IOException e) {
			System.out.println("IO Error Occurred: " + e.toString());

		}

	}
}
