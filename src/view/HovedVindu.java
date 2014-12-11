package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class HovedVindu extends JFrame implements ActionListener {

	public HovedVindu() {
		setSize(420,800);
		setTitle("Zevs");	

		setIconImage(new ImageIcon("Zevs40.png").getImage());
		setResizable(false);
		setLocationByPlatform(true);

		Container hovedContainer = getContentPane();

		hovedContainer.setLayout(new GridLayout(6,0));
		
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
        
        MeteorologiPanel24 meteorologiPanel24 = new MeteorologiPanel24();
        hovedContainer.add(meteorologiPanel24);
        
        MeteorologiPanel48 meteorologiPanel48 = new MeteorologiPanel48();
        hovedContainer.add(meteorologiPanel48);
        
        VaerVarselPanel vaerVarselPanel = new VaerVarselPanel();
        hovedContainer.add(vaerVarselPanel);
        
        soekePanel.addAbonnent(meteorologiPanel.getEndret());
        soekePanel.addAbonnent(meteorologiPanel24.getEndret());
        soekePanel.addAbonnent(meteorologiPanel48.getEndret());
        soekePanel.addAbonnent(geografiPanel.getEndret());
        soekePanel.addAbonnent(vaerVarselPanel.getEndret());
        
        meteorologiPanel.getEndret();
        		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
