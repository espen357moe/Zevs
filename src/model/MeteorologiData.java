package model;

public class MeteorologiData {
		
	private String stedsNavn;
	private int hoydeOverHavet;
	private String breddeGrad;
	private String lengdeGrad;
	private float nedbor;
	private float nedbor24;
	private float nedbor48;
	private String skydekke;
	private int temperatur;
	private String vindRetning;
	private String vindBetegnelse;
	private float vindHastighet;
	private int symbolNummer;
	private String sistOppdatert;
	private String nesteOppdatering;
	private String vaerVarsel;
	
	public MeteorologiData(String stedsNavn, int hoydeOverHavet, String lengdeGrad, String breddeGrad, float nedbor,float nedbor24,float nedbor48, String skydekke, int temperatur, String vindRetning, String vindBetegnelse, float vindHastighet, int symbolNummer, String sistOppdatert, String nesteOppdatering, String vaerVarsel) {
		this.stedsNavn = stedsNavn;
		this.hoydeOverHavet = hoydeOverHavet;
		this.breddeGrad = breddeGrad;
		this.lengdeGrad = lengdeGrad;
		this.nedbor = nedbor;
		this.nedbor24 = nedbor24;
		this.nedbor48 = nedbor48;
		this.vindBetegnelse = vindBetegnelse;
		this.skydekke = skydekke;
		this.temperatur = temperatur;
		this.vindRetning = vindRetning;
		this.vindHastighet = vindHastighet;
		this.symbolNummer = symbolNummer;
		this.sistOppdatert = sistOppdatert;
		this.nesteOppdatering = nesteOppdatering;	
		this.vaerVarsel = vaerVarsel;
	}
	
	public String getStedsNavn() {
		return this.stedsNavn;
	}
	
	public int getHoydeOverHavet() {
		return this.hoydeOverHavet;
	}
	
	public String getBreddegrad() {
		return this.breddeGrad;
	}
	
	public String getLengdegrad() {
		return this.lengdeGrad;
	}
	
	public float getNedbor() {
		return this.nedbor;
	}
	
	public float getNedbor24() {
		return this.nedbor24;
	}
	
	public float getNedbor48() {
		return this.nedbor48;
	}
	
	public String getSkydekke() {
		return this.skydekke;
	}
	
	public int getTemperatur() {
		return this.temperatur;
	}
	
	public String getVindRetning() {
		return this.vindRetning;
	}
	
	public String getVindBetegnelse() {
		return this.vindBetegnelse;
	}
	
	public float getVindHastighet() {
		return this.vindHastighet;
	}
	
	public int getSymbolNummer() {
		return this.symbolNummer;
	}
	
	public String getSistOppdatert() {
		return this.sistOppdatert;
	}
	
	public String getNesteOppdatering() {
		return this.nesteOppdatering;
	}
	
	public String getvaerVarsel() {
		return this.vaerVarsel;
	}
		
}
