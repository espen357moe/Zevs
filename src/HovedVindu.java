import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class HovedVindu extends JFrame {
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

        menylinje.add(meny);
        meny.add(m1);
        meny.add(m2);

        setJMenuBar(menylinje);	
        
        SoekePanel soekePanel = new SoekePanel();
        hovedContainer.add(soekePanel);
        
        GeografiPanel geografiPanel = new GeografiPanel();
        hovedContainer.add(geografiPanel);
        
        MeteorologiPanel meteorologiPanel = new MeteorologiPanel();
        hovedContainer.add(meteorologiPanel);
		
		setVisible(true);
	}
	
}
