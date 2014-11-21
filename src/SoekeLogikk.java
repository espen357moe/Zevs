import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SoekeLogikk {
	
	
	public class CrunchifyStringToCharArray {
		 
		public void test (String[] args) {
			String testString = "This Is Test";
			char[] stringToCharArray = testString.toCharArray();
	 
			for (char output : stringToCharArray) {
				System.out.println(output);
			}
		}
	}

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
					System.out.println("Funnet " + " " + resultatAvSok);
					
					String strArray[] = resultatAvSok.split("\t");
		               for(int i=0; i < strArray.length;){
		               System.out.println(strArray[12]);
		               break;
		               }

				}
			}
			
			
			bf.close();
		} catch (IOException e) {
			System.out.println("IO Error Occurred: " + e.toString());

		}

	}
}
