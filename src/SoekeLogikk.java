import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SoekeLogikk {

	public void startSoek(String soekeStreng) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(
					"SoekeInfo.txt"));

			String brukerInput = soekeStreng;
			String resultatAvSøk;
			while ((resultatAvSøk = bf.readLine()) != null) {

				int resultatFunnet = resultatAvSøk.indexOf(brukerInput);
				if (brukerInput.isEmpty()) {
					System.out.println("Ingen søk utført");
					break;
				}
				if (resultatFunnet > -1) {
					System.out.println("Funnet " + " " + resultatAvSøk + " ganger"
							+ " på  ");
				}
				if (resultatFunnet < 0) {
					System.out.println("Ingen treff");
					break;
				}
			}

			bf.close();
		} catch (IOException e) {
			System.out.println("IO Error Occurred: " + e.toString());

		}

	}
}
