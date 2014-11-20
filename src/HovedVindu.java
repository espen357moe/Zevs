import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class HovedVindu extends JFrame implements ActionListener {

	HovedVindu() {
		setSize(500,500);
		setTitle("Zevs");
		
		Container hovedContainer = getContentPane();
		hovedContainer.setLayout(new GridLayout(4,0));
		
		JMenuBar menylinje = new JMenuBar();
        JMenu meny = new JMenu("Valg");
        JMenuItem m1 = new JMenuItem("Om applikasjonen");
        JMenuItem m2 = new JMenuItem("Avslutt");
        
        meny.setMnemonic(KeyEvent.VK_V);
        m1.setMnemonic(KeyEvent.VK_O);
        m2.setMnemonic(KeyEvent.VK_A);

        
        m1.addActionListener(this);
        
        menylinje.add(meny);
        meny.add(m1);
        meny.add(m2);
        
        
        m1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
            new OmVindu();
        }
        });
        
        m2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                    System.exit(0);
            }
        });
  
        
        setJMenuBar(menylinje);	
        
        SoekePanel soekePanel = new SoekePanel();
        hovedContainer.add(soekePanel);
        
        GeografiPanel geografiPanel = new GeografiPanel();
        hovedContainer.add(geografiPanel);
        
        MeteorologiPanel meteorologiPanel = new MeteorologiPanel();
        hovedContainer.add(meteorologiPanel);
        
		
		setVisible(true);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
