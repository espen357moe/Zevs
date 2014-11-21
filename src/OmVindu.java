
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OmVindu extends JFrame
{  
	public OmVindu()
   {  
		setTitle("Zevs");
		setSize(500,200);
		
		Container mainContainer = getContentPane();
		setLayout(new GridLayout (2,0));
		
		JPanel tekstFeltPanel = new JPanel();
		JPanel lukkKnappPanel = new JPanel();
		
		JTextArea tekstFelt = new JTextArea("Laget av:\n Inger Horn, Marianne Løvdok,\n Thor-Arne Høiland-Hallingrød, Espen moe,\n Rune Grønli, Øystein Paulsen");
		tekstFelt.setEditable(false);
		tekstFelt.setBackground(Color.YELLOW);


		
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

	private void Tex() {
		// TODO Auto-generated method stub
		
	}
          };