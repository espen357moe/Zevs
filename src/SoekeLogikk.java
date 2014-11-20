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
<<<<<<< HEAD

					System.out.println("Funnet " + " " + line + " ganger" + " på  ");
					
					
//					Omgj�ring til Array testing.  
//			System.out.println (java.util.Arrays.toString(line.split(";")));
					
=======
					System.out.println(line + " ganger"
							+ " på ");

					// Omgjøring til Array testing.
					// System.out.println
					// (java.util.Arrays.toString(line.split(" 	")));
>>>>>>> 719a3e864521af4c95f477020b15f3a2ad1a2a96
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
