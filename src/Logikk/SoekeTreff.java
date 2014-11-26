package Logikk;
public class SoekeTreff {
	
	private String fylke;
	private String kommune;
	private String stedsNavn;
	private String urlNorsk;
	
	public SoekeTreff(String fylke, String kommune, String stedsNavn, String urlNorsk){
		this.fylke = fylke;
		this.kommune = kommune;
		this.stedsNavn = stedsNavn;
		this.urlNorsk = urlNorsk;
	}
	
	public String getFylke(){
		return this.fylke;
	}
	
	public String getKommune(){
		return this.kommune;
	}
	
	public String getStedsNavn(){
		return this.stedsNavn;
	}
	
	public String getUrlNorsk(){
		return this.urlNorsk;
	}
}