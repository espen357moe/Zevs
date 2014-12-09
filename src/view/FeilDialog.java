package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FeilDialog {
	
	public FeilDialog(String feilTekst) {
	    JOptionPane.showMessageDialog(new JFrame(),
	    	    feilTekst,
	    	    "En feil oppsto",
	    	    JOptionPane.WARNING_MESSAGE);
	  }
}
	


