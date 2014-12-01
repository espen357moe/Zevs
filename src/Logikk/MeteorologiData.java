package Logikk;
public class MeteorologiData {
		
	private String stedsNavn;
	private int hoydeOverHavet;
	private String koordinater;
	private float nedbor;
	private int temperatur;
	private String vindRetning;
	private float vindHastighet;
	private String symbolNummer;
	private String sistOppdatert;
	private String nesteOppdatering;
	
	public MeteorologiData(String stedsNavn, int hoydeOverHavet, String koordinater, float nedbor, int temperatur, String vindRetning, float vindHastighet, String symbolNummer, String sistOppdatert, String nesteOppdatering) {
		this.stedsNavn = stedsNavn;
		this.hoydeOverHavet = hoydeOverHavet;
		this.koordinater = koordinater;
		this.nedbor = nedbor;
		this.temperatur = temperatur;
		this.vindRetning = vindRetning;
		this.vindHastighet = vindHastighet;
		this.symbolNummer = symbolNummer;
		this.sistOppdatert = sistOppdatert;
		this.nesteOppdatering = nesteOppdatering;	
	}
	
	public String getStedsNavn() {
		return this.stedsNavn;
	}
	
	public int getHoydeOverHavet() {
		return this.hoydeOverHavet;
	}
	
	public String getKoordinater() {
		return this.koordinater;
	}
	
	public float getNedbor() {
		return this.nedbor;
	}
	
	public int getTemperatur() {
		return this.temperatur;
	}
	
	public String getVindRetning() {
		return this.vindRetning;
	}
	
	public float getVindHastighet() {
		return this.vindHastighet;
	}
	
	public String getSymbolNummer() {
		return this.symbolNummer;
	}
	
	public String getSistOppdatert() {
		return this.sistOppdatert;
	}
	
	public String getNesteOppdatering() {
		return this.nesteOppdatering;
	}
	
	
	//Her skal aksessorene til de andre variablene lages etterhvert
		
}
