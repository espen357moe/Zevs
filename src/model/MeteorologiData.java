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
	private String skydekke24;
	private String skydekke48;
	private int temperatur;
	private int temperatur24;
	private int temperatur48;
	private String vindRetning;
	private String vindRetning24;
	private String vindRetning48;
	private String vindBetegnelse;
	private String vindBetegnelse24;
	private String vindBetegnelse48;
	private float vindHastighet;
	private float vindHastighet24;
	private float vindHastighet48;
	private int symbolNummer;
	private int symbolNummer24;
	private int symbolNummer48;
	private String sistOppdatert;
	private String nesteOppdatering;
	private String vaerVarsel;
	
	public MeteorologiData(String stedsNavn, int hoydeOverHavet, String lengdeGrad, String breddeGrad, float nedbor,float nedbor24,float nedbor48, String skydekke,String skydekke24, String skydekke48, int temperatur,int temperatur24,int temperatur48, String vindRetning, String vindRetning24, String vindRetning48, String vindBetegnelse, String vindBetegnelse24, String vindBetegnelse48, float vindHastighet, float vindHastighet24, float vindHastighet48, int symbolNummer, int symbolNummer24, int symbolNummer48, String sistOppdatert, String nesteOppdatering, String vaerVarsel) {
		this.stedsNavn = stedsNavn;
		this.hoydeOverHavet = hoydeOverHavet;
		this.breddeGrad = breddeGrad;
		this.lengdeGrad = lengdeGrad;
		this.nedbor = nedbor;
		this.nedbor24 = nedbor24;
		this.nedbor48 = nedbor48;
		this.vindBetegnelse = vindBetegnelse;
		this.vindBetegnelse24 = vindBetegnelse24;
		this.vindBetegnelse48 = vindBetegnelse48;
		this.skydekke = skydekke;
		this.skydekke24 = skydekke24;
		this.skydekke48 = skydekke48;
		this.temperatur = temperatur;
		this.temperatur24 = temperatur24;
		this.temperatur48 = temperatur48;
		this.vindRetning = vindRetning;
		this.vindRetning24 = vindRetning24;
		this.vindRetning48 = vindRetning48;
		this.vindHastighet = vindHastighet;
		this.vindHastighet24 = vindHastighet24;
		this.vindHastighet48 = vindHastighet48;
		this.symbolNummer = symbolNummer;
		this.symbolNummer24 = symbolNummer24;
		this.symbolNummer48 = symbolNummer48;
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

	public String getSkydekke24() {
		return this.skydekke24;
	}
	
	public String getSkydekke48() {
		return this.skydekke48;
	}
	
	public int getTemperatur() {
		return this.temperatur;
	}
	
	public int getTemperatur24() {
		return this.temperatur24;
	}
	
	public int getTemperatur48() {
		return this.temperatur48;
	}
	
	public String getVindRetning() {
		return this.vindRetning;
	}
	
	public String getVindRetning24() {
		return this.vindRetning24;
	}
	
	public String getVindRetning48() {
		return this.vindRetning48;
	}
	
	public String getVindBetegnelse() {
		return this.vindBetegnelse;
	}
	
	public String getVindBetegnelse24() {
		return this.vindBetegnelse24;
	}
	
	public String getVindBetegnelse48() {
		return this.vindBetegnelse48;
	}
	
	public float getVindHastighet() {
		return this.vindHastighet;
	}
	
	public float getVindHastighet24() {
		return this.vindHastighet24;
	}
	
	public float getVindHastighet48() {
		return this.vindHastighet48;
	}
	
	public int getSymbolNummer() {
		return this.symbolNummer;
	}
	
	public int getSymbolNummer24() {
		return this.symbolNummer24;
	}
	
	public int getSymbolNummer48() {
		return this.symbolNummer48;
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
