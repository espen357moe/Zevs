package view;

@SuppressWarnings("serial")
public class MeteorologiPanel extends DataPanel {

	private int symbol;

	public MeteorologiPanel() {
		lagEtikett("Meteorologiske data");
		skrivUtData("Her kommer meteorologiske data etterhvert");
		System.out.println(symbol);
		
	}
		        
		
	public void Bilde(int symbol) 
	{

	 System.out.println(symbol);
		
	}
	
}