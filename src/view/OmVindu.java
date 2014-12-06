package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class OmVindu extends JFrame {
	
	public OmVindu() {
		setTitle("Zevs");
		setSize(280, 350);
		setBackground(Color.LIGHT_GRAY);
		String[] navnArray = {"Rune Grønli", "Marianne Løvdok", "Øystein Paulsen", "Thor-Arne Høiland-Hallingrød", "Inger Horn", "Espen Moe"};
		shuffleArray(navnArray);
		
		BufferedImage zevsIkon = null;
		try {
			zevsIkon = ImageIO.read(new File("./ZevsLarge.png"));
		} catch (IOException e) {
			System.out.println("Klarte ikke lese bildefil!");
			e.printStackTrace();
		}
		
		Container mainContainer = getContentPane();
		setLayout(new BorderLayout());

		JLabel ikonPanel		= new JLabel(new ImageIcon(zevsIkon));
		JPanel tekstFeltPanel 	= new JPanel();
		JPanel lukkKnappPanel 	= new JPanel();

		ikonPanel.setOpaque(true);
		ikonPanel.setBackground			(Color.LIGHT_GRAY);
		tekstFeltPanel.setBackground	(Color.LIGHT_GRAY);
		lukkKnappPanel.setBackground	(Color.LIGHT_GRAY);

		JTextArea tekstFelt = new JTextArea();
		TitledBorder tittel;
		tittel = BorderFactory.createTitledBorder("Utviklet av");
		tekstFelt.setBorder(tittel);
		UIManager.put("TitledBorder.border", new LineBorder(new Color(100,100,100), 1));
		tekstFelt.setForeground(Color.DARK_GRAY);
		tekstFelt.setBackground(Color.LIGHT_GRAY);	
		tekstFelt.setEditable(false);
		
		for(int i = 0; i < navnArray.length; i++) {
			tekstFelt.append("\n" + navnArray[i]);		
		}



		JButton lukkKnapp = new JButton("Lukk");
		
		mainContainer.add(ikonPanel, BorderLayout.NORTH);
		mainContainer.add(tekstFeltPanel, BorderLayout.CENTER);
		mainContainer.add(lukkKnappPanel, BorderLayout.SOUTH);

		tekstFeltPanel.add(tekstFelt);
		lukkKnappPanel.add(lukkKnapp);

		lukkKnapp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ev) {
				dispose();
			}
		});

		setVisible(true);
	}

	private void shuffleArray(String[] navnArray) {
		  {
		    Random rnd = new Random();
		    for (int i = navnArray.length - 1; i > 0; i--)
		    {
		      int index = rnd.nextInt(i + 1);

		      String a = navnArray[index];
		      navnArray[index] = navnArray[i];
		      navnArray[i] = a;
		    }
		  }
		  
	}
	
};