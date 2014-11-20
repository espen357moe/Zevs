import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Konsoll {


   public static int readInt(String ledetekst) {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   while(true) {
		 System.out.print(ledetekst+":");
         try {return Integer.valueOf(br.readLine().trim()).intValue();}
         catch(Exception e) {}
      	}
   }

   public static String readLine(String ledetekst) {
   	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   	   while(true) {
   		 System.out.print(ledetekst+":");
            try {return br.readLine().trim();}
            catch(Exception e) {}
         	}
   }


public static double readDouble(String ledetekst) {

	   while(true) {
         try {return Double.valueOf(readLine(ledetekst).trim()).doubleValue();}
         catch(Exception e) {}
      	}
   }

}