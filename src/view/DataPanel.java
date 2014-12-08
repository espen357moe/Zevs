package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.MeteorologiData;

@SuppressWarnings("serial")
public class DataPanel extends JPanel {	
	public JLabel panelEtikett 				= new JLabel();	
	public JPanel dataPresentasjonsPanel	= new JPanel();
	public JTextArea dataTekstFelt 			= new JTextArea();
	public JLabel bildeRute 				= new JLabel();
	
	public DataPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.DARK_GRAY);				
		
		panelEtikett.setForeground(Color.ORANGE);						
		this.add(panelEtikett, BorderLayout.NORTH);		
		
		dataPresentasjonsPanel.setBackground(Color.BLUE);
		this.add(dataPresentasjonsPanel, BorderLayout.CENTER);
		
		dataPresentasjonsPanel.setLayout(new GridLayout(0,3));
		
		dataTekstFelt.setBackground(Color.GRAY);
	}
	
	public void lagNyttDataTekstFelt() {
		dataPresentasjonsPanel.add(dataTekstFelt, BorderLayout.CENTER);
	}
	
	public void lagNyBildeRute() {
		dataPresentasjonsPanel.add(bildeRute);
		bildeRute.setBackground(Color.GRAY);
		bildeRute.setOpaque(true);
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
