import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javahjelp.Konsoll;


public class SoekeLogikk {
	
	public SoekeLogikk() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(
					"SoekeInfo.txt"));
			String line;
			String df = Konsoll.readLine("Navn p� sted");
			while ((line = bf.readLine()) != null) {

				int indexfound = line.indexOf(df);
				if (df.isEmpty()) {
					System.out.println("Ingen s�k gjort ");
					break;
					}
				
				if (indexfound > -1) {
					System.out.println("Funnet " + " " + line + " ganger" + " p�  ");
					
//					Omgj�ring til Array testing.  
//					System.out.println (java.util.Arrays.toString(line.split(" 	")));
				}
				if (indexfound == 0) {
					System.out.println("Ingen funn");
				}
			}	
			
			bf.close();
			} catch (IOException e) {
				System.out.println("IO Error Occurred: " + e.toString());
				
				
				
			}
		
		
	}
}
