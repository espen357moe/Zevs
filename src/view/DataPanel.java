package view;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.MeteorologiData;

@SuppressWarnings("serial")
public class DataPanel extends JPanel {
	
	public JLabel panelEtikett = new JLabel();	
	public JPanel dataRute = new JPanel();	
	public JTextArea dataTekstFelt = new JTextArea();
	
	public DataPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.DARK_GRAY);
		
		dataTekstFelt.setBackground(Color.GRAY);
		dataTekstFelt.setForeground(Color.DARK_GRAY);
		
		panelEtikett.setForeground(Color.ORANGE);
				
		this.add(panelEtikett, BorderLayout.NORTH);
		this.add(dataTekstFelt, BorderLayout.CENTER);
	}	
	
	public void skrivUtData(String innData) {
		
		dataTekstFelt.append(innData + "\n");	
	}
	
	public void fjernData() {
		dataTekstFelt.setText("");
	}
	
	public void lagEtikett(String tekst) {
		panelEtikett.setText(tekst);
	}
	
}
