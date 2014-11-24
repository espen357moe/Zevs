import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class OmVindu extends JFrame {
	
	public OmVindu() {
		setTitle("Zevs");
		setSize(500, 200);

		Container mainContainer = getContentPane();
		setLayout(new GridLayout(2, 0));

		JPanel tekstFeltPanel = new JPanel();
		JPanel lukkKnappPanel = new JPanel();

		tekstFeltPanel.setBackground(Color.DARK_GRAY);
		lukkKnappPanel.setBackground(Color.DARK_GRAY);

		JTextArea tekstFelt = new JTextArea(
				"Laget av:\n Inger Horn, Marianne Løvdok,\n Thor-Arne Høiland-Hallingrød, Espen moe,\n Rune Grønli, Øystein Paulsen");
		tekstFelt.setEditable(false);

		Font font = new Font("Calibri", Font.PLAIN, 14);

		tekstFelt.setFont(font);
		tekstFelt.setBackground(Color.ORANGE);

		JButton lukkKnapp = new JButton("Lukk");

		mainContainer.add(tekstFeltPanel);
		mainContainer.add(lukkKnappPanel);

		tekstFeltPanel.add(tekstFelt);
		lukkKnappPanel.add(lukkKnapp);

		lukkKnapp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ev) {
				dispose();
			}
		});

		setVisible(true);
	}

};