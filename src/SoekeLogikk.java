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

				if (indexfound > -1) {
					System.out.println(line + " ganger"
							+ " på ");

					// Omgjøring til Array testing.
					// System.out.println
					// (java.util.Arrays.toString(line.split(" 	")));
				}
				if (indexfound == 0) {
					System.out.println("Ingen treff");
				}
			}

			bf.close();
		} catch (IOException e) {
			System.out.println("IO Error Occurred: " + e.toString());

		}

	}
}