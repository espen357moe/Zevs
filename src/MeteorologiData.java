
public class MeteorologiData {
	
	//Dette er kun placeholders for infotyper
	private float hoyesteTemperatur;
	private float lavesteTemperatur;
	private float vindHastighet;
	private float nedbor;
	
	public MeteorologiData(float hoyesteTemperatur, float lavesteTemperatur, float vindHastighet, float nedbor) {
		this.hoyesteTemperatur = hoyesteTemperatur;
		this.lavesteTemperatur = lavesteTemperatur;
		this.vindHastighet = vindHastighet;
		this.nedbor = nedbor;
	}
	
	public double getHoyesteTemperatur(){
		return this.hoyesteTemperatur;
	}
	
	public double getLavesteTemperatur(){
		return this.lavesteTemperatur;
	}
	
	public double getVindHastighet(){
		return this.vindHastighet;
	}
	
	public double getNedbor(){
		return this.nedbor;
	}
		
}
