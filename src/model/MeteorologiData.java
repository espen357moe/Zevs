package model;

import java.util.*;

public class MeteorologiData {
		
	private String stedsNavn;
	private int hoydeOverHavet;
	private String koordinater;
	private float nedbor;
	private String skydekke;
	private int temperatur;
	private String vindRetning;
	private String vindBetegnelse;
	private float vindHastighet;
	private int symbolNummer;
	private String sistOppdatert;
	private String nesteOppdatering;
	
	public MeteorologiData(String stedsNavn, int hoydeOverHavet, String koordinater, float nedbor, String skydekke, int temperatur, String vindRetning, String vindBetegnelse, float vindHastighet, int symbolNummer, String sistOppdatert, String nesteOppdatering) {
		this.stedsNavn = stedsNavn;
		this.hoydeOverHavet = hoydeOverHavet;
		this.koordinater = koordinater;
		this.nedbor = nedbor;
		this.vindBetegnelse = vindBetegnelse;
		this.skydekke = skydekke;
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
		
}
