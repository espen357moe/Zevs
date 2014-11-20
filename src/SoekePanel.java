import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SoekePanel extends JPanel implements ActionListener {
	
	public String soekeStreng;	
	private JTextField soekeFelt;
	
	public SoekePanel() {
		this.soekeFelt = new JTextField(30);
		this.add(soekeFelt);
		
		JButton soekeKnapp = new JButton("Søk");
		this.add(soekeKnapp);
		soekeKnapp.addActionListener(this);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		if(event.equals("Søk")) {
			soekeStreng = soekeFelt.getText();
			System.out.println("Søkeknappen trykket på - " + soekeStreng);
		}
		
	}

}
